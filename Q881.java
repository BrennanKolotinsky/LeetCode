class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // sort the array
        Arrays.sort(people);

        int i = 0, j = people.length - 1, cnt = 0;
        while (i < j) {
            ++cnt;
            if (people[i] + people[j] <= limit) {
                ++i;
                --j;
            } else {
                --j;
            }
        }
        return i == j ? cnt + 1 : cnt;
    }
}