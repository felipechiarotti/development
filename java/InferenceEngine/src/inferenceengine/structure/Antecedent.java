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
public class Antecedent<T> {
    private Variable variable;
    private T value;
    private char operation;
    
    public Antecedent(Variable var, T val, char op){
        this.variable = var;
        this.value = val;
        this.operation = op;
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

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }
    @Override
    public String toString(){
        return variable.getName()+"  "+operation+"  "+value.toString();
    }    
}
