package C3Reto3.Reto3v2.Interface;

import C3Reto3.Reto3v2.Models.Game;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceGames extends CrudRepository<Game,Integer> {
    
}
