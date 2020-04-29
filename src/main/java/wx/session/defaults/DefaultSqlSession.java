package wx.session.defaults;

import wx.session.Configuration;
import wx.session.SqlSession;
import wx.session.SqlSessionFactory;
import wx.session.mapper.MapperProxy;
import wx.session.until.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author wangxun
 * @title: DefaultSqlSessionFactory
 * @projectName mybatis-zdy
 * @version: 1.0.0
 * @description: TODO
 * @date 2020/4/29 11:18 上午
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    private Connection connection;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        this.connection = DataSourceUtil.getConnection(configuration);
    }

    /**
     * 获取代理类
     * @param clazz 类地址
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> clazz) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new MapperProxy(configuration,connection));
    }

    public void close() {
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
