class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : answers) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        int cnt = 0;
        for (Integer key: map.keySet() ) {
            int groups = key + 1;
            int total = map.get(key);
            // all members found in this group -- just return the count
            if (total % groups == 0) {
                cnt += total;
            } else {
                // consider case [2, 2, 2, 2, 2, 2, 2]
                // our map is 2 -> 7, we are going to look for groups of 3
                // we find 7 / 3 = 2 full groups + 1 partial --> 2 * 3 + 3
                cnt += (total / groups) * groups + groups;
            }
        }

        return cnt;
    }
}