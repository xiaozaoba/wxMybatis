package wx.session;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangxun
 * @title: Configuration
 * @projectName mybatis-zdy
 * @version: 1.0.0
 * @description: 所有的配置信息
 * @date 2020/4/29 10:10 上午
 */
public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;
    private Map mappers = new HashMap<String ,Mapper>();

    public Configuration() {
    }

    public Configuration(String driver, String url, String username, String password, Map mappers) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
        this.mappers = mappers;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map getMappers() {
        return mappers;
    }

    public void setMappers(Map mappers) {
        this.mappers = mappers;
    }
}
