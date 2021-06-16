package com.example.demo.dal.implementations;

import com.example.demo.dal.interfaces.IGameDao;
import com.example.demo.exceptions.DaoException;
import com.example.demo.model.Board;
import com.example.demo.model.admin.Game;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Repository
public class GameDao implements IGameDao {
    static final HashMap<Integer, Game> games = new HashMap<>();
    static private int gameIdCounter = 0;

    @Override
    public Game getGame(int gameId) throws DaoException {
        return games.get(gameId);
    }

    @Override
    public int createGame(Game game) throws DaoException {
        if (game != null) {
            Integer gameId = game.gameId;
            if (gameId != null) {
                return -1;
            } else {
                game.gameId = ++gameIdCounter;
                games.put(game.gameId, game);
                return game.gameId;
            }
        }
        return -1;
    }

    @Override
    public Collection<Game> getGames() {
        return games.values();
    }
}