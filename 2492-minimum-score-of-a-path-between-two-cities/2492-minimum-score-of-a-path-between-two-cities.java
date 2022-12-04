class Solution {
    public int minScore(int n, int[][] roads) {
        
        Map<Integer, List<int[]>> graph=new HashMap<>();
       for(int[] r:roads)
        {
            graph.putIfAbsent(r[0],new ArrayList<>());
            graph.get(r[0]).add(new int[]{r[1],r[2]});
             graph.putIfAbsent(r[1],new ArrayList<>());
            graph.get(r[1]).add(new int[]{r[0],r[2]});
        }
        //dfs(graph,1,visited,Integer.MAX_VALUE,n);
        djt(1,graph,n);
        
        return min;
        
    }
    
    private void djt(int p,Map<Integer,List<int[]>> graph,int n)
    {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[1]-b[1]));
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.offer(new int[]{p,1});
        while(!pq.isEmpty())
        {
            int[] current=pq.poll();
            for(int[] next:graph.get(current[0]))
            {
                if(next[1]<dist[next[0]])
                {
                    dist[next[0]]=next[1];
                    pq.add(new int[]{next[0],next[1]});
                }
            }
        }
        
        for(int i=1;i<=n;i++)
        {
            min=Math.min(min,dist[i]);
        }
        
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
            if(!graph.containsKey(current)) continue;
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