package io.tomoram.katas.tennis.score;

import io.tomoram.katas.tennis.GameOver;
import io.tomoram.katas.tennis.IncompleteGame;
import io.tomoram.katas.tennis.Score;
import org.junit.Before;
import org.junit.Test;

import static io.tomoram.katas.tennis.Player.PLAYER1;
import static io.tomoram.katas.tennis.Player.PLAYER2;
import static io.tomoram.katas.tennis.score.NormalScore.ScoreValue.*;
import static org.assertj.core.api.Assertions.assertThat;

public class NormalScoreShould {
    private Score score;

    @Before
    public void before() {
        score = new NormalScore();
    }

    @Test(expected = IncompleteGame.class)
    public void
    raise_IncompleteGame_from_winner() throws IncompleteGame {
        score.winner();
    }

    @Test
    public void
    increment_the_score_for_PLAYER1() throws GameOver {
        score = score.score(PLAYER1);
        assertThat(score).isEqualTo(new NormalScore(FIFTEEN, LOVE));

        score = score.score(PLAYER1);
        assertThat(score).isEqualTo(new NormalScore(THIRTY, LOVE));

        score = score.score(PLAYER1);
        assertThat(score).isEqualTo(new NormalScore(FORTY, LOVE));

        score = score.score(PLAYER1);
        assertThat(score).isEqualTo(new Game(PLAYER1));
    }

    @Test
    public void
    increment_the_score_for_PLAYER2() throws GameOver {
        score = score.score(PLAYER2);
        assertThat(score).isEqualTo(new NormalScore(LOVE, FIFTEEN));

        score = score.score(PLAYER2);
        assertThat(score).isEqualTo(new NormalScore(LOVE, THIRTY));

        score = score.score(PLAYER2);
        assertThat(score).isEqualTo(new NormalScore(LOVE, FORTY));

        score = score.score(PLAYER2);
        assertThat(score).isEqualTo(new Game(PLAYER2));
    }

    @Test
    public void
    return_a_Deuce_when_both_players_score_40() throws GameOver {
        score = score.score(PLAYER1);
        score = score.score(PLAYER1);
        score = score.score(PLAYER1);
        score = score.score(PLAYER2);
        score = score.score(PLAYER2);
        score = score.score(PLAYER2);
        assertThat(score).isEqualTo(new Deuce());
    }
}