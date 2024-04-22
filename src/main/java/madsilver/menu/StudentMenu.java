package madsilver.menu;

import madsilver.SecurityContext;
import madsilver.model.Information;
import madsilver.model.Lesson;
import madsilver.model.Student;
import madsilver.service.*;
import madsilver.util.ApplicationContext;

import java.util.List;
import java.util.Scanner;

public class StudentMenu {
    StudentService studentService= ApplicationContext.getStudentService();
    ProfessorService professorService = ApplicationContext.getProfessorService();
    LessonService lessonService=ApplicationContext.getLessonService();
    PersonService personService =ApplicationContext.getPersonService();
    InformationService informationService=ApplicationContext.getInformationService();
    private Scanner scanner=new Scanner(System.in);
    public void studentBaseMenu() {
        System.out.println("***********  welcome "+ SecurityContext.firstName+" "+SecurityContext.lastName+" to Student menu ******************");
        boolean end = true;
        while (end) {

            System.out.println("1-show profile \n2-show all lesson \n3-select lesson\n4-show all your lesson\n0-exit");
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
                                    "  major: "+SecurityContext.major
                    );
                }
                case 2 -> {
                    lessonService.findAll().stream().forEach((a)-> System.out.println(a.getId()+" "+a.getLessonName()));
                }
                case 3 -> {
                    selectLesson();
                }
                case 4->{informationService.findStudentLesson(SecurityContext.id).stream().forEach((a)-> System.out.println(a.getLessonName()));}

                case 0 -> end = false;
                default -> System.out.println("please enter valid number");
            }
        }
    }
    public void studentProfile(){}

    public void showAllLesson(){

    }
    public void selectLesson(){

        lessonService.findAll().stream().forEach((a)-> System.out.println("id: "+a.getId()+" "+a.getLessonName()));
        System.out.println("please enter id of lesson for select");
        long lesson_id=scanner.nextLong();
        Lesson lesson=null;
        try {
            lesson=lessonService.findById(lesson_id);
        }catch (Exception e){
            System.out.println("this lesson dosnt exist");
        }
        double avg=studentService.averageRate(SecurityContext.id);
        int units=0;
        for (Lesson a : informationService.findStudentNewLesson(SecurityContext.id)) {;
            units+=a.getUnit();
        }
        if (lesson!=null&avg>=18 & units<24){
            if (lesson.getUnit()+units<=24 & !checkHaveLesson(lesson)){
                Information information=new Information(studentService.findById(SecurityContext.id),lesson);
                informationService.saveOrUpdate(information);
            }else System.out.println("your lesson unit more than limit of units");

        } else if (avg<18 & units<20) {
            if (lesson.getUnit()+units<=20 & !checkHaveLesson(lesson)){
            Information information=new Information(studentService.findById(SecurityContext.id),lesson);
            informationService.saveOrUpdate(information);
        }else System.out.println("your lesson unit more than limit of units or maybe you have this lesson");

        }else System.out.println("your lesson unit more than limit of units or your lesson not exist");


    }

    public boolean checkHaveLesson(Lesson lesson){
        boolean b=false;
        List<Lesson> studentLesson = ApplicationContext.getInformationService().findStudentLesson(SecurityContext.id);
        for (Lesson l: studentLesson) {
            if (l.getId()==lesson.getId())
                b=true;
            }
        return b;
    }
    public void showAllYourLesson(){}
}
