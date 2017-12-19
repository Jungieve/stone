package stone.AST;

import stone.Parser.Token;

/**
 * Created by 丛子涵 on 2017/12/19
 */
public class Name extends ASTLeaf {
    public Name(Token t) { super(t); }
    public String name() {return getToken().getText();}
}
