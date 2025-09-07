class Solution {
    public int totalFruit(int[] fruits) {
        int l=0;
        int n= fruits.length;
        int ans=0;
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int r=0;r<n;r++){
            hm.put(fruits[r],hm.getOrDefault(fruits[r],0)+1);
            while(hm.size()>2){
                hm.put(fruits[l],hm.get(fruits[l])-1);
                if(hm.get(fruits[l])==0){
                    hm.remove(fruits[l]);
                }
                l++;
            }
            ans=Math.max(ans,r-l+1);


        }
        return ans;
        
    }
}