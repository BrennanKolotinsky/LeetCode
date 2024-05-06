class Solution {
    public int minimumKeypresses(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) charMap.put(c, charMap.getOrDefault(c, 0) + 1);

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b)->charMap.get(b) - charMap.get(a));

        pq.addAll(charMap.keySet());

        int cnt = 0;
        int slot = 0;
        while (!pq.isEmpty()) {
            char c = pq.poll();

            int multiplier = 1;
            if (slot >= 9 & slot < 18) multiplier = 2;
            else if (slot >= 18) multiplier = 3;

            cnt += charMap.get(c) * multiplier;
            ++slot;
        }

        return cnt;
    }
}