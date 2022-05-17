package test2021.threading;

import java.util.Arrays;

/**
 * Für viele Anwendungsfälle in der Informatik sind zufällige Primzahlen eine wichtige Berechnungsgrundlage. Die folgende
 * Methode der Klasse test2021.threading.GenerateRandomPrime erzeugt eine solche zufällige Primzahl.
 * static int randomPrime() Generiert eine zufällige Primzahl
 * Mitunter können solche Berechnungen aber länger dauern. Daher soll diese Berechnung und die Verarbeitung nebenläufig
 * gestaltet werden. Schreibe dazu im bereitgestellten IntelliJ-Projekt im Package test2021.threading folgende Klassen:
 */
public class GenerateRandomPrime {
    /**
     * Methode steht bereits so zur Verfügung.
     * @return int
     */
    public static int randomPrime() {
        int[] primesList = {2, 3, 5, 7, 11, 13, 17, 19};
        return primesList[(int) (Math.random() * 7)];
    }
}
