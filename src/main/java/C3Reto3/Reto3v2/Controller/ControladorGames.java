
package C3Reto3.Reto3v2.Controller;

import C3Reto3.Reto3v2.Models.Game;
import C3Reto3.Reto3v2.Services.ServiciosGames;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Game")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorGames {
    @Autowired
    private ServiciosGames servicio;
    @GetMapping("/all")
    public List<Game> getGames(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Game> getGames(@PathVariable("id") int gamesId) {
        return servicio.getGames(gamesId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Game save(@RequestBody Game games) {
        return servicio.save(games);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Game update(@RequestBody Game games) {
        return servicio.update(games);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int gamesId) {
        return servicio.deleteGames(gamesId);
    }
    
    
}
