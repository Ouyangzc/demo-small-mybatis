package com.ouyang.mybatis.chapter06.binding;

import com.ouyang.mybatis.chapter06.mapping.MappedStatement;
import com.ouyang.mybatis.chapter06.mapping.SqlCommandType;
import com.ouyang.mybatis.chapter06.session.Configuration;
import com.ouyang.mybatis.chapter06.session.SqlSession;


import java.lang.reflect.Method;

/**
 * @ClassName MapperMethod
 * @Description 映射器方法
 * @Author OuYang
 * @Date 2023/7/5 14:51
 * @Version 1.0
 */
public class MapperMethod {

    private final SqlCommand command;

    public MapperMethod(Class<?> mapperInterface, Method method, Configuration configuration) {
        this.command = new SqlCommand(configuration, mapperInterface, method);
    }

    public Object execute(SqlSession sqlSession, Object[] args) {
        Object result = null;

        switch (command.getCommandType()) {
            case INSERT:
                break;
            case UPDATE:
                break;
            case DELETE:
                break;
            case SELECT:
                result = sqlSession.selectOne(command.getName(), args);
                break;
            default:
                throw new RuntimeException("Unknown execution method for: " + command.getName());
        }
        return result;
    }

    public static class SqlCommand {

        private final String name;

        private final SqlCommandType commandType;

        public SqlCommand(Configuration configuration, Class<?> mapperInterface, Method method) {
            String statementName = mapperInterface.getName() + "." + method.getName();
            MappedStatement ms = configuration.getMappedStatement(statementName);
            this.name = ms.getId();
            this.commandType = ms.getSqlCommandType();
        }

        public String getName() {
            return name;
        }

        public SqlCommandType getCommandType() {
            return commandType;
        }
    }
}
