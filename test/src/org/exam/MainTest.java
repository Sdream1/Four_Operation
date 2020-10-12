package org.exam;

import org.demo.Expression;
import org.demo.Main;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.tool.MathTool;

import java.io.IOException;

public class MainTest {
    @BeforeClass
    public static void beforeTest(){
        System.out.println("测试即将开始");
    }

    @AfterClass
    public static void afterTest(){
        System.out.println("测试结束");
    }

    @Test
    public void toExpressionrTest() {
        String str="1、4'1/2+2-2'7/8-2=";
        Expression e=MathTool.toExpression(str);
        System.out.println(e.getExercise());
        System.out.println(e.getResult().toMixedNumber());
    }

    @Test
    public void exerciseRunTest() throws IOException {
        Main.exerciseRun(10000,10);
    }

    @Test
    public void cheackAnswerTest1() throws IOException {
        Main.checkAnswer("C:\\Users\\ASUS\\Desktop\\FourOperations\\exercisefile.txt","C:\\Users\\ASUS\\Desktop\\FourOperations\\answerfile.txt");
    }
//    @Test
//    public void cheackAnswerTest2() throws IOException {
//        Main.checkAnswer("C:\\Users\\ASUS\\Desktop\\FourOperations\\exercisefile.txt","C:\\Users\\ASUS\\Desktop\\FourOperations\\answerfile.txt");
//    }

}
