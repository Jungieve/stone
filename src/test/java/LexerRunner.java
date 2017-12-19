import stone.Exception.ParseException;
import stone.Scanner.Lexer;
import stone.Scanner.Token;

/**
 * Created by 丛子涵 on 2017/12/19
 */
public class LexerRunner {
    public static void main(String[] args) throws ParseException {
        Lexer l = new Lexer(new CodeDialog());
        for (Token t; (t = l.read()) != Token.EOF; )
            System.out.println("=> " + t.getText());
    }
}
