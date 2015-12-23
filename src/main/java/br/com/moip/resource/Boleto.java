package br.com.moip.resource;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Boleto {
    private String lineCode;
    private ExpirationDate expirationDate;
    private InstructionLines instructionLines;

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(ExpirationDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public InstructionLines getInstructionLines() {
        return instructionLines;
    }

    public void setInstructionLines(InstructionLines instructionLines) {
        this.instructionLines = instructionLines;
    }

    public class InstructionLines {
        private String first;
        private String second;
        private String third;

        public String getFirst() {
            return first;
        }

        public String getSecond() {
            return second;
        }

        public String getThird() {
            return third;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public void setSecond(String second) {
            this.second = second;
        }

        public void setThird(String third) {
            this.third = third;
        }
    }

    public class ExpirationDate {
        private Date date;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getFormatedDate() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(this.getDate());
        }
    }
}
