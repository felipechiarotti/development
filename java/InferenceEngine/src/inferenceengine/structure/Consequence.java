/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inferenceengine.structure;

/**
 *
 * @author chiarotti
 */
public class Consequence<T> {
    private Variable variable;
    private T value;
     
    public Consequence(Variable var, T val){
        this.value = val;
        this.variable = var;
    }
    
    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
