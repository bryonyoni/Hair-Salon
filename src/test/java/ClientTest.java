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

  //

  @Test
  public void all_returnsAllInstancesOfClients_true(){
    Client myClient = new Client("name","image","email");
    myClient.save();
    Client myOtherClient = new Client("name","image","email");
    myOtherClient.save();
    assertEquals(true,Client.all().get(0).equals(myClient));
    assertEquals(true,Client.all().get(1).equals(myOtherClient));
  }

//

  @Test
  public void save_savesAnObjectAndAssignsItAnId_0(){
    Client myClient = new Client("name","image","email");
    myClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(0,savedClient.getId());
  }



  @Test
  public void save_savesClientIntoDB_true(){
    Client myClient = new Client("name","image","email");
    myClient.save();
    assertTrue(Client.all().get(0).equals(myClient));
  }

  @Test
  public void getId_ClientInstantiatesWithAnID() {
    Client myClient = new Client("name","image","email");
    myClient.save();
    assertTrue(myClient.getId() > 0);
  }

  @Test
  public void find_returnsClientWithCorrespondingId_secondClient() {
    Client firstClient = new Client("name","image","email");
    firstClient.save();
    Client secondClient = new Client("name","image","email");
    secondClient.save();
    assertEquals(Client.find(secondClient.getId()), secondClient);
  }


}
