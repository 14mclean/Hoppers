import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

class Board
{
    private Dictionary<int[], Square> grid = new Hashtable<ArrayList<Integer>, Square>();

    Board()
    {
        /*
        Green frog places-
        1,1
        3,1
        2,2
        0,4
        4,4
        Red frog - 2,4
        */

        int[] tempArray = {0,0};

        for(int row = 0; row < sqrt(grid.length); row++, tempArray[0]++)
        {
            for(int column = 0; column < sqrt(grid.length); column++, tempArray[1]++)
            {

                if(row == 4 && column == 2)
                {
                    grid.put(tempArray, new Square(row, column, 2));
                }
                else if(row + column == 4 || row == coulmn)
                {
                    grid.put(tempArray, new Square(row, column, true));
                }
                else
                {
                    grid.put(tempArray, new Square(row, column, false));
                }
            }
        }
    }

    /**
     * Method to move a frog from one square to another, following the rules
     * @param startPosition coordinates of square where the frog is
     * @param endPosition coordinates of square where you wish to move the frog too
     */

    void moveFromTo(int[] startPosition, int[] endPosition)
    {
        Square startSquare = grid.get(startPosition);
        Square endSquare = grid.get(endPosition);

        if(!startSquare.hasLilypad() || !endSquare.hasLilypad())
        {
            return;
        }
        else if(startSquare.hasFrog() == 0 || endSquare.hasFrog() > 0)
        {
            return;
        }
        
        if(startPosition[0] == endPosition[0])
        {
            // going horizontally
        }
        else if(startPosition[1] == endPosition[1])
        {
            // going vertically
        }
        else if(endPosition[0] - startPosition[0] == endPosition[1] - startPosition[1])
        {
            // going diagonlly
        }
    }
}