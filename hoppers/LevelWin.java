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
        previousButton.setEnabled(false);
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
            currentBoard.close();
            currentBoard = null;
            currentLevel--;
            currentBoard = new Board(currentLevel);
            levelDisplay.setText("Level: " + currentLevel);

            if(currentLevel == 1)
            {
                previousButton.setEnabled(false);
            }
            else
            {
                previousButton.setEnabled(true);
            }

            if(currentLevel == 40)
            {
                nextButton.setEnabled(false);
            }
            else
            {
                nextButton.setEnabled(true);
            }
        }
        else if(source.hashCode() == nextButton.hashCode())
        {
            currentBoard.close();
            currentBoard = null;
            currentLevel++;
            currentBoard = new Board(currentLevel);
            levelDisplay.setText("Level: " + currentLevel);

            if(currentLevel == 40)
            {
                nextButton.setEnabled(false);
            }
            else
            {
                nextButton.setEnabled(true);
            }

            if(currentLevel == 1)
            {
                previousButton.setEnabled(false);
            }
            else
            {
                previousButton.setEnabled(true);
            }
        }
    }
}