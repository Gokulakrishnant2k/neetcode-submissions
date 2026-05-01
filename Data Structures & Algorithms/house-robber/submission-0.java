class Solution {
    public int rob(int[] nums) {
    int prev1 = 0; 
    int prev2 = 0; 

    for (int num : nums) {
        int take = num + prev2;   
        int skip = prev1;        

        int curr = Math.max(take, skip);

        prev2 = prev1;
        prev1 = curr;
    }

    return prev1;
    }
}
