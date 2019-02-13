/*
Route Between Nodes: 
Given a directed graph, design an algorithm to find out whether there is a
route between two nodes.
*/

import java.util.*;

class Solution {
    public boolean hasPath(Node src, Node dest) {
        if (src.equals(dest)) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.offer(src);
        visited.add(src);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.equals(dest)) {
                return true;
            }

            for (Node adj : cur.adj) {
                if (!visited.contains(adj)) {
                    queue.offer(adj);
                    visited.add(adj);
                }
            }
        }

        return false;
    }
}
