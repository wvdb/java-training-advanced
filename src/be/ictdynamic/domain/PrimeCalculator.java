package be.ictdynamic.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PrimeCalculator implements Callable<List<Long>> {
    private long max;

    public PrimeCalculator(long max) {
        this.max= max;
    }

    @Override
    public List<Long> call()  {
        List<Long> primes = new ArrayList<>();
        for (long number = 2; number <= max; number++) {
            boolean isPrime = true;
            for (int i = 0; (i < primes.size()) && isPrime && ((primes.get(i)*primes.get(i)) <= number) ; i++) {
                isPrime = (number % primes.get(i)) != 0;
            }

            if (isPrime) {
                primes.add(number);
            }
        }
        return primes;
    }

}
