package demo1.relect;

import demo1.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class ReflectDemo4 {
    
    public static void main(String[] args) throws Exception {
        //获取person的class对象
        Class<Person> personClass = Person.class;
        System.out.println("=============");
        Person p = new Person();
        //执行方法(无参)
        Method m1 = personClass.getMethod("fun");
        m1.invoke(p);
        //执行方法（有参）
        Method m2 = personClass.getMethod("fun",String.class);
        m2.invoke(p,"haha");
        System.out.println("===========");
        //获取所有public的方法
        //不仅仅有看到的，还有object方法
        Method[] mes = personClass.getMethods();
        for(Method a : mes){
            System.out.println(a);
        }
    }
}
