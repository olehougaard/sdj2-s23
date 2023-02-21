package dk.via.exercise4_2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Patient implements PropertyChangeListener {
    private final int ticketNumber;

    public Patient(int ticketNumber) {
        this.ticketNumber = ticketNumber;
        System.out.printf("Patient %d enters the waiting room.", ticketNumber).println();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.printf("Patient %d looks up.", ticketNumber).println();
        int currentTicket = (int) evt.getNewValue();
        if (currentTicket == ticketNumber) {
            System.out.printf("Patient %d goes to the doctor's room.", ticketNumber).println();
            WaitingRoom room = (WaitingRoom) evt.getSource();
            room.removePropertyChangeListener(this);
        } else {
            System.out.printf("Patient %d goes back to looking at phone.", ticketNumber).println();
        }
    }
}
