package wx.session.until;

import wx.session.Mapper;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxun
 * @title: ExecutorUtil
 * @projectName mybatis-zdy
 * @version: 1.0.0
 * @description: sql处理器
 * @date 2020/4/29 11:39 上午
 */
public class ExecutorUtil {
     public static <T> List<T> select(Mapper mapper, Connection connection) throws Exception{

         //sql 语句
         String sql = mapper.getSql();
         //返回值类型
         String resultType = mapper.getResultType();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(sql);
         ArrayList<T> ts = new ArrayList<T>();
         while(resultSet.next()){
             Class<?> clazz = Class.forName(resultType);
             T bean = (T)clazz.newInstance();
             Field[] fields = clazz.getDeclaredFields();
             for (Field field : fields) {
                 field.setAccessible(true);
                 // 属性名称
                 String fieldName = field.getName();
                 // 属性值
                 Object fieldValue = resultSet.getObject(fieldName);
                 // 设置值
                 field.set(bean,fieldValue);
             }
             ts.add(bean);
         }
        return ts;
     }
}
