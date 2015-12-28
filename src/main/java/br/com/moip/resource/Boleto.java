package br.com.moip.resource;

public class Boleto {
    private String lineCode;
    private ApiDate expirationDate;
    private InstructionLines instructionLines;

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public ApiDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(ApiDate apiDate) {
        this.expirationDate = apiDate;
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
}
