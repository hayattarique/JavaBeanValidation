package com.jbva.beans;

import com.jbva.annotation.PhoneNumber;
import com.jbva.annotation.Severity;
import com.jbva.group.DemographicGroup;
import com.jbva.group.LoanInfoGroup;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @NotBlank(message = "first name cannot be blanked",payload = {Severity.CRITICAL.class},
            groups = {DemographicGroup.class})
    private String firstName;
    @NotBlank(message = "last name cannot be blanked",payload = {Severity.CRITICAL.class},groups = {DemographicGroup.class})
    private String lastName;
   @NotNull(message = "dob  cannot be blank",payload = {Severity.CRITICAL.class},groups = {DemographicGroup.class})
   @Past(message = "dob should be past",payload = {Severity.CRITICAL.class},groups={DemographicGroup.class})
    private LocalDate dob;
    @Pattern(regexp = "Male|Female"
            ,message = "Gender can be either Male or Female",payload = {Severity.CRITICAL.class},groups = {DemographicGroup.class})
    private String gender;
    @PhoneNumber(message = "number should be in 10 digit only",payload = {Severity.CRITICAL.class},groups = {DemographicGroup.class})
    private String mobileNo;
    @Email(message = "email is not valid",payload = {Severity.CRITICAL.class},groups = {DemographicGroup.class})
    private String emailAddress;
    @NotBlank(message = "cannot be blank ",payload = {Severity.CRITICAL.class},groups = {LoanInfoGroup.class})
    private String loanType;
    @Min(value = 20000,message = "loanAmount Should be at least 20000",payload = Severity.CRITICAL.class,groups = LoanInfoGroup.class)
    private double loanAmount;
    @Range(min = 12,max=36,message = "tenure should be in between 12 to 36 months",payload = Severity.CRITICAL.class,groups =
            LoanInfoGroup.class)
    private int tenure;

}
