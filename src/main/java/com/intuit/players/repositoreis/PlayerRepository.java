package src.main.java.com.intuit.players.repositoreis;

import src.main.java.com.intuit.players.models.Player;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.function.Function;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {


}
