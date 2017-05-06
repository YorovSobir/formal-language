package ast;

import ast.visitor.ASTVisitor;

public class BoolExpNode extends AstExpNode {

    public String getValue() {
        return value;
    }

    private String value;

    public BoolExpNode(String value) {
        this.value = value;
    }

    @Override
    public String accept(ASTVisitor visitor) {
        return visitor.visitBool(this);
    }
}
