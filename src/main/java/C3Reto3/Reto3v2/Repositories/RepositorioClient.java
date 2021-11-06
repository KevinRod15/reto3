
package C3Reto3.Reto3v2.Repositories;

import C3Reto3.Reto3v2.Models.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import C3Reto3.Reto3v2.Interface.InterfaceClient;


@Repository
public class RepositorioClient {
      @Autowired
    private InterfaceClient crud1;

    public List<Client> getAll(){
        return (List<Client>) crud1.findAll();
    }
    public Optional<Client> getCliente(int id){
        return crud1.findById(id);
    }

    public Client save(Client cliente){
        return crud1.save(cliente);
    }
    public void delete(Client cliente){
        crud1.delete(cliente);
    }
}
