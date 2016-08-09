package lesson7.firm;

import java.util.ArrayList;

public class Firm {

    // 3. Написать класс фирма (Firm), содержащий имя, адрес, зарплатный счет
    // (сумма), список сотрудников.
    // У каждого сотрудника (Employee) есть имя, фамилия, ставка зарплаты
    // (сумма), его личный карточный счет (сумма), пол, отдел.
    //
    // Класс фирма должен выполнять следующие функции:
    //
    // - Добавить сотрудника (метод boolean addEmployee(Employee employee))
    //
    // - Уволить сотрудника по имени и фамилии (метод boolean
    // fireEmployee(String name, String surname))
    //
    // - Получить список всех сотрудников фирмы (метод ArrayList<Employee>
    // getAllEmployees())
    //
    // - Получить список всех сотрудников фирмы отсортированных по зарплате
    // (метод ArrayList<Employee> getAllEmployeesOrderedBySalary())
    //
    // - Выдать всем сотрудникам зарплату (перевести на карточный счет каждого
    // сотрудника, сумму равную зарплате сотрудника с главного счета фирмы, если
    // на счету фирмы не хватает средств - выдать сколько хватит =)) (метод void
    // giveSalaryForAll())

    String name;
    String adress;
    double account;
    ArrayList<Employee> listEmployees;

    Firm(String name, String adress, double account) {
        this.name = name;
        this.adress = adress;
        this.account = account;
        this.listEmployees = new ArrayList<Employee>();
    }

    public boolean addEmployee(Employee employee) {

        for(Employee e : listEmployees){
            if(e.name.equals(employee.name) && e.surname.equals(employee.surname)){
                return false;
            }
        }
//        if(listEmployees.contains(employee)){
//           return false;
//        }

        this.listEmployees.add(employee);
        return true;
    }

    public boolean fireEmployee(String name, String surname) {
        for (int i = 0; i < listEmployees.size(); i++) {
            if (listEmployees.get(i).name.equals(name) && listEmployees.get(i).surname.equals(surname)) {
                listEmployees.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Employee> getAllEmployees() {
        return new ArrayList<Employee>(listEmployees);
    }

    public ArrayList<Employee> getAllEmployeesOrderedBySalary() {
        Employee tmpMaxSalary;

        ArrayList<Employee> listEmployees = getAllEmployees();

        for (int i = 0; i < listEmployees.size(); i++) {

            for (int j = 0; j < listEmployees.size() - 1; j++) {

                if (listEmployees.get(j).salary > listEmployees.get(j + 1).salary) {

                    tmpMaxSalary = listEmployees.get(j);
                    listEmployees.set(j, listEmployees.get(j + 1));
                    listEmployees.set(j + 1, tmpMaxSalary);

                }
            }
        }
        return listEmployees;
    }

    public void giveSalaryForAll() {

        for(Employee e : listEmployees){
            if (this.account > e.salary) {
                this.account -= e.salary;
                e.balance += e.salary;
            } else {
                e.balance += this.account;
                this.account = 0;
                return;
            }
        }
//        System.out.println("Выплачено зарплату. Остаток на счету фирмы " + this.account);
    }

    public void printListEmployees() {
        for (int i = 0; i < listEmployees.size(); i++) {
            System.out.printf(
                    "Employee "
                            + "Name: %-10s Surname: %-10s Salary: %-8.2f Balance: %-8.2f Sex: %-6s Department: %-10s\n",
                    listEmployees.get(i).name, listEmployees.get(i).surname, listEmployees.get(i).salary,
                    listEmployees.get(i).balance, listEmployees.get(i).sex, listEmployees.get(i).department);

        }
        System.out.println("==========================================================");
    }


}