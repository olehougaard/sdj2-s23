package dk.via.exercise4_2;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        WaitingRoom waitingRoom = new WaitingRoom();
        Patient patient1 = new Patient(1);
        Patient patient2 = new Patient(2);
        waitingRoom.addPropertyChangeListener(patient1);
        waitingRoom.addPropertyChangeListener(patient2);
        Thread thread = new Thread(waitingRoom);
        thread.start();
        Thread.sleep(1000);
        Patient patient3 = new Patient(3);
        Patient patient4 = new Patient(4);
        waitingRoom.addPropertyChangeListener(patient3);
        waitingRoom.addPropertyChangeListener(patient4);
    }
}
