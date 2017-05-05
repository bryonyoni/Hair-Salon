import org.junit.rules.ExternalResource;
import org.sql2o.*;
import org.junit.*;

public class DatabaseRule extends ExternalResource{

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", "postgres", "trave1mate");
  }

  @After
    public void tearDown() {
       try(Connection con = DB.sql2o.open()) {
         String deleteClientsQuery = "DELETE FROM clients *;";
         String deleteStylistsQuery = "DELETE FROM stylists *;";
         con.createQuery(deleteClientsQuery).executeUpdate();
         con.createQuery(deleteStylistsQuery).executeUpdate();
    }
  }


}
