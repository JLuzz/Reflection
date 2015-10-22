import java.lang.reflect.*;

public class Inspector{

  public Inspector(){

  }

  public void inspect(Object object, boolean recursive){
    //get the declaring class
    Class classObject = object.getClass();

    //print the declaring class name
    System.out.println(getClassName(classObject));

  }

  //return the Class name as a string
  public String getClassName(Class classObject){
      return classObject.getName();
  }

}
