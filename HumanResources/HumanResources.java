import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Formatter;
import java.util.zip.CheckedOutputStream;

public class HumanResources {

    private static ArrayList<Staff> staff = new ArrayList<>();// ARRAYlIST CHỨA NHÂN VIÊN CÔNG TY
    private static ArrayList<Department> departments = new ArrayList<>(); // ARRAYLIST CHỨA PHÒNG BAN CÔNG TY
    private static Scanner cs = new Scanner(System.in);

    // arrayNamePosManager định nghĩa array tên chức vụ quản lý
    private static final String[] arrayNamePosManager = {"", "Business Leader", "Project Leader", "Technical Leader"};
    // nameDepartments, idDepartments định nghĩa array tên phòng ban và mã phòng ban
    private static final String[] nameDepartments = {"", "Human Resources", "Information Technology", "Marketting"};
    private static final String[] idDepartments = {"", "HR", "IT", "MKT"};
    public static void main(String[] args){
        createBasicDepartments();   // Tạo đối tượng phòng ban và thêm vào arraylist departments
        do {
            mainMenu();             // gọi function mainMenu
        } while (true);

    }

    /**
     * mainMenu() menu chính của chương trình
     */
    public static void mainMenu(){
        /** Hiển thị các mục trong menu*/
        System.out.println("\nWELL COME TO THE HUMAN RESOURCES PROGRAM");
        System.out.println("1. \t DISPLAY THE LIST OF EMPLOYEES IN THE COMPANY");
        System.out.println("2. \t DISPLAY THE LIST OF DEPARTMENTS IN THE COMPANY");
        System.out.println("3. \t DISPLAY THE LIST OF STAFF BY DEPARTMENT");
        System.out.println("4. \t ADD NEW STAFF");
        System.out.println("5. \t SEARCH STAFF INFORMATION");
        System.out.println("6. \t DISPLAY PAYROLL OF ALL STAFF");
        System.out.println("7. \t DISPLAY PAYROLL OF ALL STAFF IN ORDER");
        System.out.println("8. \t EXIT");

        /** đọc lệnh từ người dùng và chạy function tương ứng*/
        System.out.print("CH00SE: ");
        int mainMenu = Integer.parseInt(cs.next());

        switch (mainMenu){
            case 1:
                printListOfEmployeesInTheCompany();         // hiển thị danh sách nhân viên công ty
                break;
            case 2:
                printListOfDepartments();                   // hiển thị danh sách phòng ban
                break;
            case 3:
                printListOfEmployeesByDepartment();         // hiển thị danh sách nhân viên theo phòng ban
                break;
            case 4:
                addNewStaffMenu();                          // hiển thị menu thêm nhân viên mới
                break;
            case 5:
                searchEmployeeInforMenu();                  // hiển thị menu tìm kiếm thông tin nhân viên
                break;
            case 6:
                printSalaryAllEmployee();                   // hiển thị bảng lương nhân viên
                break;
            case 7:
                menuPrintSalaryInOrder();                   // hiển thị menu in bảng lương nhân viên theo thứ tự
                break;
            case 8:
                System.exit(0);                        // kết thúc chường trình
            default:
                System.out.println("ERROR VALUE");
                mainMenu();
        }
    }

    /**
     * addNewStaffMenu() : hiển thị menu thêm nhân viên mới
     *                     nhập 1 - gọi hàm thêm nhân viên mới
     *                     nhập 2 - gọi hàm thêm quản lý mới
     * @param
     * @return
     */
    public static void addNewStaffMenu(){
        System.out.println("\nMENU ADD NEW STAFF:");
        System.out.println("1. \t ADD NEW EMPLOYEE");
        System.out.println("2. \t ADD NEW MANAGER");
        System.out.print("CHOOSE: ");
        int addMenu = cs.nextInt();
        switch (addMenu){
            case 1:
                addEmployee();
                break;
            case 2:
                addManager();
                break;
            default:
                System.out.println("ERROR VALUE");
                mainMenu();
        }
    }

