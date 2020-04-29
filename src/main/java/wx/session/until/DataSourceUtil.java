package wx.session.until;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wx.session.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author wangxun
 * @title: DataSourceUtil
 * @projectName mybatis-zdy
 * @version: 1.0.0
 * @description: 数据源工具类
 * @date 2020/4/29 11:28 上午
 */
public class DataSourceUtil {

    private final static Logger logger = LoggerFactory.getLogger(DataSourceUtil.class);

    public static Connection getConnection(Configuration configuration){
        logger.info("创建数据源连接");
        Connection connection = null;
        // 1. 注册驱动类
        try {
            Class.forName(configuration.getDriver());

            connection = DriverManager.getConnection(configuration.getUrl(), configuration.getUsername(), configuration.getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
