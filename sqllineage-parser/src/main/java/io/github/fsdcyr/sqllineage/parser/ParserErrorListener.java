package io.github.fsdcyr.sqllineage.parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 * @author fsdcyr
 * @version 1.0
 * @date 2023-09-07 15:57
 */
public class ParserErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine, String msg, RecognitionException e)
            throws ParseCancellationException {
        String errorMessage = String.format("line %d:%d %s", line, charPositionInLine, msg);
        throw new ParseCancellationException(errorMessage);
    }

}
