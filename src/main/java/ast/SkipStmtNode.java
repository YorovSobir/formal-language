package ast;

import ast.visitor.ASTVisitor;

import java.io.IOException;

public class SkipStmtNode extends AstStmtNode {
    public String accept(ASTVisitor visitor) throws IOException {
        return visitor.visitSkip(this);
    }
}
