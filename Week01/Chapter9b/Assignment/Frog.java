import java.awt.Color;

/*
 * Camden Harris
 * Winter 2024, C211, William Iverson
 * 1/5/24
 * Chapter 9a Quiz
 * Data structure class for a Marketer
 */

public class Frog implements Animal {
    // data fields
    private int hopNum; // keeps track whether the frog is in the process of a hop
    private int currentDirection; // direction to be hopping in

    // default constructor
    public Frog() {
        hopNum = 0;
        currentDirection = 0;
	}

    // Frogs start with the letter F
    public String toString() {
        return "F";
    }

    // Moves randomly 3 steps in one of the four directions
    @Override
    public int getMove() {
        if (hopNum == 3) {
            hopNum %= 3;
            double r = Math.random();
            
            if (r < 0.25)
                currentDirection = NORTH;
            else if (r < 0.5)
                currentDirection = SOUTH;
            else if (r < 0.75)
                currentDirection = EAST;
            else
                currentDirection = WEST;
        }

        hopNum++;
        return currentDirection;
    }

    // Frogs are green
    @Override
    public Color getColor() {
        return Color.GREEN;
    }
}
