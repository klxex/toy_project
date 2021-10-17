import java.io.BufferedReader;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.InputStreamReader;


class Main {
    static LinkedList<Integer> deque[];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String splits[];
        deque = new LinkedList[5];

        for(int i=1;i<5;i++){
            deque[i] = new LinkedList<>();
        }

        for(int i=1;i<5;i++){
            splits = br.readLine().split("");
            for(int j=0;j<8;j++){
                deque[i].add(Integer.parseInt(splits[j]));
            }
        }

        int n=Integer.parseInt(br.readLine());




        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            rotate(num,dir);
        }

        int ans=0;
        for(int i=1;i<5;i++){
            ans+=Math.pow(2,i-1)*deque[i].peek();
        }
        System.out.println(ans);
    }

    public static void rotate(int num,int dir){

        //num회전 dir 방향

        int valid[]=new int[5];
        //left
        int dir_1=dir;
        for(int i=num-1;i>0;i--){
            if(deque[i+1].get(6)!=deque[i].get(2)){
                dir_1*=-1;
                valid[i]=dir_1;
            }
            else{
                break;
            }
        }
        //right
        int dir_2=dir;
        for(int i=num+1;i<5;i++){
            if(deque[i-1].get(2)!=deque[i].get(6)){
                dir_2*=-1;
                valid[i]=dir_2;
            }
            else{
                break;
            }
        }

        for(int i=1;i<5;i++){
            if(valid[i]!=0){
                spin(i,valid[i]);
            }
            else if(i==num){
                spin(i,dir);
            }
        }
    }

    public static void spin(int num,int dir){
        if(dir==1){
            deque[num].addFirst(deque[num].removeLast());
        }
        else{
            deque[num].addLast(deque[num].removeFirst());
        }
    }

}



