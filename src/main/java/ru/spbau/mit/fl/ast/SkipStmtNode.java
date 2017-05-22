package ru.spbau.mit.fl.ast;

import ru.spbau.mit.fl.ast.visitor.ASTVisitor;

import java.io.IOException;

public class SkipStmtNode extends AstStmtNode {
    public String accept(ASTVisitor visitor) throws IOException {
        return visitor.visitSkip(this);
    }
}
