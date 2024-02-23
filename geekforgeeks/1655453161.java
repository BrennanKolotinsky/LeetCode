class Solution {
    
    int[][] mvs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        
        if (grid.length == 0 || grid[0].length == 0)
            return -1;

        // BFS
        Queue<int[]> q = new LinkedList<>();

        q.add(source);

        int cnt = 0;
        while (!q.isEmpty()) {
            int currLength = q.size();
            
            for (int k = 0; k < currLength; k++) {
                int[] curr = q.poll();
                if (curr[0] == destination[0] && curr[1] == destination[1])
                    return cnt;
                
                for (int[] mv: mvs) {
                    int i = curr[0] + mv[0];
                    int j = curr[1] + mv[1];
                    if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
                        grid[i][j] = 0; // avoids rechecking
                        q.add(new int[] {i, j});
                    }
                        
                }
            }
            ++cnt;
        }
        
        return -1;
    }
}