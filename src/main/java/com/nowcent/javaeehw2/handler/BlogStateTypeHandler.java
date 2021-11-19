package com.nowcent.javaeehw2.handler;

import com.nowcent.javaeehw2.entity.Blog;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlogStateTypeHandler implements TypeHandler<Blog.State> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Blog.State state, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, state.ordinal());
    }

    @Override
    public Blog.State getResult(ResultSet resultSet, String s) throws SQLException {
        int value = resultSet.getInt(s);
        return Blog.State.values()[value];
    }

    @Override
    public Blog.State getResult(ResultSet resultSet, int i) throws SQLException {
        int value = resultSet.getInt(i);
        return Blog.State.values()[value];
    }

    @Override
    public Blog.State getResult(CallableStatement callableStatement, int i) throws SQLException {
        int value = callableStatement.getInt(i);
        return Blog.State.values()[value];
    }
}
