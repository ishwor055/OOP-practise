import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cvv;
    private String expiryDate;
    private double amount;
    FileLogger logger;
    public CreditCardPayment(String cardNumber , String cvv, String expiryDate){
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
    @Override
    public boolean validate(){
        return isValidCardNumber(cardNumber) && isValidCVV(cvv) && isValidExpiryDate(expiryDate);
    }

    @Override
    public void processPayment(double amount) {
        if(!validate()){
             throw new IllegalStateException("Payment detail is invalid");
        }
        // Simulate payment processing
        String last4 = cardNumber.substring(cardNumber.length() - 4);
        logger.log("Processing payment of $" + amount + " for card ending with " + last4);

        // Simulated successful transaction
        logger.log("Payment successful for card ending with " + last4 + " amount $" + amount);
        clearSensitiveData();
    }

    public void refund(double amount){
        if(!validate()){
            throw new IllegalStateException("Payment detail is invalid");
        }
        // Simulate refund processing
        String last4 = cardNumber.substring(cardNumber.length() - 4);
        logger.log("Processing refund of $" + amount + " for card ending with " + last4);

        // Simulated successful transaction
        logger.log("Refund successful for card ending with " + last4 + " amount $" + amount);
        clearSensitiveData();
    }


    private boolean isValidCardNumber(String cardNumber){
        if(cardNumber == null || cardNumber.isEmpty()) return false;
        if(!cardNumber.matches("\\d+")) return false;
        return (cardNumber.length() >= 13) && (cardNumber.length() <=19);
    }

    private boolean isValidCVV(String cvv){
        return cvv!=null && cvv.matches("\\d{3,4}");
    }

    private boolean isValidExpiryDate(String expiryDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        YearMonth expiryDateFormat = YearMonth.parse(expiryDate , formatter);
        return expiryDateFormat.isAfter(YearMonth.now());
    }

    private void clearSensitiveData() {
        cardNumber = null;
        cvv = null;
        expiryDate = null;
    }


}
