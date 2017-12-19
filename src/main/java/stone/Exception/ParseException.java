package stone.Exception;

import stone.Scanner.Token;

import java.io.IOException;

/**
 * Created by 丛子涵 on 2017/12/19
 */
public class ParseException extends Exception{
    public ParseException(Token t){
        this("",t);
    }
    public ParseException(String msg, Token t){
        super("syntax serror around "+ location(t) + ". " + msg);
    }
    private static String location(Token t){
        if(t == Token.EOF)
            return "the last line";
        else
            return "\"" + t.getText() + "\" at line " + t.getLineNumber();
    }
    public ParseException(IOException e){
        super(e);
    }
    public ParseException(String msg){
        super(msg);
    }
}
