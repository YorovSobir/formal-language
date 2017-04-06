import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.util.Arrays;

public class LexerParser {
    public static void main(String[] args) {
        try {
            LLexer lex = new LLexer(new ANTLRFileStream(args[0]));
            CommonTokenStream token = new CommonTokenStream(lex);
            LParser parser = new LParser(token);
            TreeViewer view = new TreeViewer(Arrays.asList(LParser.ruleNames), parser.program());
            view.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
