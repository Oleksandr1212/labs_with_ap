import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the number of Fibonacci numbers
        System.out.println("Введіть кількість перших чисел Фібоначчі для обчислення:");
        int n = scanner.nextInt();

// Create an array of NumberSequence objects for Fibonacci numbers
        NumberSequence[] numbers = new NumberSequence[n];

        System.out.println("Послідовність чисел Фібоначчі:");
        for (int i = 0; i < n; i++) {
            numbers[i] = new NumberSequence(i);
            System.out.println("Число " + (i + 1) + ": " + numbers[i].getValue());
        }

// We check which numbers are prime
        System.out.println("\nПрості числа серед перших " + n + " чисел Фібоначчі:");
        for (int i = 0; i < n; i++) {
            if (NumberSequence.isPrime(numbers[i].getValue())) {
                System.out.println("Число " + numbers[i].getValue() + " є простим.");
            }
        }
    }
}
