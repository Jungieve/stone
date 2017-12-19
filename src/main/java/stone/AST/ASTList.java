package stone.AST;

import java.util.Iterator;
import java.util.List;

/**
 * Created by 丛子涵 on 2017/12/19
 */
public class ASTList extends  ASTree {
    protected List<ASTree> children;

    public ASTList(List<ASTree> childrenList) { this.children = childrenList; }

    @Override
    public ASTree child(int i) { return children.get(i); }

    @Override
    public int numChildren() { return children.size(); }

    @Override
    public Iterator<ASTree> children() { return children.iterator(); }

    @Override
    public String location() {
        for (ASTree tree: children){
            String s = tree.location();
            if(s != null)
                return s;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('(');
        String sep = "";
        for (ASTree t: children){
            builder.append(sep);
            sep = " ";
            builder.append(t.toString());
        }
        return builder.append(')').toString();
    }
}
