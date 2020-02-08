package demo1.relect;

import demo1.domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo2 {
    
    public static void main(String[] args) throws Exception {
        //获取person的class对象
        Class personClass = Person.class;
        /**
         *获取所有公共成员变量
         * getFields()
         */
        Field[] fields = personClass.getFields();
        for(Field field : fields){
            System.out.println(field);
        }

        System.out.println("=======设置成员变量a的值=============");
        /**
         * 获取一个公共成员变量
         *Field getField（String name）
         * 设置成员变量的值,需要一个对象
         * set()
         */
        Person p = new Person();
        Field a = personClass.getField("a");
        a.set(p,"zs");
        System.out.println(p);

        System.out.println("=======获取所有变量=============");
        /**
         * getDeclaredFields()
         * 获取所有成员变量，不考虑属性修饰词
         */
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field f2 :declaredFields){
            System.out.println(f2);
        }
        //在反射中没有私有公有之说
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object value = d.get(p);
        System.out.println(value);
        d.set(p,"私有属性我还能改");
        System.out.println(p);
    }
}
