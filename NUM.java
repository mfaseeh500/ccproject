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
public class NUM<T> extends AST {
    private Token token;
    private int value;

    public NUM(Token token) {
        this.token = token;
        this.value = (int) token.value;
    }
}

