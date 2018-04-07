package io.tomoram.katas.tennis.score;

import io.tomoram.katas.tennis.GameOver;
import io.tomoram.katas.tennis.IncompleteGame;
import io.tomoram.katas.tennis.Player;
import io.tomoram.katas.tennis.Score;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class Advantage implements Score {
    private final Player player;

    Advantage(final Player player) {
        this.player = player;
    }

    @Override
    public Score score(final Player player) throws GameOver {
        return (this.player == player) ? new Game(Player.PLAYER1) : new Deuce();
    }

    @Override
    public String toString() {
        return "Advantage{" +
                "player=" + player +
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
}
