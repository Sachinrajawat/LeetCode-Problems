class Solution {
    public String reorganizeString(String s) {
        int[] freq=new int[26];
        for (char c:s.toCharArray()) {
            freq[c-'a']++;
        }

        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a, b)->b[0]-a[0]);
        for(int i=0;i<26;i++) {
            if(freq[i]>0) {
                maxHeap.add(new int[]{freq[i], i});
            }
        }
        StringBuilder result = new StringBuilder();
        while (maxHeap.size()>1) {
            int[] first=maxHeap.poll();
            int[] second=maxHeap.poll();
            result.append((char)(first[1] + 'a'));
            result.append((char)(second[1] + 'a'));
            if (--first[0]>0) maxHeap.add(first);
            if (--second[0]>0) maxHeap.add(second);
        }

        if(!maxHeap.isEmpty()){
            int[] last=maxHeap.poll();
            if (last[0]>1) {
                return "";
            }
            result.append((char)(last[1]+'a'));
        }

        return result.toString();
    }
}