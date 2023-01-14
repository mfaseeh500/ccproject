/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccproject;

/**
 *
 * @author FAIEZ WASEEM
 */
public class Interprator {

    private Lexer lexer;
    private Token current_token;
    private final String INTEGER = "INTEGER", PLUS = "PLUS", MINUS = "MINUS", MUL = "MUL", DIV = "DIV", EOF = "EOF";

    public Interprator(Lexer lexer) throws Exception {
        // getting lexer object 
        // bec its is responsible converting expression into Tokens
        this.lexer = lexer; 
        // getting our first Token from lexer object 
        //which we just initialized
        this.current_token = this.lexer.get_next_token();
    }
   // error handling
    public void error() throws Exception {
        throw new Exception("Error Parsing Input");
    }

    //verify the current Token else throw error
    public void verify_token(String token_type) throws Exception {
        if (this.current_token.type.equals(token_type)) {
            this.current_token = this.lexer.get_next_token();
        } else {
            this.error();
        }
    }
   // just verifies if current token is an Integer
    // and then return the value
    public int factor() throws Exception {
        Token token = this.current_token;
        this.verify_token(INTEGER);
        return (int) token.value;
    }
   // term function gets the first value from factor
    // example parses
    // Integer x digit 
    // digit x digit 
    // Integer / digit 
    // digit / digit 
    // Integer * or  / Integer 
    
    public int term() throws Exception {
        int result = this.factor();
        // loops through to check if next tokens are Multiplication or division
        while (this.current_token != null &&  (this.current_token.type.equals(DIV) ||  this.current_token.type.equals(MUL))) {
           // gets the token 
            Token token = this.current_token; 
            if (token.type.equals(MUL)) { // verify
                this.verify_token(MUL);
                result = result * this.factor(); // calculate
            } else if (token.type.equals(DIV)) {
                this.verify_token(DIV);
                result = result / this.factor();
            }
        }
        return result; // output returned
    }
       // expr function gets the parsed value of Mul and div from term
    // example parses
    // Integer + digit 
    // digit + digit 
    // Integer - digit 
    // digit - digit 
    // Integer + or - Integer 
    public int expr() throws Exception{
      int result = this.term();
      // loops through to check if next tokens are PLUS or MINUS
        while (this.current_token != null && (this.current_token.type.equals(PLUS) ||  this.current_token.type.equals(MINUS))) {
            Token token = this.current_token;
            if (token.type.equals(PLUS)) {// verify
                this.verify_token(PLUS);
                result = result + this.factor();// calculate
            } else if (token.type.equals(MINUS)) {
                this.verify_token(MINUS);
                result = result - this.factor();
            }
        }
        return result;
    }
}
