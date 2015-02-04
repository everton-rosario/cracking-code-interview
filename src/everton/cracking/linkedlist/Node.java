/**
 * 
 */
package everton.cracking.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Everton
 */
public class Node {
    private Node left;
    private Node right;
    private char data;
    
    public static void runInLevel(Node position, int level, Map<Integer, StringBuffer>levelMap) {
        
        if (position == null) {
            return;
        }
        
        StringBuffer levelString = levelMap.get(level);
        if (levelString == null) {
            levelString = new StringBuffer();
        }
        
        runInLevel(position.left, level + 1, levelMap);
        levelString.append(position.data);
        levelMap.put(level, levelString);
        runInLevel(position.right, level + 1, levelMap);
    }
    
    public static void main(String[] args) {
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        Node f = new Node();
        Node g = new Node();
        
        a.data = 'a';
        a.left = b;
        a.right = c;
        
        b.data = 'b';
        b.left = d;
        b.right = e;
        
        c.data = 'c';
        c.left = f;
        c.right = g;
        
        d.data = 'd';
        e.data = 'e';
        f.data = 'f';
        g.data = 'g';
        
        Map<Integer, StringBuffer> map = new HashMap<Integer, StringBuffer>();
        runInLevel(a, 0, map);
        
        int i = 0;
        StringBuffer level = map.get(i);
        while (level != null) {
            System.out.println(level.toString());
            level = map.get(++i);
        }
        
        
        runLeveled(a);
        
    }

    private static void runLeveled(Node head) {
        
        Queue<Node> queue = new ConcurrentLinkedQueue<Node>();
        
        Node node = head;
        
        Node MARK_NODE = new Node();
        
        queue.offer(node);
        queue.offer(MARK_NODE);
        while (true) {
            
            Node current = queue.poll();
            if (current != MARK_NODE) {
                System.out.print(current.data);
                if (current.left != null)  queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            } else {
                System.out.println();
                if (queue.isEmpty()) break;
                queue.offer(MARK_NODE);
            }
            
        }
        
    }
    
    
    
    
    
}
