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
public class Base {
    private ArrayList<Rule> rules;
    private ArrayList<Variable> variables;
    
    public ArrayList<Rule> getRules() {
        return rules;
    }
    public void addRule(Rule rule){
        this.rules.add(rule);
    }
    public void addVar(Variable var){
        this.variables.add(var);
    }
    public void setRules(ArrayList<Rule> rules) {
        this.rules = rules;
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }
    
    public Base(){
        rules = new ArrayList<>();
        variables = new ArrayList<>();
    }
    
    public boolean isEmpty(){
        if(this.rules.isEmpty() && this.variables.isEmpty()){
            return true;
        }
        return false;
    }
    
    public ArrayList<Variable> getObjectiveVars(){
        ArrayList<Variable> objectivesList = new ArrayList<Variable>();
        for (Variable variable : this.variables){
            if(variable.isObjective()){
                objectivesList.add(variable);
            }
        }
        return objectivesList;
    }
}