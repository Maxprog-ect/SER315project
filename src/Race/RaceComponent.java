package Race;

public interface RaceComponent{
    /**
     *
     * @return a string containing the race description
     */
    public String getDescription();

    /**
     *
     * @return a double containing the cost of the race license
     */
    public double getCost();

    /**
     *
     * @return the number of available spots in the race
     */
    public int getAvailableSpots();

    /**
     * starts the race
     */
    public void startRace();

    /**
     *
     * @return boolean determining if race is official
     */
    public boolean isOfficial();

    public void setType(String type);

}