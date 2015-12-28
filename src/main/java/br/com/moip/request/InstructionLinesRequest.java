package br.com.moip.request;

public class InstructionLinesRequest {
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

    public InstructionLinesRequest first(final String first) {
        this.first = first;

        return this;
    }

    public InstructionLinesRequest second(final String second) {
        this.second = second;

        return this;
    }

    public InstructionLinesRequest third(final String third) {
        this.third = third;

        return this;
    }
}
