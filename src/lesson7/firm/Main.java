package lesson7.firm;

import java.util.Scanner;

/**
 * Created by stefan on 08.08.16.
 */
public class Main {



    public static void main(String[] args) {
        Firm f = new Firm("qqqq", "qqqqq", 0);

        Console c = new Console(f);



        c.start();
//
//
////        Employee e = new Employee("Vasia", "Petrov", 0, 0, "middle", "");
//
//        f.addEmployee(new Employee("Vasia", "Ivanov", 10, 0, "middle", ""));
//        f.addEmployee(new Employee("Vasia", "Petrov", 0, 0, "middle", ""));
//
//
//
////        f.listEmployees.clear();
//
////
//        for(Employee em : f.getAllEmployeesOrderedBySalary()){
//            System.out.println(em.name + " " + em.surname + " " + em.salary);
//        }
//
//        for(Employee em : f.getAllEmployees()){
//            System.out.println(em.name + " " + em.surname + " " + em.salary);
//        }

        consolMenu();

    }

    public static void consolMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("Вы работаете с фирмой.");

        boolean check = true;
        Firm firm1 = new Firm("defalt", "defalt", 0.00);
        while (check) {
            System.out.println("Выберите действие");
            System.out.println("0 - Создать фирму");
            System.out.println("1 - Добавить сотрудника");
            System.out.println("2 - Уволить сотрудника");
            System.out.println("3 - Получить список всех сотрудников фирмы");
            System.out.println("4 - Получить список всех сотрудников фирмы отсортированных по зарплате");
            System.out.println("5 - Выплатить зарплату");
            System.out.println("6 - Выход");
            System.out.println("7 - Вывести список сотрудников в консоль");

            int action = in.nextInt();
            switch (action) {
                case 0:
                    System.out.println("Введите название фирмы");
                    firm1.name = in.next();
                    System.out.println("Введите адресс");
                    firm1.adress = in.next();
                    System.out.println("Введите баланс счета");
                    firm1.account = in.nextDouble();
                    System.out.println("Вы успешно создали фирму");
                    break;

                case 1:
                    System.out.println("Введите имя сотрудника");
                    String nameEmpl = in.next();
                    System.out.println("Введите фамилию сотрудника");
                    String surname = in.next();
                    System.out.println("Введите зарплату сотрудника");
                    double salary = in.nextDouble();
                    System.out.println("Введите баланс сотрудника");
                    double balance = in.nextDouble();
                    System.out.println("Введите пол сотрудника");
                    String sex = in.next();
                    System.out.println("Введите отдел сотрудника");
                    String department = in.next();
                    Employee employee = new Employee(nameEmpl, surname, salary, balance, sex, department);
                    firm1.addEmployee(employee);
                    System.out.println("Вы успешно добавили сотрудника");

                    break;

                case 2:
                    System.out.println("Введите имя сотрудника");
                    String nameEmplFire = in.next();
                    System.out.println("Введите фамилию сотрудника");
                    String surnameEmplFire = in.next();
                    firm1.fireEmployee(nameEmplFire, surnameEmplFire);
                    System.out.println("Вы успешно уволили сотрудника.");

                    break;

                case 3:
                    firm1.getAllEmployees();
                    break;

                case 4:
                    firm1.getAllEmployeesOrderedBySalary();
                    break;

                case 5:
                    firm1.giveSalaryForAll();
                    break;
                case 6:
                    check = false;
                    System.out.println("Вы закрыли программу");
                    break;
                case 7:
                    firm1.printListEmployees();
                    break;

                default:
                    System.out.println("Неверный ввод");
                    break;
            }

        }

    }

}
