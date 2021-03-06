package com.example.demo.service.implementations;
import com.example.demo.dal.implementations.BoardDao;
import com.example.demo.dal.implementations.GameDao;
import com.example.demo.dal.interfaces.IBoardDao;
import com.example.demo.dal.interfaces.IGameDao;
import com.example.demo.exceptions.DaoException;
import com.example.demo.exceptions.ServiceException;
import com.example.demo.model.Board;
import com.example.demo.model.Player;
import com.example.demo.model.admin.Game;
import com.example.demo.model.admin.User;
import com.example.demo.service.interfaces.IGameAdminService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class GameAdminService implements IGameAdminService {
    private final BoardDao boardDao;
    private final GameDao gameDao;
    public GameAdminService(BoardDao boardDao, GameDao gameDao) {
        this.boardDao = boardDao;
        this.gameDao = gameDao;
    }


    @Override
    public Collection<Game> getGames() throws ServiceException, DaoException {
        /*
        List<Game> result = new ArrayList<Game>();
        for (Board board : boardDao.getBoards()) {
            Game game = new Game();
            game.gameId = board.getGameId();
            result.add(game);
            game.started = board.getPlayersNumber() > 1;
            for (int i = 0; i < board.getPlayersNumber(); i++) {
                Player player = board.getPlayer(i);
                User user = new User();
                user.playerId = player.getPlayerId();
                user.playerName = player.getName();
                game.users.add(user);
            }
        }
        return result;
         */
        return gameDao.getGames();
    }

    @Override
    public int saveGame(Game game) throws ServiceException, DaoException {
        return gameDao.createGame(game);
    }

    @Override
    public int updateGame(int gameId, String name) throws ServiceException, DaoException {
        return gameDao.updateGame(gameId,name);
    }

    @Override
    public int removeGame(int gameId) throws ServiceException, DaoException {
        return gameDao.removeGame(gameId);
    }
}
