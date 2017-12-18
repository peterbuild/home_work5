

public class CarDoor {
    private Boolean doorState, windowState; //состояние двери и окна false - закрыта

    public CarDoor() {
        doorState = false;
        windowState = false;

    }

    public CarDoor(boolean doorState, boolean windowState) {
        this.doorState = doorState;
        this.windowState = windowState;
    }

    //Сама дверь
    public void openDoor() {
        if (!doorState) toggleDoor(); //открыли
    }

    public void closeDoor() {
        if (doorState) toggleDoor(); //закрыли
    }

    public void toggleDoor() {
        doorState = !doorState; //поменяли значение на противоположное
    }

    //Окно двери
    public void openWindow() {
        if (!windowState) toggleWindow(); //открыли
    }

    public void closeWindow() {
        if (windowState) toggleWindow(); //закрыли
    }

    public void toggleWindow() {
        windowState = !windowState; //поменяли значение на противоположное
    }

    public void show() {
        System.out.println((doorState ? "открыто" : "закрыто"));
        System.out.println("окно - " + (windowState ? "открыто" : "закрыто"));
        System.out.println();
    }


}
