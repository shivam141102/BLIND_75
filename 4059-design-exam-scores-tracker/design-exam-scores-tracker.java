import java.util.SortedMap;
class ExamTracker {
    private TreeMap<Integer, Long> timeExamMap;
    private long sum;
    
    public ExamTracker() {
        timeExamMap = new TreeMap();
        sum = 0L;
    }
    
    public void record(int time, int score) {
        sum += score;
        timeExamMap.put(time, sum);
    }
    
    public long totalScore(int startTime, int endTime) {
        Map.Entry<Integer, Long> endEntry = timeExamMap.floorEntry(endTime);
        Map.Entry<Integer, Long> startEntry = timeExamMap.lowerEntry(startTime);

        long endSum = (endEntry == null) ? 0L : endEntry.getValue();
        long startSum = (startEntry == null) ? 0L : startEntry.getValue();

        return endSum - startSum;
    }
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */