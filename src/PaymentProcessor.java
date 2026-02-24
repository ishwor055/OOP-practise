public class PaymentProcessor {
    public void executePayment(Payment payment){
        try {
            payment.validate();
            payment.processPayment();
            System.out.println("Payment successful. Transaction ID: " + payment.getTransactionId());
        } catch (InvalidPaymentException | PaymentFailedException e) {
            System.out.println("Payment failed: " + e.getMessage());
        }
    }

    public void refund(Payment payment){
        try {
            payment.validate();
            payment.refund();
            System.out.println("Refund successful. Transaction ID: " + payment.getTransactionId());
        } catch (InvalidPaymentException | PaymentFailedException e) {
            System.out.println("Refund failed: " + e.getMessage());
        }
    }
}
