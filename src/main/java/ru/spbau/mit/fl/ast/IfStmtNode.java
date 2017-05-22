package ru.spbau.mit.fl.ast;

import ru.spbau.mit.fl.ast.visitor.ASTVisitor;

import java.io.IOException;

public class IfStmtNode extends AstStmtNode{

    public AstExpNode getIfexp() {
        return ifexp;
    }

    public AstStmtNode getStmt1() {
        return stmt1;
    }

    public AstStmtNode getStmt2() {
        return stmt2;
    }

    private AstExpNode ifexp;
    private AstStmtNode stmt1;
    private AstStmtNode stmt2;

    public IfStmtNode(AstExpNode exp, AstStmtNode stmt1, AstStmtNode stmt2) {
        this.ifexp = exp;
        this.stmt1 = stmt1;
        this.stmt2 = stmt2;
    }

    @Override
    public String accept(ASTVisitor visitor) throws IOException {
        return visitor.visitIf(this);
    }
}
