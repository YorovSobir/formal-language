package ru.spbau.mit.fl.ast;

import ru.spbau.mit.fl.ast.visitor.ASTVisitor;

public class NumExpNode extends AstExpNode {

    public String getValue() {
        return value;
    }

    private String value;
    public NumExpNode(String value) {
        this.value = value;
    }

    @Override
    public String accept(ASTVisitor visitor) {
        return visitor.visitNum(this);
    }
}