    /**
     * searchEmployeeInforMenu(): hiển thị menu tìm kiếm thông tin nhân viên
     *                          nhập 1 - chạy chương trình tìm kiếm theo tên
     *                          nhập 2 - chạy chương trình tìm kiếm theo id
     *                          báo "ERROR VALUE" khi nhập khác 2 giá trị trên
     */
    public static void searchEmployeeInforMenu(){
        System.out.println("\nMENU SEARCH STAFF INFORMATION:");
        System.out.println("1. \t BY NAME");
        System.out.println("2. \t BY ID");
        System.out.print("CHOOSE: ");
        int searchMenu = Integer.parseInt(cs.next());
        switch (searchMenu){
            case 1:
                searchEmployeeByName();
                break;
            case 2:
                searchEmployeeById();
                break;
            default:
                System.out.println("ERROR VALUE");
                mainMenu();
        }
    }

    /**
     * searchEmployeeByName(): chương trình tìm kiếm thông tin nhân viên theo tên
     *                         Nhập tên nhân viên và hiễn thị tên nhân viên nếu có
     *                         KHông tìm thấy hiển thị "NO RESULT FOUND."
     */
    public static void searchEmployeeByName(){
        cs.nextLine();
        boolean result = false;
        System.out.print("\nENTER NAME OF STAFF:");
        String sName = cs.nextLine();
        System.out.format("%-10s %-20s %-5s %-20s %-30s %-15s\n", "ID", "Name", "Age", "Position", "Department", "DateJoin");
        for(int i = 0; i < staff.size(); i ++){
            if(staff.get(i).getName().equalsIgnoreCase(sName)){
                result = true;
                staff.get(i).displayInformation(false);
            }
        }
        if(result){
            return;
        }
        System.out.println("NO RESULT FOUND.");
    }

    /**
     * searchEmployeeById(): chương trình tìm kiếm thông tin nhân viên theo id
     *                         Nhập id nhân viên và hiễn thị tên nhân viên nếu có
     *                         KHông tìm thấy hiển thị "NO RESULT FOUND."
     */
    public static void searchEmployeeById(){
        boolean result = false;
        System.out.print("\nENTER ID OF STAFF:");
        String sId = cs.next();
        System.out.format("%-10s %-20s %-5s %-20s %-30s %-15s\n", "ID", "Name", "Age", "Position", "Department", "DateJoin");
        for(int i = 0; i < staff.size(); i ++){
            if(staff.get(i).getId().equalsIgnoreCase(sId)){
                staff.get(i).displayInformation(false);
                result = true;
            }
        }
        if(result){
            return;
        }
        System.out.println("NO RESULT FOUND.");
    }

    /**
     *  createBasicDepartments(): tạo mảng chứa các đối tượng phòng ban
     *  idDepartments -  mảng chứa mã phòng ban
     *  nameDepartments - mảng chứa tên phòng ban
     */
    public static void createBasicDepartments(){
        for (int i = 0; i < nameDepartments.length; i++){
            Department temp = new Department(idDepartments[i] , nameDepartments[i], 0);
            departments.add(temp);
        }
    }

