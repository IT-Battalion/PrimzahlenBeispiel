package test2021.threading;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Erweiterte Kompetenz:
 * Schreibe eine weitere Klasse namens StartPools, die die gleiche Aufgabe erfüllt, wie die Klasse
 * StartThreads. Verwende allerdings für die Ausführung der Threads in dieser Klasse einen Thread-
 * Pool.
 */
public class StartPools {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(Executors.defaultThreadFactory());
        GeneratePrimes gp1 = new GeneratePrimes();
        GeneratePrimes gp2 = new GeneratePrimes();
        GeneratePrimes gp3 = new GeneratePrimes();
        executorService.execute(gp1);
        executorService.execute(gp2);
        executorService.execute(gp3);
        ReadPrimes rp1 = new ReadPrimes();
        ReadPrimes rp2 = new ReadPrimes();
        executorService.execute(rp1);
        executorService.execute(rp2);
        Timer t1 = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                gp1.shutdown();
                gp2.shutdown();
                gp3.shutdown();
                rp1.shutdown();
                rp2.shutdown();
                executorService.shutdown();
            }
        };
        t1.schedule(tt, 3000);
    }
}
