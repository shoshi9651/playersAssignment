package src.main.java.com.intuit.players.services;

import src.main.java.com.intuit.players.models.Player;
import src.main.java.com.intuit.players.repositoreis.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    public PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getAllPlayers(Pageable pageable) {
        Page<Player> page = playerRepository.findAll(pageable);
        if (!page.hasContent()) {
            return null;
        }
        return page.getContent();
    }

    public Player getPlayer(String playerID) {
        Optional<Player> byId = playerRepository.findById(playerID);
        return byId.orElse(null);
    }

}
