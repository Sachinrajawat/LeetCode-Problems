class Solution {
    public static int findGCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public String fractionAddition(String expression) {
        String[] nums = expression.split("/|(?=[-+])");
        int deno = 1;
        for (int i = 1; i < nums.length; i += 2) {
            deno *= Integer.parseInt(nums[i]);
        }
        int nume = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            nume += Integer.parseInt(nums[i]) * (deno / Integer.parseInt(nums[i + 1]));
        }

        int gcd = findGCD(nume, deno);
        if (gcd < 0)
            gcd *= -1;
        nume /= gcd;
        deno /= gcd;

        String ans = "";
        ans = String.valueOf(nume) + '/' + String.valueOf(deno);
        return ans;
    }
}