package madsilver.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import madsilver.base.entity.BaseEntity;
import madsilver.util.ValidationCode;

//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;


@ToString(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Person extends BaseEntity<Long> {
    @Column(nullable = false,unique = true)
    @Size(max = 8, min = 8, message = "Invalid personal code. Size should be 8.")
    @NotNull(message = "Please enter personal code.")

    String personalCode;

    @Size(max = 20, min = 3, message = "Invalid name. Size should be between 3 to 20.")
    @NotNull(message = "Please enter password.")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$",message = "please enter valid password")
    String password;
//    @Column(nullable = false,unique = true)
//    @Pattern()
    @NotNull(message = "Please enter valid national code .")
    @ValidationCode
    String nationalCode;
//
    @Size(max = 20, min = 3, message = "Invalid name. Size should be between 3 to 20.")
    @NotNull(message = "Please enter your name.")
//    @Pattern(regexp = "[A-Za-z]")
    String firstName;

//  @Pattern(regexp = "[A-Za-z]")

    @Column(nullable = false)
    String lastName;

    public Person(Long aLong, String personalCode, String password, String nationalCode, String firstName, String lastName) {
        super(aLong);
        this.personalCode = personalCode;
        this.password = password;
        this.nationalCode = nationalCode;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String personalCode, String password, String nationalCode, String firstName, String lastName) {
        this.personalCode = personalCode;
        this.password = password;
        this.nationalCode = nationalCode;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}



