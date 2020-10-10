package org.demo;

import org.tool.MathTool;

public class Fraction {
    private int numerator;//分子
    private int denominator;//分母

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        reduce();

        if(this.numerator<0&&this.denominator<0) {
            this.numerator = Math.abs(this.numerator);
            this.denominator = Math.abs(this.denominator);
        }
        if(this.numerator>0&&this.denominator<0) {
            this.denominator = Math.abs(this.denominator);
            this.numerator = 0-this.numerator;
        }
    }

    //约分
    public void reduce() {
        int m= MathTool.maxDe(this.numerator,this.denominator);
        this.numerator=this.numerator/m;
        this.denominator=this.denominator/m;
    }

    //加法
    public Fraction add(Fraction f) {
        //通分运算
        int newNt=this.numerator*f.denominator+f.numerator*this.denominator;
        int newDt=this.denominator*f.denominator;
        Fraction newFra=new Fraction(newNt,newDt);
        return newFra;
    }

    //减法
    public Fraction subtract(Fraction f) {
        int newNt=this.numerator*f.denominator-f.numerator*this.denominator;
        int newDt=this.denominator*f.denominator;
        Fraction newFra=new Fraction(newNt,newDt);
        return newFra;
    }

    //乘法
    public Fraction multiply(Fraction f) {
        int newNt=this.numerator*f.numerator;
        int newDt=this.denominator*f.denominator;
        Fraction newFra=new Fraction(newNt,newDt);
        return newFra;
    }

    //除法
    public Fraction divide(Fraction f) {
        int newNt=this.numerator*f.denominator;
        int newDt=this.denominator*f.numerator;
        Fraction newFra=new Fraction(newNt,newDt);
        return newFra;
    }

    //比较大小
    //若比参数小则返回true
    public boolean less(Fraction f) {
        if(this.numerator*f.denominator-f.numerator*this.denominator<0)
            return true;
        else
            return false;
    }

    //判断是否相等
    public boolean equals(Fraction f) {
        if(this.getNumerator()==f.getNumerator()&&this.getDenominator()==f.getDenominator())
            return true;
        else
            return false;
    }

    //转化为带分数(分子大于分母时)或整数
    //return String
    public String toMixedNumber() {
        int IntNum=this.numerator/this.denominator;
        int NtNum=this.numerator%this.denominator;
        String res;
        if ((0==this.numerator)) {
            res=0+"";
        }
        else if(0==IntNum) {
            res=NtNum+"/"+this.denominator;//纯分数
        }
        else if(0==NtNum) {
            res=IntNum+"";//纯整数
        }
        else {
            res=IntNum+"'"+NtNum+"/"+this.denominator;//带分数
        }
        return res;
    }
}