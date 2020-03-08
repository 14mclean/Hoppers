import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board implements ActionListener
{
    private Square[][] grid = new Square[5][5];
    private JFrame win = new JFrame("Hoppers");
    private JPanel panel = new JPanel(new GridLayout(5,5));
    private boolean pressed = false;
    private int[] startPosition = new int[2], endPosition = new int[2];
    private int levelNum = 22;
    private Level currentLevel;

    Board()
    {
        win.add(panel);

        currentLevel = new Level(levelNum);

        for(int x = 0; x < 5; x++)
        {
            for(int y = 0; y < 5; y++)
            {
                if(x%2 != y%2)
                {
                    
                }
            }
        }

        win.setSize(750, 750);
        win.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        for(int count = 0; count < 5; count++)
        {
            for(int count2 = 0; count<5; count++)
            {
                if(grid[count][count2] == source)
                {
                    Square currentSquare = grid[count][count2];
                    if(currentSquare.hasFrog() > 0)
                    {
                        if(!pressed)
                        {
                            pressed = true;
                            startPosition[0] = count;
                            startPosition[1] = count2;
                            if(currentSquare.hasFrog() == 1)
                            {
                                currentSquare.changeIcon("GreenFrog2.png");
                            }
                            else if(currentSquare.hasFrog() == 2)
                            {
                                currentSquare.changeIcon("RedFrog2.png");
                            }
                        }
                        else
                        {
                            pressed = false;
                            endPosition[0] = count;
                            endPosition[1] = count2;
                            moveFromTo();
                            if(currentSquare.hasFrog() == 1)
                            {
                                currentSquare.changeIcon("GreenFrog.png");
                            }
                            else if(currentSquare.hasFrog() == 2)
                            {
                                currentSquare.changeIcon("RedFrog.png");
                            }
                        }
                    }
                }
            }
        }
    }

    void moveFromTo()
    {
        Square startSquare = grid[startPosition[0]][startPosition[1]];
        Square endSquare = grid[endPosition[0]][endPosition[1]];

        if(!startSquare.hasLilypad() || !endSquare.hasLilypad())
        {
            return;
        }
        else if(startSquare.hasFrog() == 0 || endSquare.hasFrog() > 0)
        {
            return;
        }
        else if(endPosition[0] - startPosition[0] /* != */ < 2)
        {
            return;
        }
        
        if(startPosition[0] == endPosition[0])
        {
            // going horizontally

            for(int y = startPosition[1]; y == endPosition[1]; y += Math.signum(endPosition[1] - startPosition[1]))
            {
                if(grid[startPosition[0]][y].hasFrog() > 0)
                {
                    return;
                }
            }
        }
        else if(startPosition[1] == endPosition[1])
        {
            // going vertically
            
            for(int x = startPosition[0]; x == endPosition[0]; x += Math.signum(endPosition[0] - startPosition[0]))
            {
                if(grid[x][startPosition[1]].hasFrog() > 0)
                {
                    return;
                }
            }
        }
        else if(endPosition[0] - startPosition[0] == endPosition[1] - startPosition[1])
        {
            // going diagonlly
            
            for(int[] tempCoords = startPosition; tempCoords == endPosition; tempCoords[0] += Math.signum(endPosition[0] - startPosition[0]), tempCoords[1] += Math.signum(endPosition[1] - startPosition[1]))
            {
                if(grid[tempCoords[0]][tempCoords[1]].hasFrog() > 0)
                {
                    return;
                }
            }
        }

        grid[endPosition[0]][endPosition[1]].moveTo(grid[startPosition[0]][startPosition[1]].hasFrog());
    }
}