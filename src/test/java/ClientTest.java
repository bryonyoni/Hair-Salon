import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest{

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Client_instantiatesCorrectly_true(){
    Client myClient = new Client("name","image","email");
    assertEquals(true,myClient instanceof Client);
  }

  @Test
  public void getName_returnsNameUponCalling_name(){
    Client myClient = new Client("name","image","email");
    assertEquals("name",myClient.getName());
  }

  @Test
  public void getName_returnsImageUponCalling_image(){
    Client myClient = new Client("name","image","email");
    assertEquals("image",myClient.getImage());
  }

  @Test
  public void getName_returnsEmailUponCalling_email(){
    Client myClient = new Client("name","image","email");
    assertEquals("email",myClient.getEmail());
  }

  @Test
  public void all_returnsAllInstancesOfClients_true(){

  }



}
