package OrderManagement;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String productId;
    private String productName;
    private String productDesc;
    private double productPrice;
    private int stockQuantity;


    public Product(String productId) {
    }

    public Product(String productId, String productName, String productDesc, double productPrice, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.stockQuantity = stockQuantity;
    }
    public static List<Product> fetchAllProducts(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("1", "prod1" , "prod desc", 100.0 , 5));
        productList.add(new Product("2", "prod2" , "prod desc", 100.0 , 2));
        productList.add(new Product("3", "prod3" , "prod desc", 100.0 , 4));
        productList.add(new Product("4", "prod4" , "prod desc", 100.0 , 1));
        productList.add(new Product("5", "prod5" , "prod desc", 100.0 , 9));
        productList.add(new Product("6", "prod6" , "prod desc", 100.0 , 3));

        return productList;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getProductId() {
        return productId;
    }
}
