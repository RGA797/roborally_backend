package com.example.demo.gameAdmin;
import com.example.demo.exceptions.DaoException;
import com.example.demo.exceptions.MappingException;
import com.example.demo.exceptions.ServiceException;
import com.example.demo.model.admin.Game;
import com.example.demo.service.interfaces.IGameAdminService;
import com.example.demo.util.mapping.IDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
@RestController
@CrossOrigin (origins ="*")

public class gameAdminController {
    private final IGameAdminService gameAdminService;
    private final IDtoMapper dtoMapper;


    public gameAdminController(IGameAdminService GameAdminService, IDtoMapper dtoMapper) {
        this.gameAdminService = GameAdminService;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping("/game")
    public ResponseEntity<Integer> createGame(@RequestBody GameDTO gameDTO) throws ServiceException, DaoException{
        if (gameDTO.gameId != null){
            return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
        }
        Game game = dtoMapper.convertToEntity(gameDTO);
        gameAdminService.saveGame(game);
        return new ResponseEntity<>(game.gameId, HttpStatus.OK);
    }

    @PutMapping("/game/{gameId}/{name}")
    public ResponseEntity<Integer> updateGame(@PathVariable("gameId") int gameId, @PathVariable("name") String name) throws ServiceException, DaoException{
        if (gameId < 0){
            return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
        }
        gameAdminService.updateGame(gameId, name);
        return new ResponseEntity<>(gameId, HttpStatus.OK);
    }

    @GetMapping("/game")
    public ResponseEntity<Collection<Game>> getGames() throws ServiceException, MappingException, DaoException{
        Collection<Game> games = gameAdminService.getGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }


    @DeleteMapping("/game/{gameId}")
    public ResponseEntity<Integer> deleteGame(@PathVariable("gameId") int gameId) throws ServiceException, DaoException {
        if (gameId < 0) {
            return new ResponseEntity<>(0,HttpStatus.BAD_REQUEST);
        }
        gameAdminService.removeGame(gameId);
        return new ResponseEntity<>(gameId, HttpStatus.OK);
    }
}