class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list=new ArrayList<>();
        // list.add("Science  is  what we");
        // list.add("understand      well");
        // list.add("enough to explain to");
        // list.add("a  computer.  Art is");
        // list.add("everything  else  we");
        // list.add("do                  ");
        int i=0;
        while(i<words.length){
            int k=i,width=0,word=0;
            while(k<words.length && width+words[k].length()<=maxWidth){
                width+=words[k].length()+1;
                word++;
                k++;
            }
            
            width--;
            System.out.println(width+" "+word);
            if(i+word<=words.length-1){
            int space=1;
            if(word>1){
                space+=(maxWidth-width)/(word-1);
                width=(maxWidth-width)%(word-1);
            }
            else{
                space+=(maxWidth-width)-1;
                width=0;
            }
            System.out.println(space+" "+width);
            String s="";
            for(int j=0;j<word;j++){
                s+=words[i+j];
                if(j<word-1 || word==1){
                        for(int l=0;l<space;l++){
                        s+=" ";
                    }
                }
                if(width>0){
                    s+= " ";
                    width--;
                }
            }
            list.add(s);
            }
            else{
                
                String s="";
                k=0;
                while(i+k<words.length){
                    s+=words[i+k];
                    if(i+k<words.length-1) s+=" ";
                    // count+=words[i+k].length();
                    k++;
                }
                System.out.println(s);
                int count=s.length();
                while(count<maxWidth){
                    s+=" ";
                    count++;
                }
                list.add(s);
            }
            i+=word;
        }
        return list;
    }
}