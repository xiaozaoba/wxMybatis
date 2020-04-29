package wx.session;

/**
 * @author wangxun
 * @title: SqlSession
 * @projectName mybatis-zdy
 * @version: 1.0.0
 * @description: SqlSession 的抽象接口
 * @date 2020/4/29 10:03 上午
 */
public interface SqlSession {

    /**
     * 通过类地址,获取代理对象
     * @param clazz 类地址
     * @param <T> 参数类型
     * @return 代理对象
     */
    <T> T getMapper(Class<T> clazz);

    /**
     * 关闭资源
     */
    void close();
}
