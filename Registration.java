
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
        if (verifyCourseNumber(courseNum)) {

            courseNumber = courseNum;
        } else {
            throw new IllegalArgumentException(
                    "Course Number must be either of the following: COMP 1501, ENGL 2201, CHEM 3060, PHYS 2344, ENGL 2005, COMP 2704, PHYS 2377, CHEM 4927 and COMP 3444");
        }
        if (verifySection(courseSection)) {
            section = courseSection;
        } else {
            throw new IllegalArgumentException("Section must be between 0 and 2");
        }
        if (verifySlot(slot)) {
            timeSlot = slot;
        } else {
            throw new IllegalArgumentException("Slot must be between 12 and 25");
        }
        student = courseStudent;
        professor = courseProfessor;
    }

    /*
        Method verifies courseNumber string is in list of allowed values
    */
    private boolean verifyCourseNumber(String courseNumber)
    {
        ArrayList<String> CRN_List = new ArrayList<String>();

        CRN_List.add("COMP 1501");
        CRN_List.add("ENGL 2201");
        CRN_List.add("CHEM 3060");
        CRN_List.add("PHYS 2344");
        CRN_List.add("ENGL 2005");
        CRN_List.add("COMP 2704");
        CRN_List.add("PHYS 2377");
        CRN_List.add("CHEM 4927");
        CRN_List.add("COMP 3444");

        return CRN_List.contains(courseNumber);
    }
    
    /*
        Method verifies section itn is in the range (0 <= x <= 2)
        returns true if in range and false if not
    */
    private boolean verifySection(int section)
    {
        return (section >= 0 && section <= 2);
    }

    /*
        Method verifies slot int is in the range (12 <= x <= 25)
        returns true if in range and false if not
    */
    private boolean verifySlot (int slot)
    {
        return (slot >= 12 && slot <= 25);
    }

    /*
        Accessor Methods that return courseNumber, section, timeSlot, student, and professor
    */
    public String getCourseNumber()
    {
        return this.courseNumber;
    }
    
    public int getSection()
    {
        return this.section;
    }
    public int getTimeSlot()
    {
        return this.timeSlot;
    }

    public String getStudent()
    {
        return this.student;
    }

    public String getProfessor()
    {
        return this.professor;
    }
    
    /*
        Method prints all information about Registration object.
    */
    public void printInfo()
    {  
       System.out.printf("\n--------\nStudent: %s\nCourse Number: %s\nSection: %d\nTime Slot: %d\nProfessor: %s",getStudent(), getCourseNumber(), getSection(), getTimeSlot(), getProfessor());
    }
    
}
