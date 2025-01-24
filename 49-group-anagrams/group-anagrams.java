// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         List<List<String>> result = new ArrayList<>();
//         HashMap<String, List<String>> map = new HashMap<>();
        
//         for(String word : strs){
//             char[] char_arr = word.toCharArray();
//             Arrays.sort(char_arr);
//             String sorted_word = new String(char_arr);
            
//             List<String> value = map.getOrDefault(sorted_word, new ArrayList<>());
//             value.add(word);
//             map.put(sorted_word, value);
//         }

//         for(String key : map.keySet()){
//             result.add(map.get(key));
//         }
//         return result;
//     }
// }

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}


// strs
// [eat, tea, tan, ate, nat, bat]

// sorted_strs
// [aet, aet, ant, aet, ant, abt]

// Loop 1
// key = aet -- val = [eat]

// Loop 2
// key = aet -- val = [eat, tea]

// Loop 3
// key = ant -- val = [tan]

// Loop 4
// key = aet -- val = [eat, tea, ate]

// Loop 5
// key = ant -- val = [tan, nat]

// Loop 6
// key = abt -- val = [bat]