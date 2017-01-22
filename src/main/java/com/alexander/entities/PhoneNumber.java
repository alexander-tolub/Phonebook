package com.alexander.entities;

import com.alexander.util.PhoneType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by alex on 07.01.2017.
 */
@Entity
@Table(name = "PhoneNumber")
public class PhoneNumber {

    private Long phoneId;
    private PhoneType phoneType;
    @NotBlank(message = "{phoneNumber.error.notBlank}")
    @Length(max = 30, message = "{phoneNumber.error.length}")
    private String comment;
    @NotBlank(message = "{phoneNumber.error.notBlank}")
    @Length(max = 30, message = "{phoneNumber.error.length}")
    @Pattern(regexp = "[0-9]+", message = "{phoneNumber.error.phoneNumber}")
    private String phoneNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    @Column(name = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Enumerated(EnumType.STRING)
    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "phoneId=" + phoneId +
                ", phoneType=" + phoneType +
                ", comment='" + comment + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}