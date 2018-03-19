package thread.anonymous;
/**
 * 匿名内部类前提条件：必须继承一个父类或实现一个接口
 * 二：实现一个接口
 * 此处 new People( )看似实例化了一个接口，事实并非如此，接口式的匿名内部类是  实现了一个接口的匿名类。而且只能实现一个接口。
 * 转自http://blog.csdn.net/qq_25827845/article/details/52598319
 */

interface IPeople {
    public void eat();
}
 
public class InterfaceDemo2 {
    public static void main(String[] args) {
        IPeople p1 = new IPeople() {           
            @Override
            public void eat() {
                System.out.println("I can eat ");
            }
        };
        p1.eat();
        
        /*
        //另一种方式:非匿名类实现接口
        People1 p2 = new People1();
        p2.eat();
        */
    }

}
/*
class People1 implements IPeople{

    @Override
    public void eat() {
        System.out.println("I can eat ");
    }
    
}*/