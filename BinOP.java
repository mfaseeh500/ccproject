/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccproject;

/**
 *
 * @author MUHAMMAD FASEEH
 */
public class BinOP extends AST {
   private AST left;
    private Token token;
    private Token op;
    private AST right;

    public BinOP(AST left, Token op, AST right) {
        this.left = left;
        this.token = this.op = op;
        this.right = right;
    }
}
