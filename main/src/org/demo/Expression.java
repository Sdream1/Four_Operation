package org.demo;


import org.tool.MathTool;

public class Expression {
    int operatorNum;//符号数
    int range;//分数的范围以及分母的范围
    private Fraction[] num;
    private String[] operator;

    //构造函数，根据符号数的不同构建相应的表达式
    public Expression(int range,int operatorNum) {
        this.range = range;
        this.operatorNum=operatorNum+1;
        if(1==this.operatorNum) {
            num=new Fraction[2];
            operator=new String[1];
            num[0]= MathTool.getRandomFraction(range,range);
            operator[0]=MathTool.getRandomOperator();
            num[1]= MathTool.getRandomFraction(range,range);
        }
        else if(2==this.operatorNum) {
            num=new Fraction[3];
            operator=new String[2];
            num[0]= MathTool.getRandomFraction(range,range);
            operator[0]=MathTool.getRandomOperator();
            num[1]= MathTool.getRandomFraction(range,range);
            operator[1]=MathTool.getRandomOperator();
            num[2]= MathTool.getRandomFraction(range,range);
        }
        else if(3==this.operatorNum) {
            num=new Fraction[4];
            operator=new String[3];
            num[0]= MathTool.getRandomFraction(range,range);
            operator[0]=MathTool.getRandomOperator();
            num[1]= MathTool.getRandomFraction(range,range);
            operator[1]=MathTool.getRandomOperator();
            num[2]= MathTool.getRandomFraction(range,range);
            operator[2]=MathTool.getRandomOperator();
            num[3]= MathTool.getRandomFraction(range,range);
        }
    }

    //以字符串的形式返回题目
    public String getExercise() {
        if ((1==this.operatorNum)) {
            return num[0].toMixedNumber()+""+operator[0]+""+num[1].toMixedNumber()+""+"=";
        }
        else if(2==this.operatorNum) {
            return num[0].toMixedNumber()+""+operator[0]+""+num[1].toMixedNumber()+""+operator[1]+""+num[2].toMixedNumber()+""+"=";
        }
        else {
            return num[0].toMixedNumber()+""+operator[0]+""+num[1].toMixedNumber()+""+operator[1]+""+num[2].toMixedNumber()+""
                    +operator[2]+""+num[3].toMixedNumber()+""+"=";
        }
    }

    //计算表达式的结果并返回
    public Fraction getResult() {
        if ((1 == this.operatorNum)) {//一个符号运算
            return MathTool.calculator(num[0], operator[0], num[1]);
        } else if (2 == this.operatorNum) {//两个符号运算
            Fraction temp;
            //不按顺序计算的式子单独处理
            if (operator[1] == "×" || operator[1] == "÷") {
                temp = MathTool.calculator(num[1], operator[1], num[2]);
                return MathTool.calculator(num[0], operator[0], temp);
            } else {
                temp = MathTool.calculator(num[0], operator[0], num[1]);
                return MathTool.calculator(temp, operator[1], num[2]);
            }
        } else {//三个符号运算
            Fraction temp1;
            Fraction temp2;
            //不按顺序计算的式子单独处理
            if ((operator[0] == "×" || operator[0] == "÷") && (operator[1] == "+" || operator[1] == "-")
                    && (operator[2] == "×" || operator[2] == "÷")) {
                temp1 = MathTool.calculator(num[0], operator[0], num[1]);
                temp2 = MathTool.calculator(num[2], operator[2], num[3]);
                return MathTool.calculator(temp1, operator[1], temp2);
            } else if ((operator[0] == "+" || operator[0] == "-") && (operator[1] == "+" || operator[1] == "-")
                    && (operator[2] == "×" || operator[2] == "÷")) {
                temp1 = MathTool.calculator(num[0], operator[0], num[1]);
                temp2 = MathTool.calculator(num[2], operator[2], num[3]);
                return MathTool.calculator(temp1, operator[1], temp2);
            } else if ((operator[0] == "+" || operator[0] == "-") && (operator[1] == "×" || operator[1] == "÷")
                    && (operator[2] == "×" || operator[2] == "÷")) {
                temp1 = MathTool.calculator(num[1], operator[1], num[2]);
                temp2 = MathTool.calculator(temp1, operator[2], num[3]);
                return MathTool.calculator(num[0], operator[0], temp2);
            } else if ((operator[0] == "+" || operator[0] == "-") && (operator[1] == "×" || operator[1] == "÷")
                    && (operator[2] == "+" || operator[2] == "-")) {
                temp1 = MathTool.calculator(num[1], operator[1], num[2]);
                temp2 = MathTool.calculator(num[0], operator[0], temp1);
                return MathTool.calculator(temp2, operator[2], num[3]);
            } else {
                temp1 = MathTool.calculator(num[0], operator[0], num[1]);
                temp2 = MathTool.calculator(temp1, operator[1], num[2]);
                return MathTool.calculator(temp2, operator[2], num[3]);
            }
        }
    }

}