    /**
     * printListOfEmployeesInTheCompany() - hiển thị danh sách nhân viên đã được thêm vào công ty
     */
    public static void printListOfEmployeesInTheCompany(){
        System.out.println("\nLIST OF STAFF:");
        System.out.format("%-10s %-20s %-5s %-20s %-30s %-15s\n", "ID", "Name", "Age", "Position", "Department", "DateJoin");
        staff.forEach((_staff)->_staff.displayInformation(false));
    }
    /**
     * printListOfEmployeesByDepartment() - hiển thị danh sách nhân viên theo phòng ban
     */
    public static void printListOfEmployeesByDepartment(){
        System.out.println("\nLIST OF STAFF BY DEPARTMENT:");
        for(int i = 1; i < nameDepartments.length; i ++){
            System.out.println("\n" + nameDepartments[i]);
            System.out.format("%-10s %-20s %-5s %-20s %-30s %-15s\n", "ID", "Name", "Age", "Position", "Department", "DateJoin");
            for (Staff _staff : staff) {
                if (_staff.getDepartment().getName().equalsIgnoreCase(nameDepartments[i])) {
                    _staff.displayInformation(false);
                }
            }
        }
    }
    /**
     * printListOfDepartments() hiển thị danh sách phòng ban: id - name - number of staff
     */
    public static void printListOfDepartments(){
        System.out.println("\nLIST OF DEPARTMENT:");
        System.out.format("%-10s %-30s %-50s\n","ID", "NAME", "NUMBER OF STAFF");
        for(int i = 1; i < departments.size(); i++){
            System.out.format("%-10s %-30s %-50d\n",departments.get(i).getId(), departments.get(i).getName(), departments.get(i).getNumEmployee());
        }

    }
    /**
     * addEmployee() chương trình thêm nhân viên mới
     */
    public static void addEmployee(){
        //Nhập mã nhân viên
        System.out.println("\nENTER NEW EMPLOYEE INFORMATION:");
        System.out.print("ENTER EMPLOYEE ID: ");
        String id = cs.next();
        cs.nextLine();
        //Nhập tên
        System.out.print("ENTER EMPLOYEE NAME: ");
        String name = cs.nextLine();
        //Nhập tuổi
        System.out.print("ENTER EMPLOYEE AGE: ");
        int age = cs.nextInt();
        //Nhập hệ số lương
        System.out.print("ENTER SALARY COEFFICIENT (REAL NUMBER): ");

        double coSalary  = cs.nextDouble();
        //Nhập ngày vào làm
        System.out.print("ENTER THE DATE OF JOINING THE COMPANY (DD/MM/YYYY): ");
        String dateJoin  = cs.next();
        //Nhập số ngày nghỉ phép
        System.out.print("ENTER THE NUMBER OF LEAVE DAYS: ");
        int nDayOff = cs.nextInt();
        //Nhập phòng ban
        System.out.println("SELECT THE DEPARTMENT IN THE ORDER NUMBER BELOW: ");
        for(int i = 1; i < departments.size(); i ++){
            System.out.println(i + ".\t" + departments.get(i).getId() + " - " + departments.get(i).getName());
        }
        System.out.print("CHOOSE A DEPARTMENT: ");
        int idDepartment = cs.nextInt();
        //Nhập sô giờ tăng ca
        System.out.print("ENTER OVERTIME: ");
        int otHours = cs.nextInt();

        //Tạo nhân viên mới và thêm vào ArrayList staff
        Employee emp = new Employee(id, name, age, coSalary, dateJoin, nDayOff,departments.get(idDepartment), otHours);
        staff.add(emp);

    }
    /**
     * addManager() chương trình thêm quản lý mới
     */
    public static void addManager(){
        //Nhập mã nhân viên
        System.out.println("\nENTER NEW MANAGER INFORMATION:");
        System.out.print("ENTER STAFF ID: ");
        String id = cs.next();
        cs.nextLine();
        //Nhập tên
        System.out.print("ENTER STAFF NAME: ");
        String name = cs.nextLine();
        //Nhập tuổi
        System.out.print("ENTER EMPLOYEE AGE: ");
        int age = cs.nextInt();
        //Nhập hệ số lương
        System.out.print("ENTER SALARY COEFFICIENT (REAL NUMBER): ");
        double coSalary  = cs.nextDouble();
        //Nhập ngày vào làm
        System.out.print("ENTER THE DATE OF JOINING THE COMPANY (DD/MM/YYYY): ");
        String dateJoin  = cs.next();
        //Nhập số ngày nghỉ phép
        System.out.print("ENTER THE NUMBER OF LEAVE DAYS: ");
        int nDayOff = cs.nextInt();
        //Nhập phòng ban
        System.out.println("SELECT THE DEPARTMENT IN THE ORDER NUMBER BELOW: ");
        for(int i = 1; i < departments.size(); i ++){
            System.out.println(i + ".\t" + departments.get(i).getId() + " - " + departments.get(i).getName());
        }
        System.out.print("CHOOSE A DEPARTMENT: ");
        int idDepartment = cs.nextInt();

        //Nhập chức vụ
        System.out.println("CHOOSE A POSITION FOR A NEW MANAGER:");
        for(int i = 1 ; i < arrayNamePosManager.length; i++){
            System.out.println(i + ".\t\t" + arrayNamePosManager[i]);
        }
        System.out.print("CHOOSE: ");
        int position = cs.nextInt();



        Manager emp = new Manager(id, name, age, coSalary, dateJoin, nDayOff,departments.get(idDepartment), arrayNamePosManager[position]);
        staff.add(emp);
    }
    /**
     * printSalaryAllEmployee() chương trình hiển thị thông tin và lương nhân viên
     */
    public static void printSalaryAllEmployee(){
        System.out.println("\nDISPLAY PAYROLL OF ALL STAFF");
        System.out.format("%-10s %-20s %-5s %-20s %-30s %-15s %-15s\n", "ID", "NAME", "AGE", "POSITION", "DEPARTMENT", "DATEJOIN", "SALARY");
        staff.forEach(_staff -> _staff.displayInformation(true));
    }

