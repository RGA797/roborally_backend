package com.example.demo.dal.interfaces;

import com.example.demo.exceptions.DaoException;
import com.example.demo.model.Board;
import com.example.demo.model.admin.Game;

import java.util.Collection;
import java.util.List;

public interface IGameDao {
    Game getGame(int gameId) throws DaoException;
    int createGame(Game board) throws DaoException;
    Collection<Game> getGames();
}
