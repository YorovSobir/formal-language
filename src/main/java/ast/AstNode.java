package ast;

import ast.visitor.ASTVisitor;

import java.io.IOException;

public abstract class AstNode {
    public abstract String accept(ASTVisitor visitor) throws IOException;
}
