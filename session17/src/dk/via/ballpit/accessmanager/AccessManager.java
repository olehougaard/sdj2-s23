package dk.via.ballpit.accessmanager;

import dk.via.ballpit.BallPit;
import dk.via.ballpit.ReadOnlyBallPit;

public interface AccessManager {
    void releaseRead();

    ReadOnlyBallPit requestRead();

    void releaseWrite();

    BallPit requestWrite();
}
