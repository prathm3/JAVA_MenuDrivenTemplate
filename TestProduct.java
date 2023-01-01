package com.demo.test;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestProduct {
	
	public static void main(String[] args) {
		ProductService pservice = new ProductServiceImpl();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		int choice = 0;;
		do {
		System.out.println("==========================================================================================");
		System.out.println("                            MAKE YOUR CHOICE : " );
		System.out.println("1 : Add New Product to List"
				+ "\n2  : Remove Product By ID "
				+ "\n3  : Remove Product By Name"
				+ "\n4  : Display All Products"
				+ "\n5  : Find Product By ID"
				+ "\n6  : Sort Product By Price"
				+ "\n7  : Display All Prodct Greater Than Your Qunatity"
				+ "\n8  : Modify Price Of Product"
				+ "\n9  : Find Product By Name"
				+ "\n10 : Sort Product By Name"
				+ "\n11 : Exit");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("Enter Your Choice =>");
	
		choice = sc.nextInt();
		switch(choice) {
		case 1:
			pservice.addProduct();
			break;
		case 2:
			System.out.println("Enter id");
			int id = sc.nextInt();
			pservice.removeProductByID(id);
			break;
		case 3:
			System.out.println("Enter name");
			String name = sc.next();
			pservice.removeProductByName(name);
			break;
		case 4:
			List<Product> plist = pservice.getProduct();
			for(Product p :plist) {
				System.out.println(p);
			}
			break;
		case 5:
			System.out.println("Enter id");
			id = sc.nextInt();
			Product p = pservice.findById(id);
			System.out.println(p);
			break;
		case 6:
			pservice.sortByPrice();
			break;
		case 7:
			System.out.println("Enter qty");
			int qty = sc.nextInt();
			pservice.findByQty(qty);
			break;
		case 8:
			System.out.println("Enter id, new Price");
			id = sc.nextInt();
			float newPrice = sc.nextFloat();
			pservice.modifyPriceById(id, newPrice);
			break;
		case 9:
			System.out.println("Enter name");
			name = sc.next();
			p = pservice.findByName(name);
			System.out.println(p);
		case 10:
			pservice.sortByName();
			break;
		case 11:
			sc.close();
			System.exit(0);
			break;
		default:
			System.out.println("Enter valid Choice");
			break;
		}
		}while(choice != 12);
	}
}
