import java.util.*;

public class main
 {
    private static int vertices = 8;

    // got information about making an adjacency list with an arraylist and a linkedlist from
    // https://stackoverflow.com/questions/14783831/java-implementation-of-adjacency-list
    private static ArrayList<LinkedList<Integer>> G = new ArrayList<LinkedList<Integer>>();
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
                System.out.print("Start node: ");
                int start_node = input.nextInt();

                bfs(start_node, G);
                enter = false;
                input.close();
            }

            else if (choice.equals("DFS"))
            {
                System.out.print("Start node: ");
                int start_node = input.nextInt();

                dfs(start_node, G);
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

        for(int i = 0; i<=vertices; i++)
        {
            G.add(new LinkedList<Integer>());

        }
        
        G.get(1).add(2);
        G.get(1).add(3);

        G.get(2).add(1);
        G.get(2).add(3);
        G.get(2).add(4);
        G.get(2).add(5);

        G.get(3).add(1);
        G.get(3).add(2);
        G.get(3).add(5);
        G.get(3).add(7);
        G.get(3).add(8);

        G.get(4).add(2);
        G.get(4).add(5);

        G.get(5).add(2);
        G.get(5).add(3);
        G.get(5).add(4);
        G.get(5).add(6);

        G.get(6).add(5);

        G.get(7).add(3);
        G.get(7).add(8);

        G.get(8).add(3);
        G.get(8).add(7);


        return G;


    }

    public static void bfs(int s, ArrayList<LinkedList<Integer>> G)
    {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);


        boolean[] discovered = new boolean[vertices+1];
        for(int i = 0; i <= vertices; i++)
        {
            discovered[i] = false;
        }
        while(queue.size() != 0)
        {
            int u = queue.removeFirst();
            
            

            if (discovered[u] == false)
            {
                discovered[u] = true;
                System.out.println(u);
                for(int m = 0; m < G.get(u).size(); m++)
                {
                    if(discovered[G.get(u).get(m)] == false)
                    {
                        //System.out.println(G.get(u).get(m));
                        queue.add(G.get(u).get(m));
                    }
                }
            }


        }

    }

    public static void dfs(int s, ArrayList<LinkedList<Integer>> G)
    {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);


        boolean[] discovered = new boolean[vertices+1];
        for(int i = 0; i <= vertices; i++)
        {
            discovered[i] = false;
        }
        while(queue.size() != 0)
        {
            int u = queue.removeLast();
            
            

            if (discovered[u] == false)
            {
                discovered[u] = true;
                System.out.println(u);
                for(int m = 0; m < G.get(u).size(); m++)
                {
                    if(discovered[G.get(u).get(m)] == false)
                    {
                        //System.out.println(G.get(u).get(m));
                        queue.add(G.get(u).get(m));
                    }
                }
            }


        }
    }
 }