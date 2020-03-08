import java.util.List;
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
    private Level currentLevel;
    //private int[][] levels = new int[11][];

    Board()
    {
        win.add(panel);

        currentLevel = new Level(22);

        for(int[] tempCoords = {0,0}; tempCoords[1] < 5; tempCoords[1]++)
        {
            for(; tempCoords[0] < 5; tempCoords[0]++)
            {
                if( (currentLevel.getRedFrogCoords()[0] == tempCoords[0]) && (currentLevel.getRedFrogCoords()[1] == tempCoords[1]) ) 
                {
                    grid[tempCoords[0]][tempCoords[1]] = new Square(panel, tempCoords[0], tempCoords[1], 2);
                }
                else if(listContainsList(currentLevel.getGreenFrogs(), tempCoords))
                {
                    grid[tempCoords[0]][tempCoords[1]] = new Square(panel, tempCoords[0], tempCoords[1], 1);
                }
                else if(tempCoords[0]%2 != tempCoords[1]%2)
                {
                    grid[tempCoords[0]][tempCoords[1]] = new Square(panel, tempCoords[0], tempCoords[1], false);
                }
                else
                {
                    grid[tempCoords[0]][tempCoords[1]] = new Square(panel, tempCoords[0], tempCoords[1], true);
                }
            }
            tempCoords[0] = 0;
        }

        win.setSize(750, 750);
        win.setVisible(true);
    }

    private boolean listContainsList(List<int[]> list, int[] array)
    {
        for(int count = 0; count < list.size(); count++)
        {
            if( (list.get(count)[0] == array[0]) && (list.get(count)[1] == array[1]))
            {
                return true;
            }
        }
        return false;
    }

    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        Square pressedSquare = null;

        for(int x = 0; x < 5; x++)
        {
            for(int y = 0; y < 5; y++)
            {
                if(source == grid[x][y])
                {
                    pressedSquare = grid[x][y];
                    break;
                }
                else if(x*y == 16)
                {
                    return;
                } 
            }
        }

        if(pressedSquare.hasFrog() == 0)
        {
            return;
        }

        if(!pressed)
        {
           if(pressedSquare.hasFrog() == 1)
           {
            pressedSquare.changeIcon("GreenFrog2.png");
            pressed = true;
           }
           else
           {
            pressedSquare.changeIcon("RedFrog2.png");
            pressed = true;
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