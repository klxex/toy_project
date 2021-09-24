import java.io.BufferedReader;
import java.util.*;
import java.io.InputStreamReader;


class Main{

    static int sum=0;
    static int ans[]=new int[7];
    static int a[]=new int[9];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int index=1;
        int num=1;
        int count=0;

        int a[]=new int[1001];
        while(index<=1000){
                a[index++]=num;
                count++;
                if(count==num){
                    count=0;
                    num++;
                }
        }
        int sum=0;
        for(int i=start;i<=end;i++){
            sum+=a[i];
        }
        System.out.println(sum);


   }



}