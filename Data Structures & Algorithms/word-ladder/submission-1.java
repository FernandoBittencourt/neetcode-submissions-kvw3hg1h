class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }

        HashMap<String,List<String>> pattern = new HashMap<String,List<String>>();
        for(String word:wordList){
            char[] wordChar = word.toCharArray();
            for(int i=0;i< wordChar.length;i++){
                char temp = wordChar[i];
                wordChar[i]='*';
                String hash=new String(wordChar);
                wordChar[i]=temp;
                pattern.computeIfAbsent(hash, k -> new ArrayList<>()).add(word);
            }
        }

        return bfs(pattern, beginWord, endWord);
    }

    private int bfs(HashMap<String,List<String>> pattern, String begin, String end){
        HashSet<String> visited=new HashSet<String>();
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(begin, 1));
        visited.add(begin);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String word = current.word;
            int dist = current.dist;

            if (word.equals(end)) {
                return dist;
            }
            
            char[] wordChar = word.toCharArray();

            for (int i = 0; i < wordChar.length; i++) {

                char temp = wordChar[i];

                wordChar[i] = '*';

                String hash = new String(wordChar);

                wordChar[i] = temp;

                List<String> neighbors =
                    pattern.getOrDefault(hash, new ArrayList<>());

                for (String nextWord : neighbors) {

                    if (!visited.contains(nextWord)) {

                        visited.add(nextWord);

                        queue.add(new Pair(nextWord, dist + 1));
                    }
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

    private class Pair {
        public String word;
        public int dist;

        public Pair(String word, int dist){
            this.word=word;
            this.dist=dist;
        }
    }
}
