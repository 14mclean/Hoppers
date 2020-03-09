import java.util.*;

public class Level
{
    private int[] redFrogCoords = new int[2];
    private List<int[]> greenFrogs = new ArrayList<int[]>();
    private int levelNum;

    Level(int levelNum)
    {
        this.levelNum = levelNum;
        createLevel();
    }

    private void createLevel()
    {
        if(this.levelNum < 1 || this.levelNum > 40)
        {
            return;
        }

        switch(this.levelNum)
        {
            case 1:
                this.redFrogCoords[0] = 0;
                this.redFrogCoords[1] = 0;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 1;
                this.greenFrogs.get(0)[1] = 1;
                break;
            case 2:
                this.redFrogCoords[0] = 4;
                this.redFrogCoords[1] = 0;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 4;
                this.greenFrogs.get(0)[1] = 2;
                break;
            case 3:
                this.redFrogCoords[0] = 2;
                this.redFrogCoords[1] = 2;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 3;
                this.greenFrogs.get(0)[1] = 1;
                break;
            case 4:
                this.redFrogCoords[0] = 0;
                this.redFrogCoords[1] = 0;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 1;
                this.greenFrogs.get(0)[1] = 1;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 3;
                this.greenFrogs.get(1)[1] = 3;
                break;
            case 5:
                this.redFrogCoords[0] = 0;
                this.redFrogCoords[1] = 4;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 2;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 2;
                this.greenFrogs.get(1)[1] = 0;
                break;
            case 6:
                this.redFrogCoords[0] = 4;
                this.redFrogCoords[1] = 2;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 1;
                this.greenFrogs.get(0)[1] = 3;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 2;
                this.greenFrogs.get(1)[1] = 2;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 3;
                this.greenFrogs.get(2)[1] = 3;
                break;
            case 7:
                this.redFrogCoords[0] = 4;
                this.redFrogCoords[1] = 0;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 2;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 2;
                this.greenFrogs.get(1)[1] = 0;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 4;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 4;
                this.greenFrogs.get(3)[1] = 2;
                break;
            case 8:
                this.redFrogCoords[0] = 2;
                this.redFrogCoords[1] = 0;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 1;
                this.greenFrogs.get(0)[1] = 1;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 3;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 3;
                this.greenFrogs.get(2)[1] = 1;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 3;
                this.greenFrogs.get(3)[1] = 3;
                break;
            case 9:
                this.redFrogCoords[0] = 2;
                this.redFrogCoords[1] = 2;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 1;
                this.greenFrogs.get(0)[1] = 1;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 2;
                this.greenFrogs.get(1)[1] = 0;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 3;
                this.greenFrogs.get(2)[1] = 1;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 3;
                this.greenFrogs.get(3)[1] = 3;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 4;
                this.greenFrogs.get(4)[1] = 2;
                break;
            case 10:
                this.redFrogCoords[0] = 4;
                this.redFrogCoords[1] = 4;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 2;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 3;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 0;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 3;
                this.greenFrogs.get(3)[1] = 1;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 3;
                this.greenFrogs.get(4)[1] = 3;
                break;
            case 11:
                this.redFrogCoords[0] = 0;
                this.redFrogCoords[1] = 0;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 2;
                this.greenFrogs.get(0)[1] = 2;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 3;
                this.greenFrogs.get(1)[1] = 3;
                break;
            case 12:
                this.redFrogCoords[0] = 0;
                this.redFrogCoords[1] = 4;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 2;
                this.greenFrogs.get(0)[1] = 2;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 4;
                this.greenFrogs.get(1)[1] = 2;
                break;
            case 13:
                this.redFrogCoords[0] = 4;
                this.redFrogCoords[1] = 0;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 1;
                this.greenFrogs.get(0)[1] = 1;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 3;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 4;
                break;
            case 14:
                this.redFrogCoords[0] = 2;
                this.redFrogCoords[1] = 4;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 2;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 3;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 0;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 4;
                this.greenFrogs.get(3)[1] = 2;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 4;
                this.greenFrogs.get(4)[1] = 4;
                break;
            case 15:
                this.redFrogCoords[0] = 1;
                this.redFrogCoords[1] = 3;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 0;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 2;
                this.greenFrogs.get(1)[1] = 0;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 3;
                this.greenFrogs.get(2)[1] = 3;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 4;
                this.greenFrogs.get(3)[1] = 2;
                break;
            case 16:
                this.redFrogCoords[0] = 4;
                this.redFrogCoords[1] = 0;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 3;
                this.greenFrogs.get(0)[1] = 1;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 4;
                this.greenFrogs.get(1)[1] = 2;
                break;
            case 17:
                this.redFrogCoords[0] = 2;
                this.redFrogCoords[1] = 0;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 1;
                this.greenFrogs.get(0)[1] = 3;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 2;
                this.greenFrogs.get(1)[1] = 2;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 4;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 3;
                this.greenFrogs.get(3)[1] = 3;
                break;
            case 18:
                this.redFrogCoords[0] = 2;
                this.redFrogCoords[1] = 4;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 2;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 3;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 0;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 2;
                this.greenFrogs.get(3)[1] = 2;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 3;
                this.greenFrogs.get(4)[1] = 3;
                this.greenFrogs.add(5, new int[2]);
                this.greenFrogs.get(5)[0] = 4;
                this.greenFrogs.get(5)[1] = 2;
                break;
            case 19:
                this.redFrogCoords[0] = 0;
                this.redFrogCoords[1] = 2;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 0;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 3;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 0;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 2;
                this.greenFrogs.get(3)[1] = 4;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 3;
                this.greenFrogs.get(4)[1] = 1;
                this.greenFrogs.add(5, new int[2]);
                this.greenFrogs.get(5)[0] = 3;
                this.greenFrogs.get(5)[1] = 3;
                break;
            case 20:
                this.redFrogCoords[0] = 1;
                this.redFrogCoords[1] = 3;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 1;
                this.greenFrogs.get(0)[1] = 1;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 2;
                this.greenFrogs.get(1)[1] = 0;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 3;
                this.greenFrogs.get(2)[1] = 1;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 3;
                this.greenFrogs.get(3)[1] = 3;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 4;
                this.greenFrogs.get(4)[1] = 0;
                this.greenFrogs.add(5, new int[2]);
                this.greenFrogs.get(5)[0] = 4;
                this.greenFrogs.get(5)[1] = 2;
                break;
            case 21:
                this.redFrogCoords[0] = 3;
                this.redFrogCoords[1] = 1;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 0;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 1;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 2;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 3;
                this.greenFrogs.get(3)[1] = 3;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 4;
                this.greenFrogs.get(4)[1] = 4;
                break;
            case 22:
                this.redFrogCoords[0] = 2;
                this.redFrogCoords[1] = 4;

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
            case 23:
                this.redFrogCoords[0] = 4;
                this.redFrogCoords[1] = 4;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 4;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 1;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 1;
                this.greenFrogs.get(2)[1] = 3;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 2;
                this.greenFrogs.get(3)[1] = 2;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 3;
                this.greenFrogs.get(4)[1] = 1;
                this.greenFrogs.add(5, new int[2]);
                this.greenFrogs.get(5)[0] = 4;
                this.greenFrogs.get(5)[1] = 0;
                break;
            case 24:
                this.redFrogCoords[0] = 4;
                this.redFrogCoords[1] = 0;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 2;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 1;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 1;
                this.greenFrogs.get(2)[1] = 3;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 2;
                this.greenFrogs.get(3)[1] = 0;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 2;
                this.greenFrogs.get(4)[1] = 2;
                this.greenFrogs.add(5, new int[2]);
                this.greenFrogs.get(5)[0] = 3;
                this.greenFrogs.get(5)[1] = 1;
                break;
            case 25:
                this.redFrogCoords[0] = 2;
                this.redFrogCoords[1] = 2;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 4;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 1;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 1;
                this.greenFrogs.get(2)[1] = 3;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 2;
                this.greenFrogs.get(3)[1] = 1;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 4;
                this.greenFrogs.get(4)[1] = 2;
                break;
            case 26:
                this.redFrogCoords[0] = 0;
                this.redFrogCoords[1] = 0;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 2;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 1;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 0;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 2;
                this.greenFrogs.get(3)[1] = 2;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 3;
                this.greenFrogs.get(4)[1] = 3;
                break;
            case 27:
                this.redFrogCoords[0] = 0;
                this.redFrogCoords[1] = 4;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 2;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 0;
                this.greenFrogs.get(1)[1] = 4;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 1;
                this.greenFrogs.get(2)[1] = 3;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 2;
                this.greenFrogs.get(3)[1] = 4;
                break;
            case 28:
                this.redFrogCoords[0] = 4;
                this.redFrogCoords[1] = 2;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 2;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 0;
                this.greenFrogs.get(1)[1] = 4;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 1;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 3;
                this.greenFrogs.get(3)[1] = 1;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 4;
                this.greenFrogs.get(4)[1] = 2;
                this.greenFrogs.add(5, new int[2]);
                this.greenFrogs.get(5)[0] = 4;
                this.greenFrogs.get(5)[1] = 4;
                break;
            case 29:
                this.redFrogCoords[0] = 4;
                this.redFrogCoords[1] = 0;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 4;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 3;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 2;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 3;
                this.greenFrogs.get(3)[1] = 3;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 4;
                this.greenFrogs.get(4)[1] = 4;
                break;
            case 30:
                this.redFrogCoords[0] = 2;
                this.redFrogCoords[1] = 0;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 0;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 0;
                this.greenFrogs.get(1)[1] = 2;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 1;
                this.greenFrogs.get(2)[1] = 1;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 1;
                this.greenFrogs.get(3)[1] = 3;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 2;
                this.greenFrogs.get(4)[1] = 0;
                this.greenFrogs.add(5, new int[2]);
                this.greenFrogs.get(5)[0] = 3;
                this.greenFrogs.get(5)[1] = 1;
                break;
            case 31:
                this.redFrogCoords[0] = 2;
                this.redFrogCoords[1] = 2;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 1;
                this.greenFrogs.get(0)[1] = 1;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 2;
                this.greenFrogs.get(1)[1] = 0;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 2;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 3;
                this.greenFrogs.get(3)[1] = 3;
                break;
            case 32:
                this.redFrogCoords[0] = 4;
                this.redFrogCoords[1] = 4;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 2;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 1;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 1;
                this.greenFrogs.get(2)[1] = 3;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 2;
                this.greenFrogs.get(3)[1] = 2;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 2;
                this.greenFrogs.get(4)[1] = 4;
                this.greenFrogs.add(5, new int[2]);
                this.greenFrogs.get(5)[0] = 3;
                this.greenFrogs.get(5)[1] = 3;
                break;
            case 33:
                this.redFrogCoords[0] = 0;
                this.redFrogCoords[1] = 0;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 2;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 3;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 4;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 3;
                this.greenFrogs.get(3)[1] = 3;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 4;
                this.greenFrogs.get(4)[1] = 2;
                break;
            case 34:
                this.redFrogCoords[0] = 0;
                this.redFrogCoords[1] = 4;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 4;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 3;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 0;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 2;
                this.greenFrogs.get(3)[1] = 4;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 3;
                this.greenFrogs.get(4)[1] = 3;
                break;
            case 35:
                this.redFrogCoords[0] = 4;
                this.redFrogCoords[1] = 0;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 0;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 1;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 1;
                this.greenFrogs.get(2)[1] = 3;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 3;
                this.greenFrogs.get(3)[1] = 1;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 3;
                this.greenFrogs.get(4)[1] = 3;
                this.greenFrogs.add(5, new int[2]);
                this.greenFrogs.get(5)[0] = 4;
                this.greenFrogs.get(5)[1] = 0;
                
                break;
            case 36:
                this.redFrogCoords[0] = 2;
                this.redFrogCoords[1] = 4;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 4;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 1;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 1;
                this.greenFrogs.get(2)[1] = 3;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 2;
                this.greenFrogs.get(3)[1] = 0;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 3;
                this.greenFrogs.get(4)[1] = 1;
                this.greenFrogs.add(5, new int[2]);
                this.greenFrogs.get(5)[0] = 3;
                this.greenFrogs.get(5)[1] = 3;
                break;
            case 37:
                this.redFrogCoords[0] = 1;
                this.redFrogCoords[1] = 3;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 2;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 1;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 2;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 2;
                this.greenFrogs.get(3)[1] = 4;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 3;
                this.greenFrogs.get(4)[1] = 3;
                break;
            case 38:
                this.redFrogCoords[0] = 4;
                this.redFrogCoords[1] = 0;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 0;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 3;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 0;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 2;
                this.greenFrogs.get(3)[1] = 4;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 3;
                this.greenFrogs.get(4)[1] = 1;
                break;
            case 39:
                this.redFrogCoords[0] = 2;
                this.redFrogCoords[1] = 0;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 2;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 3;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 2;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 2;
                this.greenFrogs.get(3)[1] = 4;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 3;
                this.greenFrogs.get(4)[1] = 1;
                this.greenFrogs.add(5, new int[2]);
                this.greenFrogs.get(5)[0] = 4;
                this.greenFrogs.get(5)[1] = 0;
                break;
            case 40:
                this.redFrogCoords[0] = 2;
                this.redFrogCoords[1] = 4;

                this.greenFrogs.add(0, new int[2]);
                this.greenFrogs.get(0)[0] = 0;
                this.greenFrogs.get(0)[1] = 2;
                this.greenFrogs.add(1, new int[2]);
                this.greenFrogs.get(1)[0] = 1;
                this.greenFrogs.get(1)[1] = 1;
                this.greenFrogs.add(2, new int[2]);
                this.greenFrogs.get(2)[0] = 2;
                this.greenFrogs.get(2)[1] = 2;
                this.greenFrogs.add(3, new int[2]);
                this.greenFrogs.get(3)[0] = 2;
                this.greenFrogs.get(3)[1] = 4;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 3;
                this.greenFrogs.get(4)[1] = 3;
                this.greenFrogs.add(4, new int[2]);
                this.greenFrogs.get(4)[0] = 4;
                this.greenFrogs.get(4)[1] = 0;
                break;
        }
    }

    int[] getRedFrogCoords()
    {
        return redFrogCoords;
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