package models;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by blakebishop on 5/22/14.
 */
@Stateless
@LocalBean
public class RaceService {
    @PersistenceContext(name="raceDataSource")
    private EntityManager em;

    public RaceEvent getRaceEvent(Long id) {
        return em.find(RaceEvent.class, id);
    }
    public void createRaceEvent(RaceEvent raceEvent) {
        em.persist(raceEvent);
    }
    public void deleteRaceEvent(Long id) {
        RaceEvent raceEvent = em.find(RaceEvent.class, id);
        if(raceEvent != null) {
            em.remove(raceEvent);
        }
    }
}
