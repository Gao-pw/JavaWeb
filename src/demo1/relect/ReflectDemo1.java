package demo1.relect;

import demo1.domain.Person;

public class ReflectDemo1 {
    /**
        获取class的三种方式：
            1. 源代码阶段：Class.forName（“全类名”）：将字节码文件加载进内存，返回class对象
            2. 类名.class：通过类名的class属性获取
            3. 对象.getclass()：方法在object类中定义
     */
    public static void main(String[] args) throws ClassNotFoundException {
        //1.静态方法（全类名）
        Class cls1 = Class.forName("demo1.domain.Person");
        System.out.println(cls1);

        //2.
        Class cls2 = Person.class;
        System.out.println(cls2);

        //3.
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);

        // ==比较三个对象 比较的是地址值
        System.out.println(cls1==cls2);//true
        System.out.println(cls2==cls3);//true
    }
}
