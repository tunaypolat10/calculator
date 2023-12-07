package Main;

import java.util.Scanner;

public class Main {
    public static String calc(String input) {
        try {
            String[] tokens = input.split(" ");

            if (tokens.length != 3) {
                throw new IllegalArgumentException("Неверный ввод: Должна быть одна операция между двумя числами.");
            }

            int num1 = Integer.parseInt(tokens[0]);
            int num2 = Integer.parseInt(tokens[2]);
            String operator = tokens[1];

            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new IllegalArgumentException("Неверный ввод: Числа должны быть в диапазоне от 1 до 10.");
            }

            int result = switch (operator) {
                case "+"-> num1 + num2;
                case "-"-> num1 - num2;
                case "*"-> num1 * num2;
                case "/"-> num1 / num2;
                default ->
                        throw new IllegalArgumentException("Неверный ввод: Используйте допустимый оператор (+, -, *, /).");
            };
            return String.valueOf(result);
        } catch (ArithmeticException e) {
            return "Ошибка: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите операцию (пример: 5 + 3): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            String result = calc(input);
            System.out.println("Результат: " + result);
        }
        scanner.close();
    }
}