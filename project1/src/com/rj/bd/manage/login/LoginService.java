package com.rj.bd.manage.login;

import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import com.rj.bd.dao.Dao;
import com.rj.bd.dao.DaoImpl;

public class LoginService {
	Dao dao = new DaoImpl();
	/**
	 * @desc  查询管理员账号和密码
	 * @param name
	 * @param password
	 * @return 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Map<String, Object> queryToManager(String name, String password) throws ClassNotFoundException, SQLException {
		String sql = "select * from admin where AdminName=? and AdminPwd=?";
		int[] types = new int[2];
		types[0]=Types.VARCHAR;
		types[1]=Types.VARCHAR;
		Object[] values = new Object[2];
		values[0]=name;
		values[1]=password;
		return dao.executeQueryForMap(sql, types, values);
	}
	
}
