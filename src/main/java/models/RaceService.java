package models;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import java.util.List;
import java.util.Set;

/**
 * Created by blakebishop on 5/22/14.
 */
@Stateless
@LocalBean
@Local(IRaceService.class)
public class RaceService implements IRaceService {
    @PersistenceContext(name="RaceManagement")
    private EntityManager em;

    @Override
    public RaceEvent getRaceEvent(Long id) {
        return em.find(RaceEvent.class, id);
    }
    
    @Override
    public List getAllRaceEvents() {
        Query query = em.createQuery("SELECT r FROM RaceEvent r");
        List resultList = query.getResultList();
        return resultList;
    }
    
    @Override
    public List getAllRaceEvents(String raceTypeQuery) {
    	return em.createQuery(
    	        "Select r From RaceEvent r WHERE r.raceType LIKE :raceType")
    	        .setParameter("raceType", "%"+raceTypeQuery+"%")
    	        .getResultList();
    }
    
    @Override
    public List getRaceSearchResults(String queryString){
    	String query = queryString.toLowerCase();
    	//return em.createNamedQuery("searchQuery").setParameter("raceEvent", queryString).getResultList();
    	return em.createQuery(
    	        "Select r From RaceEvent r WHERE LOWER(r.raceName) LIKE :raceEvent")
    	        .setParameter("raceEvent", "%"+query+"%")
    	        .getResultList();
    	 
    }
    
    @Override
    public Racer getRacer(Long id){
    	return em.find(Racer.class, id);
    }
    
    @Override
    public void createRaceEvent(RaceEvent raceEvent) {
        em.persist(raceEvent);
    }

    @Override
    public void deleteRaceEvent(Long id) {
        RaceEvent raceEvent = em.find(RaceEvent.class, id);
        if(raceEvent != null) {
            em.remove(raceEvent);
        }
    }
    
    @Override
    public void createRacer(Racer racer){
    	em.persist(racer);
    }
    
    @Override
    public void createAccount(Account account){
    	em.persist(account);
    }

    @Override
    public Admin getAdmin(Long id) {
    	return em.find(Admin.class, id); 
    	}
	@Override
    public List getRaceResultsList(Long id) {
		em.find(RaceEvent.class, id);
		Query query = em.createQuery("SELECT r FROM RaceResult r");
        List resultList = query.getResultList();
        return resultList;
	}

    @Override
	public RaceEvent getAllRacersFromRace(Long id) {
		RaceEvent raceEvent = em.find(RaceEvent.class, id);
        return raceEvent;
	}

    @Override
    public Account getAccountByEmail(String email) {
        return (Account)em.createNamedQuery("byUsername")
                .setParameter("email", email).getSingleResult();
    }
}
