package com.ouyang.mybatis.mapping;

/**
 * @ClassName SqlCommandType
 * @Description  SQL 指令类型
 * @Author OuYang
 * @Date 2023/6/19 11:48
 * @Version 1.0
 */
public enum SqlCommandType {
    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;
}
