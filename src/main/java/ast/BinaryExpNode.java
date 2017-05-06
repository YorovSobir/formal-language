package ast;

public abstract class BinaryExpNode extends AstExpNode {
    private AstExpNode left;
    private AstExpNode right;

    public AstExpNode getLeft() {
        return left;
    }

    public void setLeft(AstExpNode left) {
        this.left = left;
    }

    public AstExpNode getRight() {
        return right;
    }

    public void setRight(AstExpNode right) {
        this.right = right;
    }
}
