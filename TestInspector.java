import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class TestInspector{

  private Inspector gadget;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void setUp(){
    gadget = new Inspector();
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void tearDown(){
    gadget = null;
    System.setOut(null);
  }

  @Test
  public void testFindClassName(){
    //objects
    Object mung = new Object();
    gadget.findClassName(mung.getClass());
    assertEquals("Declaring Class: " + Object.class.getName(), outContent.toString());

    //string
    //assertEquals(String.class.getName(), gadget.findClassName("hey QT how you doin?".getClass()));

    //int
    //Integer testNumber = new Integer(3);
    //assertEquals(Integer.class.getName(), gadget.findClassName(testNumber.getClass()));

  }

  @Test
  public void testFindImmediateSuperclass(){
    //object
    //Object mung = new Object();
    //assertEquals("Primitive Type, Object, or interface", gadget.findImmidiateSuperClass(mung.getClass()));
  }

}
