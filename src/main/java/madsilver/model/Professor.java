package madsilver.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Professor extends Person {


    ProfessorType professorType;

    @OneToMany(mappedBy = "professor",cascade = CascadeType.REMOVE)
    private List<Lesson> lessonList=new ArrayList<>();


    public Professor(ProfessorType professorType, List<Lesson> lessonList) {
        this.professorType = professorType;
        this.lessonList = lessonList;
    }

    public Professor(Long aLong, String personalCode, String password, String nationalCode, String firstName, String lastName, ProfessorType professorType, List<Lesson> lessonList) {
        super(aLong, personalCode, password, nationalCode, firstName, lastName);
        this.professorType = professorType;
        this.lessonList = lessonList;
    }
    public Professor(Long aLong, String personalCode, String password, String nationalCode, String firstName, String lastName, ProfessorType professorType) {
        super(aLong, personalCode, password, nationalCode, firstName, lastName);
        this.professorType = professorType;

    }

    public Professor(String personalCode, String password, String nationalCode, String firstName, String lastName, ProfessorType professorType, List<Lesson> lessonList) {
        super(personalCode, password, nationalCode, firstName, lastName);
        this.professorType = professorType;
        this.lessonList = lessonList;
    }
    public Professor(String personalCode, String password, String nationalCode, String firstName, String lastName, ProfessorType professorType) {
        super(personalCode, password, nationalCode, firstName, lastName);
        this.professorType = professorType;

    }
}
