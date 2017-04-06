// Generated from L.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LParser}.
 */
public interface LListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(LParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(LParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(LParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(LParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(LParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(LParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(LParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(LParser.ExpContext ctx);
}