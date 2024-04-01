package src.test.java.com.intuit.players;

import src.main.java.com.intuit.players.controllers.PlayerRestController;
import src.main.java.com.intuit.players.models.Player;
import src.main.java.com.intuit.players.services.PlayerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(PlayerRestController.class)
@ContextConfiguration(classes = Application.class)
class PlayersApplicationTests {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    private static final String PLAYER_URL = "/api/players";
    private static final String PLAYER_URL_BY_PAGE_NUMBER = "/api/players?page=1&size=1";
    private static final int PAGE_NUMBER = 1;
    private static final int PAGE_SIZE = 1;

    private final Player player1 = Player.builder().playerID("sddfc3s").birthYear("1981").birthMonth("10").build();
    private final Player player2 = Player.builder().playerID("aardsda01").birthYear("1983").build();


    @Test
    public void testGetAllPlayers_Status_Ok() throws Exception {
        List<Player> players = List.of(player1, player2);
        Mockito.when(playerService.getAllPlayers()).thenReturn(new ArrayList<Player>(players));
        mockMvc.perform(MockMvcRequestBuilders.get(PLAYER_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].playerID", Matchers.is(player1.getPlayerID())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].birthYear", Matchers.is(player1.getBirthYear())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].birthMonth", Matchers.is(player1.getBirthMonth())));
    }

    @Test
    public void testGetAllPlayersByPageNumber_Status_Ok() throws Exception {
        List<Player> players = List.of(player1);
        Pageable pageable = PageRequest.of(PAGE_NUMBER, PAGE_SIZE);
        Mockito.when(playerService.getAllPlayers(pageable)).thenReturn(new ArrayList<Player>(players));
        List<Player> page = playerService.getAllPlayers(pageable);
        mockMvc.perform(MockMvcRequestBuilders.get(PLAYER_URL_BY_PAGE_NUMBER))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].playerID", Matchers.is(player1.getPlayerID())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].birthYear", Matchers.is(player1.getBirthYear())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].birthMonth", Matchers.is(player1.getBirthMonth())));
    }

    @Test
    public void testGetPlayer_Exist_Player() throws Exception {
        Mockito.when(playerService.getPlayer(player1.getPlayerID())).thenReturn(player1);
        mockMvc.perform(MockMvcRequestBuilders.get(PLAYER_URL + "/" + player1.getPlayerID()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.playerID", Matchers.is(player1.getPlayerID())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.birthYear", Matchers.is(player1.getBirthYear())));
    }

    @Test
    public void testGetPlayer_Not_Exist_Player() throws Exception {
        Mockito.when(playerService.getPlayer(player2.getPlayerID())).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.get(PLAYER_URL + "/" + player2.getPlayerID()))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }


}
