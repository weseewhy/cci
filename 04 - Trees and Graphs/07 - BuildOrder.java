/*
Build Order:
You are given a list of projects and a list of dependencies (which is a list of pairs of projects,
where the second project is dependent on the first project).
All of a project's dependencies must be built before the project is.
Find a build order that will allow the projects to be built. If there is no valid build order, return an error.

EXAMPLE
Input:
projects: a, b, c, d, e, f
dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)

Output: f, e, a, b, d, c
*/

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    List<String> getBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        List<Node> nodes = dfs(graph);

        List<String> out = nodes.stream().map(n -> n.name).collect(Collectors.toList());
        Collections.reverse(out);
        return out;
    }

    // [a, b] means 'b' is dependent on 'a' ('a' must be compiled before 'b')
    // So graph will have have edge a->b
    private Graph buildGraph(String[] projects, String[][] dependencies) {
        Map<String, Node> nodes = new HashMap<>();
        for (String s : projects) {
            nodes.put(s, new Node(s));
        }

        for (String[] arr : dependencies) {
            nodes.get(arr[0]).addAdj(nodes.get(arr[1]));
        }

        Graph graph = new Graph();
        graph.nodes.addAll(nodes.values());
        return graph;
    }

    private List<Node> dfs(Graph graph) {
        Set<Node> visited = new HashSet<>();
        List<Node> out = new ArrayList<>();
        for (Node node : graph.nodes) {
            Set<Node> path = new HashSet<>();
            dfs(node, visited, out, path);
        }
        return out;
    }

    private void dfs(Node node, Set<Node> visited, List<Node> out, Set<Node> path) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);
        path.add(node);

        for (Node adj : node.adj) {
            if (path.contains(adj)) {
                throw new RuntimeException("Found cycle");
            }

            if (!visited.contains(adj)) {
                dfs(adj, visited, out, path);
            }
        }

        out.add(node);
        path.remove(node);
    }
}
