class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String,Double>> graph = new HashMap<String, HashMap<String, Double>>();
        buildGraph(graph, equations, values);
        double[] results = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++)
        {
            List<String> query = queries.get(i);
            String num = query.get(0);
            String den = query.get(1);
            HashSet <String> visited = new HashSet<String>();
            if(!graph.containsKey(num) || !graph.containsKey(den))
                results[i] = -1.0;
            else if(num.equals(den))
                results[i] = 1.0;
            else
                results[i] = dfs(graph, num, den, visited);
        }
        return results;
    }
    
    
    public static double dfs(HashMap<String,HashMap<String,Double>> graph, String start, String end, HashSet <String> visited)
    {
        if(graph.get(start).containsKey(end))
            return graph.get(start).get(end);
        visited.add(start);
        for(String child : graph.get(start).keySet())
        {
            if(visited.contains(child))
                continue;
            double val = dfs(graph, child, end, visited);
            if(val != -1.0)
                return graph.get(start).get(child) * val;
        }
        return -1.0;
    }
    
    public static void buildGraph(HashMap<String,HashMap<String,Double>> graph, List<List<String>> equations, double[] values)
    {
        int i = 0;
        for(i = 0; i < equations.size(); i++)
        {
            List<String> eqn = equations.get(i);
            String startnode = eqn.get(0);
            String endnode = eqn.get(1);
            HashMap<String,Double> distances = graph.getOrDefault(startnode, new HashMap<String,Double>());
            distances.put(endnode, values[i]);
            graph.put(startnode,distances);
            
            distances = graph.getOrDefault(endnode, new HashMap<String,Double>());
            distances.put(startnode, 1/values[i]);
            graph.put(endnode,distances);
        }
    }
}