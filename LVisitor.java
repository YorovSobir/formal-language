// Generated from L.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(LParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#write_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrite_stmt(LParser.Write_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#read_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead_stmt(LParser.Read_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#assign_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stmt(LParser.Assign_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(LParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(LParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(LParser.ExpContext ctx);
}