package io.tomoram.katas.tennis.score;

import io.tomoram.katas.tennis.GameOver;
import io.tomoram.katas.tennis.Player;
import io.tomoram.katas.tennis.Score;

public class LoveLove implements Score {
    @Override
    public Score score(final Player player) throws GameOver {
        return new Point(player);
    }

    @Override
    public String toString() {
        return "LoveLove{}";
    }
}
