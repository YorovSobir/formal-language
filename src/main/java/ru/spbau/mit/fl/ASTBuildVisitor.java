package ru.spbau.mit.fl;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import ru.spbau.mit.fl.ast.*;
import java.util.List;

public class ASTBuildVisitor implements LVisitor<AstNode>{
    public AstNode visitProgram(LParser.ProgramContext ctx) {
        return ctx.stmt_seq().accept(this);
//        return ctx.stmt().accept(this);
    }

    @Override
    public AstNode visitStatement(LParser.StatementContext ctx) {
        return ctx.stmt().accept(this);
//        return null;
    }

    public AstNode visitIfStmt(LParser.IfStmtContext ctx) {
        List<LParser.StmtContext> stmt = ctx.if_stmt().stmt();
        AstExpNode ifExp = (AstExpNode) ctx.if_stmt().exp().accept(this);
        AstStmtNode stmt1 = (AstStmtNode) stmt.get(0).accept(this);
        AstStmtNode stmt2 = (AstStmtNode) stmt.get(1).accept(this);
        return new IfStmtNode(ifExp, stmt1, stmt2);
    }

    public AstNode visitWhileStmt(LParser.WhileStmtContext ctx) {
        AstExpNode whileExp = (AstExpNode) ctx.while_stmt().exp().accept(this);
        AstStmtNode doStmt = (AstStmtNode) ctx.while_stmt().stmt().accept(this);
        return new WhileStmtNode(whileExp, doStmt);
    }

    public AstNode visitAssignStmt(LParser.AssignStmtContext ctx) {
        IdentExpNode ident = new IdentExpNode(ctx.IDENT().getText());
        AstExpNode exp = (AstExpNode) ctx.exp().accept(this);
        return new AssignStmtNode(ident, exp);
    }

    public AstNode visitWriteStmt(LParser.WriteStmtContext ctx) {
        AstExpNode exp = (AstExpNode) ctx.exp().accept(this);
        return new WriteStmtNode(exp);
    }

    public AstNode visitReadStmt(LParser.ReadStmtContext ctx) {
        IdentExpNode ident = new IdentExpNode(ctx.IDENT().getText());
        return new ReadStmtNode(ident);
    }

    public AstNode visitColonStmt(LParser.ColonStmtContext ctx) {
        AstStmtNode left = (AstStmtNode) ctx.stmt_seq(0).accept(this);
        AstStmtNode right = (AstStmtNode) ctx.stmt_seq(1).accept(this);
        return new ColonStmtNode(left, right);
    }

    public AstNode visitSkipStmt(LParser.SkipStmtContext ctx) {
        return new SkipStmtNode();
    }

    public AstNode visitWhile_stmt(LParser.While_stmtContext ctx) {
        AstExpNode exp = (AstExpNode) ctx.exp().accept(this);
        AstStmtNode stmt = (AstStmtNode) ctx.stmt().accept(this);
        return new WhileStmtNode(exp, stmt);
    }

    public AstNode visitIf_stmt(LParser.If_stmtContext ctx) {
        AstExpNode exp = (AstExpNode) ctx.exp().accept(this);
        AstStmtNode stmt1 = (AstStmtNode) ctx.stmt(0).accept(this);
        AstStmtNode stmt2 = (AstStmtNode) ctx.stmt(1).accept(this);
        return new IfStmtNode(exp, stmt1, stmt2);
    }

    public AstNode visitBoolExp(LParser.BoolExpContext ctx) {
        String value = ctx.getText();
        return new BoolExpNode(value);
    }

    public AstNode visitCompareExp(LParser.CompareExpContext ctx) {
        String op = ctx.op.getText();
        AstExpNode exp1 = (AstExpNode) ctx.exp(0).accept(this);
        AstExpNode exp2 = (AstExpNode) ctx.exp(1).accept(this);
        return new CompareExpNode(op, exp1, exp2);
    }

    public AstNode visitMultExp(LParser.MultExpContext ctx) {
        String op = ctx.op.getText();
        AstExpNode exp1 = (AstExpNode) ctx.exp(0).accept(this);
        AstExpNode exp2 = (AstExpNode) ctx.exp(1).accept(this);
        return new MultExpNode(op, exp1, exp2);
    }

    public AstNode visitAlgSumExp(LParser.AlgSumExpContext ctx) {
        String op = ctx.op.getText();
        AstExpNode exp1 = (AstExpNode) ctx.exp(0).accept(this);
        AstExpNode exp2 = (AstExpNode) ctx.exp(1).accept(this);
        return new AlgSumExpNode(op, exp1, exp2);
    }

    public AstNode visitNumExp(LParser.NumExpContext ctx) {
        return new NumExpNode(ctx.getText());
    }

    public AstNode visitInnerExp(LParser.InnerExpContext ctx) {
        return ctx.exp().accept(this);
    }

    public AstNode visitIdentExp(LParser.IdentExpContext ctx) {
        return new IdentExpNode(ctx.getText());
    }

    public AstNode visit(ParseTree parseTree) {
        return parseTree.accept(this);
    }

    public AstNode visitChildren(RuleNode ruleNode) {
        return null;
    }

    public AstNode visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    public AstNode visitErrorNode(ErrorNode errorNode) {
        System.out.println(errorNode.getText());
        System.exit(-1);
        return null;
    }
}
