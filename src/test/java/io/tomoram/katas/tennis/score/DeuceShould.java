package io.tomoram.katas.tennis.score;

import io.tomoram.katas.tennis.GameOver;
import io.tomoram.katas.tennis.IncompleteGame;
import org.junit.Test;

import static io.tomoram.katas.tennis.Player.PLAYER1;
import static io.tomoram.katas.tennis.Player.PLAYER2;
import static org.assertj.core.api.Assertions.assertThat;

public class DeuceShould {
    private Deuce deuce = new Deuce();

    @Test(expected = IncompleteGame.class)
    public void
    throw_IncompleteGame_from_winner() throws IncompleteGame {
        deuce.winner();
    }

    @Test
    public void
    returns_an_advantage_when_scoring_PLAYER1() throws GameOver {
        assertThat(deuce.score(PLAYER1)).isEqualTo(new Advantage(PLAYER1));
    }
    @Test
    public void
    returns_an_advantage_when_scoring_PLAYER2() throws GameOver {
        assertThat(deuce.score(PLAYER2)).isEqualTo(new Advantage(PLAYER2));
    }
}