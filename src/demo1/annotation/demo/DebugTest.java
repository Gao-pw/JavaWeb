package demo1.annotation.demo;

public class DebugTest {

    @Check
    public  void sum(){
        System.out.println("1+0="+(1+0));
    }

    @Check
    public void div(){
        System.out.println("1/0="+(1/0));
    }


}
