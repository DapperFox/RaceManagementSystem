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
    private String raceTime;

    @Column(name="racePosition")
    private Integer racePosition;

    @ManyToOne
    @JoinColumn(name="raceEvent_id")
    private RaceEvent racerEvent;

    @ManyToOne
    @JoinColumn(name="racer_id")
    private Racer racer;

    public RaceResult() {

    }

    public Integer getRacePosition() {
        return racePosition;
    }

    public void setRacePosition(Integer racePosition) {
        this.racePosition = racePosition;
    }

    public String getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(String raceTime) {
        this.raceTime = raceTime;
    }

    public RaceEvent getRacerEvents() {
        return racerEvent;
    }

    public void setRacerEvents(RaceEvent racerEvents) {
        this.racerEvent = racerEvents;
    }

    public Racer getRacer() {
        return racer;
    }

    public void setRacer(Racer racer) {
        this.racer = racer;
    }
}