package ru.spbau.mit.fl;

import ru.spbau.mit.fl.ast.AstNode;
import ru.spbau.mit.fl.ast.visitor.ASTVisitor;
import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("put path to file");
            System.exit(-1);
        }

//        File file = new File("src/test/resources/test_all");
        File file = new File(args[0]);
        CharStream inputCharStream = null;
        try {
            inputCharStream = new ANTLRInputStream(new FileReader(file));
        } catch (IOException e) {
            System.out.println("Cannot open file\n");
            System.exit(-1);
        }
        TokenSource tokenSource = new LLexer(inputCharStream);
        TokenStream inputTokenStream = new CommonTokenStream(tokenSource);
        LParser parser = new LParser(inputTokenStream);

        LErrorListener errorListener = new LErrorListener();
        parser.addErrorListener(errorListener);
        LParser.ProgramContext context = parser.program();

        if (errorListener.isFail()) {
            return;
        }

        ASTBuildVisitor visitor = new ASTBuildVisitor();
        AstNode ast = context.accept(visitor);

        try {
            ASTVisitor astVisitor = new ASTVisitor(file.getAbsolutePath() + ".dot");
            ast.accept(astVisitor);
            astVisitor.printTree();
        } catch (IOException e) {
            System.out.println("cannot write tree to file");
            System.exit(-1);
        }

    }
}
