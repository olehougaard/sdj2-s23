package solutions2_6;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        Bar bar = new Bar(10);
        Thread[] bartenders = { new Thread(new Bartender(bar)), new Thread(new Bartender(bar))};
        Thread[] customers = { new Thread(new Customer(bar)), new Thread(new Customer(bar)), new Thread(new Customer(bar)), new Thread(new Customer(bar)), new Thread(new Customer(bar)) };
        for(Thread bartender: bartenders) {
            bartender.start();
        }
        for(Thread customer: customers) {
            Thread.sleep(3000);
            customer.start();
        }
        Thread.sleep(30);
        bar.close();
    }
}
