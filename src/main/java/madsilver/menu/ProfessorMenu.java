package madsilver.menu;

import madsilver.SecurityContext;
import madsilver.model.ProfessorType;
import madsilver.service.InformationService;
import madsilver.service.PersonService;
import madsilver.service.ProfessorService;
import madsilver.service.StudentService;
import madsilver.util.ApplicationContext;

import java.util.Scanner;

public class ProfessorMenu {

    PersonService personService= ApplicationContext.getPersonService();
    StudentService studentService= ApplicationContext.getStudentService();
    InformationService informationService =ApplicationContext.getInformationService();
    ProfessorService professorService =ApplicationContext.getProfessorService();
    private Scanner scanner=new Scanner(System.in);
    public void ProfessorBaseMenu() {
        System.out.println("***********  welcome "+SecurityContext.firstName+" "+SecurityContext.lastName+" to Professor menu ******************");
        boolean end = true;
        while (end) {

            System.out.println("1-show profile \n2-rate to student \n3-pay check\n0-exit");
            int num = 5;
            try {
                num = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("your input is not valid!!!!!!!");
            }
            switch (num) {
                case 1 -> {
                    System.out.println(
                            "  name: "+SecurityContext.firstName+
                            "  lastName: "+SecurityContext.lastName+
                            "  personalCode: "+SecurityContext.personalCode+
                            "  national code: "+SecurityContext.nationalCode+
                            "  professor type: "+SecurityContext.professorType
                            );
                }
                case 2 -> {
                    try {
                        studentRate();
                    }catch (Exception e){
                        System.out.println("please enter valid inputs.\n" +
                                "you have not this lesson or student\n" +
                                "or the student has not this lesson");
                    }
                }
                case 3 -> {
                    if (SecurityContext.professorType.equals(ProfessorType.CONVENTIONAL)){
                        System.out.println("Please enter num of term for calculate pay check");
                        int term=0;
                        try {
                            term=scanner.nextInt();
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                            end=false;}
                        long count = 0;
                        try {
                            count = professorService.professorUnitsSum(SecurityContext.id, term);
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        System.out.println("your pay check is :"+1000000*count);
                    } else if (SecurityContext.professorType.equals(ProfessorType.FACULTY)) {
                        System.out.println("Please enter num of term for calculate pay check");
                        int term=0;
                        try {
                            term=scanner.nextInt();
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                            end=false;}
                        long count = 0;
                        try {
                            count = professorService.professorUnitsSum(SecurityContext.id, term);
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        System.out.println("your pay check is :"+5000000+(1000000*count));
                    }

                    }


                case 0 -> end = false;
                default -> System.out.println("please enter valid number");
            }
        }
    }


    public void studentRate(){
        System.out.println("please enter student personal code for rate");
        String student =scanner.next();
        long studentId=personService.findByPersonalCode(student).getId();
        System.out.println("please enter lesson id for rate");
        Long lesson =scanner.nextLong();
        System.out.println("please enter rate");
        double rate =scanner.nextInt();
        informationService.rated(studentId,lesson,rate,SecurityContext.id);
    }


}
