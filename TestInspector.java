import org.junit.Test;
import static org.junit.Assert.*;

public class TestInspector{
  @Test
  public void testGetClassName(){
    Object mung = new Object();
    Inspector gadget = new Inspector();
    assertEquals(Object.class.getName(), gadget.getClassName(mung.getClass()));
  }
}
