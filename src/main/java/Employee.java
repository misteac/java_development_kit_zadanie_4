import java.util.ArrayList;
import java.util.List;

class Employee {
    private int employeeId;
    private String phoneNumber;
    private String name;
    private int experience;

    public Employee(int employeeId, String phoneNumber, String name, int experience) {
        this.employeeId = employeeId;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "табельный номер = " + employeeId +
                ", номер телефона = '" + phoneNumber + '\'' +
                ", имя = '" + name + '\'' +
                ", стаж = " + experience;
    }
}

class EmployeeDirectory {
    private List<Employee> employees;

    public EmployeeDirectory() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> findEmployeesByExperience(int targetExperience) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getExperience() == targetExperience) {
                result.add(employee);
            }
        }
        return result;
    }

    public String findPhoneNumberByName(String targetName) {
        for (Employee employee : employees) {
            if (employee.getName().equals(targetName)) {
                return employee.getPhoneNumber();
            }
        }
        return "Сотрудник не найден";
    }

    public Employee findEmployeeByEmployeeId(int targetEmployeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == targetEmployeeId) {
                return employee;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        // Добавление новых сотрудников
        directory.addEmployee(new Employee(1, "8(985)863-96-74", "Иванов Николай Петрович", 5));
        directory.addEmployee(new Employee(2, "8(635)878-85-48", "Сидорова Виктория Ивановна", 3));
        directory.addEmployee(new Employee(3, "8(485)125-32-21", "Калмыкова Юлия Сергеевна", 1));
        directory.addEmployee(new Employee(4, "8(519)362-46-31", "Дедков Иван Юрьевич", 10));
        directory.addEmployee(new Employee(5, "8(785)496-49-11", "Симухин Владимир Митрофанович", 7));

        // Поиск сотрудников по стажу
        List<Employee> employeesWithExperience3 = directory.findEmployeesByExperience(3);
        System.out.println("Сотрудники со стажем 3 года: " + employeesWithExperience3);

        // Поиск номера телефона по имени
        String phoneNumberIvanov = directory.findPhoneNumberByName("Иванов Николай Петрович");
        System.out.println("Номер телефона для: 'Иванов Н.П.': " + phoneNumberIvanov);

        // Поиск сотрудника по табельному номеру
        Employee employeeById2 = directory.findEmployeeByEmployeeId(2);
        System.out.println("Информация о сотруднике с табельным номером 2: " + employeeById2);
    }
}
