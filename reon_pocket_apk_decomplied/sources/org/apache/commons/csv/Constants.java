package org.apache.commons.csv;

import kotlin.text.Typography;

final class Constants {
    static final char BACKSLASH = '\\';
    static final char BACKSPACE = '\b';
    static final char COMMA = ',';
    static final char COMMENT = '#';
    static final char CR = '\r';
    static final String CRLF = "\r\n";
    static final Character DOUBLE_QUOTE_CHAR = Character.valueOf(Typography.quote);
    static final String EMPTY = "";
    static final int END_OF_STREAM = -1;
    static final char FF = '\f';
    static final char LF = '\n';
    static final String LINE_SEPARATOR = " ";
    static final String NEXT_LINE = "";
    static final String PARAGRAPH_SEPARATOR = " ";
    static final char PIPE = '|';
    static final char RS = '\u001e';
    static final char SP = ' ';
    static final char TAB = '\t';
    static final int UNDEFINED = -2;
    static final char US = '\u001f';

    Constants() {
    }
}
