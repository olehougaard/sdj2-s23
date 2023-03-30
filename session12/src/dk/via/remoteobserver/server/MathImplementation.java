package dk.via.remoteobserver.server;

import dk.via.remote.observer.RemotePropertyChangeListener;
import dk.via.remote.observer.RemotePropertyChangeSupport;
import dk.via.remoteobserver.shared.Expression;
import dk.via.remoteobserver.shared.Math;

import java.rmi.RemoteException;

public class MathImplementation implements Math {
    // Step 1
    private final RemotePropertyChangeSupport<Expression> support;

    public MathImplementation() {
        // Step 2
        this.support = new RemotePropertyChangeSupport<>();
    }

    // Step 3
    public void addPropertyChangeListener(RemotePropertyChangeListener<Expression> listener) {
        support.addPropertyChangeListener(listener);
    }

    // Step 3
    public void removePropertyChangeListener(RemotePropertyChangeListener<Expression> listener) {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public double compute(Expression e) throws RemoteException {
        // Step 4
        support.firePropertyChange("compute", null, e);
        return switch(e.getOperator()) {
            case '+' -> e.getOperand1() + e.getOperand2();
            case '-' -> e.getOperand1() - e.getOperand2();
            case '*' -> e.getOperand1() * e.getOperand2();
            case '/' -> e.getOperand1() / e.getOperand2();
            default -> throw new RemoteException("Unknown operator: " + e.getOperator());
        };
    }
}
