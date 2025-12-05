/**
 * Curso: MCA 1
 *
 * Temas: Sucesiones, Runnable-Threads, llamadas recursivas, Ciclos
 * Mejora: Se incorpora Hashtable para almacenar resultados ya calculados
 *         y evitar la explosión de llamadas recursivas.
 */

import java.util.Hashtable;

public class Main implements Runnable {

    long fi;
    int num;

    // 🔹 Mejora: Hashtable compartida para guardar resultados ya calculados
    static Hashtable<Long, Long> memo = new Hashtable<>();

    public Main(int n, long f) {
        num = n;
        fi = f;
        // Inicializamos casos base en la tabla
        memo.put(0L, 1L);
        memo.put(1L, 1L);
    }

    @Override
    public void run() {
        System.out.println("Thread #" + num + " iniciado");
        long res = fibonacci(fi);
        System.out.println("Thread #" + num + " - fibonacci(" + fi + ") = " + res);
    }

    long fibonacci(long f) {
        // 🔹 Mejora: si ya está calculado, lo devolvemos directamente
        if (memo.containsKey(f)) {
            return memo.get(f);
        }
        // Si no está, lo calculamos recursivamente y lo guardamos
        long val = fibonacci(f - 1) + fibonacci(f - 2);
        memo.put(f, val);
        return val;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Main(i,
                    (long) (Math.random() * 50) + 1));
        }

        for (Thread t : threads) {
            t.start();
        }
    }
}
