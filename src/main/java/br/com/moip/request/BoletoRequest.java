package br.com.moip.request;

public class BoletoRequest {

    private ApiDateRequest expirationDate;
    private InstructionLinesRequest instructionLines;
    private String logoUri;

    public ApiDateRequest getExpirationDate() {
        return expirationDate;
    }

    public InstructionLinesRequest getInstructionLines() {
        return instructionLines;
    }

    public String getLogoUri() {
        return logoUri;
    }

    public BoletoRequest expirationDate(final ApiDateRequest expirationDate) {
        this.expirationDate = expirationDate;

        return this;
    }

    public BoletoRequest instructionLines(final InstructionLinesRequest instructionLines) {
        this.instructionLines = instructionLines;

        return this;
    }

    public BoletoRequest logoUri(final String logoUri) {
        this.logoUri = logoUri;

        return this;
    }
}
