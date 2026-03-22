package OrderManagement;

import java.util.List;

public class ImplementOrder extends Order{
    private final String shippingAddress;
    private final Product product;
    private List<Product> productList;

    public ImplementOrder(int quantity, OrderLogger logger, String shippingAddress, Product product){
        super(quantity, logger);
        this.shippingAddress = shippingAddress;
        productList = Product.fetchAllProducts();
        this.product = product;
    }

    @Override
    protected void validateOrder() throws InvalidOrderException {
        if(shippingAddress==null || shippingAddress.isEmpty()){
            throw new InvalidOrderException("Shipping Address is invalid");
        }

        for (Product p : productList) {
            if(p.getProductId() == product.getProductId()){
                if(p.getStockQuantity() >= quantity){
                    logger.log("Product "+product + "is on stock");
                }
                else throw new InvalidOrderException("product is not on stock");
            }
            else throw new InvalidOrderException("the product is not available");
        }

    }

    @Override
    protected void processOrder() throws InvalidOrderException {
        logger.log("Product "+product + " is ordered successfuclly with orderId : " +orderId);
    }

    @Override
    protected void cancelOrder() {
        logger.log("Cancelling order: " + orderId);
    }



}
