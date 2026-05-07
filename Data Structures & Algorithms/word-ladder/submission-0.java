class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int beginIndex=wordList.size()-1;
        int endIndex=-1;
        for(int i=0;i<wordList.size();i++){
            if(endWord.equals(wordList.get(i))){
                endIndex=i;
            }
        }
        if(endIndex==-1||beginIndex==-1){
            return 0;
        }

        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i=0;i<wordList.size();i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<wordList.size();i++){
            for(int j=i;j<wordList.size();j++){
                if(isNextWord(wordList.get(i), wordList.get(j))){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        return bfs(graph,beginIndex,endIndex);
    }

    private int bfs(List<List<Integer>> graph, int i, int j){
        boolean[] visited=new boolean[graph.size()];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, 1});
        visited[i] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int dist = current[1];

            if (node == j) {
                return dist;
            }

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, dist + 1});
                }
            }
        }
        return 0;
    }

    private boolean isNextWord(String s1, String s2){
        int countDiff=0;
        for(int i=0; i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                countDiff++;
            }
        }
        return countDiff == 1;
    }
}
