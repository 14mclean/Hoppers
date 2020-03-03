import javax.swing.ImageIcon;
import javax.swing.JButton;

class Square
{
    private ImageIcon displayImage = new ImageIcon();
    private boolean containsLilypad;
    private int containsFrog;
    private int[] coordinates = new int[2];
    private JButton button;

    /**
     * 
     * @param position Coordinates on 5x5 grid in which the square is positoned (0-4)
     * @param frogType If =0: no frog, if =1: green frog, if =2: red frog
     */

    Square(int row, int column, int frogType)
    {
        this.containsLilypad = true;
        this.containsFrog = frogType;
        this.coordinates[0] = row;
        this.coordinates[1] = coulmn;
        if(frogType == 1)
        {
            displayImage.setImage(new Image("GreenFrog.png"));
        }
        else if(frogType == 2)
        {
            displayImage.setImage(new Image("RedFrog.png"));
        }

        button = new JButton(displayImage);
    }

    /**
     * 
     * @param position Coordinates on 5x5 grid in which the square is positoned (0-4)
     * @param lilypad Boolean on whether the square contains a lilypad
     */

    Square(int row, int column, boolean lilypad)
    {
        this.containsLilypad = lilypad;
        this.containsFrog = 0;
        this.coordinates[0] = position[0];
        this.coordinates[1] = position[1];
        if(lilypad)
        {
            displayImage.setImage(new Image("Lilypad.png"));
        }
        else
        {
            displayImage.setImage(new Image("Water.png"));
        }
    }

    /**
     * Acessor method for whether the square contains a lilypad
     * @return boolean on whether the square contains a lilypad
     */

    boolean hasLilypad()
    {
        return this.containsLilypad;
    }

    /**
     * Acessor method for whether the square contains a frog
     * @return whether the square has a frog on it
     */

    int hasFrog()
    {
        return containsFrog;
    }

    void changeFrog(int frogType)
    {
        this.containsFrog = frogType;
        if(frogType == 1)
        {
            displayImage.setImage(new Image("GreenFrog.png"));
        }
        else if(frogType == 2)
        {
            displayImage.setImage(new Image("RedFrog.png"));
        }
    }

    /**
     * Method to move a frog from one sqaure to another
     * @param row the row that the frog will move to (0-4)
     * @param column the column that the frog will move to (0-4)
     */

    void moveTo(int row, int column)
    {

    }
}
