import javax.swing.*;

public class Square
{
    private boolean containsLilypad;
    private int containsFrog;
    private int[] coordinates = new int[2];
    private JPanel panel;
    private JButton button = new JButton();
    private String currentIcon = new String();

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
            button.setIcon( new ImageIcon("Lilypad.png"));
        }
        else
        {
            button.setIcon( new ImageIcon("Water.png"));
        }
        this.panel.add(button);
    }

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

    int getButtonHash()
    {
        return this.button.hashCode();
    }

    void changeIcon(String path)
    {
        this.button.setIcon(new ImageIcon(path));
        this.currentIcon = path;
    }

    boolean hasLilypad()
    {
        return this.containsLilypad;
    }

    int hasFrog()
    {
        return containsFrog;
    }

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

    void moveTo(Square endSquare)
    {
        endSquare.setFrog(this.containsFrog);
        this.setFrog(0);
    }

    int[] getCoordinates()
    {
        return coordinates;
    }

    void taken()
    {
        this.containsFrog = 0;
        changeIcon("LilyPad.png");
    }
}
