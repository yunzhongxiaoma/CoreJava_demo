package loop;

public class Outer {
	public static void main(String[] args) {
	       outer: 
	           for(int i=0; i<10; i++){  
	               for(int j=0; j<10; j++){  
	                   System.out.println("i:"+i+" j:"+j);  
	                   if(j==1){
	                       continue outer; 
	                   }
	                   if(i==1){
	                       break outer;
	                   }
	               }
	               System.out.println("i:"+i);
	           } 
	}
}
//
//【java】break outer,continue outer的使用
//
//break默认是结束当前循环，有时我们在使用循环时，想通过内层循环里的语句直接跳出外层循环，java提供了使用break直接跳出外层循环，此时需要在break后通过标签指定外层循环。java中的标签是一个紧跟着英文冒号的标识符，与其他语言不同的是，java中的标签只有放在循环语句之前才有作用。需要注意的是，break后标签必须是一个有效的标签，即这个标签须在break语句所在循环的外层循环之前定义。
//
//continue是结束当前循环的单次循环，同理，continue也可以结束外部循环的当前单次循环
//结果
//i:0 j:0
//i:0 j:1
//i:1 j:0
