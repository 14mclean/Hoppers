import java.util.*;

public class Solver implements Runnable
{
    private int[] redFrogLocation;
    private List<int[]> greenFrogLocations;
    private int givenFrogIndex;
    private int[][] allMoves = {{0,-2},{2,-2},{2,0},{2,2},{0,2},{-2,2},{-2,0},{-2,-2},};

    /**
     * 
     * @param currentBoard
     * @param tree
     * @param givenFrogIndex if 1+greenFrogList == red frog
     */

    Solver(Board currentState, List<int[][]> list, int givenFrogIndex)
    {
        this.redFrogLocation = currentState.getRedFrogs();
        this.greenFrogLocations = currentState.getGreenFrogs();
        this.givenFrogIndex = givenFrogIndex;
    }

    public void run()
    {
        System.out.println("Thread: " + Thread.currentThread().getId());
    }

    private boolean movePossible(Square startSquare, Square endSquare, Board currentState)
    {
        int[] startCoords = startSquare.getCoordinates(), endCoords = endSquare.getCoordinates();

        if(startCoords[0] == endCoords[0]) // Vertical
        {
            Square centerSquare = currentState.getSquare(startCoords[0], startCoords[1] + (int) Math.signum(endCoords[1]-startCoords[1]));
            if(centerSquare.hasFrog() > 0 && centerSquare.getCoordinates()[0] == endCoords[0] && centerSquare.getCoordinates()[1] == endCoords[1]-1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(startCoords[1] == endCoords[1]) // Horizontal
        {
            Square centerSquare = currentState.getSquare(startCoords[0] + (int) Math.signum(endCoords[0]-startCoords[0]), startCoords[1]);
            if(centerSquare.hasFrog() > 0 && centerSquare.getCoordinates()[0] == endCoords[0]-1 && centerSquare.getCoordinates()[1] == endCoords[1])
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if( (endCoords[0]-startCoords[0]) == (endCoords[1]-startCoords[1]) ) // Diagonal
        {
            Square centerSquare = currentState.getSquare(startCoords[0] + (int) Math.signum(endCoords[0]-startCoords[0]), startCoords[1] + (int) Math.signum(endCoords[1]-startCoords[1]));
            if(centerSquare.hasFrog() > 0 && centerSquare.getCoordinates()[0] == endCoords[0]-1 && centerSquare.getCoordinates()[1] == endCoords[1]-1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    private void calcNode(Board boardState, List<int[][]> moveList)
    {
        // Calc possible move
    }
}