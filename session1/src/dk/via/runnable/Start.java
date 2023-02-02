package dk.via.runnable;

public class Start {
    public static void main(String[] args) {
        Runnable numbersRunner = new Numbers();
        Runnable charactersRunner = new Characters();
        Thread numbersThread = new Thread(numbersRunner);
        Thread charactersThread = new Thread(charactersRunner);
        numbersThread.start();
        charactersThread.start();
    }
}
