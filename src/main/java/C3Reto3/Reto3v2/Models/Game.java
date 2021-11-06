package C3Reto3.Reto3v2.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id;
    private String name;
    private String developer;
    private Integer year;    
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("games")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "game")
    @JsonIgnoreProperties({"game", "client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "game")
    @JsonIgnoreProperties({"game", "message"})
    private List<Reservations> reservations;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }
  
}
