package com.smburgoo.api.validation.upgrade.models;

import java.util.Objects;

public class LoanAppResumptionInfo {

    private String loanAppId;
    private String loanAppUuid;
    private String referrer;
    private String productType;

    private String status;
    private String sourceSystem;
    private String desiredAmount;
    private LoanAppBorrowerResumptionInfo borrowerResumptionInfo;

    private LoanAppCoBorrowerResumptionInfo coBorrowerResumptionInfo;

    private Boolean turnDown;
    private Boolean hasLogin;
    private Boolean availableAppImprovements;

    private Double cashOutAmount;
    private Boolean canAddCollateral;
    private String rewardProgramCode;
    private String rewardProgramId;
    private String addon;
    private String isMobileDiscountApplied;
    private Boolean checkingDiscountAvailable;

    private Boolean plDepositBundleEligible;

    private String welcomeBonusCode;

    public Boolean getPlDepositBundleEligible() {
        return plDepositBundleEligible;
    }

    public void setPlDepositBundleEligible(Boolean plDepositBundleEligible) {
        this.plDepositBundleEligible = plDepositBundleEligible;
    }

    public LoanAppResumptionInfo() {
    }

    public String getWelcomeBonusCode() {
        return welcomeBonusCode;
    }

    public void setWelcomeBonusCode(String welcomeBonusCode) {
        this.welcomeBonusCode = welcomeBonusCode;
    }

    @Override
    public String toString() {
        return "LoanAppResumptionInfo{" +
                "loanAppId='" + loanAppId + '\'' +
                ", loanAppUuid='" + loanAppUuid + '\'' +
                ", referrer='" + referrer + '\'' +
                ", productType='" + productType + '\'' +
                ", status='" + status + '\'' +
                ", sourceSystem='" + sourceSystem + '\'' +
                ", desiredAmount='" + desiredAmount + '\'' +
                ", borrowerResumptionInfo=" + borrowerResumptionInfo +
                ", coBorrowerResumptionInfo=" + coBorrowerResumptionInfo +
                ", turnDown=" + turnDown +
                ", hasLogin=" + hasLogin +
                ", availableAppImprovements=" + availableAppImprovements +
                ", cashOutAmount=" + cashOutAmount +
                ", canAddCollateral=" + canAddCollateral +
                ", rewardProgramCode='" + rewardProgramCode + '\'' +
                ", rewardProgramId='" + rewardProgramId + '\'' +
                ", addon='" + addon + '\'' +
                ", isMobileDiscountApplied='" + isMobileDiscountApplied + '\'' +
                ", checkingDiscountAvailable=" + checkingDiscountAvailable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanAppResumptionInfo that = (LoanAppResumptionInfo) o;
        return Objects.equals(loanAppId, that.loanAppId) && Objects.equals(loanAppUuid, that.loanAppUuid) && Objects.equals(referrer, that.referrer) && Objects.equals(productType, that.productType) && Objects.equals(status, that.status) && Objects.equals(sourceSystem, that.sourceSystem) && Objects.equals(desiredAmount, that.desiredAmount) && Objects.equals(borrowerResumptionInfo, that.borrowerResumptionInfo) && Objects.equals(coBorrowerResumptionInfo, that.coBorrowerResumptionInfo) && Objects.equals(turnDown, that.turnDown) && Objects.equals(hasLogin, that.hasLogin) && Objects.equals(availableAppImprovements, that.availableAppImprovements) && Objects.equals(cashOutAmount, that.cashOutAmount) && Objects.equals(canAddCollateral, that.canAddCollateral) && Objects.equals(rewardProgramCode, that.rewardProgramCode) && Objects.equals(rewardProgramId, that.rewardProgramId) && Objects.equals(addon, that.addon) && Objects.equals(isMobileDiscountApplied, that.isMobileDiscountApplied) && Objects.equals(checkingDiscountAvailable, that.checkingDiscountAvailable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanAppId, loanAppUuid, referrer, productType, status, sourceSystem, desiredAmount, borrowerResumptionInfo, coBorrowerResumptionInfo, turnDown, hasLogin, availableAppImprovements, cashOutAmount, canAddCollateral, rewardProgramCode, rewardProgramId, addon, isMobileDiscountApplied, checkingDiscountAvailable);
    }

    public String getIsMobileDiscountApplied() {
        return isMobileDiscountApplied;
    }

    public void setIsMobileDiscountApplied(String isMobileDiscountApplied) {
        this.isMobileDiscountApplied = isMobileDiscountApplied;
    }

    public String getRewardProgramId() {
        return rewardProgramId;
    }

    public void setRewardProgramId(String rewardProgramId) {
        this.rewardProgramId = rewardProgramId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoanAppId() {
        return loanAppId;
    }

    public void setLoanAppId(String loanAppId) {
        this.loanAppId = loanAppId;
    }

    public String getLoanAppUuid() {
        return loanAppUuid;
    }

    public void setLoanAppUuid(String loanAppUuid) {
        this.loanAppUuid = loanAppUuid;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getDesiredAmount() {
        return desiredAmount;
    }

    public void setDesiredAmount(String desiredAmount) {
        this.desiredAmount = desiredAmount;
    }

    public LoanAppBorrowerResumptionInfo getBorrowerResumptionInfo() {
        return borrowerResumptionInfo;
    }

    public void setBorrowerResumptionInfo(LoanAppBorrowerResumptionInfo borrowerResumptionInfo) {
        this.borrowerResumptionInfo = borrowerResumptionInfo;
    }

    public LoanAppCoBorrowerResumptionInfo getCoBorrowerResumptionInfo() {
        return coBorrowerResumptionInfo;
    }

    public void setCoBorrowerResumptionInfo(LoanAppCoBorrowerResumptionInfo coBorrowerResumptionInfo) {
        this.coBorrowerResumptionInfo = coBorrowerResumptionInfo;
    }

    public Boolean getTurnDown() {
        return turnDown;
    }

    public void setTurnDown(Boolean turnDown) {
        this.turnDown = turnDown;
    }

    public Boolean getHasLogin() {
        return hasLogin;
    }

    public void setHasLogin(Boolean hasLogin) {
        this.hasLogin = hasLogin;
    }

    public Boolean getAvailableAppImprovements() {
        return availableAppImprovements;
    }

    public void setAvailableAppImprovements(Boolean availableAppImprovements) {
        this.availableAppImprovements = availableAppImprovements;
    }

    public Double getCashOutAmount() {
        return cashOutAmount;
    }

    public void setCashOutAmount(Double cashOutAmount) {
        this.cashOutAmount = cashOutAmount;
    }

    public Boolean getCanAddCollateral() {
        return canAddCollateral;
    }

    public void setCanAddCollateral(Boolean canAddCollateral) {
        this.canAddCollateral = canAddCollateral;
    }

    public String getRewardProgramCode() {
        return rewardProgramCode;
    }

    public void setRewardProgramCode(String rewardProgramCode) {
        this.rewardProgramCode = rewardProgramCode;
    }

    public String getAddon() {
        return addon;
    }

    public void setAddon(String addon) {
        this.addon = addon;
    }

    public Boolean getCheckingDiscountAvailable() {
        return checkingDiscountAvailable;
    }

    public void setCheckingDiscountAvailable(Boolean checkingDiscountAvailable) {
        this.checkingDiscountAvailable = checkingDiscountAvailable;
    }

}
