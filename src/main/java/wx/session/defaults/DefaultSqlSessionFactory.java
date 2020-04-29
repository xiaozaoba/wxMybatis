package wx.session.defaults;

import wx.session.Configuration;
import wx.session.SqlSession;
import wx.session.SqlSessionFactory;

/**
 * @author wangxun
 * @title: DefaultSqlSessionFactory
 * @projectName mybatis-zdy
 * @version: 1.0.0
 * @description: TODO
 * @date 2020/4/29 11:18 上午
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
