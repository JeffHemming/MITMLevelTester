import java.util.Random;

/**
 * Created by Dad on 10/30/2015.
 */
public class levelGenerator {
    int MAXSIZE= 8;
    Random randomGenerator = new Random();
    int size=randomGenerator.nextInt(MAXSIZE)+4;
    int startrow=randomGenerator.nextInt(size);
    int startcol=randomGenerator.nextInt(size);
    int endrow=startcol;
    int endcol=startrow;
    int [][] maze=new int[size][size];

    void printLevel(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }

    levelGenerator(){
        int startrow=randomGenerator.nextInt(size);
        int startcol=randomGenerator.nextInt(size);
        endrow=startcol;
        endcol=startrow;
        while(startrow==endrow&&startcol==endcol){
            endrow=randomGenerator.nextInt(size);
            endcol=randomGenerator.nextInt(size);
        }
        maze[startrow][startcol]=-1;
        maze[endrow][endcol]=-5;
        for(int r=0;r<size;r++){
            for(int c=0;c<size;c++){
                if(maze[r][c]!=-1&&maze[r][c]!=-5){
                    int n=randomGenerator.nextInt(100);
                    if(n<50)maze[r][c]=0;
                    else if(n<80)maze[r][c]=1;
                    else{
                        int m=randomGenerator.nextInt(18);
                        switch(m){
                            case 0:maze[r][c]=11;
                                break;
                            case 1:maze[r][c]=12;
                                break;
                            case 2:maze[r][c]=13;
                                break;
                            case 3:maze[r][c]=14;
                                break;
                            case 4:maze[r][c]=21;
                                break;
                            case 5:maze[r][c]=22;
                                break;
                            case 6:maze[r][c]=23;
                                break;
                            case 7:maze[r][c]=24;
                                break;
                            case 8:maze[r][c]=31;
                                break;
                            case 9:maze[r][c]=32;
                                break;
                            case 10:maze[r][c]=33;
                                break;
                            case 11:maze[r][c]=34;
                                break;
                            case 12:maze[r][c]=41;
                                break;
                            case 13:maze[r][c]=42;
                                break;
                            case 14:maze[r][c]=43;
                                break;
                            case 15:maze[r][c]=44;
                                break;
                            case 16:maze[r][c]=-90;
                                break;
                            case 17:maze[r][c]=-91;
                                break;
                            default:maze[r][c]=0;
                                break;
                        }
                    }
                }
            }
        }
    }
}
