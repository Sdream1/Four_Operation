package org.tool;

import org.demo.Fraction;

import java.util.ArrayList;
import java.util.Random;

public class MathTool {

    //最大公约数: 使用辗转相除法
    public static int maxDe(int a, int b){
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    //随机生成一个运算符
    //return String
    public static String getRandomOperator() {
        int choice=new Random().nextInt(4);
        ArrayList<String> operators=new ArrayList<>();
        operators.add("+");
        operators.add("-");
        operators.add("×");
        operators.add("÷");
        return operators.get(choice);
    }

    //随机生成一个0-range的整数
    public static int getRandomInterget(int range){
        return new Random().nextInt(range);
    }

    //随机生成一个0-range，分母最大为denominatorRange的分数
    public static Fraction getRandomFraction(int range,int denominatorRange) {
        int dt=getRandomInterget(denominatorRange)+1;
        int nt=getRandomInterget(dt*range)+1;
        Fraction newFra=new Fraction(nt,dt);
        return newFra;
    }

    //两个分数的四则运算
    public static Fraction calculator(Fraction a,String o,Fraction b) {
        if (o.equals("+")) return a.add(b);
        else if (o.equals("-")) return a.subtract(b);
        else if (o.equals("×")) return a.multiply(b);
        else  return a.divide(b);//除
    }

    //将字符串（带分数，纯分数，纯整数）转化为分数
    public static Fraction toFraction(String MixedNumber) {
        if(MixedNumber.contains("/")) {
            if(MixedNumber.contains("'")) {
                String[] s1=MixedNumber.split("'");//带分数的时候
                int it=Integer.parseInt(s1[0]);
                String[] s2=s1[1].split("/");
                int nt=Integer.parseInt(s2[0]);
                int dt=Integer.parseInt((s2[1]));
                nt+=it*dt;
                return new Fraction(nt,dt);
            }

            else{
                String[] s1=MixedNumber.split("/");//纯分数的时候
                int nt=Integer.parseInt(s1[0]);
                int dt=Integer.parseInt((s1[1]));
                return new Fraction(nt,dt);
            }

        }
        return new Fraction(Integer.parseInt(MixedNumber),1);//纯整数的时候
    }


}

