package dk.via.pi;

public class Start {
    public static void main(String[] args) {
        PiService service = new PiService();
        for(int i = 0; i < 8; i++) {
            PiClient client = new PiClient(service);
            Thread thread = new Thread(client);
            thread.start();
        }
    }
}
