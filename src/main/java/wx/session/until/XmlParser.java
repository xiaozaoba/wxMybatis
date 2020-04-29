package wx.session.until;

import cn.hutool.core.util.XmlUtil;
import com.sun.org.apache.xpath.internal.NodeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import wx.io.Resources;
import wx.session.Configuration;
import wx.session.Mapper;

import javax.xml.xpath.XPathConstants;
import java.io.InputStream;
import java.util.Map;

/**
 * @author wangxun
 * @title: XmlParser
 * @projectName mybatis-zdy
 * @version: 1.0.0
 * @description: xml 解析类
 * @date 2020/4/29 10:20 上午
 */
public class XmlParser {
    private final static Logger logger = LoggerFactory.getLogger(XmlParser.class);

    /**
     * 解析
     * @param in
     * @param configuration
     * @return
     */
    public  static void parse(InputStream in,Configuration configuration){
        logger.info("xml解析开始");
        Document document = XmlUtil.readXML(in);
        setDataSource(document,configuration);

        setMapper(document,configuration);
    }

    /**
     * 获取数据源信息
     * @param document
     * @param configuration 存储配置类
     */
    public static void setDataSource(Document document ,Configuration configuration){
        logger.info("数据源解析开始");
        Node driver = (Node)XmlUtil.getByXPath("//dataSource/property[@name='driver']", document, XPathConstants.NODE);
        Node url = (Node)XmlUtil.getByXPath("//dataSource/property[@name='url']", document, XPathConstants.NODE);
        Node username = (Node)XmlUtil.getByXPath("//dataSource/property[@name='username']", document, XPathConstants.NODE);
        Node password = (Node)XmlUtil.getByXPath("//dataSource/property[@name='password']", document, XPathConstants.NODE);

        configuration.setDriver(getValue(driver));
        configuration.setUrl(getValue(url));
        configuration.setUsername(getValue(username));
        configuration.setPassword(getValue(password));
        logger.info("数据源解析结束,解析到的数据为 ["+configuration.getDriver()+"| "+configuration.getUrl()+"| "+configuration.getUsername()+"| "+configuration.getPassword()+"}");


    }

    public static String getValue(Node node){
        NamedNodeMap attributes = node.getAttributes();
        Node rs = attributes.getNamedItem("value");
        return rs.getNodeValue();
    }

    /**
     * 设置映射
     * @param document
     * @param configuration
     */
    public static void setMapper(Document document ,Configuration configuration){
        logger.info("映射解析开始");
        Node mapper = (Node)XmlUtil.getByXPath("//mapper", document, XPathConstants.NODE);
        String  resourcePath = mapper.getAttributes().getNamedItem("resource").getNodeValue();
        logger.info("解析的路径是:"+resourcePath);
        Document mapperDocument = XmlUtil.readXML(resourcePath);

        Node namespace = (Node)XmlUtil.getByXPath("//mapper", mapperDocument, XPathConstants.NODE);
        String  namespaceStr = namespace.getAttributes().getNamedItem("namespace").getNodeValue();

        NodeList selectList = (NodeList)XmlUtil.getByXPath("//select", mapperDocument, XPathConstants.NODESET);
        // 映射的对象,放入对应mapperMap 中

        Map mappers = configuration.getMappers();
        for (int i = 0; i <selectList.getLength() ; i++) {
            Node select = selectList.item(i);

            String  id = select.getAttributes().getNamedItem("id").getNodeValue();
            String  resultType = select.getAttributes().getNamedItem("resultType").getNodeValue();
            String sql = select.getTextContent().trim();
            logger.info("映射解析结束,得到的信息:["+namespaceStr+"|"+id +"|"+sql+"|"+resultType+"]");

            Mapper selectMapper = new Mapper(sql, resultType);
            mappers.put(namespaceStr+"."+id,selectMapper);
        }


    }

    public static void main(String[] args) {
        XmlParser.parse(Resources.getResourceAsStream("SqlBasic.xml"),new Configuration());
    }

}
