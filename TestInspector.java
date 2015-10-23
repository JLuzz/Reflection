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
    assertEquals(Object.class.getName() + "\n", outContent.toString());
    outContent.reset();

    //string
    gadget.findClassName("hey QT 3.14".getClass());
    assertEquals(String.class.getName() + "\n", outContent.toString());
    outContent.reset();

    //int
    Integer meeseeks = new Integer(3);
    gadget.findClassName(meeseeks.getClass());
    assertEquals(Integer.class.getName() + "\n", outContent.toString());
    outContent.reset();

    //Array
    /*
    int[] tonyYayo = new int[3];
    gadget.findClassName(tonyYayo.getClass());
    assertEquals(Array.class.getName(), outContent.toString());
    outContent.reset();
    */
  }

  @Test
  public void testFindImmediateSuperclass(){
    //object
    //Object mung = new Object();
    //gadget.findImmidiateSuperClass(mung.getClass());
    //System.out.println(outContent.toString());
    //assertEquals(Object.class.getSuperclass().getName() + "\n", outContent.toString());

    //int

    //string

  }

  @Test
  public void testFindInterfaces(){
    //interface exists
    //ClassA extends serializable and runnable
    gadget.findInterfaces(new ClassA().getClass());
    assertEquals("Interface: java.io.Serializable\nInterface: java.lang.Runnable\n", outContent.toString());
    outContent.reset();
    //no interface
    //ClassD implements no interfaces
    gadget.findInterfaces(new ClassD().getClass());
    assertEquals("", outContent.toString());
    outContent.reset();


  }

}
