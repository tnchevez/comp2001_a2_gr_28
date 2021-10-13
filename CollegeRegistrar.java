import java.util.ArrayList;
import java.util.stream.IntStream; 
import java.util.Random;
/**
 * CollegeRegistrar class keeps track of every student registration in each course
 * 
 * @author (Tannia Chevez)
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
    /*
     * Method that adds a new class registration to the registrations arraylist
     */
    public void addRegistration(Registration newRegistration)
    {
        registration.add(newRegistration);
        
    }
    /**
     * Method that prints the information about all the class registrations, including course nummber, section, time slot, student and professor, taking the information from the registration object.
     */
    public void printAllRegistrations()
    {
        registration.forEach(
            record -> record.printInfo()
        );
        
    }
    /**
     * Method that prints the information, course number and professor, of all classes that are registered by the student given as parameter.
     */
    public void printClassesForStudent(String student)
    {
        registration.stream()
            .filter(record -> student.equals(record.getStudent()))
            .forEach(record -> System.out.printf("\nCourse Number: %s Professor: %s",record.getCourseNumber(),record.getProfessor()));

    }
    /**
     * Method that returns the amount of classes registered by the student given as parameter.
     */
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
    /**
     * Method that prints the information of the classes that are registered by the student given as parameter with the professor given as the parameter.
     */
    public void printClassesForStudentByProfessor(String student, String professor)
    {
        registration.stream()
            .filter(record -> student.equals(record.getStudent()) && professor.equals(record.getProfessor()))
            .forEach(record -> System.out.printf("\nCourse Number: %s Section: %s",record.getCourseNumber(),record.getSection()));
    }
    /**
     * Method that prints the course number and section of the classes registered by the student given as parameter and the specififc time slot. 
     */
    public void printClassesForStudentInSlot(String student, int timeSlot)
    {
        registration.stream()
            .filter(record -> student.equals(record.getStudent()) && timeSlot==record.getTimeSlot())
            .forEach(record -> System.out.printf("\nCourse Number: %s Section: %s",record.getCourseNumber(),record.getSection()));

    }
    /**
     * Method that prints the course number and section of the classes registered by the student given as parameter and the specific time slot. 
     */
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
    /**
     * Method that return the number of students that are registered in a course with the number and time slot given as parameters
     */
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
    /**
     * Method that return the number of students taking classes in timeSlot given as parameter.
     */
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
    /**
     * Method that drops a course registered by the student given as parameter with the specific class number. This method removes the object from the registration arraylist.
     */
    public void dropClassForStudent(String classNumber, String student)
    {
        registration.stream()
            .filter(record -> student.equals(record.getStudent()) && classNumber.equals(record.getCourseNumber()))
            .forEach(record -> registration.remove(record));
        // drops class classNumber for student
    }
    /**
     * Method that drops all courses registered by the student given as parameter. This method removes all the objects from the registration arraylist.
     */
    public void dropAllClassesForStudent(String student)
    {
        // drops all classes for student
        ArrayList<Registration> newList = new ArrayList<>();
        registration.stream()
            .filter(record -> student.equals(record.getStudent()))
            .forEach(record -> newList.add(record));
        registration.removeAll(newList);
    }
    /**
     * Method creates 30 arbitrary registration records
     */
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
