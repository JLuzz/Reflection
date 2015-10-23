import java.lang.reflect.*;

public class Inspector{

  public Inspector(){

  }

  public void inspect(Object object, boolean recursive){

    Class objClass = object.getClass();

    //find the declaring class
    findClassName(objClass);

    //find the immediate superclass
    findImmidiateSuperClass(objClass);

    //find interfaces implemented by this class object
    findInterfaces(objClass);

  }

  //return the Class name as a string
  public void findClassName(Class objClass){
    //print the declaring class name
    System.out.println("Declaring Class: " + objClass.getName());
  }

  //
  public void findImmidiateSuperClass(Class objClass){
    Class objSuperclass = objClass.getSuperclass();
    if (objSuperclass == null){
      System.out.println("Immediate superclass: Primitive Type, Object, or Interface");
    }else if (objSuperclass == Object.class){
      System.out.println("Immediate superclass: Array");
    }else{
      System.out.println("Immediate superclass: " + objSuperclass.getName());
    }
  }

  public void findInterfaces(Class objClass){

    Class[] interfaces = objClass.getInterfaces();
    System.out.println("Interfaces: ");

    for (Class interf : interfaces){
      System.out.println(interf.getName()+", ");
    }
  }

}
