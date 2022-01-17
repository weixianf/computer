package com.rj.bd.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc 数据库操作实现类
 * @author 20441
 * @time 2021-11-17
 */
public class DaoImpl implements Dao {
	// 连库四要素
	private String className = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/superman?useUnicode=true&characterEncoding=utf-8";
	private String user = "root";
	private String password = "root";

	/**
	 * @desc 建立连接
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// 加载驱动
		Class.forName(className);
		// 指定url、user和password
		return DriverManager.getConnection(url, user, password);
	}

	/**
	 * @desc 查询一条数据，不支持预编译
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public Map<String, Object> executeQueryForMap(String sql) throws SQLException, ClassNotFoundException{
		System.out.println("查询一条数据：" + sql);
		Connection con = this.getConnection();
		Statement ment = con.createStatement();
		ResultSet set = ment.executeQuery(sql);
		List<Map<String, Object>> list = setToList(set);
		if (!list.isEmpty()) {
			return list.get(0);
		}
		this.releaseConnection(set, ment, con);
		return null;
	}

	/**
	 * @desc 查询一条数据，支持预编译
	 * @param sql
	 * @param types
	 * @param values
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Override
	public Map<String, Object> executeQueryForMap(String sql, int[] types, Object[] values)
			throws ClassNotFoundException, SQLException {
		System.out.println("查询一条数据：" + sql);
		this.print(values);
		Connection con = this.getConnection();
		PreparedStatement ment = con.prepareStatement(sql);
		if (types != null) {
			for (int i = 0; i < types.length; i++) {
				switch (types[i]) {
				case Types.VARCHAR:
					ment.setString(i + 1, String.valueOf(values[i]));
					break;
				case Types.INTEGER:
					ment.setInt(i + 1, Integer.parseInt(String.valueOf(values[i])));
					break;
				}
			}
		}
		ResultSet set = ment.executeQuery();
		List<Map<String, Object>> list = setToList(set);
		if (!list.isEmpty()) {
			return list.get(0);
		}
		this.releaseConnection(set, ment, con);
		return null;
	}

	/**
	 * @desc 查询多条数据，不支持预编译
	 * @param sql
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public List<Map<String, Object>> executeQueryForList(String sql) throws ClassNotFoundException, SQLException {
		System.out.println("查询多条数据" + sql);
		Connection con = this.getConnection();
		Statement ment = con.createStatement();
		ResultSet set = ment.executeQuery(sql);
		List<Map<String, Object>> list = this.setToList(set);
		this.releaseConnection(set, ment, con);
		return list;
	}

	/**
	 * @desc 查询多条数据，支持预编译
	 * @param sql
	 * @param types
	 * @param values
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Override
	public List<Map<String, Object>> executeQueryForList(String sql, int[] types, Object[] values)
			throws ClassNotFoundException, SQLException {
		System.out.println("查询多条数据：" + sql);
		this.print(values);
		Connection con = this.getConnection();
		PreparedStatement ment = con.prepareStatement(sql);
		if (types != null) {
			for (int i = 0; i < types.length; i++) {
				switch (types[i]) {
				case Types.VARCHAR:
					ment.setString(i + 1, String.valueOf(values[i]));
					break;
				case Types.INTEGER:
					ment.setInt(i + 1, Integer.parseInt(String.valueOf(values[i])));
					break;
				}
			}
		}
		ResultSet set = ment.executeQuery();
		List<Map<String, Object>> list = this.setToList(set);
		this.releaseConnection(set, ment, con);
		return list;
	}

	/**
	 * @desc 操作(增删改)数据，不支持预编译
	 * @param sql
	 * @param types
	 * @param values
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@Override
	public int executeUpdate(String sql) throws ClassNotFoundException, SQLException {
		System.out.println("操作数据：" + sql);
		Connection con = this.getConnection();
		Statement ment = con.createStatement();
		int count = ment.executeUpdate(sql);
		this.releaseConnection(ment, con);
		return count;
	}

	/**
	 * @desc 操作(增删改)数据，支持预编译
	 */
	@Override
	public int executeUpdate(String sql, int[] types, Object[] values)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("操作数据：" + sql);
		this.print(values);
		Connection con = this.getConnection();
		PreparedStatement ment = con.prepareStatement(sql);
		if (types != null) {
			for (int i = 0; i < types.length; i++) {
				switch (types[i]) {
				case Types.VARCHAR:
					ment.setString(i + 1, String.valueOf(values[i]));
					break;
				case Types.INTEGER:
					ment.setInt(i + 1, Integer.parseInt(String.valueOf(values[i])));
					break;
				case Types.BLOB:
					InputStream in = new FileInputStream((File) values[i]);
					ment.setBinaryStream(i + 1, in, in.available());
					break;
				}
			}
		}
		return 0;
	}
	
	/**
	 * @desc  查询数据总记录数，不支持预编译
	 * @param sql
	 * @param types
	 * @param values
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Override
	public int executeQueryForInt(String sql) throws ClassNotFoundException, SQLException {
		System.out.println("查询数据总记录数"+sql);
		Connection con = this.getConnection();
		Statement ment = con.createStatement();
		ResultSet set = ment.executeQuery(sql);
		if(set.next()){
			return set.getInt(1);
		}
		this.releaseConnection(set, ment, con);
		return 0;
	}
	
	/**
	 * @desc  查询数据总记录数，支持预编译
	 * @param sql
	 * @param types
	 * @param values
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Override
	public int executeQueryForInt(String sql, int[] types, Object[] values)
			throws ClassNotFoundException, SQLException {
		System.out.println("查询数据总记录数："+sql);
		this.print(values);
		Connection con = this.getConnection();
		PreparedStatement ment =  con.prepareStatement(sql);
		if( types != null ){
			for(int i=0;i<types.length;i++){
				switch( types[i] ){
				case Types.VARCHAR:
					ment.setString(i+1, String.valueOf( values[i] ) );
					break;
				case Types.INTEGER:
					ment.setInt(i+1, Integer.parseInt( String.valueOf( values[i] ) ));
					break;
				}
			}
		}
		ResultSet set = ment.executeQuery();
		if(set.next()){
			return set.getInt(1);
		}
		this.releaseConnection(set, ment, con);
		return 0;
	}

	/**
	 * @desc set转list
	 * @param set
	 * @return
	 * @throws SQLException
	 */
	private List<Map<String, Object>> setToList(ResultSet set) throws SQLException {
		List<Map<String, Object>> list = new ArrayList<>();
		while (set.next()) {
			Map<String, Object> map = new HashMap<>();
			for (int i = 1; i <= set.getMetaData().getColumnCount(); i++) {
				switch (set.getMetaData().getColumnType(i)) {
				case Types.VARCHAR:
					map.put(set.getMetaData().getColumnTypeName(i), set.getString(i));
					break;
				case Types.INTEGER:
					map.put(set.getMetaData().getColumnTypeName(i), set.getInt(i));
					break;
				case Types.BLOB:
					map.put(set.getMetaData().getColumnTypeName(i), set.getBinaryStream(i));
					break;
				default:
					map.put(set.getMetaData().getColumnTypeName(i), set.getString(i));
					break;
				}
			}
			list.add(map);
		}
		return list;
	}
	
	/**
	 * @desc  打印出所有的参数值
	 * @param values
	 */
	private void print(Object[] values){
		if( values == null ) return;
		System.out.println("参数值：\t---------------------");
		for (int i = 0; i < values.length; i++) {
			System.out.println( "\t["+i+"]=["+values[i]+"]" );
		}
		System.out.println("\t---------------------");
	}

	/**
	 * @desc 关闭连接，不支持预编译
	 * @param set
	 * @param ment
	 * @param con
	 * @throws SQLException
	 */
	private void releaseConnection(Statement ment, Connection con) throws SQLException {
		try {
			if (ment != null) {
				ment.close();
			}
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("Close the connection encounter error!\n" + e.getMessage());
			throw new SQLException("关闭连接异常！");
		}
	}

	/**
	 * @desc 关闭连接，支持预编译
	 * @param set
	 * @param ment
	 * @param con
	 * @throws SQLException
	 */
	public void releaseConnection(PreparedStatement ment, Connection con) throws SQLException {
		try {
			if (ment != null) {
				ment.close();
			}
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("Close the connection encounter error!\n" + e.getMessage());
			throw new SQLException("关闭连接异常！");
		}
	}

	/**
	 * @desc 关闭连接，不支持预编译
	 * @param set
	 * @param ment
	 * @param con
	 * @throws SQLException
	 */
	private void releaseConnection(ResultSet set, Statement ment, Connection con) throws SQLException {
		try {
			if (set != null) {
				set.close();
			}
			if (ment != null) {
				ment.close();
			}
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("Close the connection encounter error!\n" + e.getMessage());
			throw new SQLException("关闭连接异常！");
		}
	}

	/**
	 * @desc 关闭连接，支持预编译
	 * @param set
	 * @param ment
	 * @param con
	 * @throws SQLException
	 */
	private void releaseConnection(ResultSet set, PreparedStatement ment, Connection con) throws SQLException {
		try {
			if (set != null) {
				set.close();
			}
			if (ment != null) {
				ment.close();
			}
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("Close the connection encounter error!\n" + e.getMessage());
			throw new SQLException("关闭连接异常！");
		}
	}
}
