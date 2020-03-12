package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn = null;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
// The date has to be date.sql not date.util!
//		PreparedStatement st = null;
//		try {
//		st = conn.prepareStatement("insert into seller values (?, ?, ?, ?, ?, ?);");
//		
//		st.setInt(1, obj.getId());
//		st.setString(2, obj.getName());
//		st.setString(3, obj.getEmail());
//		st.setDate(4,  obj.getBirthDate());
//		st.setDouble(5, obj.getBaseSalary());
//		st.setInt(6, obj.getDepartment().getId());
//		
//		int rows = st.executeUpdate();
//		
//		if(rows > 0) 
//			System.out.println("Query executed with sucess, " + rows + " rows affected");
//		else
//			System.out.println("Query wasn't executed");
//		
//		
//		}
//		catch(SQLException e) {
//			throw new DbException(e.getMessage());
//		}
//		finally {
//			DB.closeStatement(st);
//			}

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department ON seller.DepartmentId = department.Id WHERE seller.Id = ?;");

			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {

				Department dep = makeDepartment(rs);
				Seller sell = makeSeller(rs, dep);
				return sell;

			}
			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Seller> sell = new ArrayList<Seller>();
		try {
			st = conn.prepareStatement("select seller.*, department.Name from seller inner join department on DepartmentId = department.id where departmentId = ? order by seller.Id;");

			st.setInt(1, department.getId());
			rs = st.executeQuery();
			
			while (rs.next()) {
				sell.add(makeSeller(rs, department));
			}
			return sell;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	// Inicializable the department
	private Department makeDepartment(ResultSet rs) throws SQLException {

		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;

	}

	// Inicializable the seller
	private Seller makeSeller(ResultSet rs, Department dep) throws SQLException {

		Seller sell = new Seller();
		sell.setId(rs.getInt("Id"));
		sell.setName(rs.getString("Name"));
		sell.setEmail(rs.getString("Email"));
		sell.setBirthDate(rs.getDate("BirthDate"));
		sell.setBaseSalary(rs.getDouble("BaseSalary"));
		sell.setDepartment(dep);
		return sell;
	}

}
