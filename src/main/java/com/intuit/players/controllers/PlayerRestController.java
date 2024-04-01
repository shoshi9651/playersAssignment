package src.main.java.com.intuit.players.controllers;

import src.main.java.com.intuit.players.models.Player;
import src.main.java.com.intuit.players.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.ObjectUtils;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/players")
public class PlayerRestController {


    @Autowired
    public PlayerService playerService;

    @GetMapping()
    public ResponseEntity<List<Player>> getAllPlayers(@RequestParam Map<String, String> pageParams) {
        if(pageParams.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(playerService.getAllPlayers());
        }
        System.out.println();
        List<Player> playersInRange = null;
        int pageSize = Integer.valueOf(pageParams.get("size"));
        int pageNumber = Integer.valueOf(pageParams.get("page"));
        if(pageSize>0&&pageNumber>0){
            Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
            playersInRange = playerService.getAllPlayers(pageable);
        }
        return ObjectUtils.isEmpty(playersInRange) ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
            ResponseEntity.status(HttpStatus.OK).body(playersInRange);
    }

    @GetMapping("/{playerID}")
    public ResponseEntity<Player> getPlayer(@PathVariable String playerID) {
        Player player = playerService.getPlayer(playerID);
        if (Objects.nonNull(player)) {
            return ResponseEntity.status(HttpStatus.OK).body(player);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
