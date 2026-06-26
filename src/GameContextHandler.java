package src;

import java.util.Random;

public class GameContextHandler {
    private int rand = getRandom();
    private int currentGameAttempts = 0;
    private int bestGameAttempts = 0;

    public void startNewGame() {
        rand = getRandom();
        currentGameAttempts = 0;
    }

    public int getRand() {
        return rand;
    }

    public void incrementCurrentGameAttempts() {
        currentGameAttempts++;
    }

    public void printResults() {
        if (bestGameAttempts != 0) {
            System.out.printf("результат Героя: %d попыток%n", bestGameAttempts);
        }

        if (currentGameAttempts == 0) {
            System.out.println("Твои результаты ещё впереди, брат!");
            return;
        }

        System.out.printf("попыток в текущей игре: %d%n", currentGameAttempts);
    }

    public void endGame() {
        if (bestGameAttempts == 0 || currentGameAttempts < bestGameAttempts) {
            bestGameAttempts = currentGameAttempts;
        }

        printResults();
    }

    private int getRandom() {
        return (new Random().nextInt(100)) + 1;
    }
}
