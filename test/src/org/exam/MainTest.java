package org.exam;

import org.demo.Expression;
import org.demo.Main;

//import org.demo.checkAnswer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.tool.MathTool;

import java.io.IOException;
import java.util.ArrayList;

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
    public void exerciseRunTest() throws IOException {
        Main.exerciseRun(10,10);
    }

    @Test
    public void cheackAnswerTest() throws IOException {
        ArrayList<Expression> e=Main.exerciseRun(10,10);
        Main.checkAnswer(e,"C:\\Users\\ASUS\\Desktop\\Four Operations\\answerfile.txt");
    }
}
