package madsilver.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
public class Clerk extends Person{
    String description;

    public Clerk(String description) {
        this.description = description;
    }

    public Clerk(Long aLong, String personalCode, String password, String nationalCode, String firstName, String lastName, String description) {
        super(aLong, personalCode, password, nationalCode, firstName, lastName);
        this.description = description;
    }

    public Clerk(String personalCode, String password, String nationalCode, String firstName, String lastName, String description) {
        super(personalCode, password, nationalCode, firstName, lastName);
        this.description = description;
    }
}
