package latte.ast;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.Token;
import java.util.List;

public class LatteAST extends CommonTree {

	
	public LatteAST(Token t) {
		super(t);
		//text = (t != null? t.getText(): "[]");
	}

	public LatteAST() {
		// TODO Auto-generated constructor stub
	}

	public LatteAST(CommonTree node) {
		super(node);
		// TODO Auto-generated constructor stub
	}
	
	
	/* (non-Javadoc)
	 * @see org.antlr.runtime.tree.CommonTree#dupNode()
	 */
	@Override
	public LatteAST dupNode()
	{
		return new LatteAST(this);
	}	

	/**
	 *  Produces a string representation of the parse tree rooted at this node.
	 */
	@Override
	public String toString()
	{
		return constructTreeString(this, "");
	}
	
	static private final String INDENT_STRING = "  ";
	
	@SuppressWarnings("unchecked")
	private String constructTreeString(LatteAST node, String indent)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(indent + "[" + node.getType() + "] " +
				node.getText() + "\n");
		if (node.getChildCount() > 0) {
			for (LatteAST n : (List<LatteAST>)node.getChildren()) {
				sb.append(n.constructTreeString(n, indent + INDENT_STRING));
			}
		}
		return sb.toString();
	}
	
	public  void printTree()
	{
		constructPrintTree(this, 0);
	}
	
	private static void constructPrintTree(CommonTree t, int indent) {
		if ( t != null ) {
			StringBuffer sb = new StringBuffer(indent);
			for ( int i = 0; i < indent; i++ )
				sb = sb.append("   ");
			for ( int i = 0; i < t.getChildCount(); i++ ) {
				System.out.println(sb.toString() + t.getChild(i).toString());
				constructPrintTree((CommonTree)t.getChild(i), indent+1);
			}
		}
	}
	
}
