class Student implements Student_ {
    public String fname;      // Return student’s first name
    public String lname;      // Return student’s last name
    public String hostel;     // Return student’s hostel name
    public String department; // Return student’s department name
    public String cgpa;
    public Student(){

    }

    @Override
    public String fname() {
        return fname;
    }

    @Override
    public String lname() {
        return lname;
    }

    @Override
    public String hostel() {
        return hostel;
    }

    @Override
    public String department() {
        return department;
    }

    @Override
    public String cgpa() {
        return cgpa;
    }
}
