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
    private Square startSquare;

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
                    grid[tempCoords[0]][tempCoords[1]] = new Square(panel, tempCoords[0], tempCoords[1], 2, this);
                }
                else if(listContainsList(currentLevel.getGreenFrogs(), tempCoords))
                {
                    grid[tempCoords[0]][tempCoords[1]] = new Square(panel, tempCoords[0], tempCoords[1], 1, this);
                }
                else if(tempCoords[0]%2 != tempCoords[1]%2)
                {
                    grid[tempCoords[0]][tempCoords[1]] = new Square(panel, tempCoords[0], tempCoords[1], false, this);
                }
                else
                {
                    grid[tempCoords[0]][tempCoords[1]] = new Square(panel, tempCoords[0], tempCoords[1], true, this);
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

        xLoop: for(int x = 0; x < 5; x++)
        {
            for(int y = 0; y < 5; y++)
            {
                if(source.hashCode() == grid[x][y].getButtonHash())
                {
                    pressedSquare = grid[x][y];
                    break xLoop;
                }
                else if(x == 4 && y == 4)
                {
                    return;
                } 
            }
        }

        if(!pressed)
        {
           if(pressedSquare.hasFrog() == 1)
           {
            startPosition = pressedSquare.getCoordinates();
            pressedSquare.switchIcon();
            pressed = true;
           }
           else
           {
            startPosition = pressedSquare.getCoordinates();
            pressedSquare.switchIcon();
            pressed = true;
           }
           return;
        }

        Square endSquare = pressedSquare;
        endPosition = endSquare.getCoordinates();
        pressedSquare = null;

        if(endSquare.hasFrog() > 0)
        {
            return;
        }

        if(startPosition[0] == endPosition[0] && startPosition[1] == endPosition[1])
        {
            pressed = false;
            endSquare.switchIcon();
            return;
        }

        else if(startPosition[0] == endPosition[0])
        {
            if(Math.abs(endPosition[1]-startPosition[1]) == 4)
            {
                if(grid[startPosition[0]][startPosition[1] + (int) Math.signum(endPosition[1]-startPosition[1])*2].hasFrog() > 0)
                {
                    moveFrog(grid[startPosition[0] + (int) Math.signum(endPosition[0]-startPosition[0])][startPosition[1]], endSquare);
                }
            }
        }
        else if(startPosition[1] == endPosition[1])
        {
            if(Math.abs(endPosition[0]-startPosition[0]) == 4)
            {
                if(grid[startPosition[0] + (int) Math.signum(endPosition[0]-startPosition[0])][startPosition[1]*2].hasFrog() > 0)
                {
                    moveFrog(grid[startPosition[0] + (int) Math.signum(endPosition[0]-startPosition[0])][startPosition[1]], endSquare);
                }
            }
        }
        else if( Math.abs(endPosition[0]-startPosition[0]) == 2 && Math.abs(endPosition[1]-startPosition[1]) == 2)
        {
            System.out.println("Going Diagonally");
        }
    }

    private void moveFrog(Square takenSquare, Square endSquare)
    {
        takenSquare.taken();
        startSquare.moveTo(endSquare);
        pressed = false;
    }
}