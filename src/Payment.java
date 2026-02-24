import java.util.logging.Logger;

public abstract class Payment {
    protected double payment;
    protected String transactionId;
    protected Logger logger;

    protected abstract boolean validate();
    protected abstract void processPayment(double amount) throws IllegalStateException;
    protected abstract void refund(double amount) throws IllegalStateException;

    String generateTransactionId(){

        return "transactionId generated";
    }

}
