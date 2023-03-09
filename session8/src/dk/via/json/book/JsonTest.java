package dk.via.json.book;

import com.google.gson.Gson;

public class JsonTest {
    public static void main(String... args) {
        Gson gson = new Gson();
        Author connolly = new Author("Thomas Connolly");
        Author begg = new Author("Carolyn Begg");
        Book ds = new Book("Database Systems", 2010, "Pearson", connolly, begg);
        String json = gson.toJson(ds);
        System.out.println(json);
        Book bookFromJson = gson.fromJson(json, Book.class);
        System.out.println(bookFromJson);
    }
}
