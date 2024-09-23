/**
 * A class for working with Fibonacci numbers.
 */
public class NumberSequence {

    private int index;
    private long value;

    /**
     * A constructor that calculates the Fibonacci number by index.
     * @param index number number
     */
    public NumberSequence(int index) {
        this.index = index;
        this.value = calculateFibonacci(index);
    }

    public int getIndex() {
        return index;
    }

    public long getValue() {
        return value;
    }

    /**
     * Calculates the nth Fibonacci number.
     * @param n number number
     * @return nth Fibonacci number
     */
    private long calculateFibonacci(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    /**
     * Checks whether a number is prime.
     * @param number the number to check
     * @return true if the number is prime, false otherwise
     */
    public static boolean isPrime(long number) {
        if (number <= 1) return false;
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
