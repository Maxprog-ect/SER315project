package race.decorator;

import race.RaceComponent;

public abstract class RaceDecorator implements RaceComponent{
    private RaceComponent decoratedRace;

    public RaceDecorator(RaceComponent decoratedRace){
        this.decoratedRace = decoratedRace;
    }

    public String getDescription(){
        return decoratedRace.getDescription();
    }

    public double getCost(){
        return decoratedRace.getCost();
    }

    public int getAvailableSpots(){
        return decoratedRace.getAvailableSpots();
    }

    public void startRace(){
        System.out.println("Starting Race");
    }
    public void setType(String type){
        decoratedRace.setType(type);
    }
    public boolean isOfficial(){
        return decoratedRace.isOfficial();
    }
}
