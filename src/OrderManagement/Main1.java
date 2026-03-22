package OrderManagement;
public class Main1 {
    public static void main(String[] args) {
        OrderLogger logger = new OrderLogger();
        Product product = new Product("1");
        Order order = new ImplementOrder(2 , logger , "100 Eagle Dr." , product);

        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.executeOrder(order);
        orderProcessor.cancelOrder(order);
    }
}
