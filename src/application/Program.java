package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("---- TEST 1 : seller findById ----");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n---- TEST 2 : seller findByDepartment ----");
        Department department = new Department(2, null);
        List<Seller> sellerList = sellerDao.findByDepartment(department);
        for (Seller obj : sellerList) {
            System.out.println(obj);
        }

        System.out.println("\n---- TEST 3 : seller findAll ----");
        sellerList = sellerDao.findAll();
        for (Seller obj : sellerList) {
            System.out.println(obj);
        }

        System.out.println("\n---- TEST 4 : seller Insert ----");
        Seller newSeller = new Seller(null, "Pedro Bruno", "pedro@gmail2.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + seller.getId());

        System.out.println("\n---- TEST 5 : seller Update ----");
        seller = sellerDao.findById(1);
        seller.setName("Joao Paulo");
        sellerDao.update(seller);
        System.out.println("Update completed! New name = " + seller.getName());

        System.out.println("\n---- TEST 6 : seller Update ----");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");
        sc.close();
    }
}
