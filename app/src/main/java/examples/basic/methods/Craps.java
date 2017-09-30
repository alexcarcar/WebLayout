package examples.basic.methods;

import java.util.Random;

public class Craps {
    private static final Random random = new Random();
    private static final int SNAKE_EYES = 2; // constants that represent game status
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void main(String[] args) {
        int myPoint = 0; // point if no win or loss on first roll
        Status gameStatus;
        int sumOfDice = rollDice();
        switch (sumOfDice) {
            case SEVEN: // win with 7 on first roll
            case YO_LEVEN: // win with 11 on first roll
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES: // lose with 2 on first roll
            case TREY: // lose with 3 on first roll
            case BOX_CARS: // lose with 12 on first roll
                gameStatus = Status.LOST;
                break;
            default: // did not win or lose, so remember point
                gameStatus = Status.CONTINUE;
                myPoint = sumOfDice;
                System.out.printf("Point is %d\n", myPoint);
                break;
        }

        while (gameStatus == Status.CONTINUE) {
            sumOfDice = rollDice();
            if (sumOfDice == myPoint) { // win by making point
                gameStatus = Status.WON;
            } else if (sumOfDice == SEVEN) { // lose by rolling 7 before point
                gameStatus = Status.LOST;
            }
        }

        System.out.println("Player " + (gameStatus == Status.WON ? "wins" : "loses"));
    }

    public static int rollDice() {
        int die1 = 1 + random.nextInt(6);
        int die2 = 1 + random.nextInt(6);
        int sum = die1 + die2;
        System.out.printf("Player rolled %d + %d = %d\n", die1, die2, sum);
        return sum;
    }

    private enum Status {CONTINUE, WON, LOST}
}
