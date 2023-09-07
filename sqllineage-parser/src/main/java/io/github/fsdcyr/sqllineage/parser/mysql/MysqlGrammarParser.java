package io.github.fsdcyr.sqllineage.parser.mysql;

import io.github.fsdcy.sqllineage.parser.mysql.MySqlLexer;
import io.github.fsdcy.sqllineage.parser.mysql.MySqlParser;
import io.github.fsdcyr.sqllineage.parser.ParserErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * @author fsdcyr
 * @version 1.0
 * @date 2023-09-07 15:50
 */
public class MysqlGrammarParser {

    public static ParseTree parse(String sql) {
        CharStream inputStream = CharStreams.fromString(sql);
        MySqlLexer mySqlLexer = new MySqlLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(mySqlLexer);
        MySqlParser mySqlParser = new MySqlParser(commonTokenStream);
        mySqlParser.removeErrorListeners();
        mySqlParser.addErrorListener(new ParserErrorListener());
        return mySqlParser.sqlStatements();
    }

}
