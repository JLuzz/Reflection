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

    //find methods implemented by this class object
    findMethods(objClass);

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
    System.out.println("Interfaces:");
    for (Class interf : interfaces){
      System.out.println("\t" + interf.getName());
    }
  }

  public void findMethods(Class objClass){
    Method[] methods = objClass.getDeclaredMethods();
    System.out.println("Methods:");
    for (Method meth : methods){
      System.out.println("\t" + meth.getName());
      findMethodExceptions(meth);
      findMethodParameters(meth);
      findReturnType(meth);
      findMethodModifiers(meth);
    }
  }

  public void findMethodExceptions(Method meth){
    Class[] exceptions = meth.getExceptionTypes();
    System.out.println("\t\tExceptions:");
    for (Class excep : exceptions){
      System.out.println("\t\t\t" + excep.getName());
    }
  }

  public void findMethodParameters(Method meth){
    Class[] params = meth.getParameterTypes();
    System.out.println("\t\tParameters:");
    for (Class param : params){
      System.out.println("\t\t\t" + param.getName());
    }
  }

  public void findReturnType(Method meth){
    Class returnType = meth.getReturnType();
    System.out.println("\t\tReturn Type:");
    System.out.println("\t\t\t" + returnType.getName());
  }

  public void findMethodModifiers(Method meth){
      int modCode = meth.getModifiers();
      System.out.println("\t\tModifier:");
      System.out.println("\t\t\t" + Modifier.toString(modCode));
  }

}
