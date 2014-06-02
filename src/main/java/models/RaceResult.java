package models;

import java.sql.Timestamp;

/**
 * Created by blakebishop on 5/30/14.
 */
public class RaceResult {

    private Timestamp raceTime;
    private int racePosition;

    public RaceResult() {

    }

    public int getRacePosition() {
        return racePosition;
    }

    public void setRacePosition(int racePosition) {
        this.racePosition = racePosition;
    }

    public Timestamp getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(long raceTime) {
        this.raceTime = new Timestamp(raceTime);
    }
}
