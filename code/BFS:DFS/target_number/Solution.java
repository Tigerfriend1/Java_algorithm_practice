class Solution {
    int answer = 0;
    int[] numbers;
    int target;
    int[] cases = {-1,1};
    int sum=0;
    int start=0;

    public int solution(int[] numbers, int target) {
        this.numbers=numbers;
        this.target=target;
        dfs(start);
        return answer;
    }

    public void dfs(int x){
        if(x==numbers.length){
            if(sum==target){
                answer+=1;
            }
            return;
        }
        for(int c:cases){
            sum+=numbers[x]*c;
            dfs(x+1);
            sum-=numbers[x]*c;
        }

    }
}