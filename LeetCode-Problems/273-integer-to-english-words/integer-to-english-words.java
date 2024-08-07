class Solution {
    String one_ninety(int num){  
        if(num==1) return "One";
        else if(num==2) return "Two";
        else if(num==3) return "Three";
        else if(num==4) return "Four";
        else if(num==5) return "Five";
        else if(num==6) return "Six";
        else if(num==7) return "Seven";
        else if(num==8) return "Eight";
        else if(num==9) return "Nine";
        else if(num==10) return "Ten";
        else if(num==11) return "Eleven";
        else if(num==12) return "Twelve";
        else if(num==13) return "Thirteen";
        else if(num==14) return "Fourteen";
        else if(num==15) return "Fifteen";
        else if(num==16) return "Sixteen";
        else if(num==17) return "Seventeen";
        else if(num==18) return "Eighteen";
        else if(num==19) return "Nineteen";
        else if(num==20) return "Twenty";
        else if(num==30) return "Thirty";
        else if(num==40) return "Forty";
        else if(num==50) return "Fifty";
        else if(num==60) return "Sixty";
        else if(num==70) return "Seventy";
        else if(num==80) return "Eighty";
        else if(num==90) return "Ninety";
        return "";
    }
    String hundred(int num){ //
        String ans="";
        while(num!=0){
            if(num>=100){
                ans+=one_ninety(num/100)+" Hundred ";
                num-=(num/100)*100;
            }
            else if(num>=20){
                ans+=one_ninety((num)-(num%10))+" ";
                num%=10;
            }
            else{
                ans+=one_ninety(num);
                num=0;
            }
        }
        return ans;
    }
    public String numberToWords(int num) {
        String ans="";
        if(num==0) ans="Zero";
        else{
        int i=0;
        while(num!=0){
            if(i==0){
                ans+=hundred(num%1000);
            }
            else if(i==1){
                if(ans.length()>=8 &&ans.substring(0,8).equals(" Hundred")){
                    ans=ans.substring(9,ans.length());
                }
                ans=hundred(num%1000)+" Thousand "+ans;
            }
            else if(i==2){
                System.out.println(ans);
                if(ans.length()>=9 &&ans.substring(0,9).equals(" Thousand")){
                    ans=ans.substring(10,ans.length());
                }
                ans=hundred(num%1000)+" Million "+ans;
            }
            else{
                if(ans.length()>=8 && ans.substring(0,8).equals(" Million")){
                    ans=ans.substring(9,ans.length());
                }
                ans=hundred(num%1000)+" Billion "+ans;
            }
            String str=Integer.toString(num);
            if(str.length()>3){
                String subStr=str.substring(0,str.length()-3);
                num=Integer.parseInt(subStr);
            }
            else num=0;
            i++;
        }
        }
        ans=ans.trim();
        String[] word=ans.split("\\s+");
        ans=String.join(" ",word);
        return ans;
    }
}