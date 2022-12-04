class Solution {
    public int minScore(int n, int[][] roads) {
        
        Map<Integer, List<int[]>> graph=new HashMap<>();
        buildGraph(roads,graph);
        boolean[] visited=new boolean[n+1];
        //dfs(graph,1,visited,Integer.MAX_VALUE,n);
        bfs(1,graph,n);
        
        return min;
        
    }
    
    private void bfs(int p,Map<Integer,List<int[]>> graph,int n)
    {
        boolean[] visited=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.offer(p);
        while(!q.isEmpty())
        {
            int current=q.poll();
            visited[current]=true;
            for(int[] next:graph.get(current))
            {
                if(!visited[next[0]])
                {
                    min=Math.min(min,next[1]);
                    q.offer(next[0]);
                }

            }
        }
    }
    
    int min=Integer.MAX_VALUE;
    //boolean connected=false;
    
    private void dfs(Map<Integer,List<int[]>> graph,int p,boolean[] visited,int currentMin,int n)
    {
       
        if(visited[p]) return;
        visited[p]=true;
        if(graph.containsKey(p))
            for(int[] next:graph.get(p))
            {
                dfs(graph,next[0],visited,min=Math.min(min,next[1]),n);
            }
        visited[p]=false;
       
    }
    
    private void buildGraph(int[][] roads,Map<Integer,List<int[]>> graph)
    {
        for(int[] r:roads)
        {
            graph.putIfAbsent(r[0],new ArrayList<>());
            graph.get(r[0]).add(new int[]{r[1],r[2]});
             graph.putIfAbsent(r[1],new ArrayList<>());
            graph.get(r[1]).add(new int[]{r[0],r[2]});
        }
    }
}