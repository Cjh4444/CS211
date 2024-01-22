import java.awt.Color;
// Stuart Reges
// 12/03/04
//
// Changed 2023 by W.P. Iverson, for CS211 project at Bellevue College
//
// The Animal interface defines the methods necessary for an animal
// to participate in the animal scramble simulation.  It must return a
// character when getChar is called that is used for displaying it on
// the screen.  The getMove method must return a legal move (one of
// the constants NORTH, SOUTH, EAST, WEST, CENTER).  

public interface Animal {
	// Each direction resolves to int
	// based on layout of keypad, 8 at top, 2 at bottom, etc...
    public static final int NORTH = 8;
    public static final int SOUTH = 2;
    public static final int EAST = 6;
    public static final int WEST = 4;
    public static final int HOLD = 0;	
	
    // methods required by interface
    public String toString();
    public int getMove();
    public Color getColor();
}
