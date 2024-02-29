import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;

public class SimpleBankAccountWithAtmTest {
    
    private final static int DEFAULT_ID = 1;
    private final static int DEFAULT_BALANCE_AMOUNT = 0;
    private AccountHolder holder;
    private BankAccount bankAccountWithAtm;

    @BeforeEach
    public void init(){
        this.holder = new AccountHolder("Mario", "Rossi", DEFAULT_ID);
        this.bankAccountWithAtm = new SimpleBankAccountWithAtm(this.holder, DEFAULT_BALANCE_AMOUNT);
    }

    @Test
    public void correctWithdraw(){
        this.bankAccountWithAtm.deposit(this.holder.getId(), 100);
        this.bankAccountWithAtm.withdraw(this.holder.getId(), 70);
        assertEquals(29, this.bankAccountWithAtm.getBalance());
    }

    @Test
    public void wrongWithdraw(){
        this.bankAccountWithAtm.deposit(this.holder.getId(), 100);
        this.bankAccountWithAtm.withdraw(2, 70);
        assertEquals(100, this.bankAccountWithAtm.getBalance());
    }
}
