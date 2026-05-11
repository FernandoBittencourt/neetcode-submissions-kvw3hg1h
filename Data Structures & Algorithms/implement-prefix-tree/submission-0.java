class PrefixTree {
    Node root;

    public PrefixTree() {
         root=new Node();
    }

    public void insert(String word) {
        Node current = root;
        for(int i=0; i<word.length();i++){
            char c = word.charAt(i);
            current.nodes.putIfAbsent(c, new Node());
            current=current.nodes.get(c);
        }
        current.isFinished=true;
    }

    public boolean search(String word) {
        Node current = root;
        for(int i=0; i<word.length();i++){
            char c = word.charAt(i);
            if(!current.nodes.containsKey(c)){
                return false;
            }
            current=current.nodes.get(c);
        }
        return current.isFinished;
    }

    public boolean startsWith(String prefix) {
        Node current = root;
        for(int i=0; i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(!current.nodes.containsKey(c)){
                return false;
            }
            current=current.nodes.get(c);
        }
        return true;
    }

    class Node{
        public Map<Character,Node> nodes;
        public boolean isFinished;

        public Node(){
            nodes=new HashMap<Character,Node>();
        }

    }
}
