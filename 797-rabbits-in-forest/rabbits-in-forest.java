class Solution {
    public int numRabbits(int[] answers) {
        if(answers.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;

        //For each rabbits answer
        for(int num : answers){
            if(num == 0){
                sum += 1;
                continue;
            }
            if(!map.containsKey(num)){
                //If we haven't accounted for this rabbit color then account for the one telling us
                // as well as the one that rabbit says is that color.
                map.put(num, 0);
                sum += (num + 1);
            }
            else{
                map.put(num, map.get(num) + 1);
                //if there are k of each color then they are all present, remove them to allow the change to account for others.
                if(map.get(num) == num){
                     map.remove(num);
                }
            }
            
        }
        return sum;
    }
}