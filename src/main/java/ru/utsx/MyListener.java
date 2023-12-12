package ru.utsx;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import ru.utsx.Sources.langBaseListener;
import ru.utsx.Sources.langLexer;
import ru.utsx.Sources.langParser;
import ru.utsx.Types.Value;
import ru.utsx.Types.ValueInt;
import ru.utsx.Types.ValueString;

import java.io.IOException;
import java.util.*;

public class MyListener extends langBaseListener {

    private final Scanner scanner = new Scanner(System.in);
    private final Map<String, Value> variables;

    public MyListener() {
        this.variables = new HashMap<>();
    }

    private Value returnMapElem(String name) {
        Value value;
        try {
            value = variables.get(name);
        } catch (Exception e) {
            throw new NoSuchElementException(name + " doesn't exist");
        }
        return value;
    }

    private void initString(String name, String str) {
        variables.put(name, new ValueString(str));
    }

    private void initID(String prevName, String newName){
        Value value = returnMapElem(prevName);
        Value buffer = returnMapElem(newName);
        if(!value.getClass().equals(buffer.getClass())){
            throw new UnsupportedOperationException("Can't cast " + value.getClass() + " to " + buffer.getClass() + "\n");
        }
        buffer.setValue(value.getValue());
    }

    private void initInt(String name, Integer value) {
        variables.put(name, new ValueInt((value)));
    }

    private void initValue(String name, Value value){
        variables.put(name, value);
    }

    @Override
    public void exitInit(langParser.InitContext ctx) {
        String name = ctx.ID(0).getText();
        Value value = null;
        switch (ctx.type.getText()) {
            case "INT" -> value = new ValueInt();
            case "STRING" -> value = new ValueString();
        }
        switch (ctx.arg.getType()) {
            case langParser.ID -> value.setValue(returnMapElem(ctx.ID(1).getText()));
            case langParser.INT -> value.setValue(Integer.parseInt(ctx.INT().getText()));
            case langParser.STRING -> value.setValue(ctx.STRING().getText().substring(1, ctx.STRING().getText().length() - 1));
        }
        initValue(name, value);
    }


    @Override
    public void exitAssign(langParser.AssignContext ctx) {
        String name = ctx.ID(0).getText();
        if(returnMapElem(name) == null){
            throw new NoSuchElementException(name + " doesn't exist");
        }
            switch (ctx.arg.getType()) {
                case langParser.INT -> initInt(name, Integer.parseInt(ctx.INT().getText()));
                case langParser.ID -> initID(ctx.ID(1).getText(), name);
                case langParser.STRING -> initString(name, ctx.STRING().getText());
            }
    }

    @Override
    public void exitAdd(langParser.AddContext ctx) {
        try {
            String name = ctx.ID().size() > 1 ? ctx.ID(1).getText() : ctx.ID(0).getText();
            switch (ctx.arg.getType()) {
                case langParser.ID -> {
                    String childName = ctx.ID(0).getText();
                    returnMapElem(name).add(returnMapElem(childName));
                }
                case langParser.INT -> {
                    ValueInt valueInt = new ValueInt(Integer.parseInt(ctx.INT().getText()));
                    returnMapElem(name).add(valueInt);
                }
                case langParser.STRING -> {
                    ValueString valueString = new ValueString(ctx.STRING().getText());
                    returnMapElem(name).add(valueString);
                }
            }
        }catch (Exception e){
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void exitExpr(langParser.ExprContext ctx) {
        Value firstValue;
        Value secondValue = null;
        firstValue = returnMapElem(ctx.ID().get(0).getText());
        switch (ctx.arg.getType()){
            case langParser.ID -> secondValue = returnMapElem(ctx.ID(1).getText());
            case langParser.INT -> secondValue = new ValueInt(Integer.parseInt(ctx.INT().getText()));
            case langParser.STRING -> secondValue = new ValueString(ctx.STRING().getText());
        }
        switch (ctx.op.getType()) {
            case langParser.EQUAL -> System.out.println(firstValue.equal(secondValue));
            case langParser.NOTEQUAL -> System.out.println(firstValue.notEqual(secondValue));
            case langParser.MORETHAN -> System.out.println(firstValue.more(secondValue));
            case langParser.LESS -> System.out.println(firstValue.less(secondValue));
            case langParser.MORETHANOREQUALTO -> System.out.println(firstValue.moreOrEqual(secondValue));
            case langParser.LESSTHANOREQUALTO -> System.out.println(firstValue.lessOrEqual(secondValue));
        }


    }

    @Override
    public void exitDivision(langParser.DivisionContext ctx) {
        String name = ctx.ID().size() > 1 ? ctx.ID(1).getText() : ctx.ID(0).getText();
        switch (ctx.arg.getType()){
            case langParser.ID -> {
                String childName = ctx.ID(0).getText();
                returnMapElem(name).dev(returnMapElem(childName));
            }
            case langParser.INT -> {
                ValueInt valueInt = new ValueInt(Integer.parseInt(ctx.INT().getText()));
                returnMapElem(name).dev(valueInt);
            }
        }
    }


    @Override
    public void exitMulti(langParser.MultiContext ctx) {
        String name = ctx.ID().size() > 1 ? ctx.ID(1).getText() : ctx.ID(0).getText();
        switch (ctx.arg.getType()){
            case langParser.ID -> {
                String childName = ctx.ID(0).getText();
                returnMapElem(name).multi(returnMapElem(childName));
            }
            case langParser.INT -> {
                ValueInt valueInt = new ValueInt(Integer.parseInt(ctx.INT().getText()));
                returnMapElem(name).multi(valueInt);
            }
        }
    }

    @Override
    public void exitSub(langParser.SubContext ctx){
        String name = ctx.ID().size() > 1 ? ctx.ID(1).getText() : ctx.ID(0).getText();
        switch (ctx.arg.getType()){
            case langParser.ID -> {
                String childName = ctx.ID(0).getText();
                returnMapElem(name).sub(returnMapElem(childName));
            }
            case langParser.INT -> {
                ValueInt valueInt = new ValueInt(Integer.parseInt(ctx.INT().getText()));
                returnMapElem(name).sub(valueInt);
            }
        }
    }

    @Override
    public void exitPrint(langParser.PrintContext ctx) {
        switch (ctx.arg.getType()) {
            case langParser.STRING ->
                    System.out.println(ctx.STRING().getText().substring(1, ctx.STRING().getText().length() - 1));
            case langParser.ID -> System.out.println(returnMapElem(ctx.ID().getText()));
            case langParser.INT -> System.out.println(ctx.INT().getText());
        }
    }

    public static void main(String[] args) {
        try {
            CharStream input = CharStreams.fromFileName("src/main/java/ru/utsx/test.lang");
            langLexer lexer = new langLexer(input);
            langParser parser = new langParser(new CommonTokenStream(lexer));
            parser.addParseListener(new MyListener());
            parser.program();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}