class Solution {

    /**
     * @param Integer $num
     * @return Integer[]
     */
    function countBits($num) {
        
        // dynamic programming
        $sol = array(0 => 0);
        
        for ($i = 1; $i <= $num; $i++) {
            // if we have an odd number our solution will be equal to our previous solution + 1
            if (($i & 1)) {
                $sol[$i] = $sol[$i - 1] + 1;
                
            // if we are even, it'll be the same answer as our previous solution with all the bits moved  over one to the right (since the last one is zero anyways)
            } else {
                $sol[$i] = $sol[$i >> 1];
            }
        }
        
        return $sol;
        
        // brute force
//         $sol = array();
        
//         for ($i = 0; $i <= $num; $i++) {
//             $temp = $i;
//             $bits = 0;
            
//             for ($j = 0; $j < 32; $j++) {
//                 if ($temp & 1) $bits++;
                
//                 $temp >>= 1;
//             }
            
//             $sol[] = $bits;
//         }
        
//         return $sol;
    }
}