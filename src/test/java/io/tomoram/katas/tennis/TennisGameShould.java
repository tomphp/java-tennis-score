package io.tomoram.katas.tennis;

import org.junit.Before;
import org.junit.Test;

import static io.tomoram.katas.tennis.Player.PLAYER1;
import static io.tomoram.katas.tennis.Player.PLAYER2;
import static org.assertj.core.api.Assertions.assertThat;

public class TennisGameShould {
    private TennisGame game;

    @Before
    public void
    before() {
        game = new TennisGame();
    }

    @Test(expected = IncompleteGame.class)
    public void
    throws_IncompleteGame_if_this_game_is_not_over() throws ScoringException {
        game.play(PLAYER1);
    }

    @Test(expected = GameOver.class)
    public void
    throws_GameOver_if_a_play_is_attempted_on_game_that_has_complete() throws ScoringException {
        game.play(
                PLAYER1,
                PLAYER1,
                PLAYER1,
                PLAYER1,
                PLAYER1
        );
    }

    @Test
    public void
    return_PLAYER1_for_a_PLAYER1_domination() throws ScoringException {
        assertThat(game.play(
                PLAYER1,
                PLAYER1,
                PLAYER1,
                PLAYER1
        )).isEqualTo(PLAYER1);
    }

    @Test
    public void
    return_PLAYER2_for_a_PLAYER2_domination() throws ScoringException {
        assertThat(game.play(
                PLAYER2,
                PLAYER2,
                PLAYER2,
                PLAYER2
        )).isEqualTo(PLAYER2);
    }

    @Test
    public void
    return_PLAYER1_for_a_game_which_PLAYER1_wins_without_deuce() throws ScoringException {
        assertThat(game.play(
                PLAYER1,
                PLAYER2,
                PLAYER1,
                PLAYER1,
                PLAYER1
        )).isEqualTo(PLAYER1);
    }

    @Test
    public void
    return_PLAYER1_a_game_which_PLAYER1_wins_with_deuce() throws ScoringException {
        assertThat(game.play(
                PLAYER1, // 15 - 0
                PLAYER1, // 30 - 0
                PLAYER1, // 40 - 0
                PLAYER2, // 40 - 15
                PLAYER2, // 40 - 30
                PLAYER2, // deuce
                PLAYER1, // P1 advantage
                PLAYER1  // P1 game
        )).isEqualTo(PLAYER1);
    }

    @Test
    public void
    return_PLAYER1_a_game_which_PLAYER1_wins_with_a_fight() throws ScoringException {
        assertThat(game.play(
                PLAYER1, // 15 - 0
                PLAYER1, // 30 - 0
                PLAYER1, // 40 - 0
                PLAYER2, // 40 - 15
                PLAYER2, // 40 - 30
                PLAYER2, // deuce
                PLAYER2, // P2 advantage
                PLAYER1, // deuce
                PLAYER1, // P1 advantage
                PLAYER1  // P1 game
        )).isEqualTo(PLAYER1);
    }
}