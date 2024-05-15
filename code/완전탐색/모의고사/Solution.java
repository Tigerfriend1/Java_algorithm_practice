package code.완전탐색.모의고사;

import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{2,1,2,3,2,4,2,5};
        int[] c = new int[]{3,3,1,1,2,2,4,4,5,5};
        int al = 5;
        int bl = 8;
        int cl = 10;
        int[] score = new int[3];
        
        for(int i=0;i<answers.length;i++){
            int value = answers[i];
            if(value == a[i%al]){
                score[0]++;
            }
            if(value == b[i%bl]){
                score[1]++;
            }
            if(value == c[i%cl]){
                score[2]++;
            }
        }
        List<Integer> list = new ArrayList<>();
        int high = Math.max(score[0],Math.max(score[1],score[2]));
        for(int i=0;i<score.length;i++){
            if(score[i]==high){
                list.add(i+1);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}
