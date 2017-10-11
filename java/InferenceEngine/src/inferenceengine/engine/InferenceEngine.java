/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inferenceengine.engine;
import java.util.ArrayList;
import inferenceengine.structure.Antecedent;
import inferenceengine.structure.Base;
import inferenceengine.structure.Consequence;
import inferenceengine.structure.Rule;
import inferenceengine.structure.Variable;

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
                if(var.getName().equals(cons.getVariable().getName())){
                    for(Antecedent ant : rule.getAntecedents()){
                        this.process(ant.getVariable());
                    }
                }else{
                    String answer = var.makeQuestion();
                    for(Rule rule_verify : base.getRules()){
                        for(Antecedent antecedent_verify : rule_verify.getAntecedents()){
                            if(antecedent_verify.getValue().toString().equals(answer.toString())){
                                System.out.println("A resposta \"" + answer +"\" bate com a regra: " + rule_verify.getName());
                                break;
                            }else if(rule_verify.getCheck()){
                                rule_verify.setCheck(false);
                                System.out.println("Alterando a regra: "+ rule_verify.getName() + " para inválida.");
                            }
                        }
                    }
                    return;
                }
                break;
            }
            break;
        }
        String result = "";
        for(Rule rule : base.getRules()){
            System.out.println(rule.getCheck());
            if(rule.getCheck()){
                System.out.println("Olá");
                result = rule.getConsequences().get(0).getValue().toString();
            }
        }
        javax.swing.JOptionPane.showMessageDialog(null, "Resultado: "+result);
    }
}

    