public class Main {
    public static void main(String[] args) {
        PaymentLogger logger = new ConsoleLogger();

        Payment payment = new CreditCardPayment(1000.0 , logger, "1234123456785678" , "999" , "01/28");

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.executePayment(payment);

        paymentProcessor.refund(payment);

    }


}
