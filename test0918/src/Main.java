import java.io.BufferedReader;
import java.lang.reflect.Method;
import java.util.*;
import java.io.InputStreamReader;


class Main{



    public final static int MAX=100001;
    static int costs=-1;
    static Vector<Integer> router=new Vector<>();
    public static void main(String args[]) throws Exception {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st=new StringTokenizer(br.readLine());

       int n=Integer.parseInt(st.nextToken());
       int k=Integer.parseInt(st.nextToken());

        bfs(n,k);

    }


    public static void bfs(int n,int k){

        int visited[]=new int[MAX];
        int parent[]=new int[MAX];
        Queue<Integer[]> queue = new LinkedList<>();

        for(int i=0;i<MAX;i++){
            visited[i]=-1;
        }
        visited[n]=0;
        parent[n]=n;
        queue.add(new Integer[]{n,0});

        while(!queue.isEmpty()){
            Integer[] node = queue.poll();
            int next=0;
            for(int i=0;i<3;i++){
                if(i==0){
                    next=node[0]+1;
                }
                else if(i==1){
                    next=node[0]-1;
                }
                else{
                    next=node[0]*2;
                }

                if(next<0 || MAX<=next){
                    continue;
                }

                if(visited[next]==-1 || visited[next]>(node[1]+1)){
                    visited[next]=node[1]+1;
                    parent[next]=node[0];
                    queue.add(new Integer[]{next,node[1]+1});
                }


            }



        }

        Stack<Integer> stack=new Stack<>();
        int x=k;

        while(true){
            if(parent[x]==x){
                stack.add(x);
                break;
            }
            else{
                stack.add(x);
                x=parent[x];
            }
        }
        System.out.println(visited[k]);
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }

    }





}