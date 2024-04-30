
import java.util.*;
public class Main {
  static int N,M,r,c,d,answer;
  static int[][] map;
  static int[] dx = {-1,0,1,0};//북,동,남,서 //시계방향
  static int[] dy = {0,1,0,-1};
  public static void main(String[] args) {
    answer=0;
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    map = new int[N][M];
    r=sc.nextInt();
    c=sc.nextInt();
    d=sc.nextInt();

    for(int i = 0; i<N; i++){
      for(int j=0; j<M; j++){
        map[i][j]=sc.nextInt();
      }
    }
    Integer[] robot = {r,c,d};
    ArrayDeque<Integer[]> dq = new ArrayDeque<>();
    dq.offer(robot);

    //현재 BFS로 탐색한다.
    while(!dq.isEmpty()){
      Integer[] now = dq.pollFirst();
      r=now[0];
      c=now[1];
      d=now[2];
      //1)현재칸 청소x -> 청소
      if(map[r][c]==0){
        answer++;
        map[r][c]=2; //2는 청소완료 의미
      }
      int flag = 0;//4방향 중 청소안한 곳 찾기
      for(int i=0;i<4;i++){
        //반시계로 90도씩 4번 돌림
        int nd = (d+3-i)%4;
        int nx = r+dx[nd];
        int ny = c+dy[nd];
        //청소할 빈칸이 있으면 전진
        if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==0){
          //갈수있으면
          Integer[] next = {nx,ny,nd};
          dq.offer(next);
          flag=1;
          break;
        }
        //갈수없으면 4방향 모두 확인하고 뒤로 후진
      }
      if(flag==0){
        int bx=r+dx[(d+2)%4];
        int by=c+dy[(d+2)%4];
        //int bd=(d+2)%4; <-- 불필요한 부분 삭제
        if(bx>=0 && bx<N && by>=0 && by<M && map[bx][by]!=1){
          Integer[] next={bx,by,d};
          dq.offer(next);
          continue;
        }
        break;
      }
      
    }
    System.out.println(answer);
  }

}