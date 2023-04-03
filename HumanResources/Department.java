public class Department {
    private String id;             // mã số phòng ban
    private String name;        // tên phòng ban
    private int numEmployee;    // số lường nhân viên thuộc phòng ban

    /**
     *Hàm tạo class Department
     * @param id mã số phong ban
     * @param name tên phòng ban
     * @param numEmployee số lượng nhân viên thuộc phòng ban
     * @return
     */
    public Department(String id, String name, int numEmployee){
        this.id = id;
        this.name = name;
        this.numEmployee = numEmployee;
    }
    /** setter and getter id: mã số phòng ban */
    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
    /** setter and getter name: tên phòng ban */
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    /** setter and getter numEmployee: số nhân viên thuộc phòng ban */
    public void setNumEmployee(int numEmployee) {
        this.numEmployee = numEmployee;
    }

    public int getNumEmployee() {
        return numEmployee;
    }
    /**
     * toString : hiển thị thông tin phòng ban
     * @return String : thông tin phòng ban
     */
    public String toString(){
        return "ID: " + id + " \t\t Name: " + name + " \t\t Number of employees: " + numEmployee + ".\n";
    }

}
