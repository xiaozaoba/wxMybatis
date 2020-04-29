package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wx.entity.Address;
import wx.io.Resources;
import wx.mapper.IAddressMapper;
import wx.session.SqlSession;
import wx.session.SqlSessionFactory;
import wx.session.SqlSessionFactoryBuilder;

import java.util.List;

/**
 * @author wangxun
 * @title: MybatisTest
 * @projectName mybatis-zdy
 * @version: 1.0.0
 * @description: TODO
 * @date 2020/4/29 9:42 上午
 */
public class MybatisTest {
    private final static Logger logger = LoggerFactory.getLogger(MybatisTest.class);
    public static void main(String[] args)throws Exception {
        /**
         * 获取资源
         *  通过一层一层的类加载器去寻找对应的文件
         */
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlBasic.xml"));
        SqlSession sqlSession = sessionFactory.openSession();
        IAddressMapper mapper = sqlSession.getMapper(IAddressMapper.class);
        List<Address> all = mapper.findAll();
        for (Address address : all) {
            logger.debug(address.toString());
        }
        sqlSession.close();
    }
}
