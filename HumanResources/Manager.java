/**
 * Class Manager thừa kế class Staff và interface ICalculator
 */
public class Manager extends Staff implements ICalculator{
    private String position;
    private double salary;

    /** Hàm tạo class Manager */
    public Manager(String id, String name, int age, double coefSalaru, String dateJoin, int nDayOff,Department department, String position) {
        super(id, name, age, coefSalaru, dateJoin, nDayOff, department);    //gửi thông tin tạo obj mới tới hàm tạo class Staff
        department.setNumEmployee(department.getNumEmployee() + 1);         //update số lượng nhân viên
        this.position = position;                                           //gán vị trí
        super.setSalary(calculateSalary());                                 //tính lương
    }

    /** Setter and getter position: chức vụ quản lý */
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * calculateSalary: override function from interface ICalculator : hàm tính lương quản lý
     * @return lương quản lý = hệ số lương * 5,000,000  +   mức lương theo chức vụ
     */
    @Override
    public double calculateSalary() {
        double responsibleWage;
        switch (this.getPosition()){
            case "Business Leader":
                responsibleWage = 8000000.0;
                break;
            case "Project Leader":
                responsibleWage = 5000000.0;
                break;
            case "Technical Leader":
                responsibleWage = 6000000.0;
                break;
            default:
                responsibleWage = 0;
        }

        return this.getCoefSalary() * 5000000.0 + responsibleWage;
    }
    /**
     * displayInformation: override function from class Staff : hiển thị thông tin nhân viên
     * @param flagSalary cờ hiền thị mức lương của nhân viên
     *                   true: có hiển thị
     *                   false: không hiển thị
     * @return none
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

}
