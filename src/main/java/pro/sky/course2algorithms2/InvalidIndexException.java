package pro.sky.course2algorithms2;

public class InvalidIndexException extends RuntimeException{
    public InvalidIndexException(){
    }
    public InvalidIndexException(String message){
        super(message);
    }
    public InvalidIndexException(Throwable cause){
        super(cause);
    }
    public InvalidIndexException(String message,Throwable cause, boolean enableSuppression,boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }

}
