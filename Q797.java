class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> sol = new ArrayList<>();
        if (graph == null || graph.length == 0) return sol;
        dfs(graph, 0, new ArrayList<Integer>(), sol);
        return sol;
    }

    public void dfs(int[][] graph, int i, List<Integer> currSol, List<List<Integer>> sol) {
        currSol.add(i);
        if (i == graph.length - 1) {
            List<Integer> tmp = new ArrayList<>();
            for (int n : currSol) tmp.add(n);
            sol.add(tmp);
        }

        for (int n : graph[i]) {
            dfs(graph, n, currSol, sol);
        }
        currSol.remove(currSol.size() - 1);
    }
}