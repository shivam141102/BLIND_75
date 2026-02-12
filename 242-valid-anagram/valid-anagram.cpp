class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.length() != t.length()) return false;

        unordered_map<char, int> mp;
        for(int i = 0; i < s.length(); i++){
            mp[s[i]] += 1;
            mp[t[i]] -= 1;
        }
        
        for(auto it : mp){
            if(it.second != 0){
                return false;
            }
        }
        return true;
    }
};