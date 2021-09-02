package task1718;

import org.apache.commons.math3.primes.Primes;

public class Determinant {

    public void defineArrayElement(String[] array) {
        for (String str : array) {
            if (str.matches("^[0-9]*$")) {
                int i = Integer.parseInt(str);
                if (Primes.isPrime(i)) {
                    System.out.printf("%s - prime%n", str);
                } else {
                    System.out.printf("%s - not prime%n", str);
                }
            } else {
                System.out.printf("%s - this is not an int number%n", str);
            }
        }
    }
}