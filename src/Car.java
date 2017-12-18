
public class Car {
    private String dateOfManufacture;
    private String engineType;
    private int maxSpeed;
    private int curentSpeed;
    private int accelerationTime;
    private int passCapacity;
    private int passCount;
    public CarWheel[] wheels = new CarWheel[4];
    //        {
    //        new CarWheel(1),
    //        new CarWheel(1),
    //        new CarWheel(1),
    //        new CarWheel(1)
    //  };

    public CarDoor[] doors = new CarDoor[4];


    public Car(String dateOfManufacture) {
        this(dateOfManufacture, "diesel", 300, 80, 10, 4, 0);

    }

    public Car(String dateOfManufacture, String engineType, int maxSpeed, int curentSpeed, int accelerationTime, int passCapacity, int passCount) {
        this.dateOfManufacture = dateOfManufacture;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.curentSpeed = curentSpeed;
        this.accelerationTime = accelerationTime;
        this.passCapacity = passCapacity;
        this.passCount = passCount;

        newWheels();
        newDoors();
    }

    //получить текущюю скорость
    public int getCurentSpeed() {
        return curentSpeed;
    }

    //установить текущюю скорость
    public void setCurentSpeed(int speed) {
        if (speed > maxSpeed)
            System.err.println("Ошибка!!! Максимальная скорость - " + maxSpeed);
        else
            this.curentSpeed = speed;
    }

    //добавить пассажира
    public void addPassagire() {
        if (passCapacity > passCount + 1) {
            this.passCount++;
            System.out.println("Пассажир добавлен");
        } else System.err.println("Ошибка !!! Пассажировместимость " + passCapacity);
    }

    //Высадит пассажира
    public void delPassagire() {
        if (passCount > 0) {
            this.passCount--;
            System.out.println("Пассажир высажен");
        } else System.err.println("Ошибка!!! Автомобиль пуст");
    }

    //Высадить всех
    public void delAllPassagire() {
        this.passCount = 0;
        System.out.println("Все пасажиры высажены, автомобиль пуст");
    }

    // создаем новые двери
    public void newWheels() {
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new CarWheel();

        }
    }

    //создаем новые колеса
    public void newDoors() {
        for (int i = 0; i < doors.length; i++) {
            doors[i] = new CarDoor();
        }
    }

    // метод переопределяет коллеса, 0 и меньше - в последнем пареметре снимает все коллеса
    public CarWheel[] rebuildWheels(int newSize) {
        CarWheel[] tempWheels;
        if (newSize <= 0) {
            tempWheels = new CarWheel[0];
            System.out.println("Все колеса сняты");
        } else {

            tempWheels = new CarWheel[wheels.length + newSize];
            for (int i = 0; i < wheels.length; i++) {
                tempWheels[i] = wheels[i];
            }
            System.out.println("Добавленно " + newSize + " колес\nИтого " + tempWheels.length + " колес");
        }
        return tempWheels;
    }

    //добавить коллеса
    public void addWell(int newWells) {
        wheels = rebuildWheels(newWells);
    }

    //Получить колесо по индексу
    public CarWheel getWheelByIndex(int ind) throws ArrayIndexOutOfBoundsException {
        return wheels[ind];
    }

    //Получить дверь по индексу
    public CarDoor getDoorByIndex(int ind) throws ArrayIndexOutOfBoundsException {
        return doors[ind];
    }

    //вычисляем максимальную скорость
    public double getMaxSpeed() {
        if (passCount == 0) {
            return 0.0;
        }
        double tempCondition = 1;
        for (CarWheel wheel : wheels) {
            if (wheel.getCondition() < tempCondition) {
                tempCondition = wheel.getCondition();
            }
        }
        return maxSpeed * tempCondition;
    }

    public void show() {
        System.out.println(dateOfManufacture);
        System.out.println(engineType);
        System.out.println(getMaxSpeed());
        System.out.println(getCurentSpeed());
        System.out.println(accelerationTime);
        System.out.println(passCapacity);
        System.out.println(passCount);

        if (wheels.length > 0) {
            for (int i = 0; i < wheels.length; i++) {
                System.out.print(i + " колесо: ");
                wheels[i].show();
            }
        } else System.out.println("Колес нет!");

        for (int i = 0; i < doors.length; i++) {
            System.out.println("Дверь № " + i);
            doors[i].show();

        }


    }

}



