package com.smburgoo.api.validation.upgrade.models;

public class BorrowerApiCreateRequest {
    private String loanAppUuid;
    private Boolean skipSideEffects;

    public BorrowerApiCreateRequest() {
    }

    public String getLoanAppUuid() {
        return loanAppUuid;
    }

    public void setLoanAppUuid(String loanAppUuid) {
        this.loanAppUuid = loanAppUuid;
    }

    public Boolean getSkipSideEffects() {
        return skipSideEffects;
    }

    public void setSkipSideEffects(Boolean skipSideEffects) {
        this.skipSideEffects = skipSideEffects;
    }
}
