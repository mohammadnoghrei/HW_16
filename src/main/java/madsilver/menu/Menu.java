package madsilver.menu;

import madsilver.SecurityContext;
import madsilver.model.Clerk;
import madsilver.model.Person;
import madsilver.model.Professor;
import madsilver.model.Student;
import madsilver.util.ApplicationContext;

import java.util.Scanner;

public class Menu {

    private Scanner scanner=new Scanner(System.in);
    StudentMenu studentMenu=new StudentMenu();
    ProfessorMenu professorMenu= new ProfessorMenu();
    ClerkMenu clerkMenu=new ClerkMenu();

    public void baseMenu(){
        System.out.println("***********  WELCOME TO OUR UNIVERSITY **********");
        System.out.println();
        System.out.println("please enter your personal code:");
        String personalCode=scanner.next();

        System.out.println("please enter your password:");
        String password= scanner.next();

        Person person=null;
        try {
            person= ApplicationContext.getPersonService().findByPersonalCode(personalCode);

        }catch (Exception e){

        }

        if (person==null){
            System.out.println("please enter valid userName or password");}
        else if (!person.getPassword().equals(password)) {
            System.out.println("please enter valid userName or passWord");
        } else if (Student.class == person.getClass()) {
           Student student= (Student) person;
           SecurityContext.id=student.getId();
           SecurityContext.firstName=student.getFirstName();
           SecurityContext.lastName=student.getLastName();
           SecurityContext.nationalCode=student.getNationalCode();
           SecurityContext.personalCode=student.getPersonalCode();
           SecurityContext.password=student.getPassword();
           SecurityContext.major=student.getMajor();
           studentMenu.studentBaseMenu();
        }
        else if (Professor.class == person.getClass()) {
            Professor professor= (Professor) person;
            SecurityContext.id=professor.getId();
            SecurityContext.firstName=professor.getFirstName();
            SecurityContext.lastName=professor.getLastName();
            SecurityContext.nationalCode=professor.getNationalCode();
            SecurityContext.personalCode=professor.getPersonalCode();
            SecurityContext.password=professor.getPassword();
            SecurityContext.professorType=professor.getProfessorType();
            professorMenu.ProfessorBaseMenu();
        }
        else if (Clerk.class == person.getClass()) {
            Clerk clerk= (Clerk) person;
            SecurityContext.id=clerk.getId();
            SecurityContext.firstName=clerk.getFirstName();
            SecurityContext.lastName=clerk.getLastName();
            SecurityContext.nationalCode=clerk.getNationalCode();
            SecurityContext.personalCode=clerk.getPersonalCode();
            SecurityContext.password=clerk.getPassword();
            SecurityContext.description=clerk.getDescription();
            clerkMenu.clerkBaseMenu();
        }
    }
}
