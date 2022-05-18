package test2021.threading;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class PrimeNumberList2 {
    private static final BlockingDeque<Integer> primes = new LinkedBlockingDeque<>(15);

    synchronized public void savePrime(int prime) {
           try {
               primes.putLast(prime);
           } catch (InterruptedException ignored) {}
    }

    synchronized public int getPrime() {
        int oldest = -1;
        try {
            oldest = primes.takeFirst();
        } catch (InterruptedException ignored) {}
        primes.removeFirst();
        return oldest;
    }
}
