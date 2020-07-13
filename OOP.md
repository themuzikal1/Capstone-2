Object Oriented Programming Concept Questions

As you should know by now, there are 4 pillars of Object Oriented Programming.

********************
1. Encapsulation
Encapsulation is the process of wrapping and code and data together into a single unit.  We can create a 
fully encapsulated class in Java by making all of the data members of the class private.  Variables
are hidden from each other and only accessible though methods of current class. 

--Shape Class

public class EncapTest {
   private String name;
   private String idNum;
   private int age;

   public int getAge() {
      return age;
   }

   public String getName() {
      return name;
   }

   public String getIdNum() {
      return idNum;
   }

   public void setAge( int newAge) {
      age = newAge;
   }

   public void setName(String newName) {
      name = newName;
   }

   public void setIdNum( String newId) {
      idNum = newId;
   }
}

********************
2. Inheritance -- Splash Screen
Inheritance is a mechanism in Java by which one class is allowed to inherit the features (fields and methods)
of another class.  The subclass can add its own fields and methods in addition to the superclass fields
and methods. 
class Vehicle {
  protected String brand = "Ford";        // Vehicle attribute
  public void honk() {                    // Vehicle method
    System.out.println("Tuut, tuut!");
  }
}

class Car extends Vehicle {
  private String modelName = "Mustang";    // Car attribute
  public static void main(String[] args) {

    // Create a myCar object
    Car myCar = new Car();

    // Call the honk() method (from the Vehicle class) on the myCar object
    myCar.honk();
********************
3. Abstraction - Splash Screen
Abstraction is the property by virtue of which only the essential details are displayed to the user.  
the trival or non-essential units are not displayed to the user. Abstraction is achieved by interfaces
and abstract classes.  

abstract class Animal {
  public abstract void animalSound();
  public void sleep() {
    System.out.println("Zzz");
  }
}

********************
4. Polymorphism - Board - game cycle implements action listener. 
Polymorphism is the ability of an object to take on many forms.  The most commpon use of polymorphism
in OOP occurs when a parent class reference is used to refer to a child class object.

Any Java object that can mass more than one IS-A test is considered to be polymorphic. In Java
all objects are polymorphic since they will pass the IS-A test for their own type and for the class
object. 
   
public interface Vegetarian{}
public class Animal{}
public class Deer extends Animal implements Vegetarian{}





Please write 1-3 paragraphs explaining these 4 concepts further.  Please provide a sufficient enough explanation about these pillars, as well as some examples to illustrate the practical use cases of these principles.  

**Dependency Inversion - started with the least important class.  Splash Screen.  it does not depend on 
anther class.  

**Observer Pattern - score board.  It is always listening to the game and when a line is cleared, the 
status bar is updated with the score. 

Also, the KeyEvent is listening for key presses and updates the GUI. 

**Adaptor Pattern - 
KeyAdaptor - is an abstract adaptor class for receiving keyvoard events.  The key listener
is an interface.  Create a listener object using the extended class and then register it with a component
using the compoents addKeyListener. 

**Error handling - if you press ENTER, you get an error message in the status bar that 
goes away when a valid key is pressed. 

