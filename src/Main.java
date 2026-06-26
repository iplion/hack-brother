package src;

import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        var contextHandler = new GameContextHandler();

        System.out.println("Привет, дружище! Ну введи же число от 1 до 100, я так этого жду!");

        boolean isPlaying = true;

        while (isPlaying) {
            contextHandler.startNewGame();

            playGame(contextHandler);

            System.out.println("Сыграть еще раз? y/n");
            String answer = input.nextLine();

            if (!answer.equalsIgnoreCase("y")) {
                isPlaying = false;
                continue;
            }

            System.out.println("А ты силён! Вводи число от 1 до 100, я в ожидании!");
        }

    }

    private static void playGame(GameContextHandler contextHandler) {
        int userNum = 0;

        while (userNum != contextHandler.getRand()) {
            String userInput = input.nextLine();

            if (userInput.equalsIgnoreCase("RESULT")) {
                contextHandler.printResults();
                continue;
            }

            try {
                userNum = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.printf("Брат, \"%s\" - это не число! Числа,- они другие!%n", userInput);
                continue;
            }

            if (userInput.length() > 3) {
                System.out.println("Ну не, тут слишком много циферок, попробуй ещё, ты сможешь!");
                continue;
            }

            if (userNum < 1 || userNum > 100) {
                System.out.println("Я же просил от 1 до 100, зачем ты так со мной?");
                continue;
            }

            contextHandler.incrementCurrentGameAttempts();

            if (userNum < contextHandler.getRand()) {
                System.out.println("Я сам в шоке, но, загаданное число больше, брат");
            }

            if (userNum > contextHandler.getRand()) {
                System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
            }
        }

        contextHandler.endGame();
    }

}
