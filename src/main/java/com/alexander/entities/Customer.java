package com.alexander.entities;

import javax.persistence.*;

/**
 * Created by alex on 07.01.2017.
 */

@Entity
@Table(name = "Customer")
public class Customer {

    private Long CustomerId;
    private String firstName;
    private String lastName;
    private String patronymic;
    private PhoneNumber phoneNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Long customerId) {
        CustomerId = customerId;
    }

    @OneToOne
    @JoinColumn(name = "PhoneId")
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String
    toString() {
        return "Customer{" +
                "CustomerId=" + CustomerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}