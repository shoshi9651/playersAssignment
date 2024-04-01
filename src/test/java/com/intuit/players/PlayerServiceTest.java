package src.test.java.com.intuit.players;

import src.main.java.com.intuit.players.models.Player;
import src.main.java.com.intuit.players.repositoreis.PlayerRepository;
import src.main.java.com.intuit.players.services.PlayerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerServiceImpl playerService;

    private final Player player1 = Player.builder().playerID("sddfc3s").birthYear("1981").birthMonth("10").build();
    private final Player player2 = Player.builder().playerID("aardsda01").birthYear("1983").build();

    private static final int PAGE_NUMBER = 1;
    private static final int PAGE_SIZE = 1;

    @Test
    public void testGetAllPlayers() {
        List<Player> expectedPlayers = List.of(player1, player2);
        Mockito.when(playerRepository.findAll()).thenReturn(expectedPlayers);
        List<Player> actualPlayers = playerService.getAllPlayers();
        assertEquals(expectedPlayers, actualPlayers);
    }

//    @Test
//    public void testGetAllPlayersByPageNumber() {
//        List<Player> expectedPlayers = List.of(player1);
//        Pageable pageable = PageRequest.of(PAGE_NUMBER, PAGE_SIZE);
//        Mockito.when(playerRepository.findAll(pageable)).thenReturn(expectedPlayers);
//        Page<Player> actualPlayers = playerService.getAllPlayers(pageable);
//        assertEquals(expectedPlayers, actualPlayers);
//    }

    @Test
    public void testGetPlayer() {
        Mockito.when(playerRepository.findById(player1.getPlayerID())).thenReturn(Optional.of(player1));
        Player actualPlayer = playerService.getPlayer(player1.getPlayerID());
        assertEquals(player1, actualPlayer);
    }
}
