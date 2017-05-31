package tuxt.help.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class MyHelp {
	/**
	 * 将异常的完整堆栈追踪信息保存到字符串中
	 * @param t Throwable
	 * @return 异常的完整堆栈追踪信息
	 */
	public static String printStackTraceToString(Throwable t) {
	    StringWriter sw = new StringWriter();
	    t.printStackTrace(new PrintWriter(sw, true));
	    //e.toString()或e.getMessage()只能得到栈顶的内容
	    return sw.getBuffer().toString()+t.getMessage();
	}
}
