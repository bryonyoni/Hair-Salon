import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Stylists{



 @Override
  public boolean equals(Object otherStylists) {
  if (!(otherStylists instanceof Stylists)) {
  return false;
  } else {
    Stylists newStylists = (Stylists) otherStylists;
     return this.getName().equals(newStylists.getName()) &&
     this.getId() == newStylists.getId();
    }
  }

  
}
