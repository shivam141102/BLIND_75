class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> sorted_strs = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        for(String word : strs){
            char[] char_arr = word.toCharArray();
            Arrays.sort(char_arr);
            String temp = new String(char_arr);
            sorted_strs.add(temp);
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < sorted_strs.size(); i++){
            String key = sorted_strs.get(i);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(strs[i]);
            map.put(key, value);
        }

        for(String key : map.keySet()){
            result.add(map.get(key));
        }
        return result;
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