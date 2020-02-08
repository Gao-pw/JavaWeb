package demo1.test;

import demo1.junit.JiaFa;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JiaFaTest {

    /**
     * 初始化方法
     * 用于资源申请，所有测试方法执行之前都执行这个方法
     * @Before
     */
    @Before
    public void init(){
        System.out.println("初始化...");
    }

    /**
     * 在所有方法执行完后自动执行该方法
     * @After
     */
    @After
    public void close(){
        System.out.println("结束了...");
    }
    /**
     * 测试sum方法
     */
    @Test
    public  void testSum(){
        System.out.println("执行了！");
        JiaFa ja = new JiaFa();
        int res = ja.sum(4,5);
        System.out.println(res);

        //断言 (提前评估)
        Assert.assertEquals(9,res);
    }
}
