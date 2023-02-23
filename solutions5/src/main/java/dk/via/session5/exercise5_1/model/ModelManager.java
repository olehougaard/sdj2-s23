package dk.via.session5.exercise5_1.model;

public class ModelManager implements Model {
    private final Converter converter;

    public ModelManager() {
        this.converter = new Converter();
    }

    @Override
    public String convert(String source) {
        return converter.toUpperCase(source);
    }
}
