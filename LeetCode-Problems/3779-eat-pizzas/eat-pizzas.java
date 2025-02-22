class Solution {
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        int n=pizzas.length;
        long totalWeight=0;
        int days=n/4;
        
        int evenDays=days/2;
        int oddDays=days-evenDays;
        n--;
        System.out.println(oddDays+" "+evenDays);
        for (int day=1; day<=oddDays; day++) {
            totalWeight+=pizzas[n];
            n--;
        }
        for (int day=1; day<=evenDays; day++) {
            totalWeight+=pizzas[n-1];
            n-=2;
        }
        return totalWeight;
    }
}