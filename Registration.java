
/**
 * Registration class saves the information about each registration, including the course number, section, time slot, student and professor.
 *
 * @author (Tannia Chevez)
 * @version (Oct 12,2021)
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Registration
{
    private String courseNumber;
    private int section;
    private int timeSlot;
    private String student;
    private String professor;

    /**
     * Constructor for objects of class Registration
     */
    public Registration(String courseNum, int courseSection, int slot, 
                      String courseStudent,String courseProfessor)
    {
        if (verifyCourseNumber(courseNum)){
    
            courseNumber = courseNum;
        }
        else{ 
            throw new IllegalArgumentException("Course Number must be either of the following: COMP 1501, ENGL 2201, CHEM 3060, PHYS 2344, ENGL 2005, COMP 2704, PHYS 2377, CHEM 4927 and COMP 3444");
        }
        if (verifySection(courseSection)){
            section = courseSection;
        }
        else{ 
            throw new IllegalArgumentException("Section must be between 0 and 2");
        }
        if (verifySlot (slot)){
            timeSlot = slot;
        }
        else{
            throw new IllegalArgumentException("Slot must be between 12 and 25");
        }
        student = courseStudent;
        professor = courseProfessor;
    }
    /**
     * Method that verifies if the course number is in the list of acceptable numbers.
     */
    private boolean verifyCourseNumber(String courseNumber)
    {
        String[] number ={"COMP 1501", "ENGL 2201", "CHEM 3060", "PHYS 2344", "ENGL 2005", "COMP 2704", "PHYS 2377", "CHEM 4927","COMP 3444"};
        boolean contains = Arrays.stream(number).anyMatch(courseNumber::equals);
        if(!contains){
            return false;
        }
        
        return true;
        
    }
    /**
     * Method that verifies if the section is within the range of 0 to 2.
     */
    private boolean verifySection(int section)
    {
        if (section < 0 || section > 2){
            return false;  
        }
        return true;
    }
    /**
     * Method that verifies if the time slot is within the range of 12 to 25.
     */
    private boolean verifySlot (int slot)
    {
        if (slot < 12 || slot > 25){
            return false;  
        }
        return true;
    }
    /**
     * Assesor methods for variables courseNumber, section, timeSlot, student and professor.
     */
    public String getCourseNumber(){
        return this.courseNumber;
    }
    public int getSection(){
        return this.section;
    }
    public int getTimeSlot(){
        return this.timeSlot;
    }
    public String getStudent(){
        return this.student;
    }
    public String getProfessor(){
        return this.professor;
    }
    /**
     * Method that prints the information about the object.
     */
   public void printInfo()
   {
       System.out.printf("\n--------\nCourse Number: %s\nSection: %d\nTime Slot: %d\nProfessor: %s\nStudent: %s",getCourseNumber(),getSection(),getTimeSlot(),getProfessor(),getStudent());
   }
    
}
