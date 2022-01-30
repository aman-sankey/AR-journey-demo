package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.demo.request.EmployeeRequest;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "emp_table")
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long empId;

//    @JsonProperty("emp_name")  //Alternative name column
    @Column(name = "emp_name")
    @NotBlank
    private String empName;

    @Column(name = "email")
    @Email
    private String email;

//    @JsonIgnore // will ignore this prop
    @Column(name = "ege")
    private Long age=0L;

    @Column(name = "department")
    @NotBlank
    private String department;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false,updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updatedAt;

    public Employee(EmployeeRequest employeeRequest){
        this.empName = employeeRequest.getEmpName();
        this.email = employeeRequest.getEmail();
        this.age = employeeRequest.getAge();
        this.department = employeeRequest.getDepartment();
    }
}

