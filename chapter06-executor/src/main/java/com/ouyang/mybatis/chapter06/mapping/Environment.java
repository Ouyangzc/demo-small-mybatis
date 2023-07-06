package com.ouyang.mybatis.chapter06.mapping;

import com.ouyang.mybatis.chapter06.transaction.TransactionFactory;

import javax.sql.DataSource;

/**
 * @ClassName Environment
 * @Description 环境
 * @Author OuYang
 * @Date 2023/7/5 14:06
 * @Version 1.0
 */
public class Environment {
    private final String id;

    private final DataSource dataSource;

    private final TransactionFactory transactionFactory;


    public Environment(String id, DataSource dataSource, TransactionFactory transactionFactory) {
        this.id = id;
        this.dataSource = dataSource;
        this.transactionFactory = transactionFactory;
    }

    public String getId() {
        return id;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public TransactionFactory getTransactionFactory() {
        return transactionFactory;
    }


    public static class Builder{
        private String id;
        private TransactionFactory transactionFactory;
        private DataSource dataSource;

        public Builder(String id) {
            this.id = id;
        }

        public Builder transactionFactory(TransactionFactory transactionFactory) {
            this.transactionFactory = transactionFactory;
            return this;
        }

        public Builder dataSource(DataSource dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public String id() {
            return this.id;
        }

        public Environment build() {
            return new Environment(this.id, this.dataSource, this.transactionFactory);
        }
    }
}
