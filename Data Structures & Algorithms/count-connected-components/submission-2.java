class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent=new int[n];

        for(int i=0; i<n; i++){
            parent[i]=i;
        }

        for(int[] e:edges){
            union(parent,e[0],e[1]);
        }

        int count=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i){
                count++;
            }
        } 
        return count;       
    }

    private void union(int[] parent, int i, int j){
        int rootI = find(parent, i);
        int rootJ = find(parent, j);

        if(rootI != rootJ){
            parent[rootI] = rootJ;
        }
    }

    private int find(int[] parent, int value){
        while(parent[value]!=value){
            value=parent[value];
        }
        return value;
    }
}
