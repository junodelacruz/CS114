import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String args[]){
       try(Scanner maze = new Scanner(new File("maze.dat"))) {
        int row = 0;
        int column = 0;
        // Finding the coordinates of the entrance
        while(maze.hasNextLine()){
                String line = maze.nextLine();
                System.out.println(line);
                if(!line.contains("+")){
                    row++;
                }
                else {
                    for(int i = 0; i<line.length();i++) {
                        if(line.charAt(i) == '+'){
                            break;
                        }
                        else {
                            column++;
                        }
                    }
                    break;
                }
        }
        System.out.println(row + " " +  column);
       } catch (FileNotFoundException error) {
            System.out.println(error);
       }

       //Moving through the maze
    }
    
}