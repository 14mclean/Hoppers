public class Solver implements Runnable
{
    private Board beginningState;
    private int frogIndex;
    private Square startSquare;

    Solver(Board gameState, int frogIndex)
    {
        this.beginningState = gameState;
        this.frogIndex = frogIndex;
        this.startSquare = beginningState.getSquare(beginningState.getFrogCoords().get(frogIndex));
    }

    public void run()
    {
        System.out.println("Thread " + (frogIndex+1) + " has started");

        for(int[] coords = {0,0}; coords[0] < 5; coords[0]++)
        {
            for(;coords[1] < 5; coords[1]++)
            {
                if(movePossible(this.startSquare, beginningState.getSquare(coords[0], coords[1]), beginningState))
                {
                    beginningState.moveFrog(this.startSquare, getTakenSquare(beginningState, this.startSquare.getCoordinates(), coords), beginningState.getSquare(coords));
                    
                    if(makeNode(beginningState))
                    {
                        System.out.println("Found Solution");
                    }
                }
            }
        }

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

    private Square getTakenSquare(Board board, int[] startCoords, int[] endCoords)
    {      
        if(startCoords[0] == endCoords[0]) // Vertical
        {
            return board.getSquare(startCoords[0], startCoords[1]);
        }
        else if(startCoords[1] == endCoords[1]) // Horizontal
        {
            return board.getSquare(startCoords[0]+1, startCoords[1]);
        }
        else // Diagonal
        {
            return board.getSquare(startCoords[0]+1, startCoords[1]+1);
        }
    }

    private boolean makeNode(Board gameState)
    {
        if(gameState.hasWon())
        {
            return true;
        }

        for(int count = 0; count < gameState.getFrogNum(); count++)
        {
            for(int x = 0; x < 5; x++)
            {
                for(int y = 0; y < 5; y++)
                {
                    if(movePossible(gameState.getSquare(gameState.getFrogCoords().get(count)), gameState.getSquare(x, y), gameState))
                    {
                        int[] tempCoords = {x,y};
                        gameState.moveFrog(getTakenSquare(gameState, gameState.getFrogCoords().get(count), tempCoords), gameState.getSquare(x, y));
                        return makeNode(gameState);
                    }
                }
            }
        }
        return false;
    }
}