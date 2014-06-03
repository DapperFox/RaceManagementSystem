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
    @JoinColumn(name="raceEvent_id")
    private RaceEvent racerEvents;

    @ManyToOne
    @JoinColumn(name="racer_id")
    private Racer racer;

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

    public RaceEvent getRacerEvents() {
        return racerEvents;
    }

    public void setRacerEvents(RaceEvent racerEvents) {
        this.racerEvents = racerEvents;
    }

    public Racer getRacer() {
        return racer;
    }

    public void setRacer(Racer racer) {
        this.racer = racer;
    }
}