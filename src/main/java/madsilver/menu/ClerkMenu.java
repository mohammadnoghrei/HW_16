package madsilver.menu;

import madsilver.SecurityContext;
import madsilver.model.*;
import madsilver.service.*;
import madsilver.util.ApplicationContext;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClerkMenu {
    StudentService studentService = ApplicationContext.getStudentService();
    ProfessorService professorService = ApplicationContext.getProfessorService();
    ClerkService clerkService = ApplicationContext.getClerkService();
    PersonService personService=ApplicationContext.getPersonService();
    LessonService lessonService=ApplicationContext.getLessonService();
    Scanner scanner = new Scanner(System.in);


    public void clerkBaseMenu() {
        System.out.println("***********  welcome "+ SecurityContext.firstName+" "+SecurityContext.lastName+"  to clerk menu ******************");
        boolean end = true;
        while (end) {

            System.out.println("1-student edit \n2-professor edit \n3-clerk edit \n4-lesson edit\n5-pay check\n0-exit");
            int num = 5;
            try {
                num = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("your input is not valid!!!!!!!");
            }
            switch (num) {
                case 1 -> {
                    studentMethod();
                }
                case 2 -> {
                    professorMethod();
                }
                case 3 -> {
                    clerkMethod();
                }
                case 4->{lessonMethod();}
                case 5 -> {
                    System.out.println("name: "+SecurityContext.firstName+
                            "\nlast name: "+SecurityContext.lastName+
                            "\npersonal code: "+SecurityContext.personalCode+
                            "\npassword: "+SecurityContext.password+
                            "\nnational code: "+SecurityContext.nationalCode+
                            "\ndescription: "+SecurityContext.description +
                            "\nyour salary is $5,000,000");
                }
                case 0 -> end = false;
                default -> System.out.println("please enter valid number");
            }
        }
    }

    public void studentMethod() {
        boolean end = true;
        while (end) {
            System.out.println("please select one item");
            System.out.println("1-save student\n2-update student\n3-delete student\n0-back");
            int num = 0;
            try {
                num = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("your input is not valid!!!!!!!");
            }
            switch (num) {
                case 1 -> {
                    studentSaveMethod();
                }
                case 2 -> {
                    System.out.println("please enter student personal code for update");
                    String personalCode=scanner.next();
                    Person person = null;
                    try {
                        person = personService.findByPersonalCode(personalCode);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    if (person == null)
                        System.out.println("this student is not exist");
                    else if (Student.class == person.getClass()) {
                        studentSaveMethod();
                    }else System.out.println("this student is not exist");
                }
                case 3 -> {
                    System.out.println("please enter student personal code for delete");
                    String personalCode=scanner.next();
                    Person person = null;
                    try {
                        person = personService.findByPersonalCode(personalCode);
                    } catch (Exception e) {System.out.println(e.getMessage());}
                    if (person == null)
                        System.out.println("this student is not exist");
                    else if (Student.class == person.getClass()) {
                        studentService.delete(studentService.findById(person.getId()));
                    }else System.out.println("this student is not exist");
                }
                case 0 -> end = false;
                default -> System.out.println("please enter valid number");
            }
        }
    }

    public void professorMethod() {
        boolean end = true;
        while (end) {
            System.out.println("please select one item");
            System.out.println("1-save professor\n2-update professor\n3-delete professor\n0-back");
            int num = 0;
            try {
                num = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("your input is not valid!!!!!!!");
            }
            switch (num) {
                case 1 -> {professorSaveMethod();}
                case 2 -> {
                    System.out.println("please enter professor personal code for update");
                    String personalCode=scanner.next();
                    Person person = null;
                    try {
                        person = personService.findByPersonalCode(personalCode);
                    } catch (Exception e) {
                        System.out.println("this professor not exist");
                    }
                    if (person == null)
                        System.out.println("this professor is not exist");
                    else if (Professor.class == person.getClass()) {
                        professorSaveMethod();
                    }else System.out.println("this professor is not exist");
                }
                case 3 -> {
                    System.out.println("please enter professor personal code for delete");
                    String personalCode=scanner.next();
                    Person person = null;
                    try {
                        person = personService.findByPersonalCode(personalCode);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    if (person == null)
                        System.out.println("this person is not exist");
                    else if (Professor.class == person.getClass()) {
                        professorService.delete(professorService.findById(person.getId()));
                    }else System.out.println("this professor is not exist");
                }
                case 0 -> end = false;
                default -> System.out.println("please enter valid number");
            }
        }
    }

    public void clerkMethod() {
        boolean end = true;
        while (end) {
            System.out.println("please select one item");
            System.out.println("1-save clerk\n2-update clerk\n3-delete clerk\n0-back");
            int num = 0;
            try {
                num = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("your input is not valid!!!!!!!");
            }
            switch (num) {
                case 1 -> {clerkSaveMethod();}
                case 2 -> {
                    System.out.println("please enter clerk personal code for update");
                    String personalCode=scanner.next();
                    Person person = null;
                    try {
                        person = personService.findByPersonalCode(personalCode);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    if (person == null)
                        System.out.println("this clerk is not exist");
                    else if (Clerk.class == person.getClass()) {
                        clerkSaveMethod();
                    }else System.out.println("this clerk is not exist");
                }
                case 3 -> {
                    System.out.println("please enter clerk personal code for delete");
                    String personalCode=scanner.next();
                    Person person = null;
                    try {
                        person = personService.findByPersonalCode(personalCode);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    if (person == null)
                        System.out.println("this clerk is not exist");
                    else if (Clerk.class == person.getClass()) {
                        clerkService.delete(clerkService.findById(person.getId()));
//                        clerkService.delete((Clerk) person);
                    }else System.out.println("this clerk is not exist");

                }

                case 0 -> end = false;
                default -> System.out.println("please enter valid number");

            }
        }
    }
    public void lessonMethod(){
        boolean end = true;
        while (end) {
            System.out.println("please select one item");
            System.out.println("1-save lesson\n2-update lesson\n3-delete lesson\n0-back");
            int num = 0;
            try {
                num = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("your input is not valid!!!!!!!");
            }
            switch (num) {
                case 1 -> {lessonSaveMethod();}
                case 2 -> {
                    System.out.println("please enter lesson id for update");
                    int id=scanner.nextInt();
                    Lesson lesson=null;
                    try {
                        lesson= lessonService.findById((long) id);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    if (lesson==null)
                        System.out.println("this lesson is not exist");
                    else {
                    lessonSaveMethod();}
                }
                case 3 -> {
                    System.out.println("please enter lesson id for update");
                    int id = scanner.nextInt();
                    Lesson lesson = null;
                    try {
                        lesson = lessonService.findById((long) id);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    if (lesson == null)
                        System.out.println("this lesson is not exist");
                    else {
                        lessonService.delete(lesson);
                    }

                }

                case 0 -> end = false;
                default -> System.out.println("please enter valid number");

            }
        }
    }
    public void studentSaveMethod(){
        System.out.println("please enter first name");
        String firstName = scanner.next();
        System.out.println("please enter last name");
        String lastName = scanner.next();
        System.out.println("please enter national code");
        String nationalCode = scanner.next();
        System.out.println("please enter personal code");
        String personalCode = scanner.next();
        System.out.println("please enter password");
        String password = scanner.next();
        System.out.println("please enter major");
        String major = scanner.next();
        Student student = new Student(personalCode, password, nationalCode, firstName, lastName, major);
        if (studentService.validate(student)){
            studentService.saveOrUpdate(student);
            System.out.println(" save done ");}
        else System.out.println("please enter valid data");
    }
    public void professorSaveMethod(){
        System.out.println("please enter first name");
        String firstName = scanner.next();
        System.out.println("please enter last name");
        String lastName = scanner.next();
        System.out.println("please enter national code");
        String nationalCode = scanner.next();
        System.out.println("please enter personal code");
        String personalCode = scanner.next();
        System.out.println("please enter password");
        String password = scanner.next();
        System.out.println("please select one type : 1-CONVENTIONAL 2-FACULTY");
        String professorTypeSelect=scanner.next();
        ProfessorType professorType = null;
        if (professorTypeSelect.equals("1"))
            professorType=ProfessorType.CONVENTIONAL;
        else if (professorTypeSelect.equals("2")) {
            professorType=ProfessorType.FACULTY;
        }
        Professor professor = new Professor(personalCode, password, nationalCode, firstName, lastName,professorType);
        if (professorService.validate(professor))
            professorService.saveOrUpdate(professor);
        else System.out.println("please enter valid data");
    }
    public void clerkSaveMethod(){
        System.out.println("please enter first name");
        String firstName = scanner.next();
        System.out.println("please enter last name");
        String lastName = scanner.next();
        System.out.println("please enter national code");
        String nationalCode = scanner.next();
        System.out.println("please enter personal code");
        String personalCode = scanner.next();
        System.out.println("please enter password");
        String password = scanner.next();
        System.out.println("please enter description");
        String description=scanner.next();
        Clerk clerk = new Clerk(personalCode, password, nationalCode, firstName, lastName,description);
        if (clerkService.validate(clerk)){
            clerkService.saveOrUpdate(clerk);
            System.out.println(" save done ");}
        else System.out.println("please enter valid data");
    }
    public void lessonSaveMethod(){
        System.out.println("please enter lesson name");
        String name = scanner.next();
        System.out.println("please enter term num");
        int term=0;
        try {
            term = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("your input is not valid!!!!!!!");
        }if (term!=0){
            System.out.println("please enter count of unit");
            int unit = 0;
            try {
                unit = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("your input is not valid!!!!!!!");
            }
            if (unit!=0){
                System.out.println("please enter professor personal code");
                String personalCode=scanner.next();
                Person person = null;
                try {
                    person = personService.findByPersonalCode(personalCode);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                if (person == null)
                { System.out.println("this professor is not exist");}
                else if (Professor.class == person.getClass()) {
                    Lesson lesson=new Lesson(name,unit,term,(Professor) person);
                    if (lessonService.validate(lesson)){
                        lessonService.saveOrUpdate(lesson);
                        System.out.println("save done");}
                    else System.out.println("!!!!! invalid input");
                }else System.out.println("this professor code is not exist");
            }else System.out.println("please enter valid num of unit");
        }else System.out.println("please enter valid num of term");
    }

}
