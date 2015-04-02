/**
 * 
 */
package everton.cracking.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Everton
 */
public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private char data;
    
    public static void runInLevel(TreeNode position, int level, Map<Integer, StringBuffer>levelMap) {
        
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
        TreeNode a = new TreeNode();
        TreeNode b = new TreeNode();
        TreeNode c = new TreeNode();
        TreeNode d = new TreeNode();
        TreeNode e = new TreeNode();
        TreeNode f = new TreeNode();
        TreeNode g = new TreeNode();
        
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
        
        
        printInLevel(a);
        
    }

    private static void runLeveled(TreeNode head) {
        
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<TreeNode>();
        
        TreeNode node = head;
        
        TreeNode MARK_NODE = new TreeNode();
        
        queue.offer(node);
        queue.offer(MARK_NODE);
        while (true) {
            
            TreeNode current = queue.poll();
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
    
    
    public static void printInLevel(TreeNode head) {
    	Queue<TreeNode> queue = new ConcurrentLinkedQueue<TreeNode>();
    	
    	queue.offer(head);
    	while (!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		System.out.print(node.data);
    		if (node.left != null) { 
    			queue.offer(node.left); 
			}
    		if (node.right != null) {
    			queue.offer(node.right);
    		}
    	}
    }
    
    
    
    
}
