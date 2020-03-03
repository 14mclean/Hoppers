import javax.swing.*;

public class Square
{
    private ImageIcon displayImage;
    private boolean containsLilypad;
    private int containsFrog;
    private int[] coordinates = new int[2];
    private JPanel win;
    private JButton button;

    /**
     * 
     * @param position Coordinates on 5x5 grid in which the square is positoned (0-4)
     * @param frogType If =0: no frog, if =1: green frog, if =2: red frog
     */

    Square(JPanel win, int row, int column, int frogType)
    {
        this.win = win;
        this.containsLilypad = true;
        this.containsFrog = frogType;
        this.coordinates[0] = row;
        this.coordinates[1] = column;

        if(frogType == 1)
        {
            changeIcon("GreenFrog.png");
        }
        else if(frogType == 2)
        {
            changeIcon("RedFrog.png");
        }

        button = new JButton(displayImage);
        win.add(button/*, this.coordinates[0], this.coordinates[1]*/);
    }

    /**
     * 
     * @param position Coordinates on 5x5 grid in which the square is positoned (0-4)
     * @param lilypad Boolean on whether the square contains a lilypad
     */

    Square(JPanel win, int row, int column, boolean lilypad)
    {
        this.win = win;
        this.containsLilypad = lilypad;
        this.containsFrog = 0;
        this.coordinates[0] = row;
        this.coordinates[1] = column;
        if(lilypad)
        {
            changeIcon("Lilypad.png");
        }
        else
        {
            changeIcon("Water.png");
        }
    }

    private void changeIcon(String path)
    {
        displayImage.setImage(new ImageIcon("path").getImage());
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

    int move()
    {
        int temp = this.containsFrog;
        this.containsFrog = 0;
        return temp;
    }

    void moveTo(int frogType)
    {
        this.containsFrog = frogType;
        if(frogType == 1)
        {
            changeIcon("GreenFrog.png");
        }
        else if(frogType == 2)
        {
            changeIcon("RedFrog.png");
        }
    }
}
