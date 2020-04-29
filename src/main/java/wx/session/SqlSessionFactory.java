package wx.session;

/**
 * @author wangxun
 * @title: SqlSessionFactory
 * @projectName mybatis-zdy
 * @version: 1.0.0
 * @description: 工厂的抽象接口
 * @date 2020/4/29 10:02 上午
 */
public interface SqlSessionFactory {

    SqlSession openSession();
}
