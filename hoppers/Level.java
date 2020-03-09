import java.util.*;

public class Level
{
    private int[] redFrogCoords = new int[2];
    private int[][] greenFrogCoords;
    private List<int[]> greenFrogs = new ArrayList<int[]>();
    private int levelNum;

    Level(int levelNum)
    {
        this.levelNum = levelNum;
        createLevel();
    }

    private void createLevel()
    {
        if((this.levelNum < 1 || this.levelNum > 10) && this.levelNum != 22)
        {
            return;
        }

        switch(this.levelNum)
        {
            case 1:
                this.redFrogCoords[0] = 0;
                this.redFrogCoords[1] = 0;

                this.greenFrogCoords = new int[1][2];
                this.greenFrogCoords[0][0] = 1;
                this.greenFrogCoords[0][1] = 1;
                break;
            case 2:
                this.redFrogCoords[0] = 4;
                this.redFrogCoords[1] = 0;

                this.greenFrogCoords = new int[1][2];
                this.greenFrogCoords[0][0] = 4;
                this.greenFrogCoords[0][1] = 2;
                break;
            case 3:
                this.redFrogCoords[0] = 2;
                this.redFrogCoords[1] = 2;

                this.greenFrogCoords = new int[1][2];
                this.greenFrogCoords[0][0] = 3;
                this.greenFrogCoords[0][1] = 1;
                break;
            case 4:
                this.redFrogCoords[0] = 0;
                this.redFrogCoords[1] = 0;

                this.greenFrogCoords = new int[2][2];
                this.greenFrogCoords[0][0] = 1;
                this.greenFrogCoords[0][1] = 1;
                this.greenFrogCoords[1][0] = 3;
                this.greenFrogCoords[1][1] = 3;
                break;
            case 5:
                this.redFrogCoords[0] = 0;
                this.redFrogCoords[1] = 4;

                this.greenFrogCoords = new int[2][2];
                this.greenFrogCoords[0][0] = 0;
                this.greenFrogCoords[0][1] = 2;
                this.greenFrogCoords[1][0] = 2;
                this.greenFrogCoords[1][1] = 0;
                break;
            case 6:
                this.redFrogCoords[0] = 4;
                this.redFrogCoords[1] = 2;

                this.greenFrogCoords = new int[3][2];
                this.greenFrogCoords[0][0] = 1;
                this.greenFrogCoords[0][1] = 3;
                this.greenFrogCoords[1][0] = 2;
                this.greenFrogCoords[1][1] = 2;
                this.greenFrogCoords[2][0] = 4;
                this.greenFrogCoords[2][1] = 3;
                break;
            case 7:
                this.redFrogCoords[0] = 4;
                this.redFrogCoords[1] = 0;

                this.greenFrogCoords = new int[4][2];
                this.greenFrogCoords[0][0] = 0;
                this.greenFrogCoords[0][1] = 2;
                this.greenFrogCoords[1][0] = 2;
                this.greenFrogCoords[1][1] = 0;
                this.greenFrogCoords[2][0] = 2;
                this.greenFrogCoords[2][1] = 4;
                this.greenFrogCoords[3][0] = 4;
                this.greenFrogCoords[3][1] = 2;
                break;
            case 8:
                this.redFrogCoords[0] = 2;
                this.redFrogCoords[1] = 0;

                this.greenFrogCoords = new int[4][2];
                this.greenFrogCoords[0][0] = 1;
                this.greenFrogCoords[0][1] = 1;
                this.greenFrogCoords[1][0] = 1;
                this.greenFrogCoords[1][1] = 3;
                this.greenFrogCoords[2][0] = 3;
                this.greenFrogCoords[2][1] = 1;
                this.greenFrogCoords[3][0] = 3;
                this.greenFrogCoords[3][1] = 3;
                break;
            case 9:
                this.redFrogCoords[0] = 2;
                this.redFrogCoords[1] = 2;

                this.greenFrogCoords = new int[5][2];
                this.greenFrogCoords[0][0] = 1;
                this.greenFrogCoords[0][1] = 1;
                this.greenFrogCoords[1][0] = 2;
                this.greenFrogCoords[1][1] = 0;
                this.greenFrogCoords[2][0] = 3;
                this.greenFrogCoords[2][1] = 1;
                this.greenFrogCoords[3][0] = 3;
                this.greenFrogCoords[3][1] = 3;
                this.greenFrogCoords[4][0] = 4;
                this.greenFrogCoords[4][1] = 2;
                break;
            case 10:
                this.redFrogCoords[0] = 4;
                this.redFrogCoords[1] = 4;

                this.greenFrogCoords = new int[5][2];
                this.greenFrogCoords[0][0] = 0;
                this.greenFrogCoords[0][1] = 2;
                this.greenFrogCoords[1][0] = 1;
                this.greenFrogCoords[1][1] = 3;
                this.greenFrogCoords[2][0] = 2;
                this.greenFrogCoords[2][1] = 0;
                this.greenFrogCoords[3][0] = 3;
                this.greenFrogCoords[3][1] = 1;
                this.greenFrogCoords[4][0] = 3;
                this.greenFrogCoords[4][1] = 3;
                break;
            case 22:
                this.redFrogCoords[0] = 2;
                this.redFrogCoords[1] = 4;

                this.greenFrogCoords = new int[5][2];
                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 4;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 1;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 2;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 3;
                this.greenFrogs.get(3)[1] = 1;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 4;
                this.greenFrogs.get(4)[1] = 4;

                /*this.greenFrogCoords[0][0] = 0;
                this.greenFrogCoords[0][1] = 4;
                this.greenFrogCoords[1][0] = 1;
                this.greenFrogCoords[1][1] = 1;
                this.greenFrogCoords[2][0] = 2;
                this.greenFrogCoords[2][1] = 2;
                this.greenFrogCoords[3][0] = 3;
                this.greenFrogCoords[3][1] = 1;
                this.greenFrogCoords[4][0] = 4;
                this.greenFrogCoords[4][1] = 4;*/
        }
    }

    int[] getRedFrogCoords()
    {
        return redFrogCoords;
    }

    int[][] getGreenFrogCoords()
    {
        return greenFrogCoords;
    }

    List<int[]> getGreenFrogs()
    {
        return this.greenFrogs;
    }

    int getLevelNumber()
    {
        return this.levelNum;
    }
}