
package C3Reto3.Reto3v2.Services;

import C3Reto3.Reto3v2.Repositories.RepositorioReservations;
import C3Reto3.Reto3v2.Models.Reservations;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosReservations {
     @Autowired
    private RepositorioReservations metodosCrud;

    public List<Reservations> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Reservations> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    public Reservations save(Reservations reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservations> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservations update(Reservations reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservations> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
