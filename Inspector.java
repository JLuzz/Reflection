import java.lang.reflect.*;

public class Inspector{

  public void inspect(Object object, boolean recursive){
    // get declaring class
    Class classObject = object.getClass();
    System.out.println(classObject.getName());
  }
}
