package stone.AST;

import java.util.List;

/**
 * Created by 丛子涵 on 2017/12/19
 */
public class BinaryExpr extends ASTList {
    public BinaryExpr(List<ASTree> childrenList) { super(childrenList); }
    public ASTree left() { return child(0);}
    public ASTree right() {return child(2);}
    public String operator() { return ((ASTLeaf)child(1)).getToken().getText();}
}
