package main.java.basic;

public class BracketsTest {
    public static void main(String[] args) {
        
        {
            System.out.println("outter brackets");
            {
                {System.out.println("inner brackets");}
                System.out.println("inner brackets");
                {System.out.println("inner brackets");}
            }
            System.out.println("outter brackets");
        }
        
    }
}
