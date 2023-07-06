package com.ouyang.mybatis.chapter06.mapping;

/**
 * @ClassName SqlCommandType
 * @Description SQL 指令类型
 * @Author OuYang
 * @Date 2023/7/5 14:18
 * @Version 1.0
 */
public enum SqlCommandType {
    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 新增
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 查询
     */
    SELECT,
    /**
     * 删除
     */
    DELETE;
}
