package models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by blakebishop on 5/30/14.
 */
@Entity
@Table(name="raceResult")
public class RaceResult {

    @Id
    @Column(name="id")
    @SequenceGenerator(name="RaceResultSequence", sequenceName="raceResult_seq", initialValue=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="RaceResultSequence")
    private Long id;

    @Column(name="raceTime")
    private Timestamp raceTime;

    @Column(name="racePosition")
    private int racePosition;

    @ManyToOne
    private RaceEvent racerEvents = new RaceEvent();

    @ManyToOne
    private Racer racer = new Racer();

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