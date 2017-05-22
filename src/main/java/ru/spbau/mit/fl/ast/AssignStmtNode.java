package ru.spbau.mit.fl.ast;

import ru.spbau.mit.fl.ast.visitor.ASTVisitor;

import java.io.IOException;

public class AssignStmtNode extends AstStmtNode {

    public IdentExpNode getIdent() {
        return ident;
    }

    public AstExpNode getValue() {
        return value;
    }

    private IdentExpNode ident;
    private AstExpNode value;

    public AssignStmtNode(IdentExpNode ident, AstExpNode value) {
        this.ident = ident;
        this.value = value;
    }

    @Override
    public String accept(ASTVisitor visitor) throws IOException {
        return visitor.visitAssighn(this);
    }
}
