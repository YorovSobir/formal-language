package ru.spbau.mit.fl.ast;

import ru.spbau.mit.fl.ast.visitor.ASTVisitor;

import java.io.IOException;

public class WriteStmtNode extends AstStmtNode {

    public AstExpNode getExp() {
        return exp;
    }

    private AstExpNode exp;
    public WriteStmtNode(AstExpNode exp) {
        this.exp = exp;
    }

    @Override
    public String accept(ASTVisitor visitor) throws IOException {
        return visitor.visitWrite(this);
    }
}
