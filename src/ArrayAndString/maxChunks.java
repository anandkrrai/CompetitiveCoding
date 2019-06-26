class maxChunks{
    
    public static int findNum(int[] arr ){
        int rv=0;
        int[] min=new int[arr.length];
        int[] max= new int[arr.length];

        max[0]=Integer.MIN_VALUE;
        for(int i=1 ;i<arr.length;++i){
            max[i]=Math.max(max[i-1], arr[i]);
        }

        min[arr.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;--i){
            min[i]=Math.min(arr[i],min[i+1]);
        }

            for(int i=0;i<arr.length;++i){
                if(max[i]<=min[i]){
                    ++rv;
                }
            }
        return rv;
    }
    
    
    public static void main(String[] args){
        int[] arr = {5,3,1,2,4,9,7,10,11,14,12};
        System.out.println(findNum(arr));
    }
}