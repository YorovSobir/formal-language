package ru.spbau.mit.fl.ast;

import ru.spbau.mit.fl.ast.visitor.ASTVisitor;

import java.io.IOException;

public class CompareExpNode extends BinaryExpNode {

    private String op;
    private AstExpNode left;

    public String getOp() {
        return op;
    }

    @Override
    public AstExpNode getLeft() {
        return left;
    }

    @Override
    public AstExpNode getRight() {
        return right;
    }

    private AstExpNode right;

    public CompareExpNode(String op, AstExpNode left, AstExpNode right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    @Override
    public String accept(ASTVisitor visitor) throws IOException {
        return visitor.visitCompare(this);
    }
}
