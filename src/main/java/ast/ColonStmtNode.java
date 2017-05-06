package ast;

import ast.visitor.ASTVisitor;

import java.io.IOException;

public class ColonStmtNode extends AstStmtNode{

    public AstStmtNode getLeft() {
        return left;
    }

    public AstStmtNode getRight() {
        return right;
    }

    private AstStmtNode left;
    private AstStmtNode right;

    public ColonStmtNode(AstStmtNode left, AstStmtNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String accept(ASTVisitor visitor) throws IOException {
        return visitor.visitColon(this);
    }
}
