package OrderManagement;

public class OrderProcessor {
    public void executeOrder(Order order) {
        try {
            order.validateOrder();
            order.processOrder();
            System.out.println("Order processed successfully: " + order.getOrderId());
        } catch (InvalidOrderException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
    }

    public void cancelOrder(Order order) {
        try {
            order.cancelOrder();
            System.out.println("Order cancelled: " + order.getOrderId());
        } catch (InvalidOrderException e) {
            System.out.println("Cancellation failed: " + e.getMessage());
        }
    }


}
