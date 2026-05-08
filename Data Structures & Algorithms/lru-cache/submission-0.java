class LRUCache {
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache = new HashMap<Integer,Node>();
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node != null){
            removeNode(node);
            addFirst(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node=cache.get(key);
        if(node==null){
            node=new Node(key, value);  
            cache.put(key, node);
        } else{
            node.value=value;
            removeNode(node);
        }
                  
        addFirst(node);
        if(cache.size()>capacity){
            Node last=removeLast();
            cache.remove(last.key);
        }
    }

    private void addFirst(Node node){
        if(head==null){
            head=node;
            tail=node;
        } else if(head!=node){
            head.prev=node;
            node.next=head;
            head=node;
        }
    }

    private Node removeLast(){
        if(tail==null){
            return null;
        }      
        Node node=tail;
        if(head==tail){      
            head=null;
            tail=null;
            return node;
        }
        Node prev= node.prev;
        tail=prev;
        tail.next=null;
        
        node.prev=null;
        node.next=null;
        return node;
    }

    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        if(head==tail){
            head=null;
            tail=null;
        } else if(head==node){
            head=next;
            next.prev=null;
        } else if(tail==node){
            tail=prev;
            prev.next=null;
        } else{
            prev.next=next;
            next.prev=prev;
        }
        node.prev=null;
        node.next=null;
    }


    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
