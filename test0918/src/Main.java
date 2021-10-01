import java.io.BufferedReader;
import java.lang.reflect.Method;
import java.util.*;
import java.io.InputStreamReader;


class Main{
    public static int directions[][]={{0,1},{0,-1},{1,0},{-1,0}};
    static int answer=1000000000;
    static int nested=0;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int  k = Integer.parseInt(st.nextToken());
        int visited[]=new int[100001];
        bfs(n,k,visited);


    }

    static class Node implements Comparable<Node>{
        int pos;

        public Node(int pos, int dist) {
            this.pos = pos;
            this.dist = dist;
        }

        int dist;

        public int compareTo(Node o){
            return this.dist-o.dist;
        }

    }
// 5~17
    public static void bfs(int n,int k,int visited[]){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(n, 0));
        for(int i=0;i<visited.length;i++){
            visited[i]=-1;
        }
        visited[n]=0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int next_pos=0;
            int next_dist=0;

            if(node.pos==k){
                System.out.println(node.dist);
                break;
            }

            for(int i=0;i<3;i++){
                if(i==0){
                    next_pos=node.pos+1;
                    next_dist=node.dist+1;
                }
                else if(i==1){
                    next_pos=node.pos-1;
                    next_dist=node.dist+1;
                }
                else{
                    next_pos=node.pos*2;
                    next_dist=node.dist;
                }

                if(next_pos>=0 && next_pos<=100000 && (visited[next_pos]==-1 || visited[next_pos]>next_dist)){
                    visited[next_pos]=next_dist;
                    pq.add(new Node(next_pos, next_dist));
                }
            }



        }




    }

}