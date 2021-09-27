import java.io.BufferedReader;
import java.lang.reflect.Method;
import java.util.*;
import java.io.InputStreamReader;


class Main{

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int a[]=new int[n];

        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int dp[][]=new int[n][k+1];

        /** 0 1 2 3 4 5 6 7 8 9 10
         *  0 1 1 1 1 1 1 1 1 1 1
         *  1 0 1 1 2
         *  2
         **/

        for(int j=0;j<k+1;j++){
            if(j-a[0]>=0){
                if(j%a[0]==0){
                    dp[0][j]=1;
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<k+1;j++){
                if((j-a[i])>0){
                    dp[i][j]=dp[i][j-a[i]]+dp[i-1][j];
                }
                else if(j-a[i]==0){
                    dp[i][j]=1+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }

            }
        }

        System.out.println(dp[n-1][k]);


    }





}