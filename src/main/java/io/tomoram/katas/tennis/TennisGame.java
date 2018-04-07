package io.tomoram.katas.tennis;

import io.tomoram.katas.tennis.score.LoveLove;

final class TennisGame {
    Player play(final Player... plays) throws ScoringException {
        Score score = new LoveLove();

        for (Player player : plays) {
            score = score.score(player);
        }

        return score.winner();
    }
}
