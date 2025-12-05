/**
 * Curso: / MCA 1
 *
 * Fibonacci con BigInteger + Hashtable
 *
 * Mejora: Se incorpora Hashtable para almacenar resultados ya calculados
 *         y evitar la explosión de llamadas recursivas.
 */

import java.math.BigInteger;
import java.util.Hashtable;

public class FibonacciThreadsBigIntegerMem implements Runnable {

    BigInteger fi;
    int num;

    // Hashtable compartida para guardar resultados ya calculados
    static Hashtable<BigInteger, BigInteger> memo = new Hashtable<>();

    public FibonacciThreadsBigIntegerMem(int n, BigInteger f) {
        num = n;
        fi = f;
        // Inicializamos casos base
        memo.put(BigInteger.ZERO, BigInteger.ONE);
        memo.put(BigInteger.ONE, BigInteger.ONE);
    }

    @Override
    public void run() {
        System.out.println("Thread #" + num + " iniciado");
        BigInteger res = fibonacci(fi);
        System.out.println("Thread #" + num + " - fibonacci(" + fi + ") = " + res);
    }

    public BigInteger fibonacci(BigInteger f) {
        // Si ya está calculado, lo devolvemos directamente
        if (memo.containsKey(f)) {
            return memo.get(f);
        }
        // Si no está, lo calculamos recursivamente y lo guardamos
        BigInteger val = fibonacci(f.subtract(BigInteger.ONE))
                          .add(fibonacci(f.subtract(BigInteger.TWO)));
        memo.put(f, val);
        return val;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            long algo = (long)(Math.random() * 50) + 1;
            threads[i] = new Thread(
                    new FibonacciThreadsBigIntegerMem(i, BigInteger.valueOf(algo)));
        }

        for (Thread t : threads) {
            t.start();
        }
    }
}
