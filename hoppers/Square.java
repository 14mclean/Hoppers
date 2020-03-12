import javax.swing.*;

/**
 * Implementation of square (button) with neseccary inforamtion
 * 
 * @author Mark McLean
 * @version 1.0
 */
public class Square
{
    private boolean containsLilypad;
    private int containsFrog;
    private int[] coordinates = new int[2];
    private JPanel panel;
    private JButton button = new JButton();
    private String currentIcon = new String();

    /**
     * 
     * @param panel The panel the button will be a part of
     * @param row The row (x coordinate) of the square
     * @param column The column (y coordinate) of the square
     * @param frogType The type of frog on the square. Should be either 1 (green frog) or 2 (red frog)
     * @param instance The board instance that will be the action listener for the button
     */
    Square(JPanel panel, int row, int column, int frogType, Board instance)
    {
        this.panel = panel;
        this.containsLilypad = true;
        this.containsFrog = frogType;
        this.coordinates[0] = row;
        this.coordinates[1] = column;
        this.button.addActionListener(instance);

        if(frogType == 1)
        {
            changeIcon("GreenFrog.png");
        }
        else if(frogType == 2)
        {
            changeIcon("RedFrog.png");
        }

        this.panel.add(button);
    }

    /**
     * 
     * @param panel The panel the button will be a part of
     * @param row The row (x coordinate) of the square
     * @param column The column (y coordinate) of the square
     * @param lilypad Boolean determining whether the square has a lilypad. True: lilypad, false: water
     * @param instance The board instance that will be the action listener for the button
     */
    Square(JPanel panel, int row, int column, boolean lilypad, Board instance)
    {
        this.panel = panel;
        this.containsLilypad = lilypad;
        this.containsFrog = 0;
        this.coordinates[0] = row;
        this.coordinates[1] = column;
        this.button.addActionListener(instance);

        if(lilypad)
        {
            changeIcon("Lilypad.png");
        }
        else
        {
            changeIcon("Water.png");
        }
        this.panel.add(button);
    }

    /**
     * If square has a frog, wil switch between the default and 2nd icon
     */
    void switchIcon()
    {
        if(this.currentIcon == "GreenFrog.png")
        {
            changeIcon("GreenFrog2.png");
        }
        else if(this.currentIcon == "GreenFrog2.png")
        {
            changeIcon("GreenFrog.png");
        }
        else if(this.currentIcon == "RedFrog2.png")
        {
            changeIcon("RedFrog.png");
        }
        else if(this.currentIcon == "RedFrog.png")
        {
            changeIcon("RedFrog2.png");
        }
    }

    /**
     * @return Hashcode of JButton
     */
    int getButtonHash()
    {
        return this.button.hashCode();
    }

    /**
     * Changes the icon of the square
     * @param path path to location of the icon
     */
    void changeIcon(String path)
    {
        this.button.setIcon(new ImageIcon(this.getClass().getResource(path)));
        this.currentIcon = path;
    }

    /**
     * @return Boolean determining whether the square has a lilypad. True: lilypad, false: water
     */
    boolean hasLilypad()
    {
        return this.containsLilypad;
    }

    /**
     * 
     * @return returns value dependant of if the square contains a frog, 0: no frog, 1: green frog, 2: red frog
     */
    int hasFrog()
    {
        return containsFrog;
    }

    /**
     * Changes the frog type of the square, 0: no frog, 1: green frog, 2: red frog
     * @param frogType
     */
    void setFrog(int frogType)
    {
        this.containsFrog = frogType;
        if(this.containsFrog == 0)
        {
            changeIcon("LilyPad.png");
        }
        else if(this.containsFrog == 1)
        {
            changeIcon("GreenFrog.png");
        }
        else if(this.containsFrog == 2)
        {
            changeIcon("RedFrog.png");
        }
    }

    /**
     * Implementation of moving a frog from one square to another
     * @param endSquare The square which the frog is moving to
     */
    void moveTo(Square endSquare)
    {
        endSquare.setFrog(this.containsFrog);
        this.setFrog(0);
    }

    /**
     * 
     * @return Coordinates of the square
     */
    int[] getCoordinates()
    {
        return coordinates;
    }

    /**
     * Implementation of when this frog gets taken
     */
    void taken()
    {
        this.containsFrog = 0;
        changeIcon("LilyPad.png");
    }
}
