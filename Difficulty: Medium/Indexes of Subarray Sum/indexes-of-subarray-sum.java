
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int start = 0;
        int end = 0;
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            if(sum<target){
                sum+=arr[i];
                end=i;
            }
            if(sum>target){
                while(sum>target){
                    sum-=arr[start];
                    start+=1;
                }
            }if(sum==target){
                break;
            }
        }
        if(sum==target){
            return new ArrayList<Integer>(Arrays.asList(start+1,end+1));
        }else{
            return new ArrayList<Integer>(Arrays.asList(-1));
        }
        
    }
}