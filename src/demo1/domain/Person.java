package demo1.domain;

public class Person {
    private String name;
    private int age;

    public String a;
    protected String b;
    String c;
    private String d = "lz是私有属性";

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void fun(){
        System.out.println("我是公共方法fun");
    }

    public void fun(String name){
        System.out.println("我是有参公共方法fun："+name);
    }

    public void eat(){
        System.out.println("person is eating");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}
