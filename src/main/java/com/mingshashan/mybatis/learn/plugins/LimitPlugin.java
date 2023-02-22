package com.mingshashan.mybatis.learn.plugins;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class LimitPlugin implements Interceptor {

    Properties properties;

    private int limitSize = 1000;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Invocation invocationTemp = invocation;
        Object[] args = invocationTemp.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object parameter = args[1];
        BoundSql boundSql = 4 == args.length ? ms.getBoundSql(args[1]) : (BoundSql) args[5];
        SqlHandler sqlHandler = SqlHandler.build(boundSql, limitSize);

        if (sqlHandler.needOverride()) {
            Executor executor = (Executor) invocationTemp.getTarget();
            RowBounds rowBounds = (RowBounds) args[2];
            ResultHandler resultHandler = (ResultHandler) args[3];
            CacheKey cacheKey = args.length == 4 ? executor.createCacheKey(ms, parameter, rowBounds, boundSql) : (CacheKey) args[4];
            MetaObject metaObject = SystemMetaObject.forObject(boundSql);
            metaObject.setValue("sql", sqlHandler.getNewSql());
            return executor.query(ms, parameter, rowBounds, resultHandler, cacheKey, boundSql);
        } else {
            return invocation.proceed();
        }
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
        this.properties = properties;
        String limitSize = String.valueOf(properties.getOrDefault("limit.size", "10000"));
        this.limitSize = Integer.parseInt(limitSize);
    }
}
