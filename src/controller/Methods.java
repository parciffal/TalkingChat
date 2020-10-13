package controller;

import model.Data;

import java.io.*;
import java.util.*;

public interface Methods extends Setter{
    Scanner in=new Scanner(System.in);
    default Data defoultDat(Data data, String[] strings){
        int count=data.getQuestions().size();
        String inputFileName="src/questions.txt";
        try {
            String line;
            BufferedReader reader=new BufferedReader(new FileReader(strings[0]));
            while((line=reader.readLine())!=null){
                data.getQuestions().put(count,line);
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int countAns=data.getAnwsears().size();
        try {
            String line;
            BufferedReader reader=new BufferedReader(new FileReader(strings[1]));
            while((line=reader.readLine())!=null){
                data.getAnwsears().put(countAns,line);
                countAns++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    default Data questionNFound(String question,String[] strings){
        Data data=new Data();
        System.out.println("what can i answaer");
        String newAnswear=in.nextLine();
        int yr=0;
        try {
            FileWriter writer=new FileWriter(strings[0],true);
            writer.write("\n"+question);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter writer=new FileWriter(strings[1],true);
            writer.write("\n"+newAnswear);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator<Integer> key =data.getQuestions().keySet().iterator();
        while (key.hasNext()){
            if (!key.hasNext()){
                yr=key.next().intValue()+1;
            }
        }
        data.getQuestions().put(yr,question);
        data.getAnwsears().put(yr,newAnswear);
        return data;
    }
    default Data answear(String question,Data data,String[] strings){
        boolean er=false;
        for (Map.Entry<Integer,String> nell:data.getQuestions().entrySet()) {
            if (nell.getValue().equals(question)){
                System.out.println(data.getAnwsears().get(nell.getKey()));
                er=false;
                break;
            }else{
                er=true;
            }
        }
        if (er==true){
            data=questionNFound(question,strings);
        }
        return data;
    }
}
