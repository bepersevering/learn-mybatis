package com.mingshashan.mybatis.learn.plugins;

import org.apache.ibatis.mapping.BoundSql;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SqlHandler {
    private static final String LIMIT_SQL_TEMPLATE = "%s limit %s;";
    private static final List<String> KEY_WORD = Arrays.asList("count", "limit", "sum", "avg", "min", "max");
    private BoundSql boundSql;
    private String originSql;
    private Boolean needOverride;
    private String newSql;

    public static SqlHandler build(BoundSql boundSql, int size) {
        String originSql = boundSql.getSql().toLowerCase();
        SqlHandler handler = new SqlHandler(boundSql, originSql);
        if (!containsKeyWord(handler.getOriginSql())) {
            handler.setNeedOverride(Boolean.TRUE);
            String newSql = String.format(LIMIT_SQL_TEMPLATE, originSql.replace(";", ""), size);
            handler.setNewSql(newSql);
        }

        return handler;
    }

    private SqlHandler(BoundSql boundSql, String originSql) {
        this.needOverride = Boolean.FALSE;
        this.boundSql = boundSql;
        this.originSql = originSql;
    }

    public boolean needOverride() {
        return this.needOverride;
    }

    public static boolean containsKeyWord(String sql) {
        Iterator var1 = KEY_WORD.iterator();

        String keyWord;
        do {
            if (!var1.hasNext()) {
                return Boolean.FALSE;
            }

            keyWord = (String) var1.next();
        } while (!sql.contains(keyWord));

        return Boolean.TRUE;
    }

    public BoundSql getBoundSql() {
        return this.boundSql;
    }

    public void setBoundSql(BoundSql boundSql) {
        this.boundSql = boundSql;
    }

    public String getOriginSql() {
        return this.originSql;
    }

    public void setOriginSql(String originSql) {
        this.originSql = originSql;
    }

    public Boolean getNeedOverride() {
        return this.needOverride;
    }

    public void setNeedOverride(Boolean needOverride) {
        this.needOverride = needOverride;
    }

    public String getNewSql() {
        return this.newSql;
    }

    public void setNewSql(String newSql) {
        this.newSql = newSql;
    }
}