package model;

import client.Client;

import java.io.IOException;

public class ModelManager implements Model {
    private final Client client;

    public ModelManager(Client client) {
        this.client = client;
    }

    @Override
    public String convert(String source) {
        try {
            return client.convert(source);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
