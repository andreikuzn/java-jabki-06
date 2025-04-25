public class Wallet {

    private String owner;
    private int money;

    public Wallet(String owner, int money) {
        setOwner(owner);
        setMoney(money);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        if (owner == null || owner.trim().isEmpty()) {
            throw new IllegalArgumentException("Поле \"Владелец\" не может быть null или пустым");
        }
        this.owner = owner;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Сумма денег не может быть отрицательной");
        }
        this.money = money;
    }

    public void spend(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма списания не может быть отрицательной");
        }
        if (money < amount) {
            throw new IllegalArgumentException("Недостаточно средств для списания");
        }
        money -= amount;
    }
}
