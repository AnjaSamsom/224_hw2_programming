import java.util.Scanner;

 public class main
 {
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the BFS/DFS search tool!");
        System.out.print("Please type BFS or DFS to choose an algorithm: ");


        boolean enter = true;

        while(enter)
        {
            String choice = input.nextLine().toUpperCase();
            if(choice.equals("BFS"))
            {
                bfs();
                enter = false;

            }

            else if (choice.equals("DFS"))
            {
                dfs();
                enter = false;

            }
            else
            {
                choice = get_input();

            }
        }



    }

    public static String get_input()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please type BFS or DFS to choose an algorithm: ");
        return input.nextLine().toUpperCase();
    }

    public static void bfs()
    {
        System.out.println("we are in the bfs method!");
    }

    public static void dfs()
    {
        System.out.println("we are in the dfs method!");
    }
 }