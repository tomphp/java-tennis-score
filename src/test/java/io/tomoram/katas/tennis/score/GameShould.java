package io.tomoram.katas.tennis.score;

import io.tomoram.katas.tennis.GameOver;
import io.tomoram.katas.tennis.IncompleteGame;
import org.junit.Test;

import static io.tomoram.katas.tennis.Player.PLAYER1;
import static io.tomoram.katas.tennis.Player.PLAYER2;
import static org.assertj.core.api.Assertions.assertThat;

public class GameShould {
    @Test
    public void
    return_the_winner() throws IncompleteGame {
        Game game1 = new Game(PLAYER1);
        assertThat(game1.winner()).isEqualTo(PLAYER1);

        Game game2 = new Game(PLAYER2);
        assertThat(game2.winner()).isEqualTo(PLAYER2);
    }

    @Test(expected = GameOver.class)
    public void
    throw_GameOver_when_score_is_called() throws GameOver {
        Game game = new Game(PLAYER1);
        game.score(PLAYER1);
    }
}