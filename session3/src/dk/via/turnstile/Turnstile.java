package dk.via.turnstile;

public class Turnstile {
    private State state;

    public Turnstile() {
        this.state = new Closed();
    }

    public void onCoin() {
        state.coin(this);
    }

    public void onPass() {
        state.pass(this);
    }

    void setState(State state) {
        if (state != this.state) {
            // this.state.onExit(this);
            this.state = state;
            this.state.onEntry(this);
        } else {
            // this.state.onDo(this);
        }
    }
}
