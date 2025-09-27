package Race.Decorator;

import Race.RaceComponent;

public class CategoryDecorator extends RaceDecorator {
    int category;

    public CategoryDecorator(RaceComponent decoratedRace) {
        super(decoratedRace);
    }

    public String getDescription(){
        return "Category " + category + " Race\n" + super.getDescription();
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
}
