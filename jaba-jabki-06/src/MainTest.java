import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void accountTest() {
        Account account = new Account();
        Assertions.assertEquals(0.0, account.getBalance());

        account.deposit(100);
        Assertions.assertEquals(100.0, account.getBalance());

        account.deposit(80);
        Assertions.assertEquals(180.0, account.getBalance());

        account.withdraw(-100);
        Assertions.assertEquals(180.0, account.getBalance());

        account.withdraw(100);
        Assertions.assertEquals(80.0, account.getBalance());

        account.withdraw(80);
        Assertions.assertEquals(0.0, account.getBalance());

        account.withdraw(1);
        Assertions.assertEquals(0.0, account.getBalance());
    }

    @Test
    void walletTest() {
        Wallet wallet = new Wallet("Михаил", 1000);
        Assertions.assertEquals("Михаил", wallet.getOwner());
        Assertions.assertEquals(1000, wallet.getMoney());

        wallet.setMoney(1200);
        Assertions.assertEquals(1200, wallet.getMoney());

        wallet.setOwner("Петр");
        Assertions.assertEquals("Петр", wallet.getOwner());

        wallet.spend(200);
        Assertions.assertEquals(1000, wallet.getMoney());

        Assertions.assertThrows(IllegalArgumentException.class, () -> wallet.setMoney(-100));

        Assertions.assertThrows(IllegalArgumentException.class, () -> wallet.spend(1100));

        Assertions.assertThrows(IllegalArgumentException.class, () -> wallet.spend(-50));

        Assertions.assertThrows(IllegalArgumentException.class, () -> wallet.setOwner(null));

        Assertions.assertThrows(IllegalArgumentException.class, () -> wallet.setOwner("  "));
    }

    @Test
    void gameTest() {
        Game game = new Game(50);
        Assertions.assertEquals("Больше", game.checkGuess(30));

        Assertions.assertEquals("Меньше", game.checkGuess(70));

        Assertions.assertEquals("Угадал", game.checkGuess(50));

        Assertions.assertThrows(IllegalArgumentException.class, () -> game.checkGuess(0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> game.checkGuess(101));
    }

    @Test
    void televisionTest() {
        Television tv = new Television(10, 50);
        Assertions.assertEquals(10, tv.getCurrentChannel());
        Assertions.assertEquals(50, tv.getVolume());

        tv.setVolume(75);
        Assertions.assertEquals(75, tv.getVolume());

        tv.setVolume(0);
        Assertions.assertEquals(0, tv.getVolume());

        tv.setVolume(100);
        Assertions.assertEquals(100, tv.getVolume());

        tv.setCurrentChannel(50);
        Assertions.assertEquals(50, tv.getCurrentChannel());

        tv.nextChannel();
        Assertions.assertEquals(1, tv.getCurrentChannel());

        Assertions.assertThrows(IllegalArgumentException.class, () -> tv.setCurrentChannel(51));
        Assertions.assertThrows(IllegalArgumentException.class, () -> tv.setCurrentChannel(0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> tv.setVolume(101));
        Assertions.assertThrows(IllegalArgumentException.class, () -> tv.setVolume(-1));
    }

    @Test
    void orderTest() {
        Order order = new Order();
        Assertions.assertEquals(1, order.getOrderId());
        Assertions.assertTrue(order.getItems().isEmpty());
        Assertions.assertEquals(0.0, order.getTotalPrice());

        order.addItem("Товар 1", 10.5);
        order.addItem("Товар 2", 1.09);
        Assertions.assertEquals(2, order.getItems().size());
        Assertions.assertTrue(order.getItems().contains("Товар 1"));
        Assertions.assertTrue(order.getItems().contains("Товар 2"));
        Assertions.assertEquals(11.59, order.getTotalPrice());
        String expectedInfo = "Order ID: 1\nItems: [Товар 1, Товар 2]\nTotal Price: 11.59";
        Assertions.assertEquals(expectedInfo, order.getOrderInfo());

        Assertions.assertThrows(IllegalArgumentException.class, () -> order.addItem("Товар 1", -10.0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> order.addItem("Товар 1", 0.0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> order.addItem(null, 10.0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> order.addItem("", 10.0));
    }
}
