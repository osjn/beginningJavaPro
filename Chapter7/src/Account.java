import java.math.BigDecimal;

public abstract class Account {
    private String name;
    private BigDecimal amount;

    public Account(String acctName, String startAmount) {
        this.setName(acctName);
        this.setAmount(new BigDecimal(startAmount));
        this.getAmount().setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("Account Created: " + this.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        String pattern = "^[a-zA-Z0-9]*$";
        if (newName.matches(pattern)) {
            this.name = newName;
        }
    }

    public BigDecimal getAmount() {
        return amount;
    }

    private void setAmount(BigDecimal newAmount) {
        this.amount = new BigDecimal(String.valueOf(newAmount));
    }

    public void withdraw(String withdrawal) throws IllegalArgumentException {
        BigDecimal desiredAmount = new BigDecimal(withdrawal);

        // if desired amount is negative, throw an exception
        if (desiredAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }

        // if the amount is less than the desired amount, throw an exception
        if (amount.compareTo(desiredAmount) < 0) {
            throw new IllegalArgumentException();
        }

        this.amount = this.amount.subtract(desiredAmount);
    }

    public void deposit(String deposit) throws IllegalArgumentException {
        BigDecimal desiredAmount = new BigDecimal(deposit);

        // if desired amount is negative, throw an exception
        if (desiredAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }

        this.amount = this.amount.add(desiredAmount);
    }

    @Override
    public String toString() {
        return this.getName() + ": Balance = " + this.getAmount();
    }
}
