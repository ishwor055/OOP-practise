package OrderManagement;

import java.util.List;
import java.util.UUID;

public abstract class Order {
    protected final String orderId;
    protected final int quantity;
    protected final OrderLogger logger;
    public Order(int quantity,OrderLogger logger){
        if(quantity <= 0){
            throw new IllegalArgumentException("product quantity cannot be 0 or negative");
        }
        this.quantity=quantity;
        this.logger=logger;
        this.orderId= UUID.randomUUID().toString();
    }

    protected abstract void validateOrder() throws InvalidOrderException;
    protected abstract void processOrder() throws InvalidOrderException;
    protected abstract void cancelOrder() throws InvalidOrderException;


    public String getOrderId() {
        return orderId;
    }

    public int getQuantity() {
        return quantity;
    }
}
