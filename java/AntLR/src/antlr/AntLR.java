/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antlr;

import antlr.parser.AntlrLexer;
import antlr.parser.AntlrParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.TokenStream;
/**
 *
 * @author chiarotti
 */
public class AntLR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ANTLRInputStream input = new ANTLRInputStream("2+5");
        
        AntlrLexer lexer = new AntlrLexer(input);
        
        TokenStream stream = new BufferedTokenStream(lexer);
        
        AntlrParser parser = new AntlrParser(stream);
        
        AntlrParser.CalcContext calc = parser.calc();
        
        System.out.println(calc.value);
        
    }
    
}
