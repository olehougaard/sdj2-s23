package dk.via.exercise7_3;

import java.io.IOException;

public class ClientTest {
    public static void main(String[] args) throws IOException {
        TaskListClient client = new TaskListClient("localhost", 7777);
        client.add(new Task("Cook", 60));
        client.add(new Task("Eat", 30));
        client.add(new Task("Do dishes", 15));
        System.out.println(client.get());
        System.out.println(client.get());
        System.out.println(client.getSize());
        System.out.println(client.get());
        try {
            System.out.println(client.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        client.close();
    }
}
