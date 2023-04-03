abstract class Staff {
    private String id;
    private String name;
    private int age;
    private double coefSalary;
    private String dateJoin;
    private Department department;
    private int nDayOff;

    private double Salary;
    /**
     * Hàm tạo class Staff
     * @param id mã nhân viên
     * @param name tên nhân viên
     * @param coefSalaru hệ số lương
     * @param dateJoin  ngày gia nhập công ty
     * @param nDayOff số ngày nghỉ
     * @param department phòng ban làm việc của nhân viên
     * @return none
     */
    public Staff(String id, String name, int age, double coefSalaru, String dateJoin, int nDayOff, Department department){
        this.id = id;
        this.name = name;
        this.age = age;
        this.coefSalary = coefSalaru;
        this.dateJoin = dateJoin;
        this.nDayOff = nDayOff;
        this.department = department;
    }
    /** Setter and getter Age: tuồi nhân viên*/
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    /** setter and getter ID: mã số nhân viên */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    /** setter and getter coefSalary: hệ số lương */
    public double getCoefSalary() {
        return coefSalary;
    }

    public void setCoefSalary(double coefSalaru) {
        this.coefSalary = coefSalaru;
    }
    /** setter and getter department: phòng ban làm việc của nhân viên */
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    /** setter and getter dateJoin: ngày gia nhập công ty của nhân viên */
    public String getDateJoin() {
        return dateJoin;
    }

    public void setDateJoin(String dateJoin) {
        this.dateJoin = dateJoin;
    }
    /** setter and getter name: tên nhân viên */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /** setter and getter nDayOff: số ngày nghỉ của nhân viên */
    public int getnDayOff() {
        return nDayOff;
    }

    public void setnDayOff(int nDayOff) {
        this.nDayOff = nDayOff;
    }
    /** setter and getter salary: lương của nhân viên */
    public void setSalary(double salary) {
        Salary = salary;
    }

    public double getSalary() {
        return Salary;
    }
    /**
     * abstract function displayInfornation hiển thị thông tin nhân viên
     * @param flagSalary cờ hiền thị mức lương của nhân viên
     *                   true: có hiển thị
     *                   false: không hiển thị
     */
    abstract public void displayInformation(boolean flagSalary);
}
