/*
 * This is the node class that Jackie had us working with in CS 110!
 */

public class NodeTester
{
   public static void main(String[]args)
   {
      Node<String> n1 = new Node<>("Hello");
      Node<String> n2 = new Node<>("World");
      n1.setNext(n2);
      Node<String> n3 = new Node<>("Again", n1);
      
      n3.setNext(new Node<String>("where?", n3.getNext()));
      
      Node<String> current;
      
      for(current = n3; current != null; current = current.getNext())
         System.out.println(current.getItem());
   }
}