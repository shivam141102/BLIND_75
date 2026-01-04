class Pair{
    public String word;
    public int step;

    Pair(String word, int step){
        this.word = word;
        this.step = step;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            Pair top = q.poll();
            String word = top.word;
            int step = top.step;

            if(word.equals(endWord)){
                return step;
            }

            for(int i = 0; i < word.length(); i++){
                char[] charArray = word.toCharArray();
                char original = charArray[i];
                for(char c = 'a'; c <= 'z'; c++){
                    charArray[i] = c;
                    String str = new String(charArray);
                    if(set.contains(str)){
                        set.remove(str);
                        q.offer(new Pair(str, step + 1));
                    }
                }
            }
        }
        return 0;
    }
}