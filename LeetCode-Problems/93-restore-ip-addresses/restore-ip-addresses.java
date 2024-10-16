class Solution {
    public void address(List<String> list,StringBuilder sb,int idx,int count){
        
        if(count==3){
            String[] charArray=sb.toString().split("\\.");
            
            boolean a=true;
            for(int i=0;i<charArray.length;i++){
                if(charArray[i].length()>0){
                    int x=Integer.parseInt(charArray[i]);
                    if(x<0||x>255) a=false;
                }

                if( (charArray[i].length()>1 && charArray[i].charAt(0)=='0') ||charArray[i].length()>3  || charArray[i].length()==0 ){
                    a=false;
                    break;
                }
            }
            if(a) list.add(sb.toString());
            return;
        }
        if(idx>sb.length()) return;
        for(int i=idx;i<idx+3;i++){
            if(i>=sb.length()) break;
            sb.insert(i,'.');
            count++;
            address(list,sb,i+2,count);
            count--;
            sb.deleteCharAt(i);
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> list=new ArrayList<>();
        if(s.length()>12 || s.length()<4) return list;
        StringBuilder sb=new StringBuilder(s);
        address(list,sb,1,0);
        return list;
    }
}