package demo1.relect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架类
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //可以创建任意类的对象，可以执行任意方法
        /*
            前提，不能改变该类的任何代码，可以创建任意类的对象，可以执行任意方法
         */
        //1.加载配置文件
        //1.1 创建properties文件
        Properties pro = new Properties();
        //1.2 加载配置文件，转换为一个集合（map）
        //1.2.1 获取class目录下的配置文件 classloader
        ClassLoader classloder = ReflectTest.class.getClassLoader();
        InputStream is = classloder.getResourceAsStream("pro.properties");
        pro.load(is);

        //2.获取配置文件中定义的数据
        String classname = pro.getProperty("className");
        String classmethod = pro.getProperty("methodName");

        //3. 加载类进内存
        Class cla = Class.forName(classname);

        //4. 创建对象
        Object obj = cla.newInstance();

        //5. 获取方法对象
        Method m1 = cla.getMethod(classmethod);

        //6 .执行方法
        m1.invoke(obj);

    }
}
