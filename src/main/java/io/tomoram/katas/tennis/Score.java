package io.tomoram.katas.tennis;

public interface Score {
    Score score(Player p) throws GameOver;

    Player winner() throws IncompleteGame;
}
