import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static int rows;
    private static int columns;
    private static char[][] maze;
    public static void main(String args[]){
        try(BufferedReader read = new BufferedReader(new FileReader("maze.dat"))) {
            //Create 2D array for maze
            String line = read.readLine();
            String[] firstLine = line.split(" ");
            rows = Integer.parseInt(firstLine[0]);
            columns = Integer.parseInt(firstLine[1]);
            maze = new char[rows][columns];
            
            for(int i = 0; i < rows; i++){
                line = read.readLine();
                maze[i] = line.toCharArray();
            }

            //Entering point
            findEntrance(maze);

            //Traversing the 2D maze
            // traverse(findEntrance(maze)[0], find);
      

       }catch (IOException error) {
            System.out.println(error);
       }

    }

    public static int[] findEntrance(char[][] maze){
        int[] start = new int[2];
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[i].length; j++){
                if(maze[i][j] == '+'){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        return start;
    }

    // public static boolean traverse(){

    // }
    
}