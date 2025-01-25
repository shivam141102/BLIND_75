// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         // Step 1: Create a frequency map to count occurrences of each number
//         Map<Integer, Integer> frequencyMap = new HashMap<>();
//         for (int num : nums) {
//             frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
//         }

//         // Step 2: Convert the frequency map into a list of entries and sort by frequency in descending order
//         List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
//         sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

//         // Step 3: Extract the top K keys (most frequent elements) into the result array
//         int[] result = new int[k];
//         for (int i = 0; i < k; i++) {
//             result[i] = sortedEntries.get(i).getKey();
//         }

//         // Step 4: Return the result array containing the top K frequent elements
//         return result;
//     }
// }

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         // Step 1: Create a frequency map to count occurrences of each number
//         Map<Integer, Integer> frequencyMap = new HashMap<>();
//         for (int num : nums) {
//             frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
//         }

//         // Step 2: Use a min-heap (priority queue) to keep track of the top K elements
//         PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Map.Entry.comparingByValue());
        
//         // Step 3: Add each entry to the heap; if the heap exceeds size K, remove the smallest element
//         for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
//             minHeap.offer(entry);
//             if (minHeap.size() > k) {
//                 minHeap.poll();
//             }
//         }

//         // Step 4: Extract the keys of the top K elements from the heap
//         int[] result = new int[k];
//         int index = 0;
//         while (!minHeap.isEmpty()) {
//             result[index++] = minHeap.poll().getKey();
//         }

//         return result;
//     }
// }

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each number
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create the bucket array
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // Step 3: Populate the bucket with numbers grouped by frequency
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            int num = entry.getKey();
            bucket[freq].add(num);
        }

        // Step 4: Collect the top K frequent elements
        int[] ans = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            for (int num : bucket[i]) {
                ans[index++] = num;
                if (index == k) break; // Stop if k elements are collected
            }
        }
        return ans;
    }
}