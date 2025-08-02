class Solution {
    public int maximumDifference(int[] nums) {
      int n = nums.length;
      int max= -1;
      int min= nums[0];
      for(int i=1;i<n;i++){
       
        int vals=nums[i];
         if(min<vals){
        max=Math.max(max,vals-min);
        }
        min=Math.min(min,vals);
      } 

    return max;
}
}