package madsilver.util;

import madsilver.connection.SessionFactorySingleton;
import madsilver.repository.*;
import madsilver.service.*;
import org.hibernate.SessionFactory;

public class ApplicationContext {
    static final SessionFactory SESSION_FACTORY;

    private static final PersonRepository PERSON_REPOSITORY;
    private static final PersonService PERSON_SERVICE;
    private static final ClerkRepository CLERK_REPOSITORY;
    private static final ClerkService CLERK_SERVICE;
    private static final LessonRepository LESSON_REPOSITORY;
    private static final LessonService LESSON_SERVICE;
    private static final ProfessorRepository PROFESSOR_REPOSITORY;
    private static final ProfessorService PROFESSOR_SERVICE;
    private static final StudentRepository STUDENT_REPOSITORY;
    private static final StudentService STUDENT_SERVICE;
    private static final InformationRepository INFORMATION_REPOSITORY;
    private static final InformationService INFORMATION_SERVICE;

    static {
        SESSION_FACTORY = SessionFactorySingleton.getInstance();

        PERSON_REPOSITORY =new PersonRepositoryImpl(SESSION_FACTORY);
        CLERK_REPOSITORY = new ClerkRepositoryImpl(SESSION_FACTORY);
        LESSON_REPOSITORY =new LessonRepositoryImpl(SESSION_FACTORY);
        PROFESSOR_REPOSITORY=new ProfessorRepositoryImpl(SESSION_FACTORY);
        STUDENT_REPOSITORY = new StudentRepositoryImpl(SESSION_FACTORY);
        INFORMATION_REPOSITORY=new InformationRepositoryImpl(SESSION_FACTORY);

        PERSON_SERVICE =new PersonServiceImpl(PERSON_REPOSITORY,SESSION_FACTORY);
        CLERK_SERVICE = new ClerkServiceImpl(CLERK_REPOSITORY, SESSION_FACTORY);
        LESSON_SERVICE = new LessonServiceImpl(LESSON_REPOSITORY,SESSION_FACTORY);
        PROFESSOR_SERVICE = new ProfessorServiceImpl(PROFESSOR_REPOSITORY,SESSION_FACTORY);
        STUDENT_SERVICE = new StudentServiceImpl(STUDENT_REPOSITORY,SESSION_FACTORY);
        INFORMATION_SERVICE =new InformationServiceImpl(INFORMATION_REPOSITORY,SESSION_FACTORY);
    }

    public static PersonService getPersonService(){return PERSON_SERVICE;}
    public static ClerkService getClerkService() {
        return CLERK_SERVICE;
    }
    public static LessonService getLessonService(){return LESSON_SERVICE;}
    public static ProfessorService getProfessorService(){return PROFESSOR_SERVICE;}
    public static StudentService getStudentService(){return STUDENT_SERVICE;}
    public static InformationService getInformationService(){return INFORMATION_SERVICE;}
}
