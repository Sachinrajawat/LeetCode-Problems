class Solution {
    public int smallestDistancePair(int[] nums, int k) {
/*
        ArrayList<Integer> list=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int a=Math.abs(nums[i]-nums[j]);
                max=Math.max(a,max);
                if(list.size()<=k || a<=max) list.add(a);
            }
        }
        System.out.println(list);
        Collections.sort(list);
        int ans=list.get(k-1);
        return ans;
        */
        int n=nums.length,ans=0;
        Arrays.sort(nums);
        int start=0,end=nums[n-1]-nums[0];
        System.out.println(start+" "+end);
        while(start<=end){
            int mid=start+(end-start)/2;
            int count=0;
            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    int a=Math.abs(nums[i]-nums[j]);
                    if(a<=mid) count++;
                    else break;
                }
                System.out.println(count);
            }
            if(count>=k){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }

}