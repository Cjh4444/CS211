// Stuart Reges
// 9/6/00 (original code with "Building Java Programs" textbook
// Changed 2023 by W.P. Iverson, for CS211 project at Bellevue College
//

// AnimalMain provides method main for a simple simulation program.

public class AnimalMain {
    public static void main(String[] args21) {
    	// start work with two animals
    	Animal[] tester = {new Bird(), new Mouse(), new Frog(), new Snake()};
    	// once done, all seven animals should work
    	//Animal[] tester = {new Bird(),new Mouse(),new Frog(),new Rabbit(),new Snake(),new Turtle(),new Wolf()};
    	for (int i=0; i<tester.length; i++) {
    	    System.out.print("Animal: "  + tester[i].toString());   	    
    	    System.out.println(" color=" + tester[i].getColor());    	    
    	    for (int step=1; step<10; step++) {   		
    		System.out.print(" move="    + tester[i].getMove());
    	    }
    	    System.out.println("\n");
    	}
    	// Sample output, some should be random:
    	// B   6   java.awt.Color[r=0,g=0,b=255]
    	// M   4   java.awt.Color[r=128,g=128,b=128]
    	// F   8   java.awt.Color[r=0,g=225,b=0]
    	// V   8   java.awt.Color[r=225,g=0,b=0]
    	// S   2   java.awt.Color[r=100,g=100,b=0]
    	// T   2   java.awt.Color[r=0,g=100,b=100]
    	// W   8   java.awt.Color[r=100,g=0,b=100]
    }
}
