import java.awt.Color;

public class Snake implements Animal {
    // data fields
    private int maxSlither; // keeps track of how long to slither
    private int currentSlither; // keeps track of how many spots have been slithered in a given movement
    private boolean isSlithering; // keeps track of whether to move left/right (true), or downwards (false)
    private boolean slitheringLeft; // keeps track of whether to slither left (true), or right (false)

    // default constructor
    public Snake() {
        maxSlither = 0;
        currentSlither = 0;
        isSlithering = false;
        slitheringLeft = true;
	}

    // Snakes start with the letter S
    public String toString() {
        return "S";
    }

    // slithers left and right in increasing length
    @Override
    public int getMove() {
        if (currentSlither == maxSlither) {
            isSlithering = false;
            slitheringLeft = !slitheringLeft;
        }

        if (isSlithering) {
            currentSlither++;
            return slitheringLeft ? WEST : EAST;
        } else {
            isSlithering = true;
            currentSlither = 0;
            maxSlither++;
            return SOUTH;
        }
    }

    // Snakes are red
    @Override
    public Color getColor() {
        return Color.RED;
    }
}
