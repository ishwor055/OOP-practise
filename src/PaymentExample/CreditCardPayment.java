import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(double amount, PaymentLogger logger, String cardNumber , String cvv, String expiryDate){
        super(amount,logger);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
    @Override
    public void validate() throws InvalidPaymentException{
         if(! isValidCardNumber(cardNumber) && isValidCVV(cvv) && isValidExpiryDate(expiryDate)) throw  new InvalidPaymentException(" Invalid Card information") ;
         else logger.log("validation successful for transaction : " + transactionId);
    }

    @Override
    public void processPayment() throws PaymentFailedException{
        // Simulate payment processing
        try {
            double fee = amount * 0.02;
            double total = amount + fee;

            logger.log("Processing credit card payment...");
            logger.log("Amount: " + amount);
            logger.log("Fee: " + fee);
            logger.log("Total charged: " + total);

        } catch (Exception e) {
            throw new PaymentFailedException("Processing failed");
        }
    }

    public void refund()throws PaymentFailedException {
        logger.log("Refunding credit card payment for transaction " + transactionId);
    }


    private boolean isValidCardNumber(String cardNumber){
        if(cardNumber == null || cardNumber.isEmpty()) return false;
        if(!cardNumber.matches("\\d+")) return false;
        return (cardNumber.length() >= 13) && (cardNumber.length() <=19);
    }

    private boolean isValidCVV(String cvv){
        return cvv!=null && cvv.matches("\\d{3,4}");
    }

    private boolean isValidExpiryDate(String expiryDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
            YearMonth expiry = YearMonth.parse(expiryDate, formatter);
            return !expiry.isBefore(YearMonth.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
