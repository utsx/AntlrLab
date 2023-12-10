// Generated from C:/Users/dimma/IdeaProjects/AntlrLab/src/main/java/ru/utsx/lang.g4 by ANTLR 4.13.1
package ru.utsx.Sources;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link langParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface langVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link langParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(langParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(langParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(langParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(langParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(langParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(langParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#division}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(langParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#multi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulti(langParser.MultiContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(langParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(langParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(langParser.ExprContext ctx);
}