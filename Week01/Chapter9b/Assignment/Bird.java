import java.awt.Color;
//Stuart Reges
//9/6/00 (original code with "Building Java Programs" textbook
//Changed 2023 by W.P. Iverson, for CS211 project at Bellevue College
public class Bird implements Animal {
	
	// Constructor
	public Bird() {
		super(); // nothing to do here, so calling obvious (redundant)
		// Iverson CS211, always requests a zero parameter constructor
	}
	
	// over-rides Object, and satisfies interface
    public String toString() {
        return "B";
    }

    // required by interface, not even using AnimalInfo in code below
    public int getMove() { //AnimalInfo info) {
        double r = Math.random();
        if (r < 0.25)
            return NORTH;
        else if (r < 0.5)
            return SOUTH;
        else if (r < 0.75)
            return EAST;
        else
            return WEST;
    }

    // millions of options here
	public Color getColor() {
		return new Color(0,0,255);
	}
}
