
package C3Reto3.Reto3v2.Controller;

import C3Reto3.Reto3v2.Models.Category;
import C3Reto3.Reto3v2.Services.ServiciosCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

    public class ControladorCategory {
    @Autowired
    private ServiciosCategory servicio;
    @GetMapping("/all")
    public List<Category> getCategoria(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoria(@PathVariable("id") int categoriaId) {
        return servicio.getCategoria(categoriaId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category categoria) {
        return servicio.save(categoria);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category categoria) {
        return servicio.update(categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoriaId) {
        return servicio.deletecategoria(categoriaId);
    }
    
}
