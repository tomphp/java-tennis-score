package io.tomoram.katas.tennis.score;

import io.tomoram.katas.tennis.IncompleteGame;
import io.tomoram.katas.tennis.Player;
import io.tomoram.katas.tennis.Score;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import static io.tomoram.katas.tennis.Player.PLAYER1;
import static io.tomoram.katas.tennis.Player.PLAYER2;

public final class NormalScore implements Score {
    private final ScoreValue player1Score;
    private final ScoreValue player2Score;

    public NormalScore() {
        this.player1Score = ScoreValue.LOVE;
        this.player2Score = ScoreValue.LOVE;
    }

    NormalScore(final ScoreValue player1score, final ScoreValue player2score) {
        this.player1Score = player1score;
        this.player2Score = player2score;
    }

    @Override
    public Score score(final Player player) {
        if (player == PLAYER1) {
            return scoreForPlayer(PLAYER1, player1Score, player2Score);
        }

        return scoreForPlayer(PLAYER2, player2Score, player1Score);
    }

    private Score scoreForPlayer(final Player player, final ScoreValue currentScore, final ScoreValue otherPlayerScore) {
        final ScoreValue newScore;

        if (currentScore == ScoreValue.FORTY) {
            return new Game(player);
        }

        newScore = currentScore.next();

        if (isDeuce(newScore, otherPlayerScore))
            return new Deuce();

        if (player == PLAYER1) {
            return new NormalScore(newScore, otherPlayerScore);
        }

        return new NormalScore(otherPlayerScore, newScore);
    }

    private boolean isDeuce(final ScoreValue newPlayer1Score, final ScoreValue newPlayer2Score) {
        return newPlayer1Score == ScoreValue.FORTY && newPlayer2Score == ScoreValue.FORTY;
    }

    @Override
    public Player winner() throws IncompleteGame {
        throw new IncompleteGame();
    }

    @Override
    public String toString() {
        return "NormalScore{" +
                "player1Score=" + player1Score +
                ", player2Score=" + player2Score +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public enum ScoreValue {
        LOVE, FIFTEEN, THIRTY, FORTY;

        static ScoreValue[] values = values();

        public ScoreValue next() {
            return values[(this.ordinal() + 1) % values.length];
        }
    }
}
