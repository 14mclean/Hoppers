import javax.swing.ImageIcon;

class Square
{
    private ImageIcon displayImage = new ImageIcon();
    private boolean containsLilypad;
    private int containsFrog;
    private int[] coordinates = new int[2];

    /**
     * 
     * @param position Coordinates on 5x5 grid in which the square is positoned (0-4)
     * @param containing True if square requires a lilypad, false if just water
     * @param frogType If =0: no frog, if =1: green frog, if =2: red frog
     */

    Square(int[] position, boolean lilypad, int frogType)
    {
        this.containsLilypad = lilypad;
        this.containsFrog = frogType;
        this.coordinates[0] = position[0];
        this.coordinates[1] = position[1];
    }

    boolean hasLilypad()
    {
        return this.containsLilypad;
    }

    int hasFrog()
    {
        return containsFrog;
    }
}
