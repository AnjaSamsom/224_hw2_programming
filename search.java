import java.util.*;

/**
 * Anja Samsom HW 2 Programming
 * CS 224
 */
public class search
 {
    private static int node_num = 8;

    // got information about making an adjacency list with an arraylist and a linkedlist from
    // https://stackoverflow.com/questions/14783831/java-implementation-of-adjacency-list
    private static ArrayList<LinkedList<Integer>> G = new ArrayList<LinkedList<Integer>>();
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the BFS/DFS search tool!");
        System.out.print("Please type BFS or DFS to choose an algorithm, or QUIT to stop: ");

        boolean enter = true;

        ArrayList<LinkedList<Integer>> G = make_tree();

        while(enter)
        {
            String choice = get_input();            

            if(choice.equals("BFS"))
            {
                System.out.print("Start node: ");
                int start_node = input.nextInt();
                bfs(start_node, G);
            }

            else if (choice.equals("DFS"))
            {
                System.out.print("Start node: ");
                int start_node = input.nextInt();
                dfs(start_node, G);
            }
            else if (choice.equals("QUIT"))
            {
                enter = false;
                input.close();
            }
            else
            {
                choice = get_input();
            }
        }

        input.close();

    }

    /**
     * this method gets user input and returns it
     */
    public static String get_input()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please type BFS or DFS to choose an algorithm: ");
        return input.nextLine().toUpperCase();
    }

    /**
     * makes the tree, does not take input, returns the tree 
     */
    public static ArrayList<LinkedList<Integer>> make_tree()
    {

        for(int i = 0; i<=node_num; i++)
        {
            G.add(new LinkedList<Integer>());

        }

        // I decided to just start my list at 1 and leave index 0 empty
        // because I had it at 0 before and it was kind of tripping me up
        // to renumber everything
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

    /**
     * runs bfs from start node
     * takes in the graph G
     * prints out nodes in bfs order
     */
    public static void bfs(int s, ArrayList<LinkedList<Integer>> G)
    {
        // https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
        // used documentation implement the stack and queue using a linked list
        // queue to hold nodes
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);

        // this boolean array holds whether or not the node has been discovered
        boolean[] discovered = new boolean[node_num+1];
        for(int i = 0; i <= node_num; i++)
        {
            discovered[i] = false;
        }
        while(queue.size() != 0)
        {
            // FIFO
            int u = queue.removeFirst();
            
            if (discovered[u] == false)
            {
                discovered[u] = true;
                System.out.println(u);
                for(int m = 0; m < G.get(u).size(); m++)
                {
                    if(discovered[G.get(u).get(m)] == false)
                    {
                        // adding node to the queue, add to the end to make it work like a FIFO queue
                        queue.add(G.get(u).get(m));
                    }
                }
            }
        }

    }

    /**
     * runs dfs from start node
     * takes in the graph G
     * prints out nodes in bfs order
     */
    public static void dfs(int s, ArrayList<LinkedList<Integer>> G)
    {
        // queue to hold nodes
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.add(s);

        // this boolean array holds whether or not the node has been discovered
        boolean[] discovered = new boolean[node_num+1];
        for(int i = 0; i <= node_num; i++)
        {
            discovered[i] = false;
        }
        while(stack.size() != 0)
        {
            // LIFO
            int u = stack.removeFirst();
            

            if (discovered[u] == false)
            {
                discovered[u] = true;
                System.out.println(u);
                for(int m = 0; m < G.get(u).size(); m++)
                {
                    if(discovered[G.get(u).get(m)] == false)
                    {
                        // adding node to the stack, add first to make it work like a LIFO stack
                        stack.addFirst(G.get(u).get(m));
                    }
                }
            }
        }
    }
 }