package madsilver.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import madsilver.base.entity.BaseEntity;
import org.hibernate.validator.constraints.Range;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
public class Lesson extends BaseEntity<Long> {

    private String lessonName;
    @Min(1)
    @Max(4)
    private int unit;

    private int term;
    @ManyToOne
    private Professor professor;
    @OneToMany(mappedBy = "lesson",cascade = CascadeType.REMOVE)
    private List<Information> informationList=new ArrayList<>();
    public Lesson(Long aLong, String lessonName, int unit, int term ,Professor professor){
        super(aLong);
        this.lessonName = lessonName;
        this.unit = unit;
        this.term = term;
        this.professor = professor;
    }

    public Lesson(String lessonName, int unit, int term, Professor professor) {
        this.lessonName = lessonName;
        this.unit = unit;
        this.term = term;
        this.professor = professor;
    }




    public Lesson(Long aLong, String lessonName, int unit) {
        super(aLong);
        this.lessonName = lessonName;
        this.unit = unit;
    }

    public Lesson(Long aLong, String lessonName, int unit, List<Information> informationList) {
        super(aLong);
        this.lessonName = lessonName;
        this.unit = unit;
        this.informationList = informationList;
    }

    public Lesson(String lessonName, int unit, List<Information> informationList) {
        this.lessonName = lessonName;
        this.unit = unit;
        this.informationList = informationList;
    }

    public Lesson(String lessonName, int unit) {
        this.lessonName = lessonName;
        this.unit = unit;

    }


    public Lesson(Long aLong, String lessonName, int unit, Professor professor, List<Information> informationList) {
        super(aLong);
        this.lessonName = lessonName;
        this.unit = unit;
        this.professor = professor;
        this.informationList = informationList;
    }
    public Lesson(Long aLong, String lessonName, int unit, Professor professor) {
        super(aLong);
        this.lessonName = lessonName;
        this.unit = unit;
        this.professor = professor;
    }
    public Lesson( String lessonName, int unit, Professor professor) {
        this.lessonName = lessonName;
        this.unit = unit;
        this.professor = professor;


}}
