import java.util.*;
class Solution {
    //[x,y,a,b]
    static int PILLAR=0;
    static int BEAM=1;
    static int CONSTRUCT=1;
    static int DESTRUCT=0;
    boolean pillars[][];
    boolean beams[][];
    int constructCnt=0;
    boolean isDestruct(int n){
        for(int i=1;i<n+2;i++){
            for(int j=1;j<n+2;j++){
                if(pillars[i][j] && !isConstructPillar(i,j)){
                    return false;
                }
                if(beams[i][j] && !isConstructBeam(i,j)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean isConstructPillar(int x,int y){
        return y==1 || beams[x-1][y] || beams[x][y]|| pillars[x][y-1];
    }
    boolean isConstructBeam(int x,int y){
        return pillars[x][y-1] || pillars[x+1][y-1] || (beams[x-1][y] && beams[x+1][y]);
    }

    public int[][] solution(int n, int[][] build_frame) {

        pillars=new boolean[n+3][n+3];
        beams=new boolean[n+3][n+3];

        for(int[] frame : build_frame){
            int x=frame[0]+1;
            int y=frame[1]+1;
            int a=frame[2];//기둥,보
            int b=frame[3];//설치,삭제

            if(b==CONSTRUCT){
                if(a==PILLAR && isConstructPillar(x,y)){
                    pillars[x][y]=true;
                    constructCnt++;
                }else if(a==BEAM && isConstructBeam(x,y)){
                    beams[x][y]=true;
                    constructCnt++;
                }
            }else if(b==DESTRUCT){
                if(a==PILLAR){
                    pillars[x][y]=false;
                }else if(a==BEAM){
                    beams[x][y]=false;
                }
                if(isDestruct(n)){
                    constructCnt--;
                    continue;
                }
                if(a==PILLAR){
                    pillars[x][y]=true;
                }else if(a==BEAM){
                    beams[x][y]=true;
                }
            }
        }
        int[][] answer=new int[constructCnt][3];
        int index=0;
        for(int i=1;i<n+2;i++){
            for(int j=1;j<n+2;j++){
                if(pillars[i][j]){
                    answer[index++]=new int[]{i-1,j-1,PILLAR};
                }
                if(beams[i][j]){
                    answer[index++]=new int[]{i-1,j-1,BEAM};
                }
            }
        }
        return answer;
    }
}

