package stone.AST;

import java.util.Iterator;

/**
 * Created by 丛子涵 on 2017/12/19
 */
public abstract class ASTree {
    public abstract ASTree child(int i);
    public abstract int numChildren();
    public abstract Iterator<ASTree> children();
    public abstract String location();
    public Iterator<ASTree> iterator() { return children();}
}
