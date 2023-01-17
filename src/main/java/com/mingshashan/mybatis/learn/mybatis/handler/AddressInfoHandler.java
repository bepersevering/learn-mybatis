package com.mingshashan.mybatis.learn.mybatis.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mingshashan.mybatis.learn.domain.Address;
import com.mingshashan.mybatis.learn.util.JSONUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mingshashan
 */
//数据库类型
@MappedJdbcTypes(JdbcType.VARCHAR)
//java中类型
@MappedTypes(List.class)
public class AddressInfoHandler extends BaseTypeHandler<List<Address>> {

    @Override
    public List<Address> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        final String json = cs.getString(columnIndex);
        List<Address> addressList = new ArrayList<>();
        try {
            addressList = JSONUtil.parseObject(json,
                    addressList.getClass());
            return addressList;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Address> parameter, JdbcType jdbcType) throws SQLException {
        try {
            String jsonString = JSONUtil.toJSONString(parameter);
            ps.setString(i, jsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Address> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        final String json = rs.getString(columnName);
        List<Address> addressList = new ArrayList<>();
        try {
            addressList = JSONUtil.parseObject(json,
                    addressList.getClass());
            return addressList;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Address> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        final String json = rs.getString(columnIndex);
        List<Address> addressList = new ArrayList<>();
        try {
            addressList = JSONUtil.parseObject(json,
                    addressList.getClass());
            return addressList;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Address> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        final String json = cs.getString(columnIndex);
        List<Address> addressList = new ArrayList<>();
        try {
            addressList = JSONUtil.parseObject(json,
                    addressList.getClass());
            return addressList;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
