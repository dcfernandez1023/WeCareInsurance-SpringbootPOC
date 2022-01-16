package com.wecareinsurance.wecareinsurance.dao;

import com.wecareinsurance.wecareinsurance.dal.DatabaseAccess;

public abstract class BaseDao {
    protected DatabaseAccess db;

    public BaseDao() throws Exception {
        this.initDb();
    }

    protected abstract void initDb() throws Exception;
}
