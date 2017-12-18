

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Car newCar = new Car("1986");
    static CarDoor doorActive = newCar.doors[0];
    static CarWheel wheelActive = newCar.wheels[0];

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

                newCar = new Car(date, engine, maxSpeed, accelerationTime, passCapacity, passCount, curSpeed);

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
