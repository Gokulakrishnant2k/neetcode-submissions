class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;
    
    public KthLargest(int k, int[] nums) {
      this.k = k;
        minHeap = new PriorityQueue<>();

        for(int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);

        // Keep only k elements
        if(minHeap.size() > k) {
            minHeap.poll();
        }

        // kth largest element
        return minHeap.peek();
    }
}
