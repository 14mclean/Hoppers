import java.util.*;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Creates a game window of a level and controls all game mechanics
 * 
 * @author Mark McLean
 * @version 1.0
 */
public class Board implements ActionListener
{
    private Square[][] grid = new Square[5][5];
    private JFrame win = new JFrame("Hoppers");
    private JPanel gamePanel = new JPanel(new GridLayout(5,5));
    private boolean pressed = false;
    private int[] startPosition = new int[2], endPosition = new int[2];
    private Level currentLevel;
    private Square startSquare;
    private LevelWin masterWin;

    /**
     * Creates the game board with the correct level layout
     * 
     * @param levelNum The level which the user is on
     */
    Board(int levelNum, LevelWin masterWin)
    {
        this.masterWin = masterWin;
        currentLevel = new Level(levelNum);

        for(int[] tempCoords = {0,0}; tempCoords[1] < 5; tempCoords[1]++)
        {
            for(; tempCoords[0] < 5; tempCoords[0]++)
            {
                if( (currentLevel.getRedFrogCoords()[0] == tempCoords[0]) && (currentLevel.getRedFrogCoords()[1] == tempCoords[1]) ) 
                {
                    grid[tempCoords[0]][tempCoords[1]] = new Square(gamePanel, tempCoords[0], tempCoords[1], 2, this);
                }
                else if(listContainsList(currentLevel.getGreenFrogs(), tempCoords))
                {
                    grid[tempCoords[0]][tempCoords[1]] = new Square(gamePanel, tempCoords[0], tempCoords[1], 1, this);
                }
                else if(tempCoords[0]%2 != tempCoords[1]%2)
                {
                    grid[tempCoords[0]][tempCoords[1]] = new Square(gamePanel, tempCoords[0], tempCoords[1], false, this);
                }
                else
                {
                    grid[tempCoords[0]][tempCoords[1]] = new Square(gamePanel, tempCoords[0], tempCoords[1], true, this);
                }
            }
            tempCoords[0] = 0;
        }
        
        win.add(gamePanel, BorderLayout.CENTER);
        win.setSize(750, 750);
        win.setVisible(true);
    }

    /**
     * Checks if a list of int arrays contains a specific int array
     * 
     * @param list The list which you are searching
     * @param array The searchee array
     * @return Boolean: true- found, false- not found
     */
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

    /**
     * Closes current game board
     */
    void close()
    {
        win.setVisible(false);
        win.dispose();
    }

    /**
     * Called when one of the sqaures is clicked and checks which one it was.
     * Ensures all moves follows the rules
     * 
     * @param e The ActionEvent that is made when a button is pressed
     */
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
           if(pressedSquare.hasFrog() > 0)
           {
            startPosition = pressedSquare.getCoordinates();
            startSquare = pressedSquare;
            pressedSquare.switchIcon();
            pressed = true;
           }
           return;
        }

        Square endSquare = pressedSquare;
        endPosition = endSquare.getCoordinates();
        pressedSquare = null;

        if(startSquare.getCoordinates()[0] == endSquare.getCoordinates()[0] && startSquare.getCoordinates()[1] == endSquare.getCoordinates()[1])
        {
            pressed = false;
            startSquare.switchIcon();
            return;
        }

        if(endSquare.hasFrog() > 0)
        {
            return;
        }

        else if(startPosition[0] == endPosition[0])
        {
            if(Math.abs(endPosition[1]-startPosition[1]) == 4)
            {
                if(grid[startPosition[0]][startPosition[1] + (endPosition[1] - startPosition[1])/2].hasFrog() > 0)
                {
                    moveFrog(grid[startPosition[0]][startPosition[1] + (int) Math.signum(endPosition[1]-startPosition[1])*2], endSquare);
                    checkWinner();
                }
            }
        }
        else if(startPosition[1] == endPosition[1])
        {
            if(Math.abs(endPosition[0]-startPosition[0]) == 4)
            {
                if(grid[startPosition[0] + (endPosition[0] - startPosition[0])/2][startPosition[1]].hasFrog() > 0)
                {
                    moveFrog(grid[startPosition[0] + (int) Math.signum(endPosition[0]-startPosition[0])*2][startPosition[1]], endSquare);
                    checkWinner();
                }
            }
        }
        else if(Math.abs(endPosition[0]-startPosition[0]) == Math.abs(endPosition[1]-startPosition[1]))
        {
            if(Math.abs(endPosition[0]-startPosition[0]) == 2 && Math.abs(endPosition[1]-startPosition[1]) == 2)
            {
                if(grid[startPosition[0] + (int) Math.signum(endPosition[0]-startPosition[0])][startPosition[1] + (int) Math.signum(endPosition[1]-startPosition[1])].hasFrog() > 0)
                {
                    moveFrog(grid[startPosition[0] + (int) Math.signum(endPosition[0]-startPosition[0])][startPosition[1] + (int) Math.signum(endPosition[1]-startPosition[1])], endSquare);
                    checkWinner();
                }
            }
        }
    }

    /**
     * Implementation for moving and taking of frogs
     * 
     * @param takenSquare The square on which the taken frog resides
     * @param endSquare The square where the moving frog will end up
     */
    void moveFrog(Square takenSquare, Square endSquare)
    {
        startSquare.moveTo(endSquare);
        takenSquare.taken();
        pressed = false;
    }

    public void moveFrog(Square startSquare, Square takenSquare, Square endSquare)
    {
        startSquare.moveTo(endSquare);
        takenSquare.taken();
    }

    /**
     * Checks if the player has taken all of the green frogs and stil has the red frog remaining
     */
    private void checkWinner()
    {
        int greenFrogs = 0;
        boolean redFrog = false;
        for(int x = 0; x < 5; x++)
        {
            for(int y = 0; y < 5; y++)
            {
                if(grid[x][y].hasFrog() == 1)
                {
                    greenFrogs++;
                }
                else if(grid[x][y].hasFrog() == 2)
                {
                    redFrog = true;
                }
            }
        }

        if(greenFrogs > 0 || !redFrog)
        {
            return;
        }

        masterWin.addWin(this.currentLevel.getLevelNumber());
        JOptionPane.showMessageDialog(win, "Winner!", "Result", JOptionPane.INFORMATION_MESSAGE);
        masterWin.levelWon();
    }

    public List<int[]> getGreenFrogs()
    {
        List<int[]> temp = new ArrayList<int[]>();

        for(int x = 0, place = 0; x < 5; x++)
        {
            for(int y = 0; y < 5; y++)
            {
                if(grid[x][y].hasFrog() == 1)
                {
                    temp.add(new int[2]);
                    temp.get(place)[0] = x;
                    temp.get(place)[1] = y;
                    place++;
                }
            }
        }
        return temp;
    }

    public int[] getRedFrog()
    {
        int[] temp = new int[2];

        for(int x = 0; x < 5; x++)
        {
            for(int y = 0; y < 5; y++)
            {
                if(grid[x][y].hasFrog() == 2)
                {
                    temp[0] = x;
                    temp[1] = y;
                    return temp;
                }
            }
        }
        return temp;
    }

    public Square getSquare(int x, int y)
    {
        return grid[x][y];
    }

    public Square getSquare(int[] coords)
    {
        return grid[coords[0]][coords[1]];
    }

    public int getFrogNum()
    {
        int temp = 0;

        for(int x = 0; x < 5; x++)
        {
            for(int y = 0; y < 5; y++)
            {
                if(grid[x][y].hasFrog() > 0)
                {
                    temp++;
                }
            }
        }
        return temp;
    }

    public List<int[]> getFrogCoords()
    {
        List<int[]> temp = new ArrayList<int[]>();

        for(int x = 0, place = 0; x < 5; x++)
        {
            for(int y = 0; y < 5; y++)
            {
                if(grid[x][y].hasFrog() > 0)
                {
                    temp.add(new int[2]);
                    temp.get(place)[0] = x;
                    temp.get(place)[1] = y;
                    place++;
                }
            }
        }
        return temp;  
    }

    public boolean hasWon()
    {
        if(this.getGreenFrogs().size() == 0)
        {
            for(int x = 0; x < 5; x++)
            {
                for(int y = 0; y < 5; y++)
                {
                    if(this.getSquare(x, y).hasFrog() == 2)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}