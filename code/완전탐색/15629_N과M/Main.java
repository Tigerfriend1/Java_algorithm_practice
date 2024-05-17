import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<int[]> output = new ArrayList<>();
    static public void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());;
        // Scanner scanner = new Scanner(System.in);
        // int N = scanner.nextInt(); //1~N개 중 M만큼 뽑음.
        // int M = scanner.nextInt();
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        int[] temp = new int[M];
        for(int i=0;i<N;i++){
            arr[i]=i+1;
        }
        

        dfs(arr, temp, visited, 0, N, M);
        //System.out.println(output);
        for(int[] a : output){
            for(int b : a){
                System.out.print(b+" ");
            }
            System.out.println();
        }

    }
    static public void dfs(int[] arr, int[] temp, boolean[] visited, int depth, int n, int r){
        if(depth==r){
            output.add(temp.clone());
            return;
        }
        for(int i =0; i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                temp[depth]=arr[i];
                dfs(arr, temp, visited, depth+1, n, r);
                visited[i]=false;
            }
        }

    }
}
