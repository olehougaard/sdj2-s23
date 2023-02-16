package solutions2_2;

public class Start {
    public static void main(String[] args) {
        ListContainer container = new ListContainer();
        ListInserter inserter1 = new ListInserter(container);
        ListInserter inserter2 = new ListInserter(container);
        Thread thread1 = new Thread(inserter1);
        Thread thread2 = new Thread(inserter2);
        thread1.start();
        thread2.start();
    }
}
