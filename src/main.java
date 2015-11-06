import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dad on 10/30/2015.
 */
public class main {
    public static void main(String[] args) throws IOException {
    int RANDOMIZER=0;

         if(RANDOMIZER==0) {
             boolean running=true;
             while(running) {
                 BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                 int size = Integer.parseInt(input.readLine());
                 int[][] maze = new int[size][size];
                 int mycol = 0;
                 int myrow = 0;
                 for (int row = 0; row < size; row++) {
                     String[] line = input.readLine().split(" ");
                     for (int col = 0; col < size; col++) {
                         maze[row][col] = Integer.parseInt(line[col]);
                         if (maze[row][col] == -1) {
                             mycol = col;
                             myrow = row;
                         }
                     }
                 }
                 boolean[][] visited = new boolean[size][size];
                 for (int i = 0; i < size; i++) {
                     for (int j = 0; j < size; j++) {
                         visited[i][j] = false;
                     }
                 }
                 System.out.println(search(size, maze, myrow, mycol, 0, visited));
                 System.out.println();
                 System.out.println("Continue? (y/n)");
                 char in= (char) input.read();
                 running=(in!='n');
             }
         }
        if(RANDOMIZER==1) {
            int count = 0;

            for (int awesome = 0; awesome < 1000; awesome++) {

                levelGenerator l = new levelGenerator();
                boolean[][] visited = new boolean[l.size][l.size];
                for (int i = 0; i < l.size; i++) {
                    for (int j = 0; j < l.size; j++) {
                        visited[i][j] = false;
                    }
                }
                if (search(l.size, l.maze, l.startrow, l.startcol, 0, visited)) {
                    System.out.println(awesome + " " + l.size);
                    l.printLevel();
                    System.out.println();
                    count++;
                }
            }
            System.out.println(count + " successful boards.");
        }
    }


    static boolean search(int size, int[][] maze, int mr, int mc,int dir,boolean[][] visited){
        if(mr<0||mr>size-1||mc<0||mc>size-1)return false;
        if(visited[mr][mc])return false;
        else visited[mr][mc]=true;
        if(maze[mr][mc]==-5)return true;
        if(maze[mr][mc]>0)return false;
        if(checkHits(size,maze,mr,mc)==false)return false;
        if(dir!=3){
            boolean uresult=search(size,maze,mr-1,mc,1,visited);
            if(uresult)return true;
        }
        if(dir!=1){
            boolean dresult=search(size,maze,mr+1,mc,3,visited);
            if(dresult)return true;
        }
        if(dir!=4) {
            boolean rresult = search(size, maze, mr, mc + 1, 2,visited);
            if (rresult) return true;
        }
        if(dir!=2){
            boolean lresult=search(size,maze,mr,mc-1,4,visited);
            if(lresult)return true;
        }
        return false;
    }

    static int[][] rotateLasers(int size,int[][] maze){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                switch(maze[row][col]){
                    case 11: maze[row][col]=12;
                        break;
                    case 12: maze[row][col]=13;
                        break;
                    case 13: maze[row][col]=14;
                        break;
                    case 14: maze[row][col]=11;
                        break;
                    case 21: maze[row][col]=24;
                        break;
                    case 22: maze[row][col]=21;
                        break;
                    case 23: maze[row][col]=22;
                        break;
                    case 24: maze[row][col]=23;
                        break;
                    case 31: maze[row][col]=32;
                        break;
                    case 32: maze[row][col]=33;
                        break;
                    case 33: maze[row][col]=34;
                        break;
                    case 34: maze[row][col]=31;
                        break;
                    case 41: maze[row][col]=44;
                        break;
                    case 42: maze[row][col]=41;
                        break;
                    case 43: maze[row][col]=42;
                        break;
                    case 44: maze[row][col]=43;
                        break;
                    case -90:maze[row][col]=-91;
                        break;
                    case -91:maze[row][col]=2;
                        break;
                    case 2:maze[row][col]=-90;
                        break;
                    default:break;
                }
            }
        }
        return maze;
    }

//not done
    static boolean checkHits(int size, int[][] maze,int mr,int mc) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                //check up
                if ((maze[row][col] > 1 && maze[row][col] % 10 == 1)||maze[row][col]==32||maze[row][col]==44) {
                    for (int k = row - 1; k > 0 && maze[k][col] < 1; k--) {
                        if(k==mr&&col==mc){
                            return false;
                        }
                    }
                }
                //check down
                if ((maze[row][col] > 1 && maze[row][col] % 10 == 3)||maze[row][col]==34||maze[row][col]==42) {
                    for (int k = row + 1; k < size && maze[k][col] < 1; k++) {
                        if(k==mr&&col==mc){
                            return false;
                        }
                    }
                }
                //check left
                if ((maze[row][col] > 1 && maze[row][col] % 10 == 4)||maze[row][col]==31||maze[row][col]==43) {
                    for (int k = col - 1; k > 0 && maze[row][k] < 1; k--) {
                        if(k==mc&&row==mr){
                            return false;
                        }
                    }
                }
                //check right
                if ((maze[row][col] > 1 && maze[row][col] % 10 == 2)||maze[row][col]==33||maze[row][col]==41) {
                    for (int k = col + 1; k < size && maze[row][k] < 1; k++) {
                        if(row==mr&&k==mc){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
