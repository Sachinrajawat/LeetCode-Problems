class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> charStack=new Stack<>();
        Stack<Integer> index=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')' || s.charAt(i)=='('){
                if(charStack.isEmpty()){
                    charStack.push(s.charAt(i));
                    index.push(i);
                }
                else if(s.charAt(i)==')' &&charStack.peek()=='('){
                    charStack.pop();
                    index.pop();
                }
                else{
                    charStack.push(s.charAt(i));
                    index.push(i);
                }
            }
        }
        System.out.println(charStack+" "+index);
        StringBuilder sb=new StringBuilder(s);
        while(!index.isEmpty()){
            sb.deleteCharAt(index.pop());
        }
        return sb.toString();

    }
}