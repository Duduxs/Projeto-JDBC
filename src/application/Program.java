package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = new DaoFactory().createSellerDao();
		
//		System.out.println("\n=== TEST 1: seller findById! ===\n");
//		Seller seller = sellerDao.findById(2);
//		System.out.println(seller);
		
//		System.out.println("\n=== TEST 2: seller findByDepartment! ===\n");
//		Department department = new Department(2,null);
//		List<Seller> sellerList = sellerDao.findByDepartment(department);
//		m
//		for(Seller x : sellerList) {
//		System.out.println(x);
//		}
//		
		System.out.println("\n=== TEST 3: seller findAll! ===\n");
		List<Seller> sellerList2 = sellerDao.findAll();
		
		for(Seller x : sellerList2) {
			System.out.println(x);
			}
	
		
	
	

	}
}
