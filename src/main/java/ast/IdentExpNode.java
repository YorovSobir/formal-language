package ast;

import ast.visitor.ASTVisitor;

public class IdentExpNode extends AstExpNode {

    public String getValue() {
        return value;
    }

    private String value;
    public IdentExpNode(String value) {
        this.value = value;
    }

    @Override
    public String accept(ASTVisitor visitor) {
        return visitor.visitIdent(this);
    }
}
