import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                Введите арифметическую операцию (например, 1 + 2):
                если хотите завершить, нажмите 'x'""");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("x")) {
                System.out.println("Программа завершена.");
                break;
            }

            try {
                int result = calculate(input);
                System.out.println("Результат: " + result);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        scanner.close();
    }

    public static int calculate(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception("Должно быть 3 значения, включая оператор (+, -, *, /)");
        }

        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[2]);
        char operator = parts[1].charAt(0);
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Цифры должны быть от 1 до 10");
        }

        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new Exception("Деление на ноль");
                }
                return a / b;
            default:
                throw new Exception("Недопустимый оператор");
        }
    }
}