package test2021.threading;

/**
 * Klasse GeneratePrimes:
 * Diese Klasse kann als Thread ausgeführt werden und erzeugt eine zufällige Primzahl mit Hilfe der
 * gegebenen Methode randomPrime(). Diese Zufallszahl wird dann mit Hilfe von savePrime in den
 * Zwischenspeicher geschrieben. Diese Klasse soll die Möglichkeit bieten, den Thread kontrolliert zu
 * beenden.
 */
public class GeneratePrimes implements Runnable {
    private boolean running = true;

    @Override
    public void run() {
        int prime = GenerateRandomPrime.randomPrime();
        PrimeNumberList.savePrime(prime);
        while (running) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {}
        }
    }

    public void shutdown() {
        this.running = false;
    }
}
