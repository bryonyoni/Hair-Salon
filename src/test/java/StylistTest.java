import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class StylistTest{

  @Rule
  public DatabaseRule database = new DatabaseRule();


  @Test
  public void Stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("name","image");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getName_stylistInstantiatesWithName_name() {
      Stylist testStylist = new Stylist("name","image");
    assertEquals("name", testStylist.getName());
  }

  @Test
  public void getImage_stylistInstantiatesWithImage_image() {
      Stylist testStylist = new Stylist("name","image1");
    assertEquals("image1", testStylist.getImage());
  }

  @Test
  public void all_returnsAllInstancesOfStylist_true() {
    Stylist firstStylist = new Stylist("name","image1");
    firstStylist.save();
    Stylist secondStylist = new Stylist("name","image1");
    secondStylist.save();
    assertEquals(true, Stylist.all().get(0).equals(firstStylist));
    assertEquals(true, Stylist.all().get(1).equals(secondStylist));
  }

  @Test
  public void getId_stylistInstantiateWithAnId_1() {
    Stylist testStylist = new Stylist("name","image1");
    testStylist.save();
    assertTrue(testStylist.getId() > 0);
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Stylist myStylist = new Stylist("name","image1");
    myStylist.save();
    assertEquals("name",Stylist.all().get(0).getName());
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame_true() {
    Stylist firstStylist = new Stylist("name","image1");
    Stylist secondStylist = new Stylist("name","image1");
    assertTrue(firstStylist.equals(secondStylist));
  }

  @Test
  public void save_assignsIdToObjectBeingSaved_1() {
    Stylist myStylist = new Stylist("name","image1");
    myStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(1, savedStylist.getId());
  }

  @Test
  public void find_returnsStylistWithSameId_secondStylist() {
    Stylist firstStylist = new Stylist("name","image1");
    firstStylist.save();
    Stylist secondStylist = new Stylist("name","image1");
    secondStylist.save();
    assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
  }

  @Test
  public void getClients_retrievesALlClientsFromDatabase_ClientList() {
    Stylist myStylist = new Stylist("name","image1");
    myStylist.save();
    Client firstClient = new Client("name","image","email", myStylist.getId());
    firstClient.save();
    Client secondClient = new Client("name","image","email", myStylist.getId());
    secondClient.save();
    Client[] clients = new Client[] { firstClient, secondClient };
    assertTrue(myStylist.getClients().containsAll(Arrays.asList(clients)));
}



}
