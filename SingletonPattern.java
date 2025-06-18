public class SingletonPattern{
  static class Logger{
    private static Logger instance;
    private Logger(){
      System.out.println("Initializing the Logger");
    }
    public static Logger getInstance(){
      if(instance==null){
        instance=new Logger();
      }
      return instance;
    }
    public void logMessage(String msg){
      System.out.println("Log: "+msg);
    }
  }

  public static void main(String[] args){
    Logger log1 = Logger.getInstance();
    log1.logMessage("First log message");
    Logger log2 = Logger.getInstance();
    log2.logMessage("Second log message");
    if(log1==log2){
      System.out.println("Both loggers are the same instance");
    }else{
      System.out.println("Different instances");
    }
  }
}
