package dk.via.exercise4_2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WaitingRoom implements Runnable {
    private int currentTicketNumber;
    private final PropertyChangeSupport support;

    public WaitingRoom() {
        this.currentTicketNumber = 0;
        this.support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void run() {
        while(currentTicketNumber < 5) {
            int previousTicket = currentTicketNumber;
            currentTicketNumber++;
            System.out.println("Ding!");
            support.firePropertyChange("ticketNumber", previousTicket, currentTicketNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Ignore and continue
            }
        }
    }
}
