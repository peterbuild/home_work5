
public class CarWheel {
    private double condition = 1.0;

    //конструктор без данных он же меняет шину на новую
    public CarWheel() {
        this(1.0);
    }

    //конструктор
    public CarWheel(double condition) {
        this.condition = condition;
    }

    //Получить состояние
    public double getCondition() {
        return condition;
    }

    public void setCondition(double condition) {
        this.condition = condition;

    }


    public void show() {
        System.out.println("Шина цела на : " + condition * 100 + "%");
    }


}
