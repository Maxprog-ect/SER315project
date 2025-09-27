package Race.Decorator;

import Race.RaceComponent;

public class OfficialRaceDecorator extends RaceDecorator{
    boolean isOfficial;

    public OfficialRaceDecorator(RaceComponent decoratedRace) {
        super(decoratedRace);
    }

    public String getDescription(){
        String description = "";
        if(isOfficial){
            description = "Official Race";
        }else{
            description = "Unofficial Race";
        }
        return description;
    }
    public double getCost(){
        return 25.0;
    }
    public void makeOfficial(){
        isOfficial = true;
    }
}
