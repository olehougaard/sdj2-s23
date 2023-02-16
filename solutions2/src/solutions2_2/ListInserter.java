package solutions2_2;

public class ListInserter implements Runnable {
    private ListContainer container;

    public ListInserter(ListContainer container) {
        this.container = container;
    }

    public void run() {
        for(int i = 0; i < 100_000; i++) {
            container.add(i);
        }
        System.out.println(container.size());
    }
}
