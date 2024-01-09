import java.util.*;
class Solution {
    int count = 0;
    boolean[] visited;
    String[] words;
    String target;
    public int solution(String begin, String target, String[] words) {
        this.target=target;
        this.words=words;
        visited=new boolean[words.length];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin,0));
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.name.equals(target)){
                return node.count;
            }
            for(int i=0; i<words.length;i++){
                if(visited[i]==false && isConvert(node.name,words[i])){
                    visited[i]=true;
                    q.offer(new Node(words[i],node.count+1));
                }
            }

        }

        return count;
    }

    public boolean isConvert(String word1, String word2){
        int cnt=0;
        for(int i=0; i<word1.length();i++){
            if(word1.charAt(i)!=word2.charAt(i)){
                cnt++;
            }
        }
        return cnt==1;
    }

    static class Node{
        String name;
        int count;
        Node(String name,int count){
            this.name=name;
            this.count=count;
        }
    }
}