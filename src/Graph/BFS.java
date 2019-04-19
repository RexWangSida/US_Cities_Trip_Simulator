package Graph;

public class BFS {
	private boolean[] marked;
    private int[] edgeTo;
    private final int s;
   public BFS(CityGraph G, int s) {
	   this.s = s;
       marked = new boolean[G.V()];
       edgeTo = new int[G.V()];
       bfs(G, s);
   }
   
   private void bfs(CityGraph G, int s) {
       Queue<Integer> q = new Queue<Integer>();
       marked[s] = true;
       q.enqueue(s);
       while (!q.isEmpty()) {
           int v = q.dequeue();
           for (int w : G.adj(v)) {
               if (!marked[w]) {
                   edgeTo[w] = v;
                   marked[w] = true;
                   q.enqueue(w);
               }
           }
       }
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
