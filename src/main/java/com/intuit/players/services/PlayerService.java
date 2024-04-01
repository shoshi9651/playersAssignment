package src.main.java.com.intuit.players.services;

import src.main.java.com.intuit.players.models.Player;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PlayerService {

    List<Player> getAllPlayers();
    List<Player> getAllPlayers(Pageable pageable);
    Player getPlayer(String playerID);

}
