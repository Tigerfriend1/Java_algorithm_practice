import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        //giver[][], receiver[][]배열을 만들어 gifts배열을 순회하며 저장
        //선물지수 배열에 위 두 배열들로 선물지수를 계산
        //nextGiftFriends 배열에 다음달에 받을 선물 개수 저장
        //이 중 가장 큰값을 리턴
        int n=friends.length;
        int giver[][]=new int[n][n];
        int recevier[][]=new int[n][n];
        int giftIdx[]=new int[n]; //선물지수

        HashMap<String,Integer> friendMap = new HashMap<>();
        for(int i=0;i<n;i++){
            friendMap.put(friends[i],i);
        }

        for(String gift : gifts){
            String[] splitFriend = gift.split(" ");
            int giverIdx=friendMap.get(splitFriend[0]);
            int recevierIdx=friendMap.get(splitFriend[1]);
            giver[giverIdx][recevierIdx]++;
            recevier[recevierIdx][giverIdx]++;
        }
        for(int i=0;i<n;i++){
            int giveSum=0;
            int recevieSum=0;
            for(int j=0;j<n;j++){
                giveSum=giveSum+giver[i][j];
                recevieSum=recevieSum+recevier[i][j];
            }
            giftIdx[i]=giveSum-recevieSum;
        }
        int nextGiftFriends[] = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(giver[i][j]>recevier[i][j] || (giver[i][j]==recevier[i][j] && giftIdx[i]>giftIdx[j])){
                        nextGiftFriends[i]++;
                    }
                }
            }

        }
        int maxNum=0;
        for(int num : nextGiftFriends){
            maxNum=Math.max(maxNum,num);
        }
        return maxNum;
    }
}
