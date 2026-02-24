import java.util.UUID;
import java.util.logging.Logger;

public abstract class Payment {
    protected final double amount;
    protected final String transactionId;
    protected final PaymentLogger logger;

    public Payment(double amount, PaymentLogger logger ){
        if(amount <= 0 ){
            throw new IllegalArgumentException("Amount must be positive and greater than zero");
        }
        this.amount = amount;
        this.logger = logger;
        this.transactionId = UUID.randomUUID().toString();
    }

    protected abstract void validate() throws InvalidPaymentException;
    protected abstract void processPayment() throws PaymentFailedException;
    protected abstract void refund() throws PaymentFailedException;

    public double getAmount() {
        return amount;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
