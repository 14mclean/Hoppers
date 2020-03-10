import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Creates Level Decider window which controls boards and timing
 * 
 * @author Mark McLean
 * @version 1.0
 */
public class LevelWin implements ActionListener
{
    private JFrame decisionWin = new JFrame("Level Decider");
    private JButton previousButton = new JButton("<");
    private JButton nextButton = new JButton(">");
    private JLabel levelDisplay = new JLabel();
    private int currentLevel = 0;
    private Board currentBoard;
    private long startNanoTime;
    private long endNanoTime;
    
    /**
     * Starts Level Decider window on 'level 0' with no game board
     */
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
        decisionWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        decisionWin.setVisible(true);
    }

    /**
     * Method called when a button on Level Decider win pressed. 
     * Checks which button is pressed and changes level & level number based off this. 
     * Also disables buttons when at extremes to ensure the user doesnt pass the number of levels or go negative
     * @param e The ActionEvent that is made when a button is pressed
     */
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
            if(currentLevel == 0)
            {
                currentBoard = new Board(1);
                startNanoTime = System.nanoTime();
                currentLevel++;
                levelDisplay.setText("Level: " + currentLevel);
                return;
            }
            if(currentLevel == 40)
            {
                endNanoTime = System.nanoTime();
                currentBoard.close();
                currentBoard = null;
                levelDisplay.setText("Level: " + currentLevel);
                JOptionPane.showMessageDialog(decisionWin, "Total time taken for 40 levels: " + (double) (endNanoTime-startNanoTime)/1000000000.00 + "s", "Time Taken", JOptionPane.INFORMATION_MESSAGE);

            }
            currentBoard.close();
            currentBoard = null;
            currentLevel++;
            currentBoard = new Board(currentLevel);
            levelDisplay.setText("Level: " + currentLevel);

            if(currentLevel == 41)
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