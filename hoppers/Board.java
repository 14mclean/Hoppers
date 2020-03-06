import javax.swing.*;
import java.awt.*;

public class Board
{
    private Square[][] grid = new Square[5][5];
    private JFrame win = new JFrame("Hoppers");
    private JPanel panel = new JPanel(new GridLayout(5,5));

    Board()
    {
        win.add(panel);
        /*
        Green frog places-
        1,1
        3,1
        2,2
        0,4
        4,4
        Red frog - 2,4
        */

        for(int row = 0; row < 5; row++)
        {
            for(int column = 0; column < 5; column++)
            {
                if(row%2 != column%2)
                {
                    grid[row][column] = new Square(panel, row, column, false);
                }
                else if(row == 0 || row == 3 || (row == 2 && column == 0 || column == 4))
                {
                    grid[row][column] = new Square(panel, row, column, true);
                }
                else if(row == 4 && column == 2)
                {
                    grid[row][column] = new Square(panel, row, column, 2);
                }
                else
                {
                    grid[row][column] = new Square(panel, row, column, 1);
                }
            }
        }

        win.setSize(750, 750);
        win.setVisible(true);
    }

    void moveFromTo(int[] startPosition, int[] endPosition)
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