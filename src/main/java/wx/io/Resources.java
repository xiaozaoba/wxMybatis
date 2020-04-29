package wx.io;

import java.io.InputStream;

/**
 * @author wangxun
 * @title: Resource
 * @projectName mybatis-zdy
 * @version: 1.0.0
 * @description: 根据类加载器,获取项目对应的文件流
 * @date 2020/4/29 9:54 上午
 */
public class Resources {

    /**
     * 获取当前类的类加载器,获取文件输入流
     * @param url 资源路径
     * @return
     */
    public static InputStream getResourceAsStream(String url){
        return Resources.class.getClassLoader().getResourceAsStream(url);
    }

}
