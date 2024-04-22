package madsilver.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchProfileOverride;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
public class Student extends Person {

    String major;
    @OneToMany(mappedBy = "student",cascade = CascadeType.REMOVE)
    private List<Information> informationList=new ArrayList<>();


    public Student(String major, List<Information> informationList) {
        this.major = major;
        this.informationList = informationList;
    }

    public Student(Long aLong, String personalCode, String password, String nationalCode, String firstName, String lastName, String major, List<Information> informationList) {
        super(aLong, personalCode, password, nationalCode, firstName, lastName);
        this.major = major;
        this.informationList = informationList;
    }
    public Student(Long aLong, String personalCode, String password, String nationalCode, String firstName, String lastName, String major) {
        super(aLong, personalCode, password, nationalCode, firstName, lastName);
        this.major = major;

    }

    public Student(String personalCode, String password, String nationalCode, String firstName, String lastName, String major, List<Information> informationList) {
        super(personalCode, password, nationalCode, firstName, lastName);
        this.major = major;
        this.informationList = informationList;
    }
    public Student(String personalCode, String password, String nationalCode, String firstName, String lastName, String major) {
        super(personalCode, password, nationalCode, firstName, lastName);
        this.major = major;
    }
}
