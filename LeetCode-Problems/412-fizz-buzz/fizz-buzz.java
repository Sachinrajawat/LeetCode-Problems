class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            if((i+1)%3==0 && (i+1)%5==0) l.add("FizzBuzz");
            else if((i+1)%3==0) l.add("Fizz");
            else if((i+1)%5==0) l.add("Buzz");
            else{
                int x=i+1;
                l.add(String.valueOf(x));
            }
        }
        return l;
    }
}