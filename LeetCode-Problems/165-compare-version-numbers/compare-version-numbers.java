class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int i=0, j=0;
        while(i<v1.length && j<v2.length){
            int val1=Integer.parseInt(v1[i]);
            int val2=Integer.parseInt(v2[i]);
            // System.out.println(val1+" "+val2);
            if(val1>val2) return 1;
            else if(val1<val2) return -1;
            i++;
            j++;
        }
        while(i<v1.length){
            int val1=Integer.parseInt(v1[i]);
            if(val1>0) return 1;
            i++;
        }
        while(j<v2.length){
            int val2=Integer.parseInt(v2[j]);
            if(val2>0) return -1;
            j++;
        }
        return 0;
    }
}