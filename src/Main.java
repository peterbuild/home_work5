import java.util.Scanner;

public class Main {
static Scanner sc = new Scanner(System.in);
static Car newCar = new Car("1986");
static CarDoor doorActive = newCar.doors[0];
static CarWheel wheelActive = newCar.wheels[0];


    static void mainMenu(){
        System.out.println("0 - **************** Меню **************** ");
        System.out.println("1 - Создать по умолчанию");
        System.out.println("2 - Создать по параметрам");
        System.out.println("3 - Получить дверь по индексу");
        System.out.println("4 - Получить колесо по индексу");
        System.out.println("5 - Вывести данные о колесе");
        System.out.println("6 - Вывести данные о двери");

        System.out.println("7 - Открыть дверь");
        System.out.println("8 - Закрыть дверь");
        System.out.println("9 - Изменить состояние двери");

        System.out.println("10 - Открыть окно");
        System.out.println("11 - Зарыть окно");
        System.out.println("12 - Изменить состояние окна");

        System.out.println("13 - Стереть шину ативного колеса");
        System.out.println("14 - Добавить пассажира");
        System.out.println("15 - Убрать пассажира");
        System.out.println("16 - Убрать всех пассажиров");
        System.out.println("17 - Снять все колеса");
        System.out.println("18 - Добавить колес");
        System.out.println("19 - Задать скорость");
        System.out.println("20 - Узнать максимальную скорость");
        System.out.println("21 - Вывести данные о машине");
        System.out.println("22 - Выход");


    }

    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.addEntry(new MenuEntry("**************** Меню ****************") {
            @Override
            public void run() {
                menu.printMenu();

            }
        });
        menu.addEntry(new MenuEntry("Создать машину по умолчанию") {
            @Override
            public void run() {
                newCar = new Car("1986");
                System.out.println("Машина создана");
                newCar.show();
            }
        });
        menu.addEntry(new MenuEntry("Создать по параметрам") {
            @Override
            public void run() {
                System.out.println("Введите дату производства: ");
                String date = sc.nextLine();
                System.out.println("Введите тип двигателя: ");
                String engine = sc.nextLine();
                System.out.println("Введите максимальную скорость: ");
                int maxSpeed = sc.nextInt();
                System.out.println("Введите время разгона сек: ");
                int accelerationTime = sc.nextInt();
                System.out.println("Введите пассажировместимость ");
                int passCapacity = sc.nextInt();
                System.out.println("Введите текущее количетво пассажиров: ");
                int passCount = sc.nextInt();
                System.out.println("Введите текущюю скорость: ");
                int curSpeed = sc.nextInt();

                 newCar = new Car(date,engine,maxSpeed,accelerationTime,passCapacity,passCount,curSpeed);

            }
        });
        menu.addEntry(new MenuEntry("Получить дверь по индексу") {
            @Override
            public void run() {
                System.out.println("Введите индекс двери: ");
                int ind = sc.nextInt();
                doorActive = newCar.getDoorByIndex(ind);
                System.out.println(ind + "дверь активна");
            }
        });

        menu.addEntry(new MenuEntry("Получить колесо по индексу") {
            @Override
            public void run() {
                System.out.println("Введите индекс колеса: ");
                int ind = sc.nextInt();
                wheelActive = newCar.getWheelByIndex(ind);
                System.out.println(ind + "колесо активно");
            }
        });
        menu.addEntry(new MenuEntry("Вывести данные о активном колесе") {
            @Override
            public void run() {
                wheelActive.show();

            }
        });
        menu.addEntry(new MenuEntry("Открыть активную дверь") {
            @Override
            public void run() {
                doorActive.openDoor();
            }
        });
        menu.addEntry(new MenuEntry("Закрыть активную дверь") {
            @Override
            public void run() {
                doorActive.closeDoor();
            }
        });
        menu.addEntry(new MenuEntry("Изменить состояние двери") {
            @Override
            public void run() {
                doorActive.toggleDoor();
            }
        });

        menu.addEntry(new MenuEntry("Открыть окно активной двери") {
            @Override
            public void run() {
                doorActive.openWindow();
            }
        });
        menu.addEntry(new MenuEntry("Закрыть окно активной двери") {
            @Override
            public void run() {
                doorActive.closeWindow();
            }
        });
        menu.addEntry(new MenuEntry("Изменить состояние окна активной двери") {
            @Override
            public void run() {
                doorActive.toggleWindow();
            }
        });
        menu.addEntry(new MenuEntry("Стереть шину ативного колеса") {
            @Override
            public void run() {
                System.out.println("стереть на % ");
                int condition = sc.nextInt();
                wheelActive.setCondition(wheelActive.getCondition() * condition / 100);
            }
        });
        menu.addEntry(new MenuEntry("Добавить пассажира") {
            @Override
            public void run() {
                newCar.addPassagire();
            }
        });
        menu.addEntry(new MenuEntry("Убрать пассажира") {
            @Override
            public void run() {
                newCar.delPassagire();
            }
        });
        menu.addEntry(new MenuEntry("Высадить всех") {
            @Override
            public void run() {
                newCar.delAllPassagire();

            }
        });
        menu.addEntry(new MenuEntry("Снять все колеса") {
            @Override
            public void run() {
                newCar.wheels = newCar.rebuildWheels(0);
            }
        });
        menu.addEntry(new MenuEntry("Добавить колес") {
            @Override
            public void run() {
                System.out.println("Введите количество добавляемых колес");
                int wheelsCounter = sc.nextInt();
                newCar.wheels = newCar.rebuildWheels(wheelsCounter);
            }
        });
        menu.addEntry(new MenuEntry("Изменить скорость") {
            @Override
            public void run() {
                System.out.println("Введите новую скорость");
                int currentSpeed = sc.nextInt();
                newCar.setCurentSpeed(currentSpeed);
            }
        });
        menu.addEntry(new MenuEntry("Максимальная скорость") {
            @Override
            public void run() {
                System.out.println("Макс.скорость - " + newCar.getMaxSpeed());
            }
        });
        menu.addEntry(new MenuEntry("Информация о авто") {
            @Override
            public void run() {
                newCar.show();
            }
        });

        menu.run();
       // menu.printMenu();


    }
}
