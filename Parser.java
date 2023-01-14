/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccproject;
/* def __init__(self,lexer : Lexer):
        self.lexer = lexer
        self.ct = self.lexer.get_next_token()
    def error(self):
        raise Exception("Parse Error")
    def verify(self,t_type):
        if self.ct.type == t_type:
            self.ct = self.lexer.get_next_token()
        else :
            self.error()
    def factor(self):
        token = self.ct
        if token.type == INT :
            self.verify(INT)
            return Num(token)
        elif token.type == LP:
            self.verify(LP)
            node = self.expr()
            self.verify(RP)
            return node 
    def term(self):
        node =self.factor()
        while self.ct.type in (MUL,DIV):
            token = self.ct
            if token.type == MUL:
                self.verify(MUL)
            elif token.type == DIV:
                self.verify(DIV)

            node = BinOP(node,token,self.factor())

        return node
    def expr(self):
        node =self.term()
        while self.ct.type in (ADD,SUB):
            token = self.ct
            if token.type == ADD:
                self.verify(ADD)
            elif token.type == SUB:
                self.verify(SUB)

            node = BinOP(node,token,self.factor())

        return node
    def parse(self):
        return self.expr()    

/**
 *
 * @author MUHAMMAD FASEEH
 */
public class Parser{
    public Lexer lexer;
    public Token ct;
    public int node;
    public Token token;
    public String token_type;
    public final String INTEGER = "INTEGER", PLUS = "PLUS", MINUS = "MINUS", MUL = "MUL", DIV = "DIV", EOF = "EOF", LP = "LP", RP = "RP";
    public Parser(Lexer lexer) throws Exception {
        this.lexer = lexer;
        this.ct = this.lexer.get_next_token();
    }
    public void error() throws Exception {
        throw new Exception("Parse Error");
    }
    //verify the current Token else throw error
    public void verify_token(String token_type) throws Exception {
        if (this.ct.type.equals(token_type)) {
            this.ct = this.lexer.get_next_token();
        } else {
            this.error();
        }
    }
    public T factor() throws Exception {
        Token token = this.ct;
        if (token.type == INTEGER) {
            verify_token(INTEGER);
            return new NUM(token);
        } else if (token.type == LP) {
            verify_token(LP);
            AST node = expr();
            verify_token(RP);
           
        } return node;}

    
    public BinOP term() throws Exception {
        node=this.factor();
        // loops through to check if next tokens are Multiplication or division
        while (this.ct != null &&  (this.ct.type.equals(DIV) ||  this.ct.type.equals(MUL))) {
           // gets the token 
            Token token = this.ct; 
            if (token.type.equals(MUL)) { // verify
                this.verify_token(MUL);
               
            } else if (token.type.equals(DIV)) {
                this.verify_token(DIV);
               
            }
            
        }
        return new BinOP(node,token,this.factor()); // output returned
    }
      public BinOP expr() throws Exception{
       node=this.term();
   
        while (this.ct != null && (this.ct.type.equals(PLUS) ||  this.ct.type.equals(MINUS))) {
            Token token = this.ct;
            if (token.type.equals(PLUS)) {
                this.verify_token(PLUS);
          
            } 
            else if (token.type.equals(MINUS)) {
                this.verify_token(MINUS);
               
            }
        }
        return new BinOP(node,token,this.expr());
    }
}
