package thread.anonymous;
/**
 * 匿名内部类前提条件：必须继承一个父类或实现一个接口
 * 一：继承一个父类
 * 转自http://blog.csdn.net/qq_25827845/article/details/52598319
 */

public class ClassDemo1 {
    public static void main(String[] args) {
        People p = new People() {
            @Override
            public void eat() {
                System.out.println("I can eat ");
            }
        };
        p.eat();
        
//        new People() {
//            @Override
//            public void eat() {
//                System.out.println("I can eat ");
//            }
//        }.eat();
        
        new Dog() {
            @Override
            public void eat() {
                super.eat();
            }
        }.eat();
    }
}

abstract class People {
    public abstract void eat();
}

class Dog{
    public void eat() {
        System.out.println("I can eat bone");
    }
}
