class Solution {
    public int[] freq(String s){
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            arr[ch-'a']++;
        }
        return arr;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int n=p.length();
        List<Integer> list=new ArrayList<>();
        if(s.length()<n) return list;
        int[] arr1=freq(s.substring(0,n));
        int[] arr2=freq(p);
        for(int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+" ");
        }
        if(Arrays.equals(arr1,arr2)) list.add(0);
            for(int i=n;i<s.length();i++){
                char ch1=s.charAt(i-n);
                char ch2=s.charAt(i);
                arr1[ch1-'a']--;
                arr1[ch2-'a']++;
                if(Arrays.equals(arr1,arr2)) list.add(i-n+1);
            }
        return list;
        }
}