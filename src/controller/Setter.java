package controller;

import java.util.Random;

public interface Setter {
    Random random=new Random();
    default String[] randMood(){
        boolean mood=random.nextBoolean();
        String str[]=new String[3];
        if (mood==true){
            str[0]="src/questions.txt";
            str[1]="src/answear.txt";
            str[2]="true";
        }else {
            str[0]="src/badquestions.txt";
            str[1]="src/badanswear.txt";
            str[2]="false";
        }
        return str;
    }
}
