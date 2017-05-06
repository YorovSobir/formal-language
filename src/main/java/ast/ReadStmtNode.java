package ast;

import ast.visitor.ASTVisitor;

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
