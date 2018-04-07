package io.tomoram.katas.tennis.score;

import io.tomoram.katas.tennis.GameOver;
import io.tomoram.katas.tennis.IncompleteGame;
import org.junit.Test;

import static io.tomoram.katas.tennis.Player.PLAYER1;
import static io.tomoram.katas.tennis.Player.PLAYER2;
import static org.assertj.core.api.Assertions.assertThat;

public class AdvantageShould {
    private Advantage advantage = new Advantage(PLAYER1);

    @Test(expected = IncompleteGame.class)
    public void
    throw_IncompleteGame_from_winner() throws IncompleteGame {
        advantage.winner();
    }

    @Test
    public void
    return_Game_from_score_if_the_player_is_the_same() throws GameOver {
        assertThat(advantage.score(PLAYER1)).isEqualTo(new Game(PLAYER1));
    }

    @Test
    public void
    return_Deuce_from_score_if_the_player_is_different() throws GameOver {
        assertThat(advantage.score(PLAYER2)).isEqualTo(new Deuce());
    }
}