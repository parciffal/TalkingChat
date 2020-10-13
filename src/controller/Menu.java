package controller;

import model.Data;

import java.util.Scanner;

public class Menu implements Methods{
    Scanner in=new Scanner(System.in);
    public void run(){
        String[] strings=randMood();
        Data data=new Data();
        data=defoultDat(data,strings);
        chat(data,strings);
    }
    public void chat(Data data,String[] strings){
        System.out.println("enter question");
        String quest=in.nextLine();
        data=answear(quest,data,strings);
        chat(data,strings);
    }
}
