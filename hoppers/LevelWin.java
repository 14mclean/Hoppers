import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LevelWin implements ActionListener
{
    private JFrame decisionWin = new JFrame("Level Decider");
    private JButton previousButton = new JButton("<");
    private JButton nextButton = new JButton(">");
    private JLabel levelDisplay = new JLabel();
    private int currentLevel = 1;
    private Board currentBoard = new Board(1);
    
    LevelWin()
    {
        levelDisplay.setText("Level: " + currentLevel);
        
        previousButton.addActionListener(this);
        nextButton.addActionListener(this);

        decisionWin.setLayout(new FlowLayout());

        decisionWin.add(previousButton);
        decisionWin.add(levelDisplay);
        decisionWin.add(nextButton);

        decisionWin.setSize(275, 75);
        decisionWin.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if(source.hashCode() == previousButton.hashCode())
        {
            currentBoard = null;
            currentBoard = new Board(currentLevel-1);
            levelDisplay.setText("Level: " + currentLevel);
        }
        else if(source.hashCode() == nextButton.hashCode())
        {
            currentBoard = null;
            currentBoard = new Board(currentLevel+1);
            levelDisplay.setText("Level: " + currentLevel);
        }
    }
}