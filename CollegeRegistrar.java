import java.util.ArrayList;
import java.util.stream.IntStream; 
import java.util.Random;
/**
 * CollegeRegistrar class keeps track of every student registration in each class
 * 
 * @author (Tannia)
 * @version (Oct 12,2021)
 */
public class CollegeRegistrar
{
    private ArrayList<Registration> registration = new ArrayList<Registration>();
    private static Random rand = new Random();

    /**
     * Constructor for objects of class CollegeRegistrar
     */
    
    public CollegeRegistrar()
    {
        
    }

    public void addRegistration(Registration newRegistration)
    {
        registration.add(newRegistration);
        
    }
    
    public void printAllRegistrations()
    {
        registration.forEach(
            record -> record.printInfo()
        );
        
    }
    
    public void printClassesForStudent(String student)
    {
        registration.stream()
            .filter(record -> student.equals(record.getStudent()))
            .forEach(record -> System.out.printf("\nCourse Number: %s Professor: %s",record.getCourseNumber(),record.getProfessor()));

    }
    
    public int getClassCountForStudent(String student)
    {
        long classesCount = registration
            .stream()
            .filter(record -> student.equals(record.getStudent()))
            .count();
        if (classesCount > 0){
            return (int)classesCount;
        }
        return 0;
    }
    
    public void printClassesForStudentByProfessor(String student, String professor)
    {
        registration.stream()
            .filter(record -> student.equals(record.getStudent()) && professor.equals(record.getProfessor()))
            .forEach(record -> System.out.printf("\nCourse Number: %s Section: %s",record.getCourseNumber(),record.getSection()));
    }
    
    public void printClassesForStudentInSlot(String student, int timeSlot)
    {
        registration.stream()
            .filter(record -> student.equals(record.getStudent()) && timeSlot==record.getTimeSlot())
            .forEach(record -> System.out.printf("\nCourse Number: %s Section: %s",record.getCourseNumber(),record.getSection()));

    }
    
    public int getRegistrationsInClass(String classNumber)
    {
        long studentCount = registration
            .stream()
            .filter(record -> classNumber.equals(record.getCourseNumber()))
            .count();
        if ( studentCount > 0){
            return (int)studentCount;
        }
        return 0;
    }
    
    public int getRegistrationsInClass(String classNumber, int timeSlot)
    {
        long studentCount = registration
            .stream()
            .filter(record -> classNumber.equals(record.getCourseNumber()) && timeSlot==record.getTimeSlot())
            .count();
        if ( studentCount > 0){
            return (int)studentCount;
        }
        return 0;
        // get the number of students enrolled in classNumber and slot
    }
    
    public int studentsTakingClassesInSlot(int timeSlot)
    {
        // get the number of students taking classes in timeSlot
        long studentCount = registration
            .stream()
            .filter(record -> timeSlot==record.getTimeSlot())
            .count();
        if ( studentCount > 0){
            return (int)studentCount;
        }
        return 0;
    }
    
    public void dropClassForStudent(String classNumber, String student)
    {
        registration.stream()
            .filter(record -> student.equals(record.getStudent()) && classNumber.equals(record.getCourseNumber()))
            .forEach(record -> registration.remove(record));
        // drops class classNumber for student
    }
    
    public void dropAllClassesForStudent(String student)
    {
        // drops all classes for student
        ArrayList<Registration> newList = new ArrayList<>();
        registration.stream()
            .filter(record -> student.equals(record.getStudent()))
            .forEach(record -> newList.add(record));
        registration.removeAll(newList);
    }
    public void populateRegistrations(){
        String[] courseNumbers ={"COMP 1501", "ENGL 2201", "CHEM 3060", "PHYS 2344", "ENGL 2005", "COMP 2704", "PHYS 2377", "CHEM 4927","COMP 3444"};
        int[] sections={0,1,2};
        int[] timeSlots={12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        String[] professors={"Kerton","Jobst","Payne","Munroe"};
        String[] students={"Tannia","Nick","Kyle","Dylan","Samantha","Julia","Peter"};
        
        int numRegistrations = 30;
        String courseNumber ="";
        int section = 0;
        int timeSlot = 0;
        String professor = "";
        String student = "";
        
        
        while(numRegistrations > 0){
            courseNumber = courseNumbers[rand.nextInt(courseNumbers.length)];
            section = sections[rand.nextInt(sections.length)];
            timeSlot = timeSlots[rand.nextInt(timeSlots.length)];
            professor = professors[rand.nextInt(professors.length)];
            student = students[rand.nextInt(students.length)];
    
            Registration newRegistration = new Registration(courseNumber,section,timeSlot,student,professor);
            addRegistration(newRegistration);
            numRegistrations--;
        };
    }
}
