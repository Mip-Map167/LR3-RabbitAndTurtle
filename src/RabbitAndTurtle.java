import java.util.InputMismatchException;
import java.util.Scanner;
public class RabbitAndTurtle {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Установка приоритетов: \n1 - приоритеты равны \n2 - кролик в приоритете \n3 - черепаха в приоритете \n------------------ \n0 - выход из программы \n------------------");
            try {
                Scanner priority = new Scanner(System.in);
                System.out.print("Введите номер действия: ");
                int p = priority.nextInt();
                switch (p) {
                    case 1:
                        System.out.println("\u001B[34m" + "Приоритеты равны!" + "\u001B[0m");
                        Priority0();
                        break;
                    case 2:
                        System.out.println("\u001B[33m" + "У кролика максимальный приоритет, у черепахи минимальный приоритет." + "\u001B[0m");
                        Priority1();
                        break;
                    case 3:
                        System.out.println("\u001B[32m" + "У кролика минимальный приоритет, у черепахи максимальный приоритет." + "\u001B[0m");
                        Priority2();
                        break;
                    case 0:
                        System.out.println("\u001B[34m" + "Выход из программы..." + "\u001B[0m");
                        return;
                    default:
                        System.out.println("\u001B[31m" + "Недопустимое значение! Введите корректный номер!" + "\u001B[0m");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("\u001B[31m" + "\nОшибка: некорректный ввод! Введите корректные значения!\n" + "\u001B[0m");
            }
        }
    }

    static void Priority1() {
        AnimalThread rabbit = new AnimalThread("\u001B[33m Кролик \u001B[0m", Thread.MAX_PRIORITY);
        Thread threadRabbit = new Thread(rabbit);
        threadRabbit.setPriority(rabbit.priorityTread);

        AnimalThread turtle = new AnimalThread("\u001B[32m Черепаха \u001B[0m", Thread.MIN_PRIORITY);
        Thread threadTurtle = new Thread(turtle);
        threadTurtle.setPriority(turtle.priorityTread);

        threadRabbit.start();
        threadTurtle.start();

        while (threadRabbit.isAlive() && threadTurtle.isAlive()) {
            int rabbitDistance = rabbit.Distance();
            int turtleDistance = turtle.Distance();

            if (rabbitDistance < turtleDistance) {
                System.out.println("\u001B[33m" + "Кролик отстаёт! Он ускоряется..." + "\u001B[0m");
                threadRabbit.setPriority(Thread.MAX_PRIORITY);
                threadTurtle.setPriority(Thread.MIN_PRIORITY);
            } else if (turtleDistance < rabbitDistance) {
                System.out.println("\u001B[32m" + "Черепаха отстаёт! Она ускоряется..." + "\u001B[0m");
                threadTurtle.setPriority(Thread.MAX_PRIORITY);
                threadRabbit.setPriority(Thread.MIN_PRIORITY);
            } else {
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    static void Priority2() {
        AnimalThread rabbit = new AnimalThread("\u001B[33m Кролик \u001B[0m", Thread.MIN_PRIORITY);
        Thread threadRabbit = new Thread(rabbit);
        threadRabbit.setPriority(rabbit.priorityTread);

        AnimalThread turtle = new AnimalThread("\u001B[32m Черепаха \u001B[0m", Thread.MAX_PRIORITY);
        Thread threadTurtle = new Thread(turtle);
        threadTurtle.setPriority(turtle.priorityTread);

        threadRabbit.start();
        threadTurtle.start();

        while (threadRabbit.isAlive() && threadTurtle.isAlive()) {
            int rabbitDistance = rabbit.Distance();
            int turtleDistance = turtle.Distance();

            if (rabbitDistance < turtleDistance) {
                System.out.println("\u001B[33m" + "Кролик отстаёт! Он ускоряется..." + "\u001B[0m");
                threadRabbit.setPriority(Thread.MAX_PRIORITY);
                threadTurtle.setPriority(Thread.MIN_PRIORITY);
            } else if (turtleDistance < rabbitDistance) {
                System.out.println("\u001B[32m" + "Черепаха отстаёт! Она ускоряется..." + "\u001B[0m");
                threadTurtle.setPriority(Thread.MAX_PRIORITY);
                threadRabbit.setPriority(Thread.MIN_PRIORITY);
            } else {
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    static void Priority0() {
        AnimalThread rabbit = new AnimalThread("\u001B[33m Кролик \u001B[0m", Thread.NORM_PRIORITY);
        Thread threadRabbit = new Thread(rabbit);
        threadRabbit.setPriority(rabbit.priorityTread);

        AnimalThread turtle = new AnimalThread("\u001B[32m Черепаха \u001B[0m", Thread.NORM_PRIORITY);
        Thread threadTurtle = new Thread(turtle);
        threadTurtle.setPriority(turtle.priorityTread);

        threadRabbit.start();
        threadTurtle.start();

        while (threadRabbit.isAlive() && threadTurtle.isAlive()) {
            int rabbitDistance = rabbit.Distance();
            int turtleDistance = turtle.Distance();

            if (rabbitDistance < turtleDistance) {
                System.out.println("\u001B[33m" + "Кролик отстаёт! Он ускоряется..." + "\u001B[0m");
                threadRabbit.setPriority(Thread.MAX_PRIORITY);
                threadTurtle.setPriority(Thread.MIN_PRIORITY);
            } else if (turtleDistance < rabbitDistance) {
                System.out.println("\u001B[32m" + "Черепаха отстаёт! Она ускоряется..." + "\u001B[0m");
                threadTurtle.setPriority(Thread.MAX_PRIORITY);
                threadRabbit.setPriority(Thread.MIN_PRIORITY);
            } else {
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class AnimalThread implements Runnable {
    String treadName;
    int priorityTread;
    int distance;

    public AnimalThread(String treadName, int priorityTread) {
        this.treadName = treadName;
        this.priorityTread = priorityTread;
        this.distance = 0;
    }

    public int Distance() {
        return distance;
    }

    @Override
    public void run() {
        System.out.println("Животное " + treadName + " стартовало. До финиша ему осталось:");
        try {
            Scanner running = new Scanner(System.in);
            System.out.println("Введите число, которое будет обозначать дистанцию в метрах: ");
            for (int m = running.nextInt(); m >= 0; m--) {
                distance = m;
                if (m == 0) {
                    System.out.println("Животное " + treadName + " финишировало!");
                }
                System.out.println(treadName + ": " + distance + " м");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("\u001B[31m" + "\nОшибка: некорректный ввод! Введите корректные значения!\n" + "\u001B[0m");
        }
    }
}