// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         // Create a frequency map
//         Map<Integer, Integer> frequencyMap = new HashMap<>();
//         for (int num : nums) {
//             frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
//         }

//         // Convert the frequency map to a list and sort by frequency in descending order
//         List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
//         sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

//         // Extract the top K keys into the result array
//         int[] result = new int[k];
//         for (int i = 0; i < k; i++) {
//             result[i] = sortedEntries.get(i).getKey();
//         }

//         return result;
//     }
// }

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Create a frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue <Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Map.Entry.comparingByValue());
        
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] result = new int [k];
        int index = 0;
        while(!minHeap.isEmpty()){
            result[index++] = minHeap.poll().getKey();
        }
        return result;
    }
}