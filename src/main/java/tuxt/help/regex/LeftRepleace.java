package tuxt.help.regex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class LeftRepleace {
	static final	String projectCharsetEncode="gbk";
	 /**
     * 读取txt文件的内容
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static List<String> javaFile2String(File file){
    	List<String> result = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),projectCharsetEncode));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.add(s);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    /**
	 * 将内容一次写入文件
	 * 
	 * @param filename
	 *            文件名称
	 * @param content
	 *            文件内容
	 * @return
	 */
	public static void writeFileSingle(String filepath, String content)  throws Exception{
		if(!"".equals(content)){
			try {
				// 第一步先判断存放文件的临时目录是否存在
				// 第二步判断该文件是否存在
				File file = createTempFile(filepath);
				// 第三步将内容一次写入文件
				FileOutputStream out=new FileOutputStream(file);
				OutputStreamWriter outputStreamWriter=new OutputStreamWriter(out, projectCharsetEncode);
				BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
				bufferedWriter.write(content);
				bufferedWriter.close();
				outputStreamWriter.close();
				out.close();
			} catch (Exception e) {
				throw new Exception();
			}
		}
	}

	/**
	 * 创建临时文件
	 * 
	 * @param filePath
	 * @return
	 */
	private static File createTempFile(String filepath) throws Exception{
		File file = null;
		try {
			file = new File(filepath);
			if(!file.getParentFile().exists()){
				file.getParentFile().mkdirs();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			throw new Exception();
		}
		return file;
	}
    public static List<String> getFiles(String directory) throws Exception {
    	Path path = Paths.get(directory);
		FindFileVisitor visitor=new FindFileVisitor(".java");
		Files.walkFileTree(path, visitor);
		return visitor.getFileNames();
	}
 
	public static void main(String[] args) throws Exception {
		String filepath="E:/eclipse/ol_java/src/com/asiainfo/ol/realname/utils/DesSpecial.java";
		File file=new File(filepath);
		List<String> result =javaFile2String(file);
		StringBuilder builder=new StringBuilder();
		for (String str : result) {
//			String regexStr="(.*?\\()(.*)\\.(equals|equalsIgnoreCase)(\\s*)\\((.*?)\\)(.*)";
			String regexStr="(.*)(hex)\\.(equals|equalsIgnoreCase)(\\s*)\\((.*?)\\)(.*)";
//			String resultStr=str.replaceAll(regexStr, "$1$5\\.$3$4\\($2\\)$6");
			builder.append(str.replaceAll(regexStr, "$1$5\\.$3$4\\($2\\)$6")).append(System.lineSeparator());
		}
		writeFileSingle(filepath, builder.toString());

		/*String content="else if (BUSI_ID.equals(\"1006\")) {";
		String regexStr=".*[equals|equalsIgnoreCase]\\s*\\((.*?)\\).*";
		Pattern pattern=Pattern.compile(regexStr,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(content);
		while(matcher.find()){
			System.out.println(matcher.group(1));
		}*/
		/*String str
		String temp=str;
		if (str.indexOf("BUSI_ID.")>-1) {
			String regexStr=".*[equals|equalsIgnoreCase]\\s*\\((.*?)\\).*";
			temp=str.substring(0, str.indexOf("BUSI_ID."));
			Pattern pattern=Pattern.compile(regexStr,Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(str);
			if(matcher.find()){
				temp+=matcher.group(1)+".equals(BUSI_ID)";
			}
		}*/
		
		/*String content="else if (BUSI_ID.equals (\"1 11 \")) {";
		String regexStr="(.*)(BUSI_ID)\\.(equals|equalsIgnoreCase)(\\s*)\\((.*?)\\)(.*)";
		String resultStr=content.replaceAll(regexStr, "$1$5\\.$3$4\\($2\\)$6");
		System.out.println(resultStr);*/
		
		/*String content="else if (BUSI_ID2.equalsIgnoreCase (\"1 11 \"))) {";
		String regexStr="(.*?\\()(.*)\\.(equals|equalsIgnoreCase)(\\s*)\\((.*?)\\)(.*)";
		String resultStr=content.replaceAll(regexStr, "$1$5\\.$3$4\\($2\\)$6");
		System.out.println(resultStr);*/
	}

}

class FindFileVisitor extends SimpleFileVisitor<Path>{
	String fileNameSuffix=null;
	List<String> fileNames=new ArrayList<>();
	public List<String> getFileNames() {
		return fileNames;
	}
	public void setFileNames(List<String> fileNames) {
		this.fileNames = fileNames;
	}
	public FindFileVisitor(String fileNameSuffix) {
		this.fileNameSuffix=fileNameSuffix;
	}
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (file.toString().endsWith(fileNameSuffix)) {
			fileNames.add(file.toString());
		}
		return FileVisitResult.CONTINUE;
	}
}