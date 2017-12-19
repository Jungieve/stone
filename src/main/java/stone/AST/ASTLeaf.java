package stone.AST;

import stone.Scanner.Token;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 丛子涵 on 2017/12/19
 */
public class ASTLeaf extends ASTree {
    protected Token token;
    private static List<ASTree> empty = new ArrayList<>();

    public ASTLeaf(Token t) { this.token = t; }

    @Override
    public ASTree child(int i) { throw new IndexOutOfBoundsException(); }

    @Override
    public int numChildren() { return 0; }

    @Override
    public Iterator<ASTree> children() { return empty.iterator(); }

    @Override
    public String location() { return "at line " + token.getLineNumber(); }

    @Override
    public String toString() { return token.getText(); }

    public Token getToken() { return token; }
}
