package Race.Decorator;

import Race.BasicRace;

public class OffRoadDecorator extends RaceDecorator {

    public OffRoadDecorator(BasicRace decoratedRace) {
        super(decoratedRace);
        decoratedRace.setType("OffRoad");
    }

    @Override
    public boolean isOfficial() {
        return super.isOfficial();
    }
    @Override
    public void setType(String type) {
        super.setType(type);
    }
}
