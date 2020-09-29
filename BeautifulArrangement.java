// Time Complexity : O(k) where k is the number of valid permutations which we will explore
// Space Complexity : O(n) to store the array of visited values
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    
    private int count = 0;
    
    public int countArrangement(int N) {
        
        if(N == 0)  return 0;
        
        backtrack(1,N,new boolean[N+1]);
        
        return count;
    }
    
    private void backtrack(int index, int N, boolean visited[]){
        
        if(index > N){
            count++;
            return;
        }   
        
        for(int i = 1; i <= N; i++){
            
            if(visited[i] == false && ( i % index == 0 || index % i == 0)){
                
                //add
                visited[i] = true;
                
                //backtrack
                backtrack(index+1, N, visited);
                
                //remove
                visited[i] = false;
                
            }
        }
    }
}
