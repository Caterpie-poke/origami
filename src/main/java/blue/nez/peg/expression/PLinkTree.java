package blue.nez.peg.expression;

import blue.nez.ast.Symbol;
import blue.nez.peg.Expression;
import blue.nez.peg.ExpressionVisitor;

public class PLinkTree extends PUnary {
	public Symbol label;

	public PLinkTree(Symbol label, Expression e) {
		super(e);
		this.label = label;
	}

	@Override
	protected Object[] extract() {
		return new Object[] { this.label };
	}

	@Override
	public final <V, A> V visit(ExpressionVisitor<V, A> v, A a) {
		return v.visitLinkTree(this, a);
	}

	@Override
	public void strOut(StringBuilder sb) {
		this.formatUnary((this.label != null) ? "$" + this.label + "(" : "$(", ")", sb);
	}
}