package blue.nez.peg.expression;

import blue.nez.peg.Expression;
import blue.nez.peg.ExpressionVisitor;

/**
 * Expression.And represents an and-predicate &e.
 * 
 * @author kiki
 *
 */

public class PAnd extends PUnary {

	public PAnd(Expression e) {
		super(e);
	}

	@Override
	public final <V, A> V visit(ExpressionVisitor<V, A> v, A a) {
		return v.visitAnd(this, a);
	}

	@Override
	public void strOut(StringBuilder sb) {
		this.formatUnary("&", null, sb);
	}

}