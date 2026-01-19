package main.java.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class csvReadPhone {
	public static void main(String[] args) throws IOException {
//		double n = Math.random();
//		System.out.println(n);
		csvWriteMethod("F:\\ssss\\w.csv");
//		csvReadMethod("F:\\ssss\\w.csv");
	}
	
	
	public static void csvReadMethod(String path) throws UnsupportedEncodingException{
		//File csv = new File("E:\\file\\test.csv"); // CSV文件路径
		File csv = new File(path);
		BufferedReader br = null;
		DataInputStream in = null;
		try {
			in = new DataInputStream(new FileInputStream(csv));
			br = new BufferedReader(new InputStreamReader(in, "gbk"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line = "";
		String splitStr = ",";
		try {
			while ((line = br.readLine()) != null) // 读取到的内容给line变量
			{
				String []str = line.split(splitStr);
				for(String s:str)
					System.out.print(s+"\t");
				System.out.println();			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//关闭文件操作
	}
	public static void csvWriteMethod(String path) throws IOException{
/*		//原来的代码
  		File csv = path;
		FileWriter writer = new FileWriter(csv);
		File csv = path;
		*/
		File csv = new File(path);
		BufferedWriter writer = null;
		DataOutputStream out = null;
		out = new DataOutputStream(new FileOutputStream(csv));
		writer = new BufferedWriter(new OutputStreamWriter(out, "gbk"));
		
		for(int i = 0;i<3;i++)
		{
			//获取专业和方向
			String[] MajDirList = getMajorAndDirection();
			String major = MajDirList[0];
			String direction = MajDirList[1];
			writer.write(getID());
			writer.write(",");
			writer.write(Name());
			writer.write(",");
			writer.write(major);
			writer.write(",");
			writer.write(direction);
			writer.write(",");
			writer.write(getPhone());
			writer.write("\r\n");
			writer.flush();
		}
		writer.close();
	}
	
	
	public static int RandomNum(int min,int max){
		Random random = new Random();
		int s = random.nextInt(max) % (max - min + 1) + min;
		return s;
	}
	public static String getID(){
		String grade = "201577";		//201577G0555
		String []major = {"10","20","30","D0","E0","F0","G0"};
		String banji = "" + RandomNum(1, 6);
		int n = RandomNum(0, 60);
		String num = "";
		if (n >= 10) {
			num = num + n;
		} else
			num = num + "0" + n;
		String stuID = grade + major[RandomNum(0, 6)] + banji + num;
		//System.out.println(stuID);
		return stuID;
	}
	public static String Name(){
		String []firstList = {"赵","钱","孙","李","周","吴","郑","王","冯","陈","褚","卫","蒋","沈","韩","杨","朱","秦","尤","许","何","吕","施","张","孔","曹","严","华","金","魏","陶","姜","戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","奚","范","彭","郎","鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","酆","鲍","史","唐","费","廉","岑","薛","雷","贺","倪","汤","滕","殷","罗","毕","郝","邬","安","常","乐","于","时","傅","皮","卞","齐","康","伍","余","元","卜","顾","孟","平","黄","和","穆","萧","尹","姚","邵","湛","汪","祁","毛","禹","狄","米","贝","明","臧","计","伏","成","戴","谈","宋","茅","庞","熊","纪","舒","屈","项","祝","董","梁","杜","阮","蓝","闵","席","季","麻","强","贾","路","娄","危","江","童","颜","郭","梅","盛","林","刁","钟","徐","邱","骆","高","夏","蔡","田","樊","胡","凌","霍","虞","万","支","柯","昝","管","卢","莫","经","房","裘","缪","干","解","应","宗","丁","宣","贲","邓","郁","单","杭","洪","包","诸","左","石","崔","吉","钮","龚","程","嵇","邢","滑","裴","陆","荣","翁","荀","羊","於","惠","甄","曲","家","封","芮","羿","储","靳","汲","邴","糜","松","井","段","富","巫","乌","焦","巴","弓","牧","隗","山","谷","车","侯","宓","蓬","全","郗","班","仰","秋","仲","伊","宫","宁","仇","栾","暴","甘","钭","厉","戎","祖","武","符","刘","景","詹","束","龙","叶","幸","司","韶","郜","黎","蓟","薄","印","宿","白","怀","蒲","台","从","鄂","索","咸","籍","赖","卓","蔺","屠","蒙","池","乔","阴","郁","胥","能","苍","双","闻","莘","党","翟","谭","贡","劳","逄","姬","申","扶","堵","冉","宰","郦","雍","却","璩","桑","桂","濮","牛","寿","通","边","扈","燕","冀","郏","浦","尚","农","温","别","庄","晏","柴","瞿","阎","充","慕","连","茹","习","宦","艾","鱼","容","向","古","易","慎","戈","廖","庚","终","暨","居","衡","步","都","耿","满","弘","匡","国","文","寇","广","禄","阙","东","殴","殳","沃","利","蔚","越","夔","隆","师","巩","厍","聂","晁","勾","敖","融","冷","訾","辛","阚","那","简","饶","空","曾","毋","沙","乜","养","鞠","须","丰","巢","关","蒯","相","查","后","荆","红","游","竺","权","逯","盖","益","桓公","万俟","司马","上官","欧阳","夏侯","诸葛","闻人","东方","赫连","皇甫","尉迟","公羊","澹台","公冶","宗政","濮阳","淳于","单于","太叔","申屠","公孙","仲孙","轩辕","令狐","钟离","宇文","长孙","慕容","鲜于","闾丘","司徒","司空","亓官","司寇","仉","督","子车","颛孙","端木","巫马","公西","漆雕","乐正","壤驷","公良","拓跋","夹谷","宰父","谷粱","晋","楚","闫","法","汝","鄢","涂","钦","段干","百里","东郭","南门","呼延","归海","羊舌","微生","岳","帅","缑","亢","况","后","有","琴","梁丘","左丘","东门","西门"};
		String []lastList = {"静雪","芸妮","姿楠","馨楠","彤芳","欣明","珍楠","优妍","初寒","嘉珊","格柔","雪灵","梦婷","舒杉","冬婷","家菡","韵克","香芸","薇欣","莉玲","采琛","嘉婧","琪诗","寒馨","馨珠","璟楠","玥初","云雨","彩欣","欣雪","欣倩","昭霞","碧初","昕寒","云梓","露凌","薇菡","祥柔","帛冬","婷锦","桃露","静采","琛格","姿雅","怡雪","薇欢","梓岚","云茜","妍晨","桂雪","柔雪","薇梦","蕾楠","杉心","格采","梦优","雅婷","枫鑫","彩妍","曦弦","初林","静芳","梦丽","雯萱","雪颖","怡橘","初彩","婷舒","露婷","冬婧","梅娜","沛洲","妍琪","晨梓","格梦","花蓓","敏婷","珊采","香祥","梅妮","婧馨","栀芸","锦珍","花娜","桂欣","梦婧","旭阳","欣雅","梓诗","彩慧","晨璐","瑶梦","梅雪","锦克","凌薇","芙琛","云桐","梅梅","初碧","采采","馨桂","初静","彤月","涵颖","茜莲","珠彩","怡漫","婷琪","凡雅","琬依","惠茹","花菲","涵姿","雯钰","芝晨","静慧","初岚","彦紫","薇莉","芳琪","锦梅","丽玲","雅媛","彩雪","月依","桃倩","俊芙","婷雅","俊楠","楠慧","妍韵","家薇","寒灵","梦梦","薇冬","婷雯","采心","呈诗","琬锦","锦梦","雪淑","沛芙","雪芳","阳彩","茜婷","雯茹","雅芙","紫妮","可华","妍芳","馨倩","琛娅","桂桐","晨曦","娅呈","冬函","昭采","寒岚","梦凌","婧栀","菲昕","淑锦","彩婷","怡彤","华静","云莲","函云","婧钰","婷怡","珠钰","妍婧","采婧","柏昕","静彤","云姿","芸薇","花正","欣诗","香姿","华心","呈萱","莲梦","文祥","洁橘","漫雨","妍倩","采春","香冰","雪初","雪莲","梦文","帆欣","欣芙","晨克","淑祥","雯欣","婧欢","曦明","格欢","枫月","蕾明","雯采","钰欣","格璐","妍玉","雪家","丽芝","灵莲","初婷","雨昭","花萱","帛涵","橘倩","慧云","芸枫","冰岚","怡莉","露锦","格雪","洲初","彩鑫","梓正","楠柏","楠琬","冰玉","昕婷","玥媛","美岚","婷淑","娅露","璇梅","娅歆","雅枫","薇锦","香涵","珊芳","帆雅","蓓霞","璐琛","桂萱","博琛","鑫逸","驰振","杞栋","禧骞","驰运","骞宇","禧炳","家栋","升德","辰沛","郁晨","柏尧","鑫蔓","逸轩","濡林","腾运","骏振","星阳","龙振","骏晨","柏强","博晨","佳祥","骏钊","礼振","勇远","弘强","锦禧","欣嘉","天良","骏佑","骞骞","辰栋","濡日","祥良","振驰","贤家","晨彬","龙梁","星嘉","国胤","振韦","胤博","晓泽","喆振","振骏","休沛","桓起","星沛","骏骏","轩骏","鹤运","运烁","晨博","礼强","烁震","文铭","晨坤","运骞","胤梁","权龙","瑞祥","驰帆","谛驰","运鹏","运福","安子","安腾","恒运","轩权","家良","浩俊","晨祯","骞贤","逸星","星涛","腾骞","远运","泽骏","裕裕","运楷","稷骏","运辰","天星","嘉驰","礼浩","骏栋","骏彬","升杞","星辰","颜颜","逸康","彬锐","辰腾","濡振","驰杞","康平","升辞","骏锐","骏稷","振吉","骞良","沛海","运颜","颜星","琛凯","腾炳","梓震","翰晨","宇裕","骞福","胤振","休皓","文良","浩骏","鹏沛","信祯","晨骏","海福","杞暄","博杰","邦宇","杞爵","晨星","辰辰","浩礼","天强","凡腾","俊运","盛博","震华","芃锐","成振","欣驰","佳骏","骞胤","运运","谛骞","骞博","运轩","杰鑫","腾禧","运振","初锐","腾鹏","家鸿","骏延","帆晓","海骏","权嘉","栋驰","文腾","逸鸿","天加","乘骞","晨晓","星博","振然","轩杞","皓星","星钊","潍腾","桀轩","子鸿","星晨","桓加","辰泽","辰骞","琛梓","权尧","骞鸿","海烁","弘轩","铭博","鑫禧","凯升","泽弘","梓博","浩桀","栋佑","暄梁","辰盛","允锐","梓鑫","允博","锟嘉","运良","骏杞","驰荣","鹏逸","梓稷","轩卓","树树","轩诚","皓震","祥辰","震诚","运锋","晨安","骏轩","晨腾","星初","峰良","运家","振逸","裕运","权平","宇宇","然稷","骏鸿","祯良","鸿晨","晨海","天安","宇皓","信沛","韦裕","振华","皓勇","鹏鹤","韦运","鸿骏","震振","骞仕","炳骏","喆龙","运韦","康仕","坤翱","驰骏","骞振","骏华","家勇","荣贤","卓腾","荣骞","国翱","凯振","初震"};
		String name = firstList[RandomNum(0, firstList.length)]+lastList[RandomNum(0, lastList.length)];
		return name;
	}
	
	/*
	 * 返回随机专业
	 */
	public static String[] getMajorAndDirection() {
		String[] majorList = {"软件工程","计算机科学与技术","信息安全","物联网工程"};
		String[][] directionList = {
				{"移动互联网开发","软件开发与测试","网络服务与工程"},
				{"传媒设计与制作","金融信息化","智能制造信息化","嵌入式软件"},
				{"信息安全1","信息安全2"},
				{"物联网工程1","物联网工程2"}
		};
		int num = RandomNum(0, majorList.length);
		//major
		String major = majorList[num];
		//direction
		int directionlength = directionList[num].length;
		String direction = directionList[num][ RandomNum(0, directionlength) ];
		
		String[] majorDirection= {major, direction};
		return majorDirection;
	}
	
    /* 
     * 返回随机手机号码 
     */
	public static String getPhone() { 
		String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
        String first = telFirst[RandomNum(0,telFirst.length-1)];
        String second = String.valueOf(RandomNum(1,7000)+10000).substring(1);
        String third = String.valueOf(RandomNum(1,9100)+10000).substring(1);
        return first+second+third;
	}
}

