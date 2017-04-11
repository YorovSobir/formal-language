// Generated from L.g4 by ANTLR 4.5.3
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
	 * Enter a parse tree produced by {@link LParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWrite_stmt(LParser.Write_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWrite_stmt(LParser.Write_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRead_stmt(LParser.Read_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRead_stmt(LParser.Read_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(LParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(LParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(LParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(LParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(LParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(LParser.If_stmtContext ctx);
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