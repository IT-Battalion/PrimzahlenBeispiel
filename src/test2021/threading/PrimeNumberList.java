package test2021.threading;

import java.util.ArrayList;
import java.util.List;

/**
 * PrimeNumberList:
 * In dieser Klasse sollen die erzeugten zufälligen Primzahlen zwischengespeichert werden. Wähle dazu
 * eine passende Datenstruktur zur Speicherung der Primzahlen und schreibe folgende Methoden:
 * • savePrime: übernimmt eine Primzahl als Parameter und speichert sie in der dafür
 * vorgesehenen Datenstruktur
 * • getPrime: gibt die am längsten in der Datenstruktur befindliche Primzahl zurück und löscht
 * diese.
 * Die Klasse soll Thread-sicher sein und dafür sorgen, dass keine weiteren Primzahlen mehr erzeugt
 * werden, wenn schon 15 Primzahlen gespeichert sind. Weiters sollen auch die Verarbeiter nicht mehr
 * weiter machen, wenn keine Primzahlen vorhanden sind. Busy-waiting ist zu vermeiden!
 */
public class PrimeNumberList {
    private static final List<Integer> primes = new ArrayList<>();

    synchronized public void savePrime(int prime) {
        if (primes.size() < 15) {
            primes.add(prime);
            this.notifyAll();
        } else {
            try {
                this.wait();
            } catch (InterruptedException ignored) {
            }
        }
    }

    synchronized public int getPrime() {
        if (primes.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException ignored) {
            }
        }
        int oldest = primes.get(0);
        primes.remove(0);
        this.notifyAll();
        return oldest;
    }
}
