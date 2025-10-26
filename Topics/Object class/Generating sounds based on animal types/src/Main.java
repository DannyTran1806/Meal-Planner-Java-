// Java code template starts here
import java.util.*;

public class Main {

    // Define Animal class here
    public class Animal{
        String name; 
        public Animal (String name){
            this.name = name; 
        }
        public String sound (){}
    }

    // Define Dog class here
    public class Dog extends Animal{
        @Override
        public String sound(){
            System.out.println("Bark!"); 
        }
    }

    // Define Cat class here
    public class Cat extends Animal{
        @Override
        public String sound(){
            System.out.println("Meow!"); 
        }
    }

    public static void main(String[] args) {

        // In this section, you need to add code to receive input
        // and create the corresponding animal object
        Scanner input = new Scanner(System.in); 
        String animalType = input.nextLine(); 
        Animal dog = new Dog(); 
        Animal cat = new Cat(); 
        

        // Replace the placeholders with the appropriate calls
        if(animalType.equals("Dog")) {
            dog.sound(); 

        } else if(animalType.equals("Cat")) {
            cat.sound(); 
        } else {
            System.out.println("Animal type not recognized");
        }
    }
} 

// Java code template ends here
