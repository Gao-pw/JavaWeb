package demo1.relect;

import demo1.domain.Person;

import java.lang.reflect.Constructor;


public class ReflectDemo3 {
    
    public static void main(String[] args) throws Exception {
        //获取person的class对象
        Class<Person> personClass = Person.class;
        System.out.println("========有参构造方法=====");
        Constructor c = personClass.getConstructor(String.class,int.class);
        System.out.println(c);
        //创建对象
        Object obj = c.newInstance("ls",23);
        System.out.println(obj);
        System.out.println("========空参构造方法一=====");
        Constructor c2 = personClass.getConstructor();
        Object obj2 = c2.newInstance();
        System.out.println(obj2);
        System.out.println("========空参构造方法二=====");
        Object obj3 = personClass.newInstance();
        System.out.println(obj3);
    }
}
