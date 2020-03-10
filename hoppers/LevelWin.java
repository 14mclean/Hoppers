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
    private boolean[] beatenLevel = new boolean[40];
    private boolean won = true;
    private double deltaTime;
    
    /**
     * Starts Level Decider window on 'level 0' with no game board
     */
    LevelWin()
    {
        levelDisplay.setText("Start Timer");

        previousButton.addActionListener(this);
        previousButton.setEnabled(false);
        nextButton.addActionListener(this);

        decisionWin.setLayout(new FlowLayout());

        decisionWin.add(previousButton);
        decisionWin.add(levelDisplay);
        decisionWin.add(nextButton);

        decisionWin.setSize(275, 75);
        decisionWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        decisionWin.setLocation(1000, 250);
        decisionWin.setVisible(true);
        for(int count = 0; count < 40; count++)
        {
            beatenLevel[count] = false;
        }
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
            if(currentLevel == 2)
            {
                previousButton.setEnabled(false);
            }
            else if(currentLevel == 41)
            {
                for(int count = 0; count < 40; count++)
                {
                    beatenLevel[count] = false;
                }
                won = true;
                levelDisplay.setText("Start Timer");
                previousButton.setEnabled(false);
                nextButton.setEnabled(true);
                currentLevel = 0;
                return;
            }
            currentBoard.close();
            currentBoard = null;
            currentLevel--;
            currentBoard = new Board(currentLevel);
            levelDisplay.setText("Level: " + currentLevel);
        }
        else if(source.hashCode() == nextButton.hashCode())
        {
            if(currentLevel == 40)
            {
                endNanoTime = System.nanoTime();
                deltaTime = (endNanoTime - startNanoTime) / Math.pow(10, 9);
                currentLevel++;
                currentBoard.close();
                currentBoard = null;
                nextButton.setEnabled(false);
                levelDisplay.setText("Timer Stopped");
                for(int count = 0; count < beatenLevel.length; count++)
                {
                    if(!beatenLevel[count])
                    {
                        won = false;
                    }
                }
                if(won || !won)
                {
                    JOptionPane.showMessageDialog(decisionWin, "Total time taken for 40 levels: " + Math.round( deltaTime * 100.0) / 100.0 + "s", "Time Taken", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(decisionWin, "Did not complete all 40 levels", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(currentLevel == 0)
            {
                previousButton.setEnabled(true);
                currentLevel++;
                currentBoard = new Board(currentLevel);
                levelDisplay.setText("Level: " + currentLevel);
                startNanoTime = System.nanoTime();
            }
            else
            {
                currentBoard.close();
                currentBoard = null;
                currentLevel++;
                currentBoard = new Board(currentLevel);
                levelDisplay.setText("Level: " + currentLevel);
            }
        }
    }

    /**
     * Sets a level to beaten after completing it
     * @param levelBeaten the level number that was beaten
     */
    void addWin(int levelBeaten)
    {
        beatenLevel[levelBeaten-1] = true;
    }
}