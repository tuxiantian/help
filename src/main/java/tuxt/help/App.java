package tuxt.help;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;




/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger logger =  Logger.getLogger(App.class);
    public static void main( String[] args )
    {
    	BasicConfigurator.configure();
    	Object message="aa";
		logger.info(message);
    	
        System.out.println( "Hello World!" );
    }
}
