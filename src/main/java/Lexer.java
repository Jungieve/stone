import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 丛子涵 on 2017/12/18
 */
public class Lexer {
    public static String regexPat
            = "\\s*((//.*)|([0-9]+)|(\"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\")"
            + "|[A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&|\\|\\||\\p{Punct})?";
    private Pattern pattern = Pattern.compile(regexPat);
    private ArrayList<Token> queue = new ArrayList<>();
    private boolean hasMore;
    private LineNumberReader reader;

    public Lexer(Reader reader){
        hasMore = true;
        reader = new LineNumberReader(reader);
    }

    public Token read() throws ParseException{
        if(fillQueue(0))
            return queue.remove(0);
        else
            return Token.EOF;
    }

    public Token peek(int i) throws ParseException{
        if(fillQueue(i))
            return queue.get(i);
        else
            return Token.EOF;
    }

    private boolean fillQueue(int i) throws ParseException{
        while(i >= queue.size()){
            if(hasMore)
                readLine();
            else
                return false;
        }
        return true;
    }

    protected void readLine() throws ParseException{
        String line = null;
        try{
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(line == null){
            hasMore = false;
            return;
        }
        int lineNo = reader.getLineNumber();
        Matcher matcher = pattern.matcher(line);
        matcher.useTransparentBounds(true).useAnchoringBounds(false);
        int pos = 0;
        int endPos = line.length();
        while(pos < endPos){
            matcher.region(pos,endPos);
            if(matcher.lookingAt()){
                addToken(lineNo,matcher);
                pos = matcher.end();
            }
            else
                throw new ParseException("bad token at line " + lineNo,lineNo);
        }
        queue.add(new IdToken(lineNo,Token.EOL));
    }

    protected static class IdToken extends Token {
        private String text;
        protected IdToken(int line,String id) {
            super(line);
            text = id;
        }

        @Override
        public boolean isIdentifier() { return true;}

        @Override
        public String getText() { return text; }
    }

    protected static class NumToken extends Token {
        private int value;
        protected NumToken(int line,int v) {
            super(line);
            value = v;
        }
        @Override
        public boolean isNumber() { return true; }

        @Override
        public String getText() { return Integer.toString(value); }

        @Override
        public int getNumber() { return value; }
    }

    protected static class StrToken extends Token {
        private String literal;
        protected StrToken(int line, String str) {
            super(line);
            literal = str;
        }
        @Override
        public boolean isString() { return true; }

        @Override
        public String getText() { return literal; }
    }
}
