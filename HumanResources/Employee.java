/**
 * Class Employee thừa kế class Staff và interface ICalculator
 */
public class Employee extends Staff implements ICalculator{
    private int otHours;                     // thời gian tăng
    private String position;                 // chức vụ


    /** Hàm tạo class Employee */
    public Employee(String id, String name, int age, double coefSalaru, String dateJoin, int nDayOff, Department department, int otHours) {
        super(id, name, age, coefSalaru, dateJoin, nDayOff, department);    // gửi thông tin tạo obj mới tới hàm tạo class Staff
        department.setNumEmployee(department.getNumEmployee() + 1);         // update số lượng nhân viên
        this.otHours = otHours;                                             // gán giá trị thời gian tăng ca
        this.position = "Employee";                                         // gán chức vụ, mặc định với class Employee là Employee
        super.setSalary(calculateSalary());                                 // tính lương nhân viên và gán giá trị vào biến salary trong class Staff
    }

    /** Setter and getter otHours: thời gian tăng ca*/
    public int getOtHours() {
        return otHours;
    }

    public void setOtHours(int otHours) {
        this.otHours = otHours;
    }
    /** Setter and getter position: chức vụ */
    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    /**
     * displayInformation: override function from class Staff : hiển thị thông tin nhân viên
     * @param flagSalary cờ hiền thị mức lương của nhân viên
     *                   true: có hiển thị
     *                   false: không hiển thị
     */
    @Override
    public void displayInformation(boolean flagSalary) {
        if (flagSalary){
            System.out.format("%-10s %-20s %-5d %-20s %-30s %-15s %-15.1f\n",
                    this.getId(), this.getName(), this.getAge(), this.getPosition(), this.getDepartment().getName(), this.getDateJoin(), this.getSalary());
            return;
        }
        System.out.format("%-10s %-20s %-5d %-20s %-30s %-15s\n",
                this.getId(), this.getName(), this.getAge(), this.getPosition(), this.getDepartment().getName(), this.getDateJoin());

    }

    /**
     * calculateSalary: override function from interface ICalculator : hàm tính lương nhân viên
     * @return lương nhân viên = hệ số lương * 3,000,000    +   thời gian tăng ca * 200,000
     */
    @Override
    public double calculateSalary(){
        return super.getCoefSalary() * 3000000 + otHours * 200000;
    }
}
