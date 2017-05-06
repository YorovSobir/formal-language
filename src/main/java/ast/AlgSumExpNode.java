package ast;

import ast.visitor.ASTVisitor;

import java.io.IOException;

public class AlgSumExpNode extends BinaryExpNode {

    public String getOp() {
        return op;
    }

    private String op;

    public AlgSumExpNode(String op, AstExpNode left, AstExpNode right) {
        super();
        this.op = op;
        setLeft(left);
        setRight(right);
    }

    @Override
    public String accept(ASTVisitor visitor) throws IOException {
        return visitor.visitSum(this);
    }
}
