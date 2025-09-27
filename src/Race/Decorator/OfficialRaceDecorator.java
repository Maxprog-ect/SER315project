package Race.Decorator;

import Race.RaceComponent;

public class OfficialRaceDecorator extends RaceDecorator{
    boolean isOfficial;

    public OfficialRaceDecorator(RaceComponent decoratedRace) {
        super(decoratedRace);
        isOfficial = true;
    }

    public String getDescription(){
        String description = "";
        if(isOfficial){
            description = "Official Race\n" + super.getDescription();
        }else{
            description = "Unofficial Race\n" + super.getDescription();
        }
        return description;
    }
    public double getCost(){
        return 25.0;
    }
}
