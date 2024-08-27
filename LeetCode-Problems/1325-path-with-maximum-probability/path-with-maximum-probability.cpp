

class Solution {
public:
    double maxProbability(int n, std::vector<std::vector<int>>& edges,
                          std::vector<double>& succProb, int start, int end) {
        std::unordered_map<int, std::vector<std::pair<int, int>>> graph;
        for (int i = 0; i < edges.size(); i++) {
            int u = edges[i][0], v = edges[i][1], edgeIdx = i;
            graph[u].push_back({v, edgeIdx});
            graph[v].push_back({u, edgeIdx});
        }
        std::vector<double> probabilities(n, 0.0);
        probabilities[start] = 1.0;
        std::priority_queue<std::pair<double, int>> nodesToExplore;
        nodesToExplore.push({1.0, start});
        while (!nodesToExplore.empty()) {
            auto topNode = nodesToExplore.top();
            double prob = topNode.first;
            int u = topNode.second;
            nodesToExplore.pop();
            if (u == end)
                return prob;
            if (probabilities[u] > prob)
                continue;
            for (auto neighbor : graph[u]) {
                int v = neighbor.first;
                int edgeIdx = neighbor.second;
                double newProb = prob * succProb[edgeIdx];
                if (newProb > probabilities[v]) {
                    probabilities[v] = newProb;
                    nodesToExplore.push({newProb, v});
                }
            }
        }
        return 0.0;
    }
};

void testMaxProbability() {
    Solution sol;

    // Example 1
    int n1 = 3;
    std::vector<std::vector<int>> edges1 = {{0, 1}, {1, 2}, {0, 2}};
    std::vector<double> succProb1 = {0.5, 0.5, 0.2};
    int start1 = 0, end1 = 2;
    std::cout << "Example 1 - Output: "
              << sol.maxProbability(n1, edges1, succProb1, start1, end1)
              << std::endl;

    // Example 2
    int n2 = 3;
    std::vector<std::vector<int>> edges2 = {{0, 1}, {1, 2}, {0, 2}};
    std::vector<double> succProb2 = {0.5, 0.5, 0.3};
    int start2 = 0, end2 = 2;
    std::cout << "Example 2 - Output: "
              << sol.maxProbability(n2, edges2, succProb2, start2, end2)
              << std::endl;

    // Example 3
    int n3 = 3;
    std::vector<std::vector<int>> edges3 = {{0, 1}};
    std::vector<double> succProb3 = {0.5};
    int start3 = 0, end3 = 2;
    std::cout << "Example 3 - Output: "
              << sol.maxProbability(n3, edges3, succProb3, start3, end3)
              << std::endl;
}

