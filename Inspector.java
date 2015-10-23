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

    //find constructors for the class object
    findContructors(objClass);

    //find the fields for the class object
    findFields(object, objClass);
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
    System.out.println("***Interfaces***");
    for (Class interf : interfaces){
      System.out.println("\t Interface: " + interf.getName());
    }
  }

  public void findMethods(Class objClass){
    Method[] methods = objClass.getDeclaredMethods();
    System.out.println("***Methods***");
    for (Method meth : methods){
      System.out.println("Method: " + meth.getName());
      findMethodExceptions(meth);
      findMethodParameters(meth);
      findReturnType(meth);
      findMethodModifiers(meth);
    }
  }

  public void findMethodExceptions(Method meth){
    Class[] exceptions = meth.getExceptionTypes();
    System.out.println("\t***Exceptions***");
    for (Class excep : exceptions){
      System.out.println("\tException:" + excep.getName());
    }
  }

  public void findMethodParameters(Method meth){
    Class[] params = meth.getParameterTypes();
    System.out.println("\t***Parameters***");
    for (Class param : params){
      System.out.println("\tParameters:" + param.getName());
    }
  }

  public void findReturnType(Method meth){
    Class returnType = meth.getReturnType();
    System.out.println("\t***Return Type***\n\tReturn: " + returnType.getName());
  }

  public void findMethodModifiers(Method meth){
      int modCode = meth.getModifiers();
      System.out.println("\t***Modifier***");
      System.out.println("\tModifier: " + Modifier.toString(modCode));
  }

  public void findContructors(Class objClass){
    Constructor[] constructors = objClass.getDeclaredConstructors();
    System.out.println("***Constructors***");
    for (Constructor construct : constructors){
      System.out.println("Constructor: " + construct.getName());
      findConstructorParameters(construct);
      findConstructorModifiers(construct);
    }
  }

  public void findConstructorParameters(Constructor construct){
    Class[] params = construct.getParameterTypes();
    System.out.println("\t***Parameters***");
    for (Class param : params){
      System.out.println("\tParameter: " + param.getName());
    }
  }

  public void findConstructorModifiers(Constructor construct){
    int modCode = construct.getModifiers();
    System.out.println("\t***Modifiers***");
    System.out.println("\tModifier: " + Modifier.toString(modCode));
  }

  public void findFields(Object obj, Class objClass){
    Field[] fields = objClass.getDeclaredFields();
    System.out.println("***Fields***");

    for (Field fld : fields){
      Object value = null;

      if(!fld.isAccessible())
        fld.setAccessible(true);

      try{
        value = fld.get(obj);
      }catch(Exception e){}
        
      System.out.println("Field: " + fld.getName()
        + "\n\t Type: " + fld.getType()
        + "\n\t Modifiers: " + Modifier.toString(fld.getModifiers())
        + "\n\t Value: " + value);
    }
  }

}
