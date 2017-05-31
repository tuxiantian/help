package tuxt.frame.logger;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.LogManager;
public class LoggerFactory
{
  private static Map<String, Map<String, DefaultLogger>> loggers = new HashMap();
  
  public LoggerFactory() {}
  
  public static Logger getDaoLog(String id)
  {
    if (!loggers.containsKey("DAO")) {
      loggers.put("DAO", new HashMap());
    }
    Map<String, DefaultLogger> logger = (Map)loggers.get("DAO");
    if (!logger.containsKey(id)) {
      logger.put(id, new DefaultLogger(id, LogManager.getLogger("DAO")));
    }
    return (Logger)logger.get(id);
  }
  
  public static Logger getDaoLog(Class<?> clz)
  {
    return getDaoLog(getClassName(clz));
  }
  
  public static Logger getActionLog(String id)
  {
    if (!loggers.containsKey("ACTION")) {
      loggers.put("ACTION", new HashMap());
    }
    Map<String, DefaultLogger> logger = (Map)loggers.get("ACTION");
    if (!logger.containsKey(id)) {
      logger.put(id, new DefaultLogger(id, LogManager.getLogger("ACTION")));
    }
    return (Logger)logger.get(id);
  }
  
  public static Logger getActionLog(Class<?> clz)
  {
    return getActionLog(getClassName(clz));
  }
  
  public static Logger getUtilLog(String id)
  {
    if (!loggers.containsKey("UTIL")) {
      loggers.put("UTIL", new HashMap());
    }
    Map<String, DefaultLogger> logger = (Map)loggers.get("UTIL");
    if (!logger.containsKey(id)) {
      logger.put(id, new DefaultLogger(id, LogManager.getLogger("UTIL")));
    }
    return (Logger)logger.get(id);
  }
  
  public static Logger getApplicationLog(Class<?> clz)
  {
    return getApplicationLog(getClassName(clz));
  }
  
  public static Logger getApplicationLog(String id)
  {
    if (!loggers.containsKey("APPLICATION")) {
      loggers.put("APPLICATION", new HashMap());
    }
    Map<String, DefaultLogger> logger = (Map)loggers.get("APPLICATION");
    if (!logger.containsKey(id)) {
      logger.put(id, new DefaultLogger(id, LogManager.getLogger("APPLICATION")));
    }
    return (Logger)logger.get(id);
  }
  
  public static Logger getUtilLog(Class<?> clz)
  {
    return getUtilLog(getClassName(clz));
  }
  
  public static Logger getServiceLog(String id)
  {
    if (!loggers.containsKey("SERVICE")) {
      loggers.put("SERVICE", new HashMap());
    }
    Map<String, DefaultLogger> logger = (Map)loggers.get("SERVICE");
    if (!logger.containsKey(id)) {
      logger.put(id, new DefaultLogger(id, LogManager.getLogger("SERVICE")));
    }
    return (Logger)logger.get(id);
  }
  
  public static Logger getServiceLog(Class<?> clz)
  {
    return getServiceLog(getClassName(clz));
  }
  
  private static String getClassName(Class<?> clz)
  {
    return clz.getName();
  }
}