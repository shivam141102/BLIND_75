class Solution {
    public boolean isPalindrome(String str){
        int l = 0, r = str.length() - 1;
        while(l < r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public void rec(int ind, int size, String s, List<String> ds, List<List<String>> ans){
        if(ind == size){
            ans.add(new ArrayList<>(ds));
        }

        for(int i = ind; i < size; i++){
            String substr = s.substring(ind, i + 1);
            if(isPalindrome(substr)){
                ds.add(substr);
                rec(i + 1, size, s, ds, ans);
                ds.remove(ds.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        int size = s.length();
        List<String> ds = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        rec(0, size, s, ds, ans);
        return ans;
    }
}