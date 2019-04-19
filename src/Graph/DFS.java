package Graph;

public class DFS {
	 private boolean[] marked;
	 private int count;
	 private int[] edgeTo;
	 private int s;
	 
	    public DFS(CityGraph G, int s) {
	    	
	        marked = new boolean[G.V()];
	        edgeTo = new int[G.V()];
	        this.s = s;
	        dfs(G, s);
	    }
	    
	    private void dfs(CityGraph G, int v) {
	        count++;
	        marked[v] = true;
	        for (int w : G.adj(v)) {
	            if (!marked[w]) {
	            	edgeTo[w] = v;
	                dfs(G, w);
	            }
	        }
	    }
	    
	    public boolean marked(int v) {
	        return marked[v];
	    }
	    public int count() {
	        return count;
	    }
	    public boolean hasPathTo(int v) {
	    	return marked[v];
	    }
	    public Iterable <Integer> pathTo(int v){
	    	if(!hasPathTo(v)) return null;
	    	Stack<Integer> path = new Stack<Integer>();
	    	for(int x = v; x !=s; x = edgeTo[x])
	    		path.push(x);
	    	path.push(s);
	    	return path;
	    }
}
