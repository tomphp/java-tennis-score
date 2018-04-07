package io.tomoram.katas.tennis.score;

import io.tomoram.katas.tennis.GameOver;
import io.tomoram.katas.tennis.IncompleteGame;
import io.tomoram.katas.tennis.Player;
import io.tomoram.katas.tennis.Score;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import static io.tomoram.katas.tennis.score.Point.ScoreValue.FORTY;

public class Point implements Score {
    private final Player player;
    private final ScoreValue score;
    private final ScoreValue otherScore;

    Point(final Player player) {
        this.player = player;
        this.score = ScoreValue.FIFTEEN;
        this.otherScore = ScoreValue.LOVE;
    }

    Point(final Player player, final ScoreValue score, final ScoreValue otherScore) {
        this.player = player;
        this.score = score;
        this.otherScore = otherScore;
    }

    @Override
    public Score score(final Player player) throws GameOver {
        if (this.player != player) {
            ScoreValue newScore = otherScore.next();

            return new Point(player, newScore, score);
        }

        if (score == FORTY) {
            return new Game(player);
        }

        ScoreValue newScore = score.next();

        if (otherScore == FORTY && newScore == FORTY) {
            return new Deuce();
        }

        return new Point(player, newScore, otherScore);
    }

    @Override
    public String toString() {
        return "Point{" +
                "player=" + player +
                ", score=" + score +
                ", otherScore=" + otherScore +
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
