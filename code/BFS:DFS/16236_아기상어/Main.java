import java.util.*;
public class Main {
    //좌표와 거리를 함께 큐에 넣음. {x,y,dist}
    //현재 상어위치와 최단거리를 먼저 큐에서 뽑는다. 
    //그렇게 만난 상어보다 작은 물고기는 가장가까이에 있는 물고기다.
    //이후 visited초기화, pq를 비운다.
    static int N,M,answer;
    static int size=2;
    static int[][] map;
    static int[] dx = {-1,0,0,1};//북서동남 pq쓸거라 상관없음.
    static int[] dy = {0,-1,1,0};
    public static void main(String[] arg){
        answer=0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map=new int[N][N];
        int x=0;
        int y=0;
        for (int i=0; i<N;i++){
            for(int j=0; j<N;j++){
                map[i][j]=sc.nextInt();
                //상어 위치 저장 및 0으로 초기화
                if(map[i][j]==9){
                    x=i;
                    y=j;
                    map[i][j]=0;
                }
            }
        }
        // PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
        //     @Override
        //     public int compare(int[] o1, int[] o2){
        //         if(o1[2]==o2[2]){//dist같으면
        //             if(o1[0]==o2[0]){ //위 아래도 같으면
        //                 return o1[1]-o2[1]; //왼쪽기준 정렬
        //             }
        //             return o1[0]-o2[0];//북쪽 기준정렬
        //         }
        //         return o1[2]-o2[2];
        //     }
        // });
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1,i2)->{
            if(i1[2]==i2[2]){
                if(i1[0]==i2[0]){
                    return i1[1]-i2[1];
                }
                return i1[0]-i2[0];
            }
            return i1[2]-i2[2];
        });
        
        pq.offer(new int[]{x,y,0});
        int cnt=0;
        boolean[][] visited=new boolean[N][N];
        visited[x][y]=true;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            //먹을수 있으면 먹은 후 위치 및 pq초기화
            if(map[now[0]][now[1]]!=0 && map[now[0]][now[1]]<size){ 
                answer+=now[2];
                cnt++;
                map[now[0]][now[1]]=0;
                if(cnt==size){
                    size++;
                    cnt=0;
                }
                visited=new boolean[N][N];
                pq.clear();
                pq.offer(new int[]{now[0],now[1],0});
                continue;
            }

            //먹을수없으면 4방향 검사 후 이동가능한 위치 pq에 offer
            for(int i=0;i<4;i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]<=size && !visited[nx][ny] ){
                    visited[nx][ny]=true;
                    pq.offer(new int[]{nx,ny,now[2]+1});
                }
            }
        }
    
        System.out.println(answer);

    }
}
