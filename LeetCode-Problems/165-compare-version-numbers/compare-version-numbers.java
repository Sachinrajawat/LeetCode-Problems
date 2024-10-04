class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1=version1.split("\\.");
        String[] ver2=version2.split("\\.");
        for(int i=0;i<Math.min(ver1.length,ver2.length);i++){
            int v1=Integer.parseInt(ver1[i]);
            int v2=Integer.parseInt(ver2[i]);
            if(v1<v2) return -1;
            else if(v1>v2) return 1;
        }
        if(ver1.length>ver2.length){
            for(int i=ver2.length;i<ver1.length;i++)
                if(Integer.parseInt(ver1[i])>0) return 1;
        }
        else if(ver1.length<ver2.length){
            for(int i=ver1.length;i<ver2.length;i++)
                if(Integer.parseInt(ver2[i])>0) return -1;
        }
        return 0;
    }
}