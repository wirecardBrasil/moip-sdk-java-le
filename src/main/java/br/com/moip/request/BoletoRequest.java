package br.com.moip.request;

import java.util.Date;

public class BoletoRequest {

    private ExpirationDateRequest expirationDate;
    private InstructionLinesRequest instructionLines;
    private String logoUri;

    public ExpirationDateRequest getExpirationDate() {
        return expirationDate;
    }

    public InstructionLinesRequest getInstructionLines() {
        return instructionLines;
    }

    public String getLogoUri() {
        return logoUri;
    }

    public BoletoRequest expirationDate(final ExpirationDateRequest expirationDate) {
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

    public class ExpirationDateRequest {
        private Date date;

        public Date getDate() {
            return date;
        }

        public ExpirationDateRequest date(Date date) {
            this.date = date;

            return this;
        }
    }
}
