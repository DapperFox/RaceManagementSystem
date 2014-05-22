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
    private EntityManager entityManager;

    public RaceEvent getRaceEvent(Long id) {
        return entityManager.find(RaceEvent.class, id);
    }
    public void createRaceEvent(RaceEvent raceEvent) {
        entityManager.persist(raceEvent);
    }
    public void deleteRaceEvent(RaceEvent raceEvent) {
        entityManager.remove(raceEvent);
    }
}
