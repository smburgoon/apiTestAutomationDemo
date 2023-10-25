package com.smburgoo.api.validation.upgrade.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BorrowerApiResponse {

    private LoanAppResumptionInfo loanAppResumptionInfo;
    private List<String> offers = new ArrayList<>();
    private String selectedOffer;
    private List<String> requiredAgreements = new ArrayList<>();
    private List<String> resetOptions = new ArrayList<>();
    private String originalLoanApp;

    public BorrowerApiResponse() {
    }

    public LoanAppResumptionInfo getLoanAppResumptionInfo() {
        return loanAppResumptionInfo;
    }

    public void setLoanAppResumptionInfo(LoanAppResumptionInfo loanAppResumptionInfo) {
        this.loanAppResumptionInfo = loanAppResumptionInfo;
    }

    public List<String> getOffers() {
        return offers;
    }

    public void setOffers(List<String> offers) {
        this.offers = offers;
    }

    public String getSelectedOffer() {
        return selectedOffer;
    }

    public void setSelectedOffer(String selectedOffer) {
        this.selectedOffer = selectedOffer;
    }

    public List<String> getRequiredAgreements() {
        return requiredAgreements;
    }

    public void setRequiredAgreements(List<String> requiredAgreements) {
        this.requiredAgreements = requiredAgreements;
    }

    public List<String> getResetOptions() {
        return resetOptions;
    }

    public void setResetOptions(List<String> resetOptions) {
        this.resetOptions = resetOptions;
    }

    public String getOriginalLoanApp() {
        return originalLoanApp;
    }

    public void setOriginalLoanApp(String originalLoanApp) {
        this.originalLoanApp = originalLoanApp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowerApiResponse that = (BorrowerApiResponse) o;
        return Objects.equals(loanAppResumptionInfo, that.loanAppResumptionInfo) && Objects.equals(offers, that.offers) && Objects.equals(selectedOffer, that.selectedOffer) && Objects.equals(requiredAgreements, that.requiredAgreements) && Objects.equals(resetOptions, that.resetOptions) && Objects.equals(originalLoanApp, that.originalLoanApp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanAppResumptionInfo, offers, selectedOffer, requiredAgreements, resetOptions, originalLoanApp);
    }

    @Override
    public String toString() {
        return "BorrowerApiResponse{" +
                "loanAppResumptionInfo=" + loanAppResumptionInfo +
                ", offers=" + offers +
                ", selectedOffer='" + selectedOffer + '\'' +
                ", requiredAgreements=" + requiredAgreements +
                ", resetOptions=" + resetOptions +
                ", originalLoanApp='" + originalLoanApp + '\'' +
                '}';
    }
}
