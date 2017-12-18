import ASTree.StoneException;

/**
 * Created by 丛子涵 on 2017/12/18
 */
public abstract class Token {
    public static final Token EOF = new Token(-1) {};
    public static final String EOL = "\\n";
    private int lineNumber;

    protected Token(int line){
        lineNumber = line;
    }
    public boolean isNumber(){ return false; }
    public boolean isString(){ return false; }
    public boolean isIdentifier(){ return false; }
    public int getLineNumber() { return lineNumber; }
    public String getText(){ return ""; }
    public int getNumber(){ throw new StoneException("not number token");}
}
