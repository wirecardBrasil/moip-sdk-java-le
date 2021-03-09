package br.com.moip.request;

public class Recurring {
    private boolean recurring;
    private int occurrence;

    public Recurring() {
    }

    public boolean isRecurring() {
        return this.recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public int getOccurrence() {
        return this.occurrence;
    }

    public void setOccurrence(int occurrence) {
        this.occurrence = occurrence;
    }
}