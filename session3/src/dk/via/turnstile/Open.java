package dk.via.turnstile;

public class Open implements State {
    @Override
    public void coin(Turnstile turnstile) {
        System.out.println("Coin returned");
        turnstile.setState(this);
    }

    @Override
    public void pass(Turnstile turnstile) {
        turnstile.setState(new Closed());
    }

    @Override
    public void onEntry(Turnstile turnstile) {
        System.out.println("Unlocked");
    }
}
