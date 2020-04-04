package CarProject;

public class Engine{

    private String name;
    private double horsepower;
    private double capacity;
    private boolean isStarted;
    Engine(String n, double h, double c)
    {
        name=n;
        horsepower=h;
        capacity=c;
    }
    String getName()
    {
        return this.name;
    }
    double getHorsepower()
    {
        return this.horsepower;
    }
    double getCapacity()
    {
        return this.capacity;
    }
    boolean getIsStarted()
    {
        return isStarted;
    }
    void start()
    {
        if(!this.isStarted)
        {this.isStarted=true;}

    }
    void stop()
    {
        if(this.isStarted)
        {this.isStarted=false;}
    }
}