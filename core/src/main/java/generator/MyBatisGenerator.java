package generator;

import org.mybatis.generator.api.ShellRunner;

import java.net.URLDecoder;

public class MyBatisGenerator {

	public static void main(String[] args) {
		 try {
             String configPath = MyBatisGenerator.class.getResource("/generator/mybatis-generator.xml").getFile();
             String[] arg = { "-configfile", URLDecoder.decode(configPath, "UTF-8"), "-overwrite" };
             ShellRunner.main(arg);
         }catch (Exception ex){
             System.err.println("代码生成失败~(′⌒`),cause:" + ex);
         }
    }
}
