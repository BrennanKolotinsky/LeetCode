class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int[] item: items) {
            int student = item[0];
            int grade = item[1];
            if (map.containsKey(student)) {
                map.get(student).add(grade);
            } else {
                PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
                pq.add(grade);
                map.put(student, pq);
            }
        }

        int[][] sol = new int[map.size()][2];

        int cnt = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            PriorityQueue pq = entry.getValue();
            int total = 0;
            for (int i = 0; i < 5; ++i) {
                int n = (int) pq.poll();
                total += n;
            }

            sol[cnt] = new int[]{key, total / 5};
            ++cnt;
        }

        return sol;
    }
}