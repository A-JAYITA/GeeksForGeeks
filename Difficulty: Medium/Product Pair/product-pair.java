class Solution {
    public boolean isProduct(int[] arr, long target) {
        HashMap<Integer, Integer> map= new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]))
                map.put(arr[i],map.get(arr[i])+1);
            else
                map.put(arr[i],1);
        }
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0 && target%arr[i]==0 ){
                int num= (int)(target/arr[i]);
                if(map.containsKey(num)){
                    if(num == arr[i]){
                        if(map.get(num)>1){
                            return true;
                        }
                }
                else{
                    return true;    
                }
            }
            }
        }
        
        return false;
    }
};