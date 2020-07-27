import java.io.*;
public class Assignment3 {
    public static void main (String[] args) throws IOException, NotFoundException {
        MyHashTable_<Key<String,String>,Student> hashTable = null;
        if (args[1].equals("DH"))
            hashTable=new MyHashTableDH<Key<String,String>,Student>(Integer.valueOf(args[0]));
        else if (args[1].equals("SCBST"))
            hashTable=new MyHashTableSCBST<Key<String,String>,Student>(Integer.valueOf(args[0]));
        FileReader studentRecord = new FileReader(args[2]);
        BufferedReader a = new BufferedReader(studentRecord);
        String line;
        while ((line = a.readLine()) != null) {
            String[] inp=line.split(" ");
            if (inp[0].equals("insert")){
                Student student=new Student();
                student.fname=inp[1];
                student.lname=inp[2];
                student.hostel=inp[3];
                student.department=inp[4];
                student.cgpa=inp[5];
                Key <String,String> key=new Key<>();
                key.f=inp[1];
                key.l=inp[2];
                int i=hashTable.insert(key,student);
                System.out.println(i);
            }else if (inp[0].equals("update")){
                Student student=new Student();
                student.fname=inp[1];
                student.lname=inp[2];
                student.hostel=inp[3];
                student.department=inp[4];
                student.cgpa=inp[5];
                Key <String,String> key=new Key<>();
                key.f=inp[1];
                key.l=inp[2];
                int i=hashTable.update(key,student);
                if (i>=0)
                System.out.println(i);
                else System.out.println('E');
            }else if (inp[0].equals("delete")){
                Key <String,String> key=new Key<>();
                key.f=inp[1];
                key.l=inp[2];
                int i=hashTable.delete(key);
                if (i>=0)
                    System.out.println(i);
                else System.out.println('E');
            }else if (inp[0].equals("contains")){
                Key <String,String> key=new Key<>();
                key.f=inp[1];
                key.l=inp[2];
                boolean b=hashTable.contains(key);
                if (b)
                    System.out.println('T');
                else System.out.println('F');
            }else if (inp[0].equals("get")){
                Key <String,String> key=new Key<>();
                key.f=inp[1];
                key.l=inp[2];
                try{
                    Student student=hashTable.get(key);
                    System.out.println(student.fname()+' '+student.lname()+' '+student.hostel()+' '+student.department()+' '+student.cgpa());
                } catch (NotFoundException e) {
                    System.out.println('E');
                }

            }else if (inp[0].equals("address")){
                Key <String,String> key=new Key<>();
                key.f=inp[1];
                key.l=inp[2];
                try{
                    System.out.println(hashTable.address(key));
                } catch (NotFoundException e) {
                    System.out.println('E');
                }
            }
        }
    }
}
