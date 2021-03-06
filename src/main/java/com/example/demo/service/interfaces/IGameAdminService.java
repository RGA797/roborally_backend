package com.example.demo.service.interfaces;


import  com.example.demo.exceptions.DaoException;
import com.example.demo.exceptions.ServiceException;
import com.example.demo.model.Board;
import com.example.demo.model.admin.Game;

import java.util.Collection;
import java.util.List;

public interface IGameAdminService {
    Collection<Game> getGames() throws ServiceException, DaoException;
    int saveGame(Game game) throws ServiceException, DaoException;
    int updateGame(int gameId, String name) throws ServiceException, DaoException;
    int removeGame(int gameId) throws ServiceException, DaoException;
}
