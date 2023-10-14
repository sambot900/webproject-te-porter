package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car{

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") // specify the column name. Without it, it will use method name
   private Integer id;

   @Column(name = "model")
   private String model;

   @Column(name = "edition")
   private String edition;

   @Column(name = "color")
   private String color;

   public Car() {
   }

   public Car(Integer id, String model, String edition, String color) {
      this.id = id;
      this.model = model;
      this.edition = edition;
      this.color = color;
   }

   public Car(String model, String edition, String color) {
      this.model = model;
      this.edition = edition;
      this.color = color;
   }


   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public String getEdition() {
      return edition;
   }

   public void setEdition(String edition) {
      this.edition = edition;
   }

   public String getColor() {
      return color;
   }

   public void setColor(String color) {
      this.color = color;
   }

   @Override
   public String toString() {
      return "Car: " + this.id + ", " + this.model + ", " + this.edition + ", " + this.color;
   }
}