package demo1.annotation;

@SuppressWarnings("all")//一般传递all
public class AnnoDemo2 {
    /**
     * 注解第一条 不要随便删除Override;用于检查是否被重写
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1(){
        //有缺陷
    }

    public  void show2(){
        //替代show1方法
    }

    public void fun(){
        show1();
        show2();
    }
}
