import java.util.*;

public class Solver implements Runnable
{
    private int[] redFrogLocation;
    private List<int[]> greenFrogLocations;
    private int givenFrogIndex;

    /**
     * 
     * @param currentBoard
     * @param tree
     * @param givenFrogIndex if 1+greenFrogList == red frog
     */

    Solver(Level currentLevel, List<int[][]> list, int givenFrogIndex)
    {
        this.redFrogLocation = currentLevel.getRedFrogCoords();
        this.greenFrogLocations = currentLevel.getGreenFrogs();
        this.givenFrogIndex = givenFrogIndex;
    }

    public void run()
    {
        System.out.println("Thread: " + Thread.currentThread().getId());
    }

    private void calcNode(Board boardState, List<int[][]> moveList)
    {}
}