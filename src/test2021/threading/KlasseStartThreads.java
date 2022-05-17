package test2021.threading;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Verwende die main-Methode in der Klasse StartThreads, um dein Programm auszuprobieren.
 * Verwende dazu:
 * • 3 Threads, die mit Hilfe der Klasse GeneratePrimes zufällige Primzahlen erzeugen
 * • 2 Threads, mit unterschiedlicher Bezeichnung die mit Hilfe der Klasse ReadPrimes zufällige
 * Primzahlen ausgibt.
 * • Nach einer kurzen Zeit (selbst gewählt, je nach Geschwindigkeit der Ausführung, z.B. 2s) sollen
 * alle Threads kontrolliert beendet werden. Die Verwendung von deprecated-Methoden ist zu
 * vermeiden
 */
public class KlasseStartThreads {
    public static void main(String[] args) {
        GeneratePrimes gp1 = new GeneratePrimes();
        GeneratePrimes gp2 = new GeneratePrimes();
        GeneratePrimes gp3 = new GeneratePrimes();
        gp1.run();
        gp2.run();
        gp3.run();
        ReadPrimes rp1 = new ReadPrimes();
        ReadPrimes rp2 = new ReadPrimes();
        rp1.run();
        rp2.run();
        Timer t1 = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                gp1.shutdown();
                gp2.shutdown();
                gp3.shutdown();
                rp1.shutdown();
                rp2.shutdown();
            }
        };
        t1.schedule(tt, 3000);
    }
}
