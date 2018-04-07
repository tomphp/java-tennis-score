package io.tomoram.katas.tennis.score;

import io.tomoram.katas.tennis.GameOver;
import io.tomoram.katas.tennis.IncompleteGame;
import org.junit.Test;

import static io.tomoram.katas.tennis.Player.PLAYER1;
import static io.tomoram.katas.tennis.Player.PLAYER2;
import static io.tomoram.katas.tennis.score.Point.ScoreValue.FIFTEEN;
import static io.tomoram.katas.tennis.score.Point.ScoreValue.LOVE;
import static org.assertj.core.api.Assertions.assertThat;

public class LoveLoveShould {
    private LoveLove loveLove = new LoveLove();

    @Test(expected = IncompleteGame.class)
    public void
    throw_IncompleteGame_from_winner() throws IncompleteGame {
        loveLove.winner();
    }

    @Test
    public void
    returns_a_PLAYER1_Point_from_score() throws GameOver {
        assertThat(loveLove.score(PLAYER1)).isEqualTo(new Point(PLAYER1, FIFTEEN, LOVE));
    }

    @Test
    public void
    returns_a_PLAYER2_Point_from_score() throws GameOver {
        assertThat(loveLove.score(PLAYER2)).isEqualTo(new Point(PLAYER2, FIFTEEN, LOVE));
    }
}