class Solution {

    class Node { //Node to store the weight and the dest.
        String key;
        double val;

        public Node(String k, double v) {
            key = k;
            val = v;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> g = buildGraph(equations, values); //build the graph.

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++)
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet(), g); //prepare the result for each query. New HashSet is passed to keep track of visited nodes.

        return result;

    }

    private double dfs(String s, String d, Set<String> visited, Map<String, List<Node>> g) {
        if (!(g.containsKey(s) && g.containsKey(d))) //if any of the src or dest is not present, return -1.
            return -1.0;
        if (s.equals(d)) //if both are equal return 1.
            return 1.0;

        visited.add(s); //mark the node as visited.
        for (Node ng : g.get(s)) {
            if (!visited.contains(ng.key)) { //if neighbour is not visited.
                double ans = dfs(ng.key, d, visited, g);
                if (ans != -1.0) //if we have found some answer from this path multiply this the result with current node val.
                    return ans * ng.val;
            }
        }

        return -1.0;
    }

    // build graph
    private Map<String, List<Node>> buildGraph(List<List<String>> eq, double[] values) {
        Map<String, List<Node>> g = new HashMap();
        for (int i = 0; i < values.length; i++) {
            String src = eq.get(i).get(0);
            String des = eq.get(i).get(1);
            g.putIfAbsent(src, new ArrayList());
            g.putIfAbsent(des, new ArrayList());
            g.get(src).add(new Node(des, values[i])); //for given a/b simply store the value.
            g.get(des).add(new Node(src, 1 / values[i])); //also store b/a as 1/value.
        }
        return g;
    }
}
