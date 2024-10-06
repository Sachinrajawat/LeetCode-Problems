class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length()==sentence2.length()){
            return sentence1.equals(sentence2);
        }
        String[] arr1=sentence1.split(" ");
        String[] arr2=sentence2.split(" ");

        if(arr1.length>arr2.length) {
            String[] temp=arr1;
            arr1=arr2;
            arr2=temp;
        }

        int s1=0,s2=0;
        int e1=arr1.length-1,e2=arr2.length-1;
        while(s1<=e1 && arr1[s1].equals(arr2[s1])){
            s1++;
            s2++;
        }
        while(s1<=e1 && arr1[e1].equals(arr2[e2])){
            e1--;
            e2--;
        }
        return s1>e1;
    }
}