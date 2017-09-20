/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import java.util.ArrayList;

/**
 *
 * @author chiarotti
 */
public class Rule {
    String name;
    ArrayList<Consequence> consequences;
    ArrayList<Antecedent> antecedents;
    
    public Rule(String name){
        this.name = name;
        this.consequences = new ArrayList<Consequence>();
        this.antecedents = new ArrayList<Antecedent>();
    }
    
    public Rule(String name, ArrayList<Consequence> consequences, ArrayList<Antecedent> antecedents){
        this.name = name;
        this.consequences = consequences;
        this.antecedents = antecedents;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Consequence> getConsequences() {
        return consequences;
    }

    public void setConsequences(ArrayList<Consequence> consequences) {
        this.consequences = consequences;
    }

    public ArrayList<Antecedent> getAntecedents() {
        return antecedents;
    }

    public void setAntecedents(ArrayList<Antecedent> antecedents) {
        this.antecedents = antecedents;
    }
    
    public void addAntecedent(Antecedent ant){
        this.antecedents.add(ant);
    }
    
    public void removeAntecedent(Antecedent ant){
        this.antecedents.remove(ant);
    }
    
    public void addConsequence(Consequence cons){
        this.consequences.add(cons);
    }
    
    public void removeConsequence(Consequence cons){
        this.consequences.remove(cons);
    }
    
    public void removeConsequence(int pos){
        this.consequences.remove(pos);
    }
}
