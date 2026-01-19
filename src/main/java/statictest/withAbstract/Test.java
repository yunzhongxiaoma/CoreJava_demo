package main.java.statictest.withAbstract;

// 原则一：static永远不能和abstract碰头；
// 原则二：interface是更抽象的抽象类，接口的所有方法都未实现，接口的方法默认为public abstract ，根据原则一，当然不能是static了；
// 原则三：抽象类是部分实现的，其中non－abstract方法可以带static，abstract方法不能带static；

// public static class Test { // static是针对方法的；对于类only public, abstract & final are permitted
/**
 * static
 * 方法是类方法,它是不允许子类覆写（override）的（所以必须在定义的时候给出实现），而abstract方法，是只有特征标，没有实现的方法，
 * 是必须由子类来覆写的，两者是水火不相容的，sun当然不会允许定义一个同时为abstract 和static 的方法。
 */
abstract class Test {

}
