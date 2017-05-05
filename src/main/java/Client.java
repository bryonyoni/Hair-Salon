import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client{
  private String name;
  private String email;
  private String image;
  private int id;



 @Override
  public boolean equals(Object otherClients) {
  if (!(otherClients instanceof Client)) {
  return false;
  } else {
    Client newClient = (Client) otherClients;
     return this.getName().equals(newClient.getName()) &&
     this.getEmail().equals(newClient.getEmail()) &&
     this.getImage().equals(newClient.getImage());
    }
  }

  public Client(String name, String image,String email ){
    this.name = name;
    this.email = email;
    this.image = image;

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


  public static List<Client> all(){
    String sql = "SELECT name,image,email FROM clients";
    try(Connection con = DB.sql2o.open()){
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  public void save(){
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO clients (name,image,email) VALUES (:name,:image,:email)";
      this.id = (int)con
      .createQuery(sql,true)
      .addParameter("name",this.name)
      .addParameter("image",this.image)
      .addParameter("email",this.email)
      .executeUpdate()
      .getKey();
    }
  }

  public static Client find(int id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM clients where id=:id";
      Client client = con.createQuery(sql)
       .addParameter("id",id)
       .executeAndFetchFirst(Client.class);
      return client;
    }
  }

  



}
