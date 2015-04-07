package util;

import java.io.File;  
import java.io.InputStreamReader;  
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.FileInputStream;  
import java.io.FileWriter;  


public class ChangeNum {
	private static String result="";
	public static void processString(String str){
		String [] res=str.split("\t");
		for (String string : res) {
			result=result+"<td align=\"left\">"+string+"</td>\r\n";
		}
		result+="\r\n";
	}
	public static void main(String args[]){
		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
			  
            /* 读入TXT文件 */  
            String pathname = "/Users/jessexu/Documents/Myeclipse/SQLvsNOSQL/input.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径  
            File filename = new File(pathname); // 要读取以上路径的input。txt文件  
            InputStreamReader reader = new InputStreamReader(  
                    new FileInputStream(filename)); // 建立一个输入流对象reader  
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
            String line = "";  
            line = br.readLine();  
            while (line != null) {  
                line = br.readLine(); // 一次读入一行数据  
                if (line!=null) {
                	processString(line.trim());
				}
                
            }  
  
            /* 写入Txt文件 */  
            File writename = new File("/Users/jessexu/Documents/Myeclipse/SQLvsNOSQL/output.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件  
            writename.createNewFile(); // 创建新文件  
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
            out.write(result); // \r\n即为换行  
            out.flush(); // 把缓存区内容压入文件  
            out.close(); // 最后记得关闭文件  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  

	}
}
