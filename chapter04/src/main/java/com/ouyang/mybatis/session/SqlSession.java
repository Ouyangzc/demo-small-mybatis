package com.ouyang.mybatis.session;

/**
 * @ClassName SqlSession
 * @Description SqlSession 用来执行SQL，获取映射器，管理事务。
 * @Author OuYang
 * @Date 2023/6/21 13:45
 * @Version 1.0
 */
public interface SqlSession {
    /**
     * 根据指定的SqlID获取一条记录的封装对象
     *
     * @param statement sqlID
     * @param <T>       the returned object type 封装之后的对象类型
     * @return Mapped object 封装之后的对象
     */
    <T> T selectOne(String statement);

    /**
     * 根据指定的SqlID获取一条记录的封装对象，只不过这个方法容许我们可以给sql传递一些参数
     * 一般在实际使用中，这个参数传递的是pojo，或者Map或者ImmutableMap
     *
     * @param statement
     * @param parameter
     * @param <T>
     * @return
     */
    <T> T selectOne(String statement, Object parameter);

    Configuration getConfiguration();

    /**
     * 得到映射器，这个巧妙的使用了泛型，使得类型安全
     *
     * @param type
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> type);
}
