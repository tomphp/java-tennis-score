package io.tomoram.katas.tennis;

import io.tomoram.katas.tennis.score.NormalScore;

import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static io.tomoram.katas.tennis.Player.PLAYER1;
import static io.tomoram.katas.tennis.Player.PLAYER2;
import static io.tomoram.katas.tennis.score.NormalScore.ScoreValue.LOVE;

final class TennisGame {
    Player play(final Player... plays) throws ScoringException {
        Score score = new NormalScore();

        for (Player player : plays) {
            score = score.score(player);
        }

        return score.winner();
    }
}
