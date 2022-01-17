package com.rj.bd.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @desc 数据库操作接口
 * @author 20441
 * @time 2021-11-19
 */
public interface Dao {
	/**
	 * @desc 查询一条数据，不支持预编译
	 * @param sql
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Map<String, Object> executeQueryForMap(String sql) throws ClassNotFoundException, SQLException;

	/**
	 * @desc 查询一条数据，支持预编译
	 * @param sql
	 * @param types
	 * @param values
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Map<String, Object> executeQueryForMap(String sql, int[] types, Object[] values)
			throws ClassNotFoundException, SQLException;

	/**
	 * @desc 查询多条数据，不支持预编译
	 * @param sql
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Map<String, Object>> executeQueryForList(String sql) throws ClassNotFoundException, SQLException;

	/**
	 * @desc 查询多条数据，支持预编译
	 * @param sql
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Map<String, Object>> executeQueryForList(String sql, int[] types, Object[] values)
			throws ClassNotFoundException, SQLException;

	/**
	 * @desc 处理数据(增删改)，不支持预编译
	 * @param sql
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int executeUpdate(String sql) throws ClassNotFoundException, SQLException;

	/**
	 * @desc 处理数据(增删改)，支持预编译
	 * @param sql
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int executeUpdate(String sql, int[] types, Object[] values)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;

	/**
	 * @desc 查询数据总记录数，不支持预编译
	 * @param sql
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int executeQueryForInt(String sql) throws ClassNotFoundException, SQLException;

	/**
	 * @desc 查询数据总记录数，支持预编译
	 * @param sql
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int executeQueryForInt(String sql, int[] types, Object[] values) throws ClassNotFoundException, SQLException;

}
