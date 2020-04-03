package CarProject;

public  class Car{
    public String name;
    public Engine carEngine;
    public double fuelCapacity;
    public double remainingCapacity;

    Car(String n, Engine c, double f){
        name=n;
        carEngine =c;
        fuelCapacity=f;
    }

    void tank(){
        System.out.println("Car " + this.name + " has been tanked up");
        this.remainingCapacity=this.fuelCapacity;
    }
    void drive(double speed, double distance)
    {

        double maxSpeed = carEngine.horsepower*2;
        if (speed>maxSpeed)
        {
            speed=maxSpeed;
        }
        if(!carEngine.isStarted){
            System.out.println("Car " + this.name + " cannot be driven because its engine has not been started");
        }
        else if(this.remainingCapacity==0.0)
        {
            System.out.println("Car " + this.name + " cannot be driven. The tank is empty.");
        }
        else if(this.remainingCapacity<carEngine.capacity*10*distance/100.0)
        {
            double maxDistance= 10*this.remainingCapacity/carEngine.capacity;
            distance=maxDistance;
            System.out.print("Car " + this.name + " has been driven for " + distance + " with speed "+ speed + " km/h.");
            this.remainingCapacity-=carEngine.capacity*10*distance/100.0;
            System.out.println(" The tank is empty.");
        }
        else {
            System.out.print("Car " + this.name + " has been driven for " + distance + " with speed "+ speed + " km/h.");
            this.remainingCapacity-=carEngine.capacity*10*distance/100.0;
            System.out.println(" Remaining fuel: "+ this.remainingCapacity);
        }
    }
    void startEngine()
    {
        if(carEngine.isStarted)
        {
            System.out.println(carEngine.name + " engine has already been started in "+ this.name);
        }
        else{
            System.out.println("Car " + this.name + " is starting "+ carEngine.name + " engine");
            System.out.println(carEngine.name + " engine has been started");
            carEngine.isStarted=true;
        }
    }
    void stopEngine()
    {
        if(!carEngine.isStarted)
        {
            System.out.println(carEngine.name + "engine has already been stopped in "+ this.name);
        }
        else{
            System.out.println("Car " + this.name + " is stopping "+ carEngine.name + " engine");
            System.out.println(carEngine.name + " engine has been stopped");
            carEngine.isStarted=false;
        }

    }

}