import java.awt.Color;
//Stuart Reges
//9/6/00 (original code with "Building Java Programs" textbook
//Changed 2023 by W.P. Iverson, for CS211 project at Bellevue College
public class Mouse implements Animal {
    private boolean myZig; // determines which way to go for each mouse
    
    public Mouse() {
    	myZig = true;
    }

    // required by interface
    public String toString() {
        return "M";
    }

    // toggle boolean, so alternates up and left
    public int getMove() { //AnimalInfo info) {
        myZig = !myZig;
        if (myZig)
            return NORTH; // up
        else
            return WEST; // left
    }
    
    // using basic grey
	public Color getColor() {
		return Color.GRAY;
	}
}

