/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chiarotti
 */
import inferenceengine.engine.InferenceEngine;
import inferenceengine.structure.Antecedent;
import inferenceengine.structure.Base;
import inferenceengine.structure.Consequence;
import inferenceengine.structure.Rule;
import inferenceengine.structure.Variable;
import java.util.ArrayList;

public class Run {
    public static void main(String[] args){
        Base base = new Base();

        //////////////////////////// VARIAVEIS
        ArrayList players_values = new ArrayList();
        players_values.add("Anthony Davis");
        players_values.add("Giannis Antetokounmpo");
        players_values.add("Stephen Curry");
        players_values.add("Damian Lillard");
        players_values.add("James Harden");
        players_values.add("Paul George");
        Variable player = new Variable("players", true, players_values);

        ArrayList team_values = new ArrayList();
        team_values.add("New Orleans Pelicans");
        team_values.add("Milwaukee Bucks");
        team_values.add("Golden State Warriors");
        team_values.add("Portland Trail Blazers");
        team_values.add("Houston Rockets");
        team_values.add("Oklahoma City Thunder");
        Variable team = new Variable("team", false, team_values);

        ArrayList country_values = new ArrayList();
        country_values.add("United States of America");
        country_values.add("Greece");
        country_values.add("Germany");
        country_values.add("Ukraine");
        Variable country = new Variable("country", false, country_values);
        
        ArrayList experience_values = new ArrayList();
        for(int i = 1; i<11; i++){
         experience_values.add(i+"");           
        }
        Variable experience = new Variable("experience", false, experience_values);
        
        ArrayList playing_values = new ArrayList();
        playing_values.add("Playing");
        playing_values.add("Not Playing");
        Variable playing = new Variable( "playing", false, playing_values);
        
        base.addVar(team);
        base.addVar(country);
        base.addVar(experience);
        
        
        
        ArrayList<Antecedent> antecedents = new ArrayList<>();
        antecedents.add(new Antecedent(team, "New Orleans Pelicans", '='));
        antecedents.add(new Antecedent(country, "United States of America", '='));        
        antecedents.add(new Antecedent(playing, "Playing", '='));        
        antecedents.add(new Antecedent(experience, "5",  '='));
        
        ArrayList<Consequence> consequences = new ArrayList<>();
        consequences.add(new Consequence(player, "Anthony Davis"));
        Rule rule = new Rule("Anthony Davis", consequences, antecedents);
        base.addRule(rule);

        
        
        antecedents = new ArrayList<>();
        antecedents.add(new Antecedent(team, "Milwaukee Bucks", '='));
        antecedents.add(new Antecedent(country, "Greece", '='));        
        antecedents.add(new Antecedent(playing, "Playing", '='));        
        antecedents.add(new Antecedent(experience, "4",  '='));
        
        consequences = new ArrayList<>();
        consequences.add(new Consequence(player, "Giannis Antetokounmpo"));
        rule = new Rule("Giannis Antetokounmpo", consequences, antecedents);
        base.addRule(rule);



        antecedents = new ArrayList<>();
        antecedents.add(new Antecedent(team, "Golden State Warriors", '='));
        antecedents.add(new Antecedent(country, "United States of America", '='));        
        antecedents.add(new Antecedent(playing, "Playing", '='));        
        antecedents.add(new Antecedent(experience, "8",  '='));
        
        consequences = new ArrayList<>();
        consequences.add(new Consequence(player, "Stephen Curry"));
        rule = new Rule("Stephen Curry", consequences, antecedents);
        base.addRule(rule);


        antecedents = new ArrayList<>();
        antecedents.add(new Antecedent(team, "Portland Trail Blazers", '='));
        antecedents.add(new Antecedent(country, "United States of America", '='));        
        antecedents.add(new Antecedent(playing, "Playing", '='));        
        antecedents.add(new Antecedent(experience, "5",  '='));
        
        consequences = new ArrayList<>();
        consequences.add(new Consequence(player, "Damian Lillard"));
        rule = new Rule("Damian Lillard", consequences, antecedents);
        base.addRule(rule);


        
        antecedents = new ArrayList<>();
        antecedents.add(new Antecedent(team, "Houston Rockets", '='));
        antecedents.add(new Antecedent(country, "United States of America", '='));        
        antecedents.add(new Antecedent(playing, "Playing", '='));        
        antecedents.add(new Antecedent(experience, "8",  '='));
        
        consequences = new ArrayList<>();
        consequences.add(new Consequence(player, "James Harden"));
        rule = new Rule("James Harden", consequences, antecedents);
        base.addRule(rule);

        
        
        antecedents = new ArrayList<>();
        antecedents.add(new Antecedent(team, "Oklahoma City Thunder", '='));
        antecedents.add(new Antecedent(country, "United States of America", '='));        
        antecedents.add(new Antecedent(playing, "Playing", '='));        
        antecedents.add(new Antecedent(experience, "7",  '='));
        
        consequences = new ArrayList<>();
        consequences.add(new Consequence(player, "Paul George"));
        rule = new Rule("Paul George", consequences, antecedents);
        base.addRule(rule);

        
        /////////////////////////////////////////



        InferenceEngine inferenceEngine = new InferenceEngine();
        inferenceEngine.setBase(base);
        
        inferenceEngine.process(player);
    }
}