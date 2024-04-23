package madsilver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import madsilver.base.entity.BaseEntity;
@Getter
@Setter
@Entity
@ToString(callSuper = true)
@NoArgsConstructor
public class Information extends BaseEntity<Long> {

//    @Min(1)
//    @Max(20)
    private double rate;


    @ManyToOne
    private Student student;
    @ManyToOne
    private Lesson lesson;

    public Information(Long aLong,  Student student, Lesson lesson) {
        super(aLong);

        this.student = student;
        this.lesson = lesson;
    }

    public Information(  Student student, Lesson lesson) {
        this.student = student;
        this.lesson = lesson;
    }
}
