package stone.AST;

import stone.Scanner.Token;

/**
 * Created by 丛子涵 on 2017/12/19
 */
public class NumberLiteral extends ASTLeaf {
    public NumberLiteral(Token t) { super(t); }
    public int value() { return token.getNumber();}
}
