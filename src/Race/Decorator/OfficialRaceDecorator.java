package Race.Decorator;

import Race.BasicRace;
import Race.RaceComponent;
import Users.Racer;

//combined official & category, category only applies to official races

public class OfficialRaceDecorator extends RaceDecorator{
    boolean isOfficial;
    int category;


    //Creates an official race with base category 5
    public OfficialRaceDecorator(BasicRace decoratedRace) {
        super(decoratedRace);
        decoratedRace.setOfficial(isOfficial = true);
        category = 5;
    }

    public String getDescription(){
        String description = "ERROR: Invalid Race";
        if(isOfficial){
            description = "Official Category " + category + " Race\n" + super.getDescription();
        }else{
            description = "Unofficial Race\n" + super.getDescription();
        }
        return description;
    }

    public double getCost(){
            switch(category){
                case 1:
                    return 100.0;
                case 2:
                    return 75.0;
                case 3:
                    return 50.0;
                case 4:
                    return 40.0;
                case 5:
                    return 30.0;
            }
            return 25;
    }

    public void setCategory(int category){
        this.category = category;
    }

    public int getCategory(){
        return category;
    }

    @Override
    public boolean isOfficial() {
        return isOfficial;
    }

}