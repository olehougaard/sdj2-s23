package dk.via.exercise4_1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Pedestrian implements PropertyChangeListener {
    public void onLightChange(LightColor color) {
        switch(color) {
            case GREEN -> {
                System.out.println("Wait");
            }
            case YELLOW -> {
                System.out.println("Run");
            }
            case RED -> {
                System.out.println("Walk");
            }
            case RED_YELLOW -> {
                System.out.println("Get ready");
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        onLightChange((LightColor) evt.getNewValue());
    }
}
