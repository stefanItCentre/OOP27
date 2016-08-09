package lesson7.firm;

class Employee {

    // У каждого сотрудника (Employee) есть имя, фамилия, ставка зарплаты
    // (сумма), его личный карточный счет (сумма), пол, отдел.

    String name;
    String surname;
    double salary;
    double balance;
    String sex;
    String department;

    public Employee(String name, String surname, double salary, double balance, String sex, String department) {

        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.balance = balance;
        this.sex = sex;
        this.department = department;

    }

    public void setEmployee(String name, String surname, double salary, double balance, String sex, String department) {

        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.balance = balance;
        this.sex = sex;
        this.department = department;

    }

    public double getSalary (){
        return salary;
    }









}