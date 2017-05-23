package ru.spbau.mit.fl;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import ru.spbau.mit.fl.ast.*;
import java.util.List;

public class ASTBuildVisitor implements LVisitor<AstNode> {

    @Override
    public AstNode visitProgram(LParser.ProgramContext ctx) {
        return ctx.seqStmt().accept(this);
    }

    @Override
    public AstNode visitStatement(LParser.StatementContext ctx) {
        return ctx.stmt().accept(this);
    }

    @Override
    public AstNode visitStmtFromSeq(LParser.StmtFromSeqContext ctx) {
        return ctx.stmt().accept(this);
    }

    @Override
    public AstNode visitBeginEndSeqStmt(LParser.BeginEndSeqStmtContext ctx) {
        return ctx.seqStmt().accept(this);
    }

    @Override
    public AstNode visitBoolExp(LParser.BoolExpContext ctx) {
        String value = ctx.getText();
        return new BoolExpNode(value);
    }

    @Override
    public AstNode visitCompareExp(LParser.CompareExpContext ctx) {
        String op = ctx.op.getText();
        AstExpNode exp1 = (AstExpNode) ctx.exp(0).accept(this);
        AstExpNode exp2 = (AstExpNode) ctx.exp(1).accept(this);
        return new CompareExpNode(op, exp1, exp2);
    }

    @Override
    public AstNode visitMultExp(LParser.MultExpContext ctx) {
        String op = ctx.op.getText();
        AstExpNode exp1 = (AstExpNode) ctx.exp(0).accept(this);
        AstExpNode exp2 = (AstExpNode) ctx.exp(1).accept(this);
        return new MultExpNode(op, exp1, exp2);
    }

    @Override
    public AstNode visitAlgSumExp(LParser.AlgSumExpContext ctx) {
        String op = ctx.op.getText();
        AstExpNode exp1 = (AstExpNode) ctx.exp(0).accept(this);
        AstExpNode exp2 = (AstExpNode) ctx.exp(1).accept(this);
        return new AlgSumExpNode(op, exp1, exp2);
    }

    @Override
    public AstNode visitNumExp(LParser.NumExpContext ctx) {
        return new NumExpNode(ctx.getText());
    }

    @Override
    public AstNode visitInnerExp(LParser.InnerExpContext ctx) {
        return ctx.exp().accept(this);
    }

    @Override
    public AstNode visitIdentExp(LParser.IdentExpContext ctx) {
        return new IdentExpNode(ctx.getText());
    }

    @Override
    public AstNode visitColonStmt(LParser.ColonStmtContext ctx) {
        AstStmtNode left = (AstStmtNode) ctx.seqStmt(0).accept(this);
        AstStmtNode right = (AstStmtNode) ctx.seqStmt(1).accept(this);
        return new ColonStmtNode(left, right);
    }

    @Override
    public AstNode visitBeginEndStmt(LParser.BeginEndStmtContext ctx) {
        return ctx.stmt().accept(this);
    }

    @Override
    public AstNode visitSkip(LParser.SkipContext ctx) {
        return new SkipStmtNode();
    }

    @Override
    public AstNode visitAssign(LParser.AssignContext ctx) {
        IdentExpNode ident = new IdentExpNode(ctx.IDENT().getText());
        AstExpNode exp = (AstExpNode) ctx.exp().accept(this);
        return new AssignStmtNode(ident, exp);
    }

    @Override
    public AstNode visitWrite(LParser.WriteContext ctx) {
        AstExpNode exp = (AstExpNode) ctx.exp().accept(this);
        return new WriteStmtNode(exp);
    }

    @Override
    public AstNode visitRead(LParser.ReadContext ctx) {
        IdentExpNode ident = new IdentExpNode(ctx.IDENT().getText());
        return new ReadStmtNode(ident);
    }

    @Override
    public AstNode visitWhile(LParser.WhileContext ctx) {
        AstExpNode whileExp = (AstExpNode) ctx.exp().accept(this);
        AstStmtNode doStmt = (AstStmtNode) ctx.sequenceStmt().accept(this);
        return new WhileStmtNode(whileExp, doStmt);
    }

    @Override
    public AstNode visitIf(LParser.IfContext ctx) {
        List<LParser.SequenceStmtContext> stmt = ctx.sequenceStmt();
        AstExpNode ifExp = (AstExpNode) ctx.exp().accept(this);
        AstStmtNode stmt1 = (AstStmtNode) stmt.get(0).accept(this);
        AstStmtNode stmt2 = (AstStmtNode) stmt.get(1).accept(this);
        return new IfStmtNode(ifExp, stmt1, stmt2);
    }

    @Override
    public AstNode visit(ParseTree parseTree) {
        return parseTree.accept(this);
    }

    @Override
    public AstNode visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public AstNode visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public AstNode visitErrorNode(ErrorNode errorNode) {
        System.out.println(errorNode.getText());
        System.exit(-1);
        return null;
    }
}
