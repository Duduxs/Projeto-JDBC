package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = new DaoFactory().createSellerDao();
		
//		System.out.println("=== TEST 1: seller findById! ===\n");
//		Seller seller = sellerDao.findById(2);
//		System.out.println(seller);
		
		System.out.println("=== TEST 2: seller findByDepartment! ===\n");
		Department department = new Department(1,"Computers");
		List<Seller> sellerList = sellerDao.findByDepartment(department);
		
		for(Seller x : sellerList) {
		System.out.println(x);
		}
	
		
	
	

	}
}
