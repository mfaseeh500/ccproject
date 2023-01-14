/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccproject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javafx.scene.Node;

/**
 *
 * @author MUHAMMAD FASEEH
 */
public class nodevisitor {
    public int visit(AST node) throws IllegalArgumentException, InvocationTargetException, Exception {
        String methodName = "visit_" + node.getClass().getSimpleName();
        Method method = null;
        try {
            method = this.getClass().getMethod(methodName, node.getClass());
        } catch (NoSuchMethodException e) {
            return genericVisit();
        }
        try {
            return (int) method.invoke(this, node);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int genericVisit() throws Exception {
        throw new Exception("Method Not found");
     


}
