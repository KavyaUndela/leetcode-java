class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n= answerKey.length();
        int ans=0;
        int countt=0;
        int countf=0;
        int l=0;
        for(int r=0;r<n;r++){
            if(answerKey.charAt(r)=='T'){
                countt++;
            }
            else{
                    countf++;
            }
                while(Math.min(countt,countf)>k){
                    if(answerKey.charAt(l)=='T'){
                        countt--;
                    }
                    else{
                            countf--;
                    }
                    l++;
                }
                    ans=Math.max(ans,r-l+1);
                    
            } 
            return ans;
        
    }
}   
