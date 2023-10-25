package com.smburgoo.api.validation.upgrade.models;

import java.util.Objects;

public class LoanAppBorrowerResumptionInfo {
    private String firstName;
    private String maskedEmail;
    private String userUuid;
    private Boolean ssnRequired;
    private String state;
    private String email;

    public LoanAppBorrowerResumptionInfo() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMaskedEmail(String maskedEmail) {
        this.maskedEmail = maskedEmail;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public void setSsnRequired(Boolean ssnRequired) {
        this.ssnRequired = ssnRequired;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMaskedEmail() {
        return maskedEmail;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public Boolean getSsnRequired() {
        return ssnRequired;
    }

    public String getState() {
        return state;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanAppBorrowerResumptionInfo that = (LoanAppBorrowerResumptionInfo) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(maskedEmail, that.maskedEmail) && Objects.equals(userUuid, that.userUuid) && Objects.equals(ssnRequired, that.ssnRequired) && Objects.equals(state, that.state) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, maskedEmail, userUuid, ssnRequired, state, email);
    }

    @Override
    public String toString() {
        return "LoanAppBorrowerResumptionInfo{" +
                "firstName='" + firstName + '\'' +
                ", maskedEmail='" + maskedEmail + '\'' +
                ", userUuid='" + userUuid + '\'' +
                ", ssnRequired=" + ssnRequired +
                ", state='" + state + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
