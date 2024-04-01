package src.main.java.com.intuit.players.services;

import src.main.java.com.intuit.players.models.Player;
import src.main.java.com.intuit.players.repositoreis.PlayerRepository;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Collections;
import java.util.List;

@Component
public class PlayerLoaderService {

    @Autowired
    private PlayerRepository playerRepository;

    @Value("classpath:player.csv")
    private Resource resource;

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerLoaderService.class);

    @PostConstruct
    public void importPlayers() {
        List<Player> players = buildCsvPlayerByColumnName();
        if (!players.isEmpty()) {
            playerRepository.saveAll(players);
            LOGGER.info("INFO:import CSV file success [ players count = " + players.size() + "]");
        }
        else {
            LOGGER.info("INFO:Empty CSV file");
        }
    }

    public List<Player> buildCsvPlayerByColumnName() {
        try {
            Reader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            CsvToBean<Player> csvToBean = new CsvToBeanBuilder<Player>(reader).withType(Player.class).build();
            List<Player> parse = csvToBean.parse();
            reader.close();
            return parse;
        } catch (Exception e) {
            LOGGER.error("ERROR: building players from CSV file: " + e);
            return Collections.emptyList();
        }
    }


}
