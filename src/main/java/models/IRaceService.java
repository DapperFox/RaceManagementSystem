package models;

import java.util.List;

/**
 * Created by blakebishop on 6/11/14.
 */
public interface IRaceService {
    RaceEvent getRaceEvent(Long id);

    List getAllRaceEvents();

    List getAllRaceEvents(String raceTypeQuery);

    List getRaceSearchResults(String queryString);

    Racer getRacer(Long id);

    void createRaceEvent(RaceEvent raceEvent);

    void deleteRaceEvent(Long id);

    void createRacer(Racer racer);

    void createAccount(Account account);

    Admin getAdmin(Long id);

    List getRaceResultsList(Long id);

    Account getAccountByEmail(String email);

    RaceEvent getAllRacersFromRace(Long id);
}
