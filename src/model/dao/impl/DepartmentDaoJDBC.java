package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{

	private Connection conn = null;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("insert into department (Name) values (?)");
			st.setString(1, obj.getName());
			
			int rows = st.executeUpdate();
			
			if(rows > 0)
				System.out.println(rows + " rows affected!");
			else
				throw new DbException("Error! No rows affected!");
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("update department set Name = ? where Id = ?");
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			int rows = st.executeUpdate();
			
			if(rows > 0)
				System.out.println(rows + " rows affected!");
			else
				throw new DbException("Error! No rows affected!");
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}