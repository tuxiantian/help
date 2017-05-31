package tuxt.help.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class GenerateDbData {

	public Template getTemplate(String name) {
        try {
            // 通过Freemaker的Configuration读取相应的ftl
            Configuration cfg = new Configuration();
            // 设定去哪里读取相应的ftl模板文件
            cfg.setClassForTemplateLoading(this.getClass(), "/ftl");
            // 在模板文件目录中找到名称为name的文件
            Template temp = cfg.getTemplate(name);
            return temp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	 /**
     * 控制台输出
     * 
     * @param name
     * @param root
     */
    public void print(String name, Map<String, Object> root) {
        try {
            // 通过Template可以将模板文件输出到相应的流
            Template temp = this.getTemplate(name);
            temp.process(root, new PrintWriter(System.out));
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static GenerateDbData generateDbData;
    @BeforeClass
    public static void beforeClass() {
    	generateDbData=new GenerateDbData();
	}
    @Test
    public void standardOrder() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMM");
		String name="standardOrder.ftl";
		Map<String, Object> root=new HashMap<String, Object>();
		List<Map<String, String>> datas=new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Map<String, String> data=new HashMap<>();
			data.put("logid", GenerateIDUtil.generateSequenceNo());
			data.put("createDate", sdf.format(new Date()));
			datas.add(data);
		}
		root.put("datas", datas);
		root.put("yyyyMM", sdf2.format(new Date()));
		generateDbData.print(name, root);
	}
    @Test
    public void ol_phone_blacklist() {
    	String name="ol_phone_blacklist.ftl";
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Map<String, Object> root=new HashMap<String, Object>();
		List<Map<String, String>> datas=new ArrayList<>();
		NumberFormat numberFormat = new DecimalFormat("0000000000");
		Random random=new Random();
		for (int i = 0; i < 20; i++) {
			Map<String, String> data=new HashMap<>();
			data.put("phone", "1"+numberFormat.format(random.nextInt(Integer.MAX_VALUE)));
			data.put("prov_code", "371");
			data.put("add_style", "1");
			data.put("ms_opcode", "00"+i);
			data.put("phone_desc", "人工审核系统添加");
			data.put("create_date", sdf.format(new Date()));
			
			datas.add(data);
		}
		root.put("datas", datas);
    	generateDbData.print(name, root);
	}
    @Test
    public void wxbdj() {
    	String name="wxbdj.ftl";
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Map<String, Object> root=new HashMap<String, Object>();
		List<Map<String, String>> datas=new ArrayList<>();
		Random random=new Random();
		String[] phoneNums={"18313818611","13772630827","13991701098","13954515915","18864512659","15169897380","13477759009","15234458934","15109195916","13613542579","13806335329","13837666229","15877551922","15949331285","15829294570","15897699103","18326157673","18371532634","18313818611","13772630827","13991701098","13954515915","18864512659","15169897380","13477759009","15234458934","15109195916","13613542579","13806335329","13837666229","15877551922","15949331285","15829294570","15897699103","18326157673","18371532634","18313818611","13772630827","13991701098","13954515915","18864512659","15169897380","13477759009","15234458934","15109195916","13613542579","13806335329","13837666229","15877551922","15949331285","15829294570","15897699103","18326157673","18371532634"};
		for (int i = 0; i < 20; i++) {
			Map<String, String> data=new HashMap<>();
			data.put("logid", GenerateIDUtil.generateSequenceNo());
			data.put("billId", phoneNums[random.nextInt(phoneNums.length)]);
			data.put("create_date", sdf.format(new Date()));
			
			datas.add(data);
		}
		root.put("datas", datas);
    	generateDbData.print(name, root);
	}
    @Test
    public void phone() {
		Random random=new Random();
		String[] phoneNums={"18313818611","13772630827","13991701098","13954515915","18864512659","15169897380","13477759009","15234458934","15109195916","13613542579","13806335329","13837666229","15877551922","15949331285","15829294570","15897699103","18326157673","18371532634","18313818611","13772630827","13991701098","13954515915","18864512659","15169897380","13477759009","15234458934","15109195916","13613542579","13806335329","13837666229","15877551922","15949331285","15829294570","15897699103","18326157673","18371532634","18313818611","13772630827","13991701098","13954515915","18864512659","15169897380","13477759009","15234458934","15109195916","13613542579","13806335329","13837666229","15877551922","15949331285","15829294570","15897699103","18326157673","18371532634"};
		for (int i = 0; i < 20; i++) {
			System.out.println(phoneNums[random.nextInt(phoneNums.length)]);
		}
    }
    @Test
    public void ftl() {
    	Map<String, Object> root=new HashMap<String, Object>();
    	generateDbData.print("371.ftl", root);
    }
}
