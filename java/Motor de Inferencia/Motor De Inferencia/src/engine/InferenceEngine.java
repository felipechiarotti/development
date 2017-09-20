/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;
import java.util.ArrayList;
import structure.Antecedent;
import structure.Base;
import structure.Consequence;
import structure.Rule;
import structure.Variable;

/**
 *
 * @author chiarotti
 */
public class InferenceEngine {
    private Base base;
    
    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }
    
    public InferenceEngine(){
        Base base = new Base();
    }
    
    public InferenceEngine(Base base){
        this.base = base;
    }
    
    public void startEngine(){
        if(!this.base.isEmpty()){
            ArrayList<Variable> objectiveVars = this.base.getObjectiveVars();
            if(objectiveVars.size() > 0){
                for(Variable var : objectiveVars){
                    this.process(var);
                }
            }
        }
    }
    
    public void process(Variable var){
        for(Rule rule : this.base.getRules()){
            for(Consequence cons : rule.getConsequences()){
                if(var == cons.getVariable()){
                    for(Antecedent ant : rule.getAntecedents()){
                        this.process(ant.getVariable());
                    }
                }
            }
        }
    }
}