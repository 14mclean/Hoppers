public class Solver implements Runnable
{
    private Board beginingState;
    Solver(Board currentBoard)
    {
        this.beginingState = currentBoard;
    }

    @Override
    public void run()
    {
        if(makeNode(beginingState))
        {
            System.out.println("Solved");
        }
        else
        {
            System.out.println("No Solution");
        }
    }

    private Square getTakenSquare(Board board, int[] startCoords, int[] endCoords)
    {      
        if(startCoords[0] == endCoords[0]) // Vertical
        {
            return board.getSquare(startCoords[0], startCoords[1]+2);
        }
        else if(startCoords[1] == endCoords[1]) // Horizontal
        {
            return board.getSquare(startCoords[0]+2, startCoords[1]);
        }
        else // Diagonal
        {
            return board.getSquare(startCoords[0]+1, startCoords[1]+1);
        }
    }

    private boolean movePossible(Square startSquare, Square endSquare, Board currentState)
    {
        int[] startPosition = startSquare.getCoordinates(), endPosition = endSquare.getCoordinates();

        if(endSquare.hasFrog() > 0)
        {
            return false;
        }

        else if(startPosition[0] == endPosition[0])
        {
            if(Math.abs(endPosition[1]-startPosition[1]) == 4)
            {
                if(currentState.getSquare(startPosition[0], startPosition[1] + (int) Math.signum(endPosition[1]-startPosition[1])).hasFrog() > 0)
                {
                    return true;
                }
            }
        }
        else if(startPosition[1] == endPosition[1])
        {
            if(Math.abs(endPosition[0]-startPosition[0]) == 4)
            {
                if(currentState.getSquare(startPosition[0] + (int) Math.signum(endPosition[0]-startPosition[0]), startPosition[1]).hasFrog() > 0)
                {
                    return true;
                }
            }
        }
        else if(Math.abs(endPosition[0]-startPosition[0]) == Math.abs(endPosition[1]-startPosition[1]))
        {
            if(Math.abs(endPosition[0]-startPosition[0]) == 2 && Math.abs(endPosition[1]-startPosition[1]) == 2)
            {
                if(currentState.getSquare(startPosition[0] + (int) Math.signum(endPosition[0]-startPosition[0]), startPosition[1] + (int) Math.signum(endPosition[1]-startPosition[1])).hasFrog() > 0)
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean makeNode(Board gameState)
    {
        for(int count = 0; count < gameState.getFrogNum(); count++)
        {
            for(int[] coords = {0,0}; coords[0] < 5; coords[0]++)
            {
                for(; coords[1] < 5; coords[1]++)
                {
                    if(movePossible(gameState.getSquare(gameState.getFrogCoords().get(count)), gameState.getSquare(coords), gameState))
                    {
                        gameState.moveFrog(gameState.getSquare(gameState.getFrogCoords().get(count)), this.getTakenSquare(gameState, gameState.getFrogCoords().get(count), coords), gameState.getSquare(coords));

                        if(gameState.getFrogNum() == 0 || gameState.hasWon())
                        {
                            return gameState.hasWon();
                        }
                        else
                        {
                            return makeNode(gameState);
                        }
                    }
                }
            }
        }

        return false;
    }
}