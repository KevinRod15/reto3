
package C3Reto3.Reto3v2.Repositories;

import C3Reto3.Reto3v2.Models.Reservations;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import C3Reto3.Reto3v2.Interface.InterfaceReservations;


@Repository
public class RepositorioReservations {
       @Autowired
    private InterfaceReservations crud4;

    public List<Reservations> getAll(){
        return (List<Reservations>) crud4.findAll();
    }
    public Optional<Reservations> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservations save(Reservations reservation){
        return crud4.save(reservation);
    }
    public void delete(Reservations reservation){
        crud4.delete(reservation);
    }
}
