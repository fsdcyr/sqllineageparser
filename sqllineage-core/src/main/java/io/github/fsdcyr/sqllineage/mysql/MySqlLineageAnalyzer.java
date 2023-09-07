package io.github.fsdcyr.sqllineage.mysql;

import io.github.fsdcy.sqllineage.parser.mysql.MySqlParserBaseListener;
import io.github.fsdcyr.sqllineage.ParserListenerEnhancer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * @author fsdcyr
 * @version 1.0
 * @date 2023-09-07 16:02
 */
public class MySqlLineageAnalyzer extends ParserListenerEnhancer {

    public MySqlLineageAnalyzer() {
    }

    public MySqlLineageAnalyzer(boolean isSubQuery) {
        this.subQuery = isSubQuery;
    }

    public void analyze(ParseTree stmt) {
        ParseTreeWalker walker = new ParseTreeWalker();
        ParserListener listener = new ParserListener();
        walker.walk(listener, stmt);
        // TODO
    }

    class ParserListener extends MySqlParserBaseListener {

    }

}
