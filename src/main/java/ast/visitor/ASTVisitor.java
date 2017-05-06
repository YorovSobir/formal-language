package ast.visitor;

import ast.*;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class ASTVisitor {

    private ArrayList<String> tree = new ArrayList<String>();
    private Writer dos = null;
    private int nodeNumber = 0;

    public ASTVisitor(String path) throws FileNotFoundException, UnsupportedEncodingException {
        dos = new OutputStreamWriter(new FileOutputStream(path), "ISO-8859-1");
    }

    public void printTree() throws IOException {

        dos.write("digraph {\n");
        ListIterator<String> it = tree.listIterator(tree.size());
        while (it.hasPrevious()) {
            dos.write(it.previous());
        }
        dos.write("}");
        dos.close();
    }

    public String visitSum(AlgSumExpNode stmtNode) throws IOException {
        int curNodeNumber = nodeNumber;
        ++nodeNumber;
        String left = stmtNode.getLeft().accept(this);
        String right = stmtNode.getRight().accept(this);
        StringBuilder sb = new StringBuilder();
        sb.append("\"#" + curNodeNumber + " " + stmtNode.getOp() + "\"");
        String res = sb.toString();
        sb.append(" -> ");
        int temp = sb.length();
        sb.append(left);
        sb.append(";\n");
        tree.add(sb.toString());
        sb.replace(temp, sb.length(), right);
        sb.append(";\n");
        tree.add(sb.toString());
        return res;
    }

    public String visitMult(MultExpNode stmtNode) throws IOException {
        int curNodeNumber = nodeNumber;
        ++nodeNumber;
        String left = stmtNode.getLeft().accept(this);
        String right = stmtNode.getRight().accept(this);
        StringBuilder sb = new StringBuilder();
        sb.append("\"#" + curNodeNumber + " " + stmtNode.getOp() + "\"");
        String res = sb.toString();
        sb.append(" -> ");
        int temp = sb.length();
        sb.append(left);
        sb.append(";\n");
        tree.add(sb.toString());
        sb.replace(temp, sb.length(), right);
        sb.append(";\n");
        tree.add(sb.toString());
        return res;
    }

    public String visitAssighn(AssignStmtNode stmtNode) throws IOException {
        int curNodeNumber = nodeNumber;
        ++nodeNumber;
        String left = stmtNode.getIdent().accept(this);
        String right = stmtNode.getValue().accept(this);
        StringBuilder sb = new StringBuilder();
        sb.append("\"#" + curNodeNumber + " :=" + "\"");
        String res = sb.toString();
        sb.append(" -> ");
        int temp = sb.length();
        sb.append(left);
        sb.append(";\n");
        tree.add(sb.toString());
        sb.replace(temp, sb.length(), right);
        sb.append(";\n");
        tree.add(sb.toString());
        return res;
    }

    public String visitBool(BoolExpNode boolExpNode) {
        ++nodeNumber;
        return "\"#" + (nodeNumber - 1) + " " + boolExpNode.getValue() + "\"";
    }

    public String visitColon(ColonStmtNode colonStmtNode) throws IOException {
        int curNodeNumber = nodeNumber;
        ++nodeNumber;
        String left = colonStmtNode.getLeft().accept(this);
        String right = colonStmtNode.getRight().accept(this);
        StringBuilder sb = new StringBuilder();
        sb.append("\"#" + curNodeNumber + " ;" + "\"");
        String res = sb.toString();
        sb.append(" -> ");
        int temp = sb.length();
        sb.append(left);
        sb.append(";\n");
        tree.add(sb.toString());
        sb.replace(temp, sb.length(), right);
        sb.append(";\n");
        tree.add(sb.toString());
        return res;
    }

    public String visitIdent(IdentExpNode identExpNode) {
        ++nodeNumber;
        return "\"#" + (nodeNumber - 1) + " " + identExpNode.getValue() + "\"";
    }

    public String visitIf(IfStmtNode ifStmtNode) throws IOException {
        int curNodeNumber = nodeNumber;
        ++nodeNumber;
        String exp = ifStmtNode.getIfexp().accept(this);
        String stmt1 = ifStmtNode.getStmt1().accept(this);
        String stmt2 = ifStmtNode.getStmt2().accept(this);
        StringBuilder sb = new StringBuilder();
        sb.append("\"#" + curNodeNumber + " if" + "\"");
        String res = sb.toString();
        sb.append(" -> ");
        int temp = sb.length();
        sb.append(stmt1);
        sb.append(";\n");
        tree.add(sb.toString());

        sb.replace(temp, sb.length(), exp);
        sb.append(";\n");
        tree.add(sb.toString());

        sb.replace(temp, sb.length(), stmt2);
        sb.append(";\n");
        tree.add(sb.toString());
        return res;
    }

    public String visitNum(NumExpNode numExpNode) {
        ++nodeNumber;
        return "\"#" + (nodeNumber - 1) + " " + numExpNode.getValue() + "\"";
    }

    public String visitRead(ReadStmtNode readStmtNode) {
        int curNodeNumber = nodeNumber;
        ++nodeNumber;
        String ident = readStmtNode.getIdent().accept(this);
        StringBuilder sb = new StringBuilder();
        sb.append("\"#" + curNodeNumber + " read" + "\"");
        String res = sb.toString();
        sb.append(" -> ");
        int temp = sb.length();
        sb.append(ident);
        sb.append(";\n");
        tree.add(sb.toString());
        return res;
    }

    public String visitWhile(WhileStmtNode whileStmtNode) throws IOException {
        int curNodeNumber = nodeNumber;
        ++nodeNumber;
        String exp = whileStmtNode.getWhileExp().accept(this);
        String stmt = whileStmtNode.getDoExp().accept(this);
        StringBuilder sb = new StringBuilder();
        sb.append("\"#" + curNodeNumber + " while" + "\"");
        String res = sb.toString();
        sb.append(" -> ");
        int temp = sb.length();
        sb.append(exp);
        sb.append(";\n");
        tree.add(sb.toString());

        sb.replace(temp, sb.length(), stmt);
        sb.append(";\n");
        tree.add(sb.toString());

        return res;
    }

    public String visitWrite(WriteStmtNode writeStmtNode) throws IOException {
        int curNodeNumber = nodeNumber;
        ++nodeNumber;
        String exp = writeStmtNode.getExp().accept(this);
        StringBuilder sb = new StringBuilder();
        sb.append("\"#" + curNodeNumber + " write" + "\"");
        String res = sb.toString();
        sb.append(" -> ");
        int temp = sb.length();
        sb.append(exp);
        sb.append(";\n");
        tree.add(sb.toString());
        return res;
    }

    public String visitCompare(CompareExpNode compareExpNode) throws IOException {
        int curNodeNumber = nodeNumber;
        ++nodeNumber;
        String left = compareExpNode.getLeft().accept(this);
        String right = compareExpNode.getRight().accept(this);
        StringBuilder sb = new StringBuilder();
        sb.append("\"#" + curNodeNumber + " " + compareExpNode.getOp() + "\"");
        String res = sb.toString();
        sb.append(" -> ");
        int temp = sb.length();
        sb.append(left);
        sb.append(";\n");
        tree.add(sb.toString());
        sb.replace(temp, sb.length(), right);
        sb.append(";\n");
        tree.add(sb.toString());
        return res;
    }

    public String visitSkip(SkipStmtNode skipStmtNode) {
        ++nodeNumber;
        return "\"#" + (nodeNumber - 1) + " skip" + "\"";
    }
}
