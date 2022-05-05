package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String[][] field = initField(3);
        printField(field);

        while (true) {
            humanMakeTurn(field);
            printField(field);
            if (isWinner(field, "X")) {
                System.out.println("X выиграл");
                break;
            }
            if (isDraw(field)) {
                System.out.println("Ничья");
                break;
            }

            aiMakeTurn(field);
            printField(field);
            if (isWinner(field, "0")) {
                System.out.println("0 выиграл");
                break;
            }
            if (isDraw(field)) {
                System.out.println("Ничья");
                break;
            }

        }
    }

    public static String[][] initField(int size) {
        String[][] field = new String[size][size];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = "*";
            }
        }
        return field;
    }

    public static void printField(String[][] field) {
        System.out.println("------------------");
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println("------------------");

    }

    // Ход человека
    public static void humanMakeTurn(String[][] field) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            if ((x >= 0 && x < field.length) && (y >= 0 && y < field.length)) {
                if (field[x][y].equals("*")) {
                    field[x][y] = "X";
                    break;
                } else {
                    System.out.println("Ячейка занята, ходите снова");

                }
            } else {
                System.out.println("Ход за пределами игрового поля");
            }
        }

    }

    // ИИ делает ход
    public static void aiMakeTurn(String[][] field) {
        Random random = new Random();
        while (true) {
            int x = random.nextInt(field.length);
            int y = random.nextInt(field.length);
            if ((x >= 0 && x < field.length) && (y >= 0 && y < field.length)) {
                if (field[x][y].equals("*")) {
                    field[x][y] = "0";
                    break;
                }
            }
        }
    }

    // Проверка победы
    public static boolean isWinner(String[][] field, String turn) {
        boolean win = true;
        for (int i = 0; i < 3; i++) {
            win = true;
            for (int j = 0; j < 3; j++) {
                if (!field[i][j].equals(turn)) {
                    win = false;
                }
            }

            if (win) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            win = true;
            for (int j = 0; j < 3; j++) {
                if (!field[j][i].equals(turn)) {
                    win = false;
                }
            }

            if (win) {
                return true;
            }
        }
        win = true;
        for (int i = 0; i < 3; i++) {
            if (!field[i][i].equals(turn)) {
                win = false;
            }
        }
        if (win) {
            return true;
        }

        win = true;
        for (int i = 0; i < 3; i++) {
            if (!field[2 - i][i].equals(turn)) {
                win = false;
            }
        }

        if (win) {
            return true;
        }


        return false;

    }

    public static boolean isDraw(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j].equals("*")) {
                    return false;
                }
            }
        }
        return true;
    }


}
