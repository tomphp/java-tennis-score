package io.tomoram.katas.tennis;

public interface Score {
    Score score(Player p) throws GameOver;

    default Player winner() throws IncompleteGame {
        throw new IncompleteGame();
    }
}