    /**
     * function menuPrintSalaryInOrder(): hiển thị menu in lương nhân vân theo thứ tự
     *                                    nhập 1 - gọi hàm hiển thị bàng lương theo thứ tự tăng dần
     *                                    nhập 2 - gọi hàmvhiển thị bảng lương theo thứ tự giàm dần
     */
    public static void menuPrintSalaryInOrder(){
        System.out.println("\nMENU DISPLAY PAYROLL OF ALL STAFF IN ORDER:");
        System.out.println("1. \t ASCENDING");
        System.out.println("2. \t DESCENDING");
        System.out.print("CHOOSE: ");
        int salaryMenu= cs.nextInt();
        switch (salaryMenu){
            case 1:
                printSalaryAllEmployeeInAscendingOrder();
                break;
            case 2:
                printSalaryAllEmployeeInDescendingOrder();
                break;
            default:
                System.out.println("ERROR VALUE");
                mainMenu();
        }
    }
    /**
     * printSalaryAllEmployeeInAscendingOrder() chương trình hiển thị thông tin và lương nhân viên theo thứ tự tăng dần
     */
    public static void printSalaryAllEmployeeInAscendingOrder(){
        ArrayList<Staff> temp = new ArrayList<>();
        ArrayList<Staff> tempSorted = new ArrayList<>();
        staff.forEach(_staff -> temp.add(_staff));    // copy từng phần tử trong arraylist staff vào arraylist temp


        double salaryMin;
        int indexMin;
        int maxlength = staff.size();
        for (int i = 0; i < maxlength; i ++){
            salaryMin = temp.get(0).getSalary();
            indexMin = 0;
            // Tìm phần tử có salary nhỏ nhất trong arraylist temp
            for (int j = 0; j < temp.size(); j ++){
                if (salaryMin >= temp.get(j).getSalary()){
                    salaryMin = temp.get(j).getSalary();
                    indexMin = j;
                }
            }
            // Thêm phần tử có salary nhỏ nhất vào arraylist tempSorted và xóa nó trong arraylist temp
            tempSorted.add(temp.get(indexMin));
            temp.remove(indexMin);

        }
        System.out.println("\nDISPLAY PAYROLL OF ALL STAFF IN ASCENDING ORDER");
        System.out.format("%-10s %-20s %-5s %-20s %-30s %-15s %-15s\n", "ID", "NAME", "AGE", "POSITION", "DEPARTMENT", "DATEJOIN", "SALARY");
        tempSorted.forEach(_tempSorted -> _tempSorted.displayInformation(true));

    }
    /**
     * printSalaryAllEmployeeInDescendingOrder() chương trình hiển thị thông tin và lương nhân viên theo thứ tự tăng dần
     */
    public static void printSalaryAllEmployeeInDescendingOrder(){
        ArrayList<Staff> temp = new ArrayList<>();
        ArrayList<Staff> tempSorted = new ArrayList<>();
        staff.forEach(_staff -> temp.add(_staff));      // copy từng phần tử trong arraylist staff vào arraylist temp


        double salaryMax;
        int indexMax;
        int maxlength = staff.size();
        for (int i = 0; i < maxlength; i ++){
            salaryMax = temp.get(0).getSalary();
            indexMax = 0;
            // Tìm phần tử có salary nhỏ nhất trong arraylist temp
            for (int j = 0; j < temp.size(); j ++){
                if (salaryMax <= temp.get(j).getSalary()){
                    salaryMax = temp.get(j).getSalary();
                    indexMax = j;
                }
            }
            // Thêm phần tử có salary lớn nhất vào arraylist tempSorted và xóa nó trong arraylist temp
            tempSorted.add(temp.get(indexMax));
            temp.remove(indexMax);

        }
        System.out.println("\nDISPLAY PAYROLL OF ALL STAFF IN DESCENDING ORDER");
        System.out.format("%-10s %-20s %-5s %-20s %-30s %-15s %-15s\n", "ID", "NAME", "AGE", "POSITION", "DEPARTMENT", "DATEJOIN", "SALARY");
        tempSorted.forEach(_tempSorted -> _tempSorted.displayInformation(true));

    }
}
