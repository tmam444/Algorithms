package topCoderAlgorithms;

import java.util.Arrays;

public class Chapter4_1_KiwiJuice {

    public static void main(String[] args){
//        int[] capacities = {10, 10};
//        int[] bottles = {5, 8};
//        int[] fromId = {0};
//        int[] toId = {1};

//        int[] capacities = {30, 20, 10};
//        int[] bottles = {10, 5, 5};
//        int[] fromId = {0, 1, 2};
//        int[] toId = {1, 2, 0};

        int[] capacities = {14, 35, 86, 58, 25, 62};
        int[] bottles = {6, 34, 27, 38, 9 ,60};
        int[] fromId = {1, 2, 4, 5, 3, 3, 1, 0};
        int[] toId = {0, 1, 2, 4, 2, 5, 3, 1};

//        int[] capacities = {700000, 800000, 900000, 1000000};
//        int[] bottles = {478478, 478478, 478478, 478478, 478478, 478478};
//        int[] fromId = {2, 3, 2, 0, 1};
//        int[] toId = {0, 1, 1, 3, 2};

        int[] test = thePouring(capacities, bottles, fromId, toId);

        System.out.println(Arrays.toString(test));
    }

    public static int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId){
        int[] returnArray = new int[capacities.length];
        //1. fromId 부터 toId까지 도는 for문을 만든다.
        //2. bottles[from[i]]를 확인하고, 옮겨질 양을 구하기 위해 capacities[toId[i]] - bottles[toId[i]]를 한다.
        //3. from[i]에는 그 양을 줄이고, toId[i]에는 기존에 값에 옮겨질 양을 더한다.
        //4. 반복한다.

        for(int i = 0; i<fromId.length; i++){
            int fromSize = bottles[fromId[i]];
            int toIdRemainSize = capacities[toId[i]] - bottles[toId[i]];
            if(fromSize > toIdRemainSize){
                returnArray[fromId[i]] = fromSize - toIdRemainSize;
                returnArray[toId[i]] = bottles[toId[i]] + toIdRemainSize;
                bottles[fromId[i]] -= toIdRemainSize;
                bottles[toId[i]] += toIdRemainSize;
            }else{
                returnArray[fromId[i]] = 0;
                returnArray[toId[i]] = bottles[toId[i]] + fromSize;
                bottles[fromId[i]] -= fromSize;
                bottles[toId[i]] += fromSize;
            }
        }

        return returnArray;
    }

}
