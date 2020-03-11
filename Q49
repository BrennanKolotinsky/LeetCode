class Solution {

    /**
     * @param String[] $strs
     * @return String[][]
     */
    function groupAnagrams($strs) {
        
        $existingArr = array();
        $sol = array();
        
        for ($i = 0; $i < sizeof($strs); $i++) {
            $word = $strs[$i];
            
            $map = array();
            for($z = 97; $z < 123; $z++){
                $map[chr($z)] = 0;
            }
            
            for ($j = 0; $j < strlen($word); $j++) {
                $ltr = $word[$j];
                if (isset($ltr)) {
                    $map[$ltr]++;
                } else {
                    $map[$ltr] = 1;
                }
            }
            
            $added = false;
            
            // check existing array to see if it contains the value
            for ($j = 0; $j < sizeof($existingArr); $j++) {
                if ($existingArr[$j] === $map) {
                    $sol[$j][] = $word;
                    $added = true;
                }
            }
            
            if (!$added) {
                $sol[] = array($word);
                $existingArr[] = $map;
            }
        }
        
        return $sol;
    }
}