package br.com.moip.resource.structure;

public class Boleto {

    private String linecode;
    private String expirationDate;
    private InstructionLines instrucionLines;
    private String logoUri;

    public String getLinecode() {
        return linecode;
    }

    public Boleto setLinecode(String linecode) {
        this.linecode = linecode;

        return this;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public Boleto setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;

        return this;
    }

    public Boleto setFirstInstructionLine(String first) {
        if (instrucionLines == null) {
            instrucionLines = new InstructionLines();
        }

        instrucionLines.setFirst(first);

        return this;
    }

    public Boleto setSecondInstructionLine(String second) {
        if (instrucionLines == null) {
            instrucionLines = new InstructionLines();
        }

        instrucionLines.setSecond(second);

        return this;
    }

    public Boleto setThirdInstructionLine(String third) {
        if (instrucionLines == null) {
            instrucionLines = new InstructionLines();
        }

        instrucionLines.setThird(third);

        return this;
    }

    public InstructionLines getInstructionLines() {
        return instrucionLines;
    }

    public String getLogoUri() {
        return logoUri;
    }

    public Boleto setLogoUri(String logoUri) {
        this.logoUri = logoUri;

        return this;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "linecode='" + linecode + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", instrucionLines=" + instrucionLines +
                ", logoUri='" + logoUri + '\'' +
                '}';
    }
}
