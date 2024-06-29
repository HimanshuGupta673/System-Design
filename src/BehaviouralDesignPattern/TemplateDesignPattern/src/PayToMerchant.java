public class PayToMerchant  extends PaymentFlow{
    @Override
    public void validateRequest() {
        System.out.println("Validate logic of PayToMerchantFlow");
    }

    @Override
    public void calculateFess() {
        System.out.println("2% fees charged");
    }

    @Override
    public void debitAmount() {
        System.out.println("Debit the amount logic of PayToMerchant");
    }

    @Override
    public void creditAmount() {
        System.out.println("Credit the remaining amount");
    }
}
