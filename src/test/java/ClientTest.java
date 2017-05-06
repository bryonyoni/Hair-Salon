import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest{

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Client_instantiatesCorrectly_true(){
    Client myClient = new Client("name","image","email",1);
    assertEquals(true,myClient instanceof Client);
  }

  @Test
  public void getName_returnsNameUponCalling_name(){
    Client myClient = new Client("name","image","email",1);
    assertEquals("name",myClient.getName());
  }

  @Test
  public void getName_returnsImageUponCalling_image(){
    Client myClient = new Client("name","image","email",1);
    assertEquals("image",myClient.getImage());
  }

  @Test
  public void getName_returnsEmailUponCalling_email(){
    Client myClient = new Client("name","image","email",1);
    assertEquals("email",myClient.getEmail());
  }

  //

  @Test
  public void all_returnsAllInstancesOfClients_true(){
    Client myClient = new Client("name","image","email",1);
    myClient.save();
    Client myOtherClient = new Client("name","image","email",1);
    myOtherClient.save();
    assertEquals(true,Client.all().get(0).equals(myClient));
    assertEquals(true,Client.all().get(1).equals(myOtherClient));
  }

//

  @Test
  public void save_savesAnObjectAndAssignsItAnId_0(){
    Client myClient = new Client("name","image","email",1);
    myClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(0,savedClient.getId());
  }



  @Test
  public void save_savesClientIntoDB_true(){
    Client myClient = new Client("name","image","email",1);
    myClient.save();
    assertTrue(Client.all().get(0).equals(myClient));
  }

  @Test
  public void getId_ClientInstantiatesWithAnID() {
    Client myClient = new Client("name","image","email",1);
    myClient.save();
    assertTrue(myClient.getId() > 0);
  }

  @Test
  public void find_returnsClientWithCorrespondingId_secondClient() {
    Client firstClient = new Client("name","image","email",1);
    firstClient.save();
    Client secondClient = new Client("name","image","email",1);
    secondClient.save();
    assertEquals(Client.find(secondClient.getId()), secondClient);
  }

  @Test
    public void update_updatesClientName_true() {
    Client myClient = new Client("name","image","email",1);
    myClient.save();
    myClient.update("name2");
    assertEquals("name2", Client.find(myClient.getId()).getName());
  }

  @Test
  public void delete_deletesClient_true(){
    Client myClient = new Client("name","image","email",1);
    myClient.save();
    int myClientId = myClient.getId();
    myClient.delete();
    assertEquals(null,Client.find(myClientId));
  }

  @Test
    public void save_savesStylistIdIntoDB_true() {
    Stylist myStylist = new Stylist("name","image1");
    myStylist.save();
    Client myClient = new Client("name","image","email", myStylist.getId());
    myClient.save();
    Client savedClient = Client.find(myClient.getId());
    assertEquals(savedClient.getStylistId(), myStylist.getId());
  }
}
