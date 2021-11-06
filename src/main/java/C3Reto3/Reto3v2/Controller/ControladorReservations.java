
package C3Reto3.Reto3v2.Controller;

import C3Reto3.Reto3v2.Models.Reservations;
import C3Reto3.Reto3v2.Services.ServiciosReservations;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorReservations {
      @Autowired
    private ServiciosReservations servicio;
    @GetMapping("/all")
    public List<Reservations> getReservations(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservations> getReservation(@PathVariable("id") int reservationId) {
        return servicio.getReservation(reservationId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations save(@RequestBody Reservations reservation) {
        return servicio.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations update(@RequestBody Reservations reservation) {
        return servicio.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return servicio.deleteReservation(reservationId);
    }
}
