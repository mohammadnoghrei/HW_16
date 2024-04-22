package madsilver;

import madsilver.connection.SessionFactorySingleton;
import madsilver.menu.ClerkMenu;
import madsilver.menu.Menu;
import madsilver.model.*;
import madsilver.util.ApplicationContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {


//////
////        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
////            Transaction transaction = session.beginTransaction();
//
//
//        //rate method for Professor
//
//
////todo ابتدا چک میکند ان درس با همان آیدی دانشجو و نمره ی صفر وجود دارد؟
//        //todo بعد چک میکند ایا ان درس را همان استاد دارد یا نه
//
////        Student student=new Student();
////        student.setId(8l);
////
////        Lesson lesson =new Lesson();
////        lesson.setId(1l);
////ApplicationContext.getInformationService().rated(6,2,20);
//
////        Query<Information> query = session.createQuery("FROM Information i WHERE i.student = :student AND i.lesson = :lesson AND i.rate =0 ", Information.class);
////        query.setParameter("student", student);
////        query.setParameter("lesson", lesson);
//////        List<Information> informationList=query.list();
////        Information information=query.uniqueResult();
////        transaction.commit();
////        if (information.getLesson().getProfessor().getId()==5){
////            information.setRate(15);
////            ApplicationContext.getInformationService().saveOrUpdate(information);}
//
////        System.out.println(informationList.size());
////        System.out.println(student.toString());
//
////
////Professor professor =ApplicationContext.getProfessorService().findById(5l);
////ApplicationContext.getProfessorService().delete(professor);
//
//
////        ApplicationContext.getInformationService().rated(8,1,18,5);
//
////todo check sum of professor unit  method
//
////        Professor professor =new Professor();
////        professor.setId(7l);
////
////        String sumHql = "SELECT SUM(unit) FROM Lesson WHERE professor=:p ";
////
////        Query sumQuery = session.createQuery(sumHql);
////        sumQuery.setParameter("p", professor);
////        long professorUnit = (long) sumQuery.list().get(0);
////        System.out.println(professorUnit);
////
////        System.out.println(ApplicationContext.getProfessorService().professorUnitsSum(7l));
////
////        // todo calculate salary of professor
////
////        long allSalary= 1000+(professorUnit*100);
////        System.out.println(allSalary);
//
//
//
//        // todo get rate avg
////        Student student1= new Student();
////        student1.setId(6l);
////        String sumHql = "SELECT avg (rate) FROM Information WHERE student=:s AND rate!=0 ";
////        Query avgQuery = session.createQuery(sumHql);
////        avgQuery.setParameter("s", student1);
////        double studentRateAVG = (double) avgQuery.list().get(0);
////        System.out.println(studentRateAVG);
//
////        System.out.println(ApplicationContext.getStudentService().averageRate(6l));
//
////        System.out.println(1111111111111111111l);
////        ClerkMenu clerkMenu=new ClerkMenu();
//////        clerkMenu.getInt();
////        clerkMenu.clerkBaseMenu();
//
// //todo find by try catch
//
////   Person person=null;
////        try {
////       person=ApplicationContext.getStudentService().findById(6l);
////   }catch (Exception e){
////        System.out.println(e.getMessage());
////    }
////        if (person==null)
////            System.out.println("nullllllll");
////        else if (Student.class == person.getClass()) {
////            System.out.println("studenttttttt");
////        }
//

        Menu menu =new Menu();
        menu.baseMenu();

//ApplicationContext.getLessonService().findAll().stream().forEach((a)-> System.out.println(a.getLessonName()));
//        Clerk clerk =new Clerk("11111118","sSD25@5l","252256561","ali","alavi","amoozesh");
//        if (ApplicationContext.getClerkService().validate(clerk))
//            ApplicationContext.getClerkService().saveOrUpdate(clerk);
//        else System.out.println("tot v");
//        ApplicationContext.getClerkService().saveOrUpdate(clerk);
//        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//        Validator validator = validatorFactory.getValidator();
//

//        Student byId = ApplicationContext.getStudentService().findById(3l);
//        ApplicationContext.getStudentService().delete(byId);
//    Student student=new Student("25555565","ddff","554154545","d","1","m");
//    ApplicationContext.getStudentService().saveOrUpdate(student);
//   ApplicationContext.getInformationService().findStudentLesson(2l);
//        Lesson lesson=ApplicationContext.getLessonService().findById(2l);
//        Student student=ApplicationContext.getStudentService().findById(12l);
//        Information information =new Information(student,lesson);
//        Lesson lesson = ApplicationContext.getLessonService().findById(2l);
//
//        List<Lesson> studentLesson = ApplicationContext.getInformationService().findStudentLesson(2l);
//
//        for (Lesson l: studentLesson) {
//            System.out.println(l.getLessonName());
//            if (l.getId()==lesson.getId())
//                System.out.println("is present");
//        }

//        System.out.println(ApplicationContext.getLessonService().findById(2l));
    }


    }

