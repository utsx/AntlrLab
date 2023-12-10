// Generated from C:/Users/dimma/IdeaProjects/AntlrLab/src/main/java/ru/utsx/lang.g4 by ANTLR 4.13.1
package ru.utsx.Sources;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link langParser}.
 */
public interface langListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link langParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(langParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(langParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(langParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(langParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(langParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(langParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(langParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(langParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(langParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(langParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#sub}.
	 * @param ctx the parse tree
	 */
	void enterSub(langParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#sub}.
	 * @param ctx the parse tree
	 */
	void exitSub(langParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#division}.
	 * @param ctx the parse tree
	 */
	void enterDivision(langParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#division}.
	 * @param ctx the parse tree
	 */
	void exitDivision(langParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#multi}.
	 * @param ctx the parse tree
	 */
	void enterMulti(langParser.MultiContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#multi}.
	 * @param ctx the parse tree
	 */
	void exitMulti(langParser.MultiContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#compare}.
	 * @param ctx the parse tree
	 */
	void enterCompare(langParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#compare}.
	 * @param ctx the parse tree
	 */
	void exitCompare(langParser.CompareContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(langParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(langParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(langParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(langParser.ExprContext ctx);
}