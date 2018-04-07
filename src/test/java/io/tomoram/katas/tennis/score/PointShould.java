package io.tomoram.katas.tennis.score;

import io.tomoram.katas.tennis.GameOver;
import io.tomoram.katas.tennis.IncompleteGame;
import io.tomoram.katas.tennis.Score;
import org.junit.Test;

import static io.tomoram.katas.tennis.Player.PLAYER1;
import static io.tomoram.katas.tennis.Player.PLAYER2;
import static org.assertj.core.api.Assertions.assertThat;

public class PointShould {
    private Score point = new Point(PLAYER1);

    @Test(expected = IncompleteGame.class)
    public void
    throw_IncompleteGame_from_winner() throws IncompleteGame {
        point.winner();
    }

    @Test
    public void
    score_up_to_a_win_for_a_single_player() throws GameOver {
        point = point.score(PLAYER1); // 30 - 0
        point = point.score(PLAYER1); // 40 - 0
        point = point.score(PLAYER1); // game

        assertThat(point).isEqualTo(new Game(PLAYER1));
    }

    @Test
    public void
    score_for_the_other_player() throws GameOver {
        point = point.score(PLAYER1); // 30 - 0
        point = point.score(PLAYER2); // 30 - 15
        point = point.score(PLAYER2); // 30 - 30
        point = point.score(PLAYER2); // 30 - 40
        point = point.score(PLAYER2); // game

        assertThat(point).isEqualTo(new Game(PLAYER2));
    }

    @Test
    public void
    scores_a_deuce() throws GameOver {
        point = point.score(PLAYER1); // 30 - 0
        point = point.score(PLAYER1); // 40 - 0
        point = point.score(PLAYER2); // 40 - 15
        point = point.score(PLAYER2); // 40 - 30
        point = point.score(PLAYER2); // deuce


        assertThat(point).isEqualTo(new Deuce());
    }
}