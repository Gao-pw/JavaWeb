package demo1.annotation;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架类
 */
@pro(className = "demo1.annotation.People",methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        // 1. 解析注解
        // 1.1 获取该类的字节码文件
        Class<ReflectTest> reflectTestClass = ReflectTest.class;

        //2. 获取上边的注解对象
        pro an = reflectTestClass.getAnnotation(pro.class);
        //其实就是在内存中生成一个该注解接口的子类实现对象
        /**
         * 子类实现 相当于系统生成了
         * public class proImpl implements pro{
         *     public String className(){
         *         return "demo1.annotation.People1";
         *     }
         *     public String methodName(){
         *         return "show";
         *     }
         * }
         */

        //3. 调用注解对象中定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className+methodName);
        //3. 加载类进内存
        Class cla = Class.forName(className);

        //4. 创建对象
        Object obj = cla.newInstance();

        //5. 获取方法对象
        Method m1 = cla.getMethod(methodName);

        //6 .执行方法
        m1.invoke(obj);
    }
}
