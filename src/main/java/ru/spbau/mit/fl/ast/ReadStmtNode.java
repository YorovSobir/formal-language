package ru.spbau.mit.fl.ast;

import ru.spbau.mit.fl.ast.visitor.ASTVisitor;

public class ReadStmtNode extends AstStmtNode {

    public IdentExpNode getIdent() {
        return ident;
    }

    private IdentExpNode ident;

    public ReadStmtNode(IdentExpNode ident) {
        this.ident = ident;
    }

    @Override
    public String accept(ASTVisitor visitor) {
        return visitor.visitRead(this);
    }
}
