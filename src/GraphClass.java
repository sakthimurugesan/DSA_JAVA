import java.util.*;

public class GraphClass {
    ArrayList<ArrayList<Integer>> obj= new ArrayList<ArrayList<Integer>>();

    GraphClass(int v)
    {
        for (int i = 0; i < v; i++) {
            ArrayList<Integer> obj=new ArrayList<>();
            this.obj.add(obj);
        }
    }

    void addEdges(int v,int u)
    {
        obj.get(u).add(v);
        obj.get(v).add(u);
    }

    void displayAdjList()
    {
        for (int i=0;i<obj.size();i++)
        {
            System.out.print(i);
            for(int j=0;j<obj.get(i).size();j++)
            {
                System.out.print("-->"+obj.get(i).get(j));
            }
            System.out.print("\n");
        }
    }

    void BFS(int ver)
    {
        System.out.println("Enter a vertex to start "+0+" to "+(obj.size()-1)+" : ");

        boolean visted[]=new boolean[obj.size()];
        Queue<Integer> qu=new LinkedList<>();
        qu.add(ver);
        while (!qu.isEmpty())
        {
            int vertex=qu.remove();
            if(visted[vertex])
            {
                continue;
            }
            visted[vertex]=true;
            System.out.print(vertex+" ");
            ArrayList<Integer> temp=obj.get(vertex);
            for (int i = 0; i < temp.size(); i++) {
                if(!visted[temp.get(i)])
                  qu.add(temp.get(i));
            }
        }
        System.out.println();
    }
    private void DFS(int vertex,boolean[] visited)
    {
        if(visited[vertex])
        {
            return;
        }
        visited[vertex]=true;
        System.out.print(vertex+" ");
        ArrayList<Integer> temp=obj.get(vertex);
        for (int i=0;i<temp.size();i++)
        {
            if(visited[temp.get(i)])continue;
            DFS(temp.get(i),visited);
        }
    }
    void DFS(int vertex)
    {
        boolean[] visited=new boolean[obj.size()];
        DFS(vertex,visited);
    }
    private GraphClass()
    {

    }

}
