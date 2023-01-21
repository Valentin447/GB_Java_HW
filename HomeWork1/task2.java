// Вывести все простые числа от 1 до 1000
package HomeWork1;

import java.util.ArrayList;
import java.util.Arrays;

public class task2 {
  public static void main(String[] args) {
    ArrayList<Integer> primes = new ArrayList<>();
    int max = 1000;
    boolean[] isPrime = new boolean[max];
    Arrays.fill(isPrime, true);

    for (int i = 2; i * i < max; i++) {
      if (isPrime[i]) {
        for (int j = 2 * i; j < max; j += i) {
          isPrime[j] = false;
        }
      }
    }
    for (int i = 2; i < max; i++) {
      if (isPrime[i]) {
        primes.add(i);
      }
    }
    System.out.println(Arrays.toString(primes.toArray()));
  }
}