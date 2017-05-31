package tuxt.help.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import tuxt.help.data.GenerateDbData;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(name="/TestServlet",urlPatterns = { "/testServlet" })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger=LogManager.getLogger(TestServlet.class);
	/**
	 * Default constructor. 
	 */
	public TestServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("你请求了TestServlet");
		System.out.println("get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String provCode=request.getParameter("provCode");
	
        GenerateDbData generateDbData=new GenerateDbData();
        Template temp = generateDbData.getTemplate(provCode+".ftl");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(temp.toString());
        
	}

}
