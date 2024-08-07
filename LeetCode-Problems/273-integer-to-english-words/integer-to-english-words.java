class Solution {
    String one_ninety(int num){  //taking number less than 100 and converting into words
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
    String hundred(int num){ //taking number less than 1000 and converting into words
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
        
        if(num==0) return "Zero";
        String ans="";
        int i=0;
        while(num!=0){
            if(i==0){ //if num is only 3 digit number
                ans+=hundred(num%1000);//converting last three digit into words
            }
            else if(i==1){ //if num more than 3 digit number
                if(ans.length()>=8 &&ans.substring(0,8).equals(" Hundred")){ 
                    ans=ans.substring(9,ans.length());//if in ans Hundred comes after the Thousand then remove Hundred from ans
                }
                ans=hundred(num%1000)+" Thousand "+ans;
            }
            else if(i==2){ //if num more than 6 digit number
                System.out.println(ans);
                if(ans.length()>=9 &&ans.substring(0,9).equals(" Thousand")){
                    ans=ans.substring(10,ans.length());//if in ans Thousand comes after the Million then remove Hundred from ans
                }
                ans=hundred(num%1000)+" Million "+ans;
            }
            else{ //if num more than 9 digit number
                if(ans.length()>=8 && ans.substring(0,8).equals(" Million")){ //if in ans Million comes after the Thousand then remove Billion from ans
                    ans=ans.substring(9,ans.length());
                }
                ans=hundred(num%1000)+" Billion "+ans;
            }
            String str=Integer.toString(num);
            if(str.length()>3){//deleting the last three digit from number
                String subStr=str.substring(0,str.length()-3);
                num=Integer.parseInt(subStr);
            }
            else num=0;
            i++;
        }
        ans=ans.trim(); //removing the extra spaces from the end & starting if any
        String[] word=ans.split("\\s+"); //removing the extra spaces from the ans if any
        ans=String.join(" ",word);
        return ans;
    }
}