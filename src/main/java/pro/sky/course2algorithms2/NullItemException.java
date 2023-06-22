package pro.sky.course2algorithms2;

public class NullItemException extends RuntimeException{
    public NullItemException(){
    }
    public NullItemException(String message){
        super(message);
    }
    public NullItemException(Throwable cause){
        super(cause);
    }
    public NullItemException(String message,Throwable cause, boolean enableSuppression,boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }
}
