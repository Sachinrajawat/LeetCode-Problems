class Solution {
public:
    vector<int> maximumBeauty(vector<vector<int>>& items, vector<int>& queries) {
        // Sort items based on price in ascending order
        sort(items.begin(), items.end());
        
        int maxBeauty = 0;
        unordered_map<int, int> beautyMap;
        vector<int> sortedQueries = queries;
        vector<int> result;
        
        // Sort queries in ascending order
        sort(sortedQueries.begin(), sortedQueries.end());
        
        int queryIndex = 0;
        
        // Traverse items and populate beauty map
        for (int price : sortedQueries) {
            while (queryIndex < items.size() && items[queryIndex][0] <= price) {
                maxBeauty = max(maxBeauty, items[queryIndex][1]);
                queryIndex++;
            }
            beautyMap[price] = maxBeauty;
        }
        
        // Prepare result based on original queries order
        for (int query : queries) {
            result.push_back(beautyMap[query]);
        }
        
        return result;
    }
};