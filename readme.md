#自定义mybatis
1. 先定义一个读取xml配置文件的流
2. 将配置信息读取到一个对象`Configuration` 中
    1. 数据库连接信息
    2. mapper映射信息
3. 建造者模式创建出`SessionFactory`
4. 工厂模式创建出一次会话连接 `SqlSession`
5. 代理模式生成 `MapperProxy`对象
6. 执行相应的方法,在实际代理执行类中,根据不同的 `Statement` 获取到 `Mapper` 信息,从而得到sql和返回的数据类型
7. 将结果封装到对应俄数据类型中

