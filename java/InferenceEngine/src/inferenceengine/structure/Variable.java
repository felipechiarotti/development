/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inferenceengine.structure;

import java.util.ArrayList;

/**
 *
 * @author chiarotti
 */
public class Variable<T> {
    private String name;
    private boolean isObjective;
    private ArrayList<T> values;
    private T answer;
    
    public Variable(String name, boolean isObjective){
        this.name = name;
        this.isObjective = isObjective;
    }
    
    public Variable(String name, boolean isObjective, ArrayList<T> values){
        this.name = name;
        this.isObjective = isObjective;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isObjective() {
        return isObjective;
    }

    public void setIsObjective(boolean isObjective) {
        this.isObjective = isObjective;
    }

    public ArrayList<T> getValues() {
        return values;
    }

    public void setValues(ArrayList<T> values) {
        this.values = values;
    }

    public void addValue(T value){
        this.getValues().add(value);
    }
    public T getAnswer() {
        return this.answer;
    }
    public void setAnswer(T answer) {
        this.answer = answer;
    }    
    public String makeQuestion(){
            int pos = 1;
            String options = "";
            for(T value : this.values){
                options = options + pos + " - " + value.toString()+"\n";
                pos+=1;
            }
            //System.out.println(resposta+" OOOOOOOOOOOOOOOOOI");        
            return javax.swing.JOptionPane.showInputDialog("Insira um valor numérico correspondente aos valores citados abaixo: \n"+options);
    }
}