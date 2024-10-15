//Juno Dela Cruz
//CS114001
//Professor Kapleau

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static int rows;
    private static int columns;
    private static char[][] maze;
    private static int[] entrance;
    public static void main(String args[]){
        try(BufferedReader read = new BufferedReader(new FileReader("maze.dat"))) {
            //Create 2D array for maze
            String line = read.readLine();
            String[] firstLine = line.split(" ");
            rows = Integer.parseInt(firstLine[0]);
            columns = Integer.parseInt(firstLine[1]);
            maze = new char[rows][columns];
            
            for(int i = 0; i < rows; i++)
            {
                line = read.readLine();
                maze[i] = line.toCharArray();
            }

            //entering point
            entrance = findEntrance(maze);
            
            //traversing the 2D maze
            if(traverse(maze, entrance[0], entrance[1]))
            {
                System.out.println("Maze solved!");
                maze[entrance[0]][entrance[1]] = '+';
                printMaze(maze); //printing the maze
            }
            else 
            {
                System.out.println("Solution not found.");
            }
      

       }catch (IOException error) 
       {
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
    public static void printMaze(char[][] maze) {
        for(int row = 0; row < maze.length; row++)
        {
            System.out.println(maze[row]);
        }
    }

    public static boolean traverse(char[][] maze, int row, int col){
        if(row == entrance[0] && col == entrance[1])
        {
            maze[row][col] = '*';
        }
        if(row<0 || col<0 || row>=maze.length || col>=maze[row].length 
        || maze[row][col] == 'X' || maze[row][col] == '.' 
        || maze[row][col] == '+')
        {
            return false;
        }

        if(maze[row][col] == '-')
        {
            return true;
        }

        // System.out.println(row + ", " + col);
        if(maze[row][col] == ' ' || maze[row][col] == '*')
        {   
            maze[row][col] = '+';
            if (traverse(maze, row + 1, col) ||   //DOWN
                traverse(maze,row - 1, col) ||    //UP
                traverse(maze, row, col + 1) ||   //RIGHT
                traverse(maze, row, col - 1))     //LEFT
                {    
                    return true; 
                }
                else
                {
                    maze[row][col] = '.';
                } 
        }
        return false;
    }
    
}