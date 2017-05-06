package ast;

import ast.visitor.ASTVisitor;

import java.io.IOException;

public class WhileStmtNode extends AstStmtNode {

    public AstExpNode getWhileExp() {
        return whileExp;
    }

    public AstStmtNode getDoExp() {
        return doExp;
    }

    private AstExpNode whileExp;
    private AstStmtNode doExp;

    public WhileStmtNode(AstExpNode whileExp, AstStmtNode doExp) {
        this.whileExp = whileExp;
        this.doExp = doExp;
    }

    @Override
    public String accept(ASTVisitor visitor) throws IOException {
        return visitor.visitWhile(this);
    }
}
