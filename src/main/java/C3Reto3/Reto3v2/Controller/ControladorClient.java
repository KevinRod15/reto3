
package C3Reto3.Reto3v2.Controller;

import C3Reto3.Reto3v2.Models.Client;
import C3Reto3.Reto3v2.Services.ServiciosClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorClient {
     @Autowired
    private ServiciosClient servicio;
  
    @GetMapping("/all")
    public List<Client> getClients(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int clientId) {
        return servicio.getClient(clientId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {
        return servicio.save(client);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client) {
        return servicio.update(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId) {
        return servicio.deleteClient(clientId);
    }
}
