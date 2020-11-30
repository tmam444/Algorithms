package topCoderAlgorithms;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class Chapter4_2_InterestingParty {

    public static void main(String[] args){

//        String[] first = {"variety", "diversity", "loquacity", "courtesy"};
//        String[] second = {"talking", "speaking", "discussion", "meeting"};

//        String[] first = {"fishing", "gardening", "swimming", "fishing"};
//        String[] second = {"hunting", "fishing", "fishing", "biting"};

//        String[] first = {"snakes", "programming", "cobra", "monty"};
//        String[] second = {"python", "python", "anaconda", "python"};

        String[] first = {"t", "o","p","c","o","d","e","r","s","i","n","g","l","e","r","o","u","n","d","m","a","t","c","h","f","o","u","r","n","i"};
        String[] second = {"n","e","f","o","u","r","j","a","n","u","a","r","y","t","w","e","n","t","y","t","w","o","s","a","t","u","r","d","a","y"};

        System.out.println(bestInvitation(first, second));
    }

    public static int bestInvitation(String[] first, String[] second){
        HashMap<String, Integer> list = new HashMap<String, Integer>();

        for(int i = 0; i<first.length; i++){
            list.put(first[i], list.getOrDefault(first[i], 0) + 1);
            list.put(second[i], list.getOrDefault(second[i], 0) + 1);
        }

        int max = 0;

        for (String key : list.keySet()){
            max = Math.max(max, list.get(key));
        }

        return max;
    }

}
