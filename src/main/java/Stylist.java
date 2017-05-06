import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Stylist{
  private String name;
  private String image;
  private int id;


 @Override
  public boolean equals(Object otherStylist) {
  if (!(otherStylist instanceof Stylist)) {
  return false;
  } else {
    Stylist newStylist = (Stylist) otherStylist;
     return this.getName().equals(newStylist.getName()) &&
     this.getImage().equals(newStylist.getImage());
    }
  }

  //constructor
    public  Stylist(String name, String image){
      this.name = name;
      this.image = image;
    }
  //

  public String getName(){
    return name;
  }

  public String getImage(){
    return image;
  }

  public int getId(){
    return id;
  }


  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists(name,image) VALUES (:name,:image)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("image",this.image)
        .executeUpdate()
        .getKey();
    }
  }


  public static List<Stylist> all(){
    String sql = "SELECT id, name, image FROM stylists";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

  public static Stylist find(int id) {
   try(Connection con = DB.sql2o.open()){
     String sql = "SELECT * FROM stylists where id =:id";
     Stylist stylist = con.createQuery(sql)
     .addParameter("id",id)
     .executeAndFetchFirst(Stylist.class);
    return stylist;
   }
  }

  public List<Client> getClients() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where StylistId=:id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Client.class);
    }
  }


}
