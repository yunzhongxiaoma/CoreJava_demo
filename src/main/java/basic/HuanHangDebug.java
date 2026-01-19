package main.java.basic;

public class HuanHangDebug {
	static String [][] a = {{"a0","a1"},{"b0","b1"}};
	public static void main(String[] args) {
		String b = a[0]
				[2];
		System.out.println(b);
		//结论：换行好像并不能看出错误出在什么地方《手动滑稽》
	}
}
