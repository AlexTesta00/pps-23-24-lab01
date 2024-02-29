package example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount {

    private final static int TRANSACTION_FEE = 1;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void withdraw(int userID, double amount) {
        double amounWithAdditionalFee = amount + TRANSACTION_FEE;
        super.withdraw(userID, amounWithAdditionalFee);
    }

}