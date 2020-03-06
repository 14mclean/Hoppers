import javax.swing.*;

public class Square
{
    private boolean containsLilypad;
    private int containsFrog;
    private int[] coordinates = new int[2];
    private JPanel panel;
    private JButton button = new JButton();

    Square(JPanel panel, int row, int column, int frogType)
    {
        this.panel = panel;
        this.containsLilypad = true;
        this.containsFrog = frogType;
        this.coordinates[0] = row;
        this.coordinates[1] = column;

        if(frogType == 1)
        {
            //changeIcon("GreenFrog.png");
            button.setIcon( new ImageIcon("GreenFrog.png"));
            button.setPressedIcon( new ImageIcon("GreenFrog2.png"));
        }
        else if(frogType == 2)
        {
            //changeIcon("RedFrog.png");
            button.setIcon( new ImageIcon("RedFrog.png"));
            button.setPressedIcon( new ImageIcon("RedFrog2.png"));
        }

        this.panel.add(button);
    }

    Square(JPanel panel, int row, int column, boolean lilypad)
    {
        this.panel = panel;
        this.containsLilypad = lilypad;
        this.containsFrog = 0;
        this.coordinates[0] = row;
        this.coordinates[1] = column;

        if(lilypad)
        {
            //changeIcon("Lilypad.png");
            button.setIcon( new ImageIcon("Lilypad.png"));
        }
        else
        {
            //changeIcon("Water.png");
            button.setIcon( new ImageIcon("Water.png"));
        }
        this.panel.add(button);
    }

    void changeIcon(String path)
    {
        button.setIcon(new ImageIcon(path));
    }

    void actionListener(Board instance)
    {
        this.button.addActionListener(instance);
    }

    boolean hasLilypad()
    {
        return this.containsLilypad;
    }

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
