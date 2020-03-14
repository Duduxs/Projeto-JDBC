package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Department department; 
		
		System.out.println("\n=== Test 1 Department Insert ===\n");
		DepartmentDao DepartmentDao = new DaoFactory().createDepartmentDao();
//		Department department = new Department(null, "Horse");
//		DepartmentDao.insert(department);
		
//		System.out.println("\n=== Test 2 Department Update ===\n");
//		department = new Department(13, "Business");
//		DepartmentDao.update(department);
//		
//		System.out.println("\n=== Test 3 Department DeleteById ===\n");
//		DepartmentDao.deleteById(14);
//		
		
//		System.out.println("\n=== Test 4 Department FindById ===\n");
//		department = DepartmentDao.findById(13);
//		System.out.println(department);
		
		
	}
}
