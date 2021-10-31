package co.usa.g32.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Clase Bike representacion de la tabla bike en la BD
 */

@Entity
@Table(name="bike")
public class Bike implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    
/**
 * Atributo de tabla bike en la BD
 */
    private Integer id; 
    /**
 * Atributo  de tabla bike en la BD
 */
    private String name;
     /**
 * Atributo  de tabla bike en la BD
 */
    private String brand;
     /**
 * Atributo  de tabla bike en la BD
 */
    private Integer year;
     /**
 * Atributo  de tabla bike en la BD
 */
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("bikes")
    private Category category;

     @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "bike")
    @JsonIgnoreProperties({"bike", "client"})
    private List<Message> messages;

   
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "bike")
    @JsonIgnoreProperties({"bike", "client"})
    private List<Reservation> reservations;

     /**
 * Metodo get bike en la BD
 */

    public Integer getId() {
        return id;
    }
          /**
 * Metodo set bike en la BD
 */
    public void setId(Integer id) {
        this.id = id;
    }

      /**
 * Metodo get bike en la BD
 */
    public String getName() {
        return name;
    }
          /**
 * Metodo set bike en la BD
 */
    public void setName(String name) {
        this.name = name;
    }
      /**
 * Metodo get bike en la BD
 */
    public String getBrand() {
        return brand;
    }
          /**
 * Metodo set bike en la BD
 */
    public void setBrand(String brand) {
        this.brand = brand;
    }
      /**
 * Metodo get bike en la BD
 */
    public Integer getYear() {
        return year;
    }
          /**
 * Metodo set bike en la BD
 */
    public void setYear(Integer year) {
        this.year = year;
    }
      /**
 * Metodo get bike en la BD
 */
    public String getDescription() {
        return description;
    }
          /**
 * Metodo set bike en la BD
 */
    public void setDescription(String description) {
        this.description = description;
    }
      /**
 * Metodo get bike en la BD
 */
    public Category getCategory() {
        return category;
    }
      /**
 * Metodo set bike en la BD
 */
    public void setCategory(Category category) {
        this.category = category;
    }
      /**
 * Metodo get bike en la BD
 */
    public List<Message> getMessages() {
        return messages;
    }
          /**
 * Metodo set bike en la BD
 */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
      /**
 * Metodo get bike en la BD
 */
    public List<Reservation> getReservations() {
        return reservations;
    }
        /**
 * Metodo set bike en la BD
 */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
     
}
