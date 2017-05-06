import ast.AstNode;
import ast.visitor.ASTVisitor;
import org.antlr.v4.runtime.*;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LParserTest {

    @Test
    public void testFile() throws IOException {
        final File folder = new File("./src/test/resources/");

        for (final File fileEntry : folder.listFiles()) {
            if (!fileEntry.isDirectory()) {
                test(fileEntry);
            }
        }
    }

    void test(File file) throws IOException {
        CharStream inputCharStream = new ANTLRInputStream(new FileReader(file));
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

        ASTVisitor astVisitor = new ASTVisitor("./target/" + file.getName() + ".dot");
        ast.accept(astVisitor);

        astVisitor.printTree();

    }

}
