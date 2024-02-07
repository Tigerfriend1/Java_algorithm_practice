import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int maxE=0;
        for(int[] edge:edges){
            maxE=Math.max(maxE,edge[0]);
            maxE=Math.max(maxE,edge[1]);
        }
        System.out.println("maxE: "+maxE);
        int n = maxE;
        int in[] = new int[n+2];
        int out[] = new int[n+2];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int[] edge:edges){
            in[edge[1]]++;
            out[edge[0]]++;
            graph.get(edge[0]).add(edge[1]);
        }
        int newV=0;
        for(int i=1;i<n+1;i++){
            if(in[i]==0 && out[i]>=2){
                newV=i;

            }
        }

        for(int i=0;i<out[newV];i++){
            in[graph.get(newV).get(i)]--;
            //System.out.println(graph.get(newV).get(i));
        }
//        for(int i=0;i<graph.size();i++){
//            System.out.print("정점"+(i+1)+"의 인접리스트"+in[i+1]+" "+out[i+1]);
//            for(int j=0;j<graph.get(i).size();j++){
//                System.out.println("->"+graph.get(i).get(j));
//            }
//            System.out.println();
//        }

        int stick=0;
        int dount=0;
        int eight=0;
        for(int i=1;i<n+1;i++){
            if(out[i]==0){
                //System.out.println("Stick: "+i);
                stick++;
            }
            if(in[i]==2 && out[i]==2){
                //System.out.println("eight: "+i);
                eight++;
            }

        }
        dount = out[newV]-stick-eight;
        int[] answer={newV,dount,stick,eight};
        return answer;
    }
}