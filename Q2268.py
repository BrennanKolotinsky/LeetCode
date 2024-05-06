class Solution:
    def minimumKeypresses(self, s: str) -> int:
        c = collections.Counter(s)
        multiplier = ans = 0
        for index, freq in enumerate(sorted(c.values(), reverse=True)):
            if (index % 9 == 0):
                multiplier += 1
            ans += freq * multiplier
            
        return ans