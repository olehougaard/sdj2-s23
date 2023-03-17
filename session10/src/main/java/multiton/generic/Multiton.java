package multiton.generic;

import java.util.HashMap;

/*
Just a generic multiton to show the pattern.
 */
public class Multiton {
    private final String instanceVariable;

    private final static HashMap<String, Multiton> instances = new HashMap<>();

    private Multiton(String instanceVariable) {
        this.instanceVariable = instanceVariable;
    }

    public static synchronized Multiton getInstance(String instanceVariable) {
        if (!instances.containsKey(instanceVariable)) {
            instances.put(instanceVariable, new Multiton(instanceVariable));
        }
        return instances.get(instanceVariable);
    }

    public String getInstanceVariable() {
        return instanceVariable;
    }
}
