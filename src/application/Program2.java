package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		System.out.println("\n=== Test 1 Department Insert ===\n");
		DepartmentDao DepartmentDao = new DaoFactory().createDepartmentDao();
		Department department = new Department(null, "Horse");
		DepartmentDao.insert(department);
		
		
	}
}
