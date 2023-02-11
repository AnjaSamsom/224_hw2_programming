import java.util.*;


 public class main
 {
    private static int vertices = 8;
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the BFS/DFS search tool!");
        System.out.print("Please type BFS or DFS to choose an algorithm: ");

        boolean enter = true;

        ArrayList<LinkedList<Integer>> G = make_tree();

        while(enter)
        {
            String choice = input.nextLine().toUpperCase();
            if(choice.equals("BFS"))
            {
                bfs(0, G);
                enter = false;
                input.close();
            }

            else if (choice.equals("DFS"))
            {
                dfs(0, G);
                enter = false;
                input.close();

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

    public static ArrayList<LinkedList<Integer>> make_tree()
    {

        ArrayList<LinkedList<Integer>> G = new ArrayList<LinkedList<Integer>>();
        for( int i = 0; i<8; i++)
        {
            G.add(new LinkedList<Integer>());
        }



        G.get(0).add(2);
        G.get(0).add(3);

        G.get(1).add(1);
        G.get(1).add(3);
        G.get(1).add(4);
        G.get(1).add(5);

        G.get(2).add(1);
        G.get(2).add(2);
        G.get(2).add(5);
        G.get(2).add(7);
        G.get(2).add(8);

        G.get(3).add(2);
        G.get(3).add(5);

        G.get(4).add(2);
        G.get(4).add(3);
        G.get(4).add(4);
        G.get(4).add(6);

        G.get(5).add(5);

        G.get(6).add(3);
        G.get(6).add(8);

        G.get(7).add(3);
        G.get(7).add(7);


        return G;


    }

    public static void bfs(int s, ArrayList<LinkedList<Integer>> G)
    {
        boolean[] discovered = new boolean[vertices];
        for(int i = 0; i < vertices; i++)
        {
            discovered[i] = false;
        }
        discovered[s] = true;

        for(int i = 0; i < vertices; i++)
        {
            System.out.println(discovered[i]);
        }

    }

    public static void dfs(int s, ArrayList<LinkedList<Integer>> G)
    {
        System.out.println("we are in the dfs method!");
    }
 }