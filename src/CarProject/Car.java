package CarProject;

public  class Car{
    private String name;
    private Engine carEngine;
    private double fuelCapacity;
    private double remainingCapacity;

    Car(String n, Engine c, double f){
        name=n;
        carEngine =c;
        fuelCapacity=f;
        remainingCapacity=f;
    }

    void tank(){
        System.out.println("Car " + this.name + " has been tanked up");
        this.remainingCapacity=this.fuelCapacity;
    }
    void drive(double speed, double distance)
    {

        double maxSpeed = carEngine.getHorsepower()*2;
        if (speed>maxSpeed)
        {
            speed=maxSpeed;
        }
        if(!carEngine.getIsStarted()){
            System.out.println("Car " + this.name + " cannot be driven because its engine has not been started");
        }
        else if(this.remainingCapacity==0.0)
        {
            System.out.println("Car " + this.name + " cannot be driven. The tank is empty.");
        }
        else if(this.remainingCapacity<carEngine.getCapacity()*10*distance/100.0)
        {
            double maxDistance= 10*this.remainingCapacity/carEngine.getCapacity();
            distance=maxDistance;
            System.out.print("Car " + this.name + " has been driven for " + distance + " with speed "+ speed + " km/h.");
            this.remainingCapacity-=carEngine.getCapacity()*10*distance/100.0;
            System.out.println(" The tank is empty.");
        }
        else {
            System.out.print("Car " + this.name + " has been driven for " + distance + " with speed "+ speed + " km/h.");
            this.remainingCapacity-=carEngine.getCapacity()*10*distance/100.0;
            System.out.println(" Remaining fuel: "+ this.remainingCapacity);
        }
    }
    void startEngine()
    {
        if(carEngine.getIsStarted())
        {
            System.out.println(carEngine.getName() + " engine has already been started in "+ this.name);
        }
        else{
            System.out.println("Car " + this.name + " is starting "+ carEngine.getName() + " engine");
            System.out.println(carEngine.getName() + " engine has been started");
            carEngine.start();
        }
    }
    void stopEngine()
    {
        if(!carEngine.getIsStarted())
        {
            System.out.println(carEngine.getName() + "engine has already been stopped in "+ this.name);
        }
        else{
            System.out.println("Car " + this.name + " is stopping "+ carEngine.getName() + " engine");
            System.out.println(carEngine.getName() + " engine has been stopped");
            carEngine.stop();
        }

    }

}