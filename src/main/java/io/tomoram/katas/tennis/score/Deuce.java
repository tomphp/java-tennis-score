package io.tomoram.katas.tennis.score;

import io.tomoram.katas.tennis.GameOver;
import io.tomoram.katas.tennis.IncompleteGame;
import io.tomoram.katas.tennis.Player;
import io.tomoram.katas.tennis.Score;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class Deuce implements Score {
    @Override
    public Score score(final Player player) throws GameOver {
        return new Advantage(player);
    }

    @Override
    public Player winner() throws IncompleteGame {
        throw new IncompleteGame();
    }

    @Override
    public String toString() {
        return "Deuce{}";
    }

    @Override
    public boolean equals(final Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
