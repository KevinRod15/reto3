
package C3Reto3.Reto3v2.Repositories;


import C3Reto3.Reto3v2.Models.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import C3Reto3.Reto3v2.Interface.InterfaceCategory;


@Repository
public class RepositorioCategory {
    @Autowired
    private InterfaceCategory crud;
    public List<Category> getAll(){
        return (List<Category>) crud.findAll();
    }
    public Optional<Category> getCategoria(int id){
        return crud.findById(id);
    }

    public Category save(Category Categoria){
        return crud.save(Categoria);
    }
    public void delete(Category Categoria){
       crud.delete(Categoria);
    }
}
