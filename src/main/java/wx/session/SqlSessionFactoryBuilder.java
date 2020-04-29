package wx.session;

import wx.session.defaults.DefaultSqlSessionFactory;
import wx.session.until.XmlParser;

import java.io.InputStream;

/**
 * @author wangxun
 * @title: SqlSessionFactoryBuilder
 * @projectName mybatis-zdy
 * @version: 1.0.0
 * @description: 解析xml文件,建造SqlSessionFactory
 * @date 2020/4/29 9:59 上午
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream in){
        Configuration configuration = new Configuration();
        XmlParser.parse(in,configuration);
        return new DefaultSqlSessionFactory(configuration);
    }
}
