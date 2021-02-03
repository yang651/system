package com.czu.yxySystem.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;

/**
 * @Description TODO
 * @Author Yxy
 * @Date 2021/1/29 16:42
 **/
public class ModuleTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Write.flag");
        if(file.exists()){
            System.out.println("文件存在");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        List<String> list = new ArrayList<>();
        String s;
        while ((s = br.readLine()) != null){
            list.add(s);
        }
        System.out.println(list);
    }

//    public static void main(String[] args) throws IOException {
//        String wkReadPath = "D:\\";
//        File file = new File(wkReadPath + "Write.flag");
//        if(!file.exists()){
//            file.createNewFile();
//        }
//        FileWriter sr = new FileWriter(wkReadPath + "Write.flag", true);
//        sr.write("[othe]" + "\r\n");
//        sr.write("jclsh=" + 1 + "\r\n");
//        sr.write("hpzl=" + 2+ "\r\n");
//        sr.write("hphm=" + 3+ "\r\n");
//        sr.write("clsbdh=" + 4+ "\r\n");
//        sr.write("zj=4000"+ "\r\n");
//        sr.write("cwkc=" + 5+ "\r\n");
//        sr.write("cwkk=" + 6+ "\r\n");
//        sr.write("cwkg=" + 7+ "\r\n");
//        sr.flush();
//        sr.close();
//    }





}
