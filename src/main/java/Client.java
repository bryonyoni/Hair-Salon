import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client{
  private String name;
  private String email;
  private String image;
  private int id;


 // @Override
 //  public boolean equals(Object otherClients) {
 //  if (!(otherClients instanceof Clients)) {
 //  return false;
 //  } else {
 //    Clients newClients = (Clients) otherClients;
 //     return this.getName().equals(newClients.getName()) &&
 //     this.getId() == newClients.getId();
 //    }
 //  }

  public Client(String name, String image,String email, int ){
    this.name = name;
    this.email = email;
    this.image = image;
    this.stylistId = stylistId;
  }

  public String getName(){
    return name;
  }

  public String getEmail(){
    return email;
  }

  public String getImage(){
    return image;
  }

  public int getId(){
    return id;
  }



}
