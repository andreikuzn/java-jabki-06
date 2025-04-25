import java.util.Random;

public class Game {
    private final int secretNumber;

    public Game() {
        Random random = new Random();
        this.secretNumber = random.nextInt(100) + 1;
    }

    public Game(int secretNumber) {
        this.secretNumber = secretNumber;
    }

    public String checkGuess(int guess) {
        if (guess < 1 || guess > 100) {
            throw new IllegalArgumentException("Число должно быть от 1 до 100");
        }

        if (guess < secretNumber) {
            return "Больше";
        } else if (guess > secretNumber) {
            return "Меньше";
        } else {
            return "Угадал";
        }
    }
}