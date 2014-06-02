package models;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by blakebishop on 5/22/14.
 */
@Stateless
@LocalBean
public class RaceService {
    @PersistenceContext(name="RaceManagement")
    private EntityManager em;

    public RaceEvent getRaceEvent(Long id) {
        return em.find(RaceEvent.class, id);
    }
    public List getAllRaceEvents() {
        Query query = em.createQuery("SELECT r FROM RaceEvent r");
        List resultList = query.getResultList();
        return resultList;
    }
    
    public List getRaceSearchResults(String queryString){
    	Query query = em.createQuery("Select r From RaceEvent r WHERE r.raceName LIKE '%"+ queryString+"%'");
    	List resultList = query.getResultList();
    	return resultList;
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
    
    public void createRacer(Racer racer){
    	em.persist(racer);
    }
}