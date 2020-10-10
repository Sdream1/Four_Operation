package org.demo;


import org.tool.MathTool;

import java.io.*;
import java.util.ArrayList;

import static org.tool.MathTool.toFraction;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Expression> e=exerciseRun(10,10);
        checkAnswer(e,"C:\\Users\\ASUS\\Desktop\\Four Operations\\answerfile.txt");
    }

    //生成所需数量，数值范围的题目
    public static ArrayList<Expression> exerciseRun(int number,int range) throws IOException {
        ArrayList<Expression> ep=new ArrayList<>();
        for (int i = 0; i < number; i++) {
            int a= MathTool.getRandomInterget(3);
            Expression e=new Expression(range,a);
            ep.add(e);
        }
        File f1=new File("C:\\Users\\ASUS\\Desktop\\Four Operations\\exercisefile.txt");
        FileOutputStream fos1=new FileOutputStream(f1);
        File f2=new File("C:\\Users\\ASUS\\Desktop\\Four Operations\\answerfile.txt");
        FileOutputStream fos2=new FileOutputStream(f2);
        for (int i = 0; i <ep.size() ; i++) {
            fos1.write(((i+1)+"、"+ep.get(i).getExercise()).getBytes());
            fos1.write("\r\n".getBytes());
            fos2.write(((i+1)+"、"+ep.get(i).getResult().toMixedNumber()).getBytes());
            fos2.write("\r\n".getBytes());
        }
        fos1.close();
        fos2.close();
        System.out.println("题目已生成！");
        return ep;
    }

    public static void checkAnswer (ArrayList<Expression> e,String afile) throws IOException {
        int correctNum=0;//正确数
        ArrayList<Integer> correctTitle = new ArrayList<>();//对题题号
        int wrongNum=0;//错误数
        ArrayList<Integer> wrongTitle = new ArrayList<>();//错题题号

        FileReader fr=new FileReader(afile);
        BufferedReader reader=new BufferedReader(fr);
        String tempString;
        ArrayList<Fraction> selfanswer=new ArrayList<>();

        while((tempString=reader.readLine())!=null) {
            selfanswer.add(toFraction(InitAnswer(tempString)));
        }

        for (int i = 0; i < e.size(); i++) {
            if (e.get(i).equals(selfanswer.get(i))) {
                correctNum++;
                correctTitle.add(i+1);
            }
            else {
                wrongNum++;
                wrongTitle.add(i+1);
            }
        }

        System.out.print("Correct:"+correctNum+"(");
        for (int i = 0; i < correctTitle.size()-1; i++) {
            System.out.print(correctTitle.get(i)+",");
        }
        System.out.print(correctTitle.get(correctTitle.size()-1));
        System.out.println(")");

        System.out.print("Wrong:"+wrongNum+"(");
        if (0==wrongTitle.size()) {
            System.out.println(")");
        }
        else{
            for (int i = 0; i < wrongTitle.size()-1; i++) {
                System.out.print(wrongTitle.get(i)+",");
            }
            System.out.print(wrongTitle.get(wrongTitle.size()-1));
            System.out.println(")");
        }
    }

    //读答案文档前把格式消除
    public static String InitAnswer(String str) {
        String[] s1=str.split("、");
        return s1[1];
    }
}
