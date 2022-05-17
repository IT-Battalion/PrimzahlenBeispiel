package test2021.threading;

public class ReadPrimes implements Runnable {
    private String bezeichnung = "Bezeichnung";
    private boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println(bezeichnung + " " + PrimeNumberList.getPrime());
        }
    }

    public void shutdown() {
        this.running = false;
    }
}
