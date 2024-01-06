//주어진 배열이 충분한 시간이 흐른 후의 모습(0은 empty, 1은 블록)
//단, 블록은 시간의 흐름에 따라 위에서 아래로 이동하며, 블록2는 네 방향으로 1번 블록을 붙잡는다.
public class Main {
    public static void main(String[] args) {
        int[][] map = {
                {0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 0, 2, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        int h = map.length;
        int w = map[0].length;
        for(int j=0; j<w; j++){
            for(int i=h-1; i>=0; i--){
                if(map[i][j]==1){
                    int next=i;
                    while(map[next+1][j]!=1 && !isTwo(map,next,j)) {
                        map[next][j]=0;
                        map[next+1][j]=1;
                        next=next+1;
                        if(next>=h-1){ //만약 배열의 크기를 초과하면(현재 검사가 밑바닥이면) 탈출
                            break;
                        }
                    }
                }
            }
        }
        for(int i=0; i<h;i++){
            for(int j=0;j<w;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    public static boolean isTwo(int[][] map, int x, int y){
        int h = map.length;
        int w = map[0].length;
        int[] dx={1,-1,0,0};
        int[] dy={0,0,-1,1};
        for(int k=0; k<4; k++){
            int nx = x+dx[k];
            int ny = y+dy[k];
            if(nx<h && nx>=0 && ny<w && ny>=0 && map[nx][ny]==2){
                return true;
            }
        }
        return false;

    }
}