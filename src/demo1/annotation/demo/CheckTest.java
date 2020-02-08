package demo1.annotation.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 简单的测试框架
 *
 * 当主方法执行后，会自动执行被检测的所有方法（加了Check注解的方法），判断方法是否有异常，记录到文件中
 *
 */
public class CheckTest {
    public static void main(String[] args) throws IOException {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        int number =0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        DebugTest debugTest = new DebugTest();
        Class ca = debugTest.getClass();
        Method[] methods = ca.getMethods();

        for (Method method : methods){
            if (method.isAnnotationPresent(Check.class)){
                try {
                    System.out.println("方法被执行:"+method);
                    method.invoke(debugTest);
                } catch (Exception e) {
                    System.out.println("捕获异常");
                    //记录到文件中
                    number++;
                    bw.write(formatter.format(date)+" ");
                    bw.write(method.getName()+"出异常了");
                    bw.newLine();
                    bw.write("异常的名称："+e.getCause().getClass());
                    bw.newLine();
                    bw.write("异常的原因："+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("===========================================");
                    bw.newLine();
                }
            }
        }
        bw.write("本次一共出现"+number+"次异常");
        bw.flush();
        bw.close();
    }
}
