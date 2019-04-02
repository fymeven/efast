package cn._51even.efast.security_cas_server.dal.typehandler;

import cn._51even.efast.core.system.BusinessException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

public class ArrayTypeHandler extends BaseTypeHandler<Object[]> {

    private static final String JDBC_VARCHAR = "varchar";
    private static final String JDBC_INTEGER = "integer";
    private static final String JDBC_BOOLEAN = "boolean";
    private static final String JDBC_NUMERIC = "numeric";

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object[] objects, JdbcType jdbcType) throws SQLException {
        String type = null;
        if (objects instanceof Integer[]){
            type = JDBC_INTEGER;
        }else if (objects instanceof String[]){
            type = JDBC_VARCHAR;
        }else if (objects instanceof Boolean[]){
            type = JDBC_BOOLEAN;
        }else if (objects instanceof Double[]){
            type = JDBC_NUMERIC;
        }else {
            throw new BusinessException("非数组类型字段无法使用"+this.getClass().getName());
        }
        Connection connection = preparedStatement.getConnection();
        preparedStatement.setArray(i,connection.createArrayOf(type,objects));
    }

    @Override
    public Object[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return getArray(resultSet.getArray(s));
    }

    @Override
    public Object[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return getArray(resultSet.getArray(i));
    }

    @Override
    public Object[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return getArray(callableStatement.getArray(i));
    }

    private Object[] getArray(Array array) throws SQLException {
        if (array == null){
            return null;
        }
        return (Object[])array.getArray();
    }
}
