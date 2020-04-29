package wx.session.mapper;

import wx.session.Configuration;
import wx.session.Mapper;
import wx.session.until.ExecutorUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.List;

/**
 * @author wangxun
 * @title: MapperPorxy
 * @projectName mybatis-zdy
 * @version: 1.0.0
 * @description: 代理类实际执行
 * @date 2020/4/29 11:34 上午
 */
public class MapperProxy implements InvocationHandler {
    private Configuration configuration;

    private Connection connection;

    public MapperProxy(Configuration configuration, Connection connection) {
        this.configuration = configuration;
        this.connection = connection;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 获取类的全限定名
        String className = method.getDeclaringClass().getName();
        String key = className+"."+method.getName();

        Mapper mapper = (Mapper)configuration.getMappers().get(key);

        return ExecutorUtil.select(mapper, connection);
    }
}
