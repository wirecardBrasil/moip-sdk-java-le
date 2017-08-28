package br.com.moip.resource;

/**
 * Created by feitosa on 12/05/16.
 */
public enum  PaymentStatus {
    UNKNOWN(0, "Desconhecido"),
    AUTHORIZED(1, "Autorizado"),
    INITIATED(2, "Iniciado"),
    PRINTED(3, "Boleto impresso"),
    SETTLED(4, "Liquidado"),
    CANCELLED(5, "Cancelado"),
    IN_ANALYSIS(6, "Em análise"),
    REVERTED(7, "Revertido"),
    IN_REVISION(8, "Em revisão"),
    REFUNDED(9, "Reembolsado"),
    WAITING(10, "Aguardando confirmação"),
    PRE_AUTHORIZED(11, "Pré-autorizado");

    private String description;
    private int id;

    private PaymentStatus(int id, String description) {
        this.description = description;
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static PaymentStatus getStatus(int id) {
        PaymentStatus[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            PaymentStatus paymentStatus = var1[var3];
            if(id == paymentStatus.getId()) {
                return paymentStatus;
            }
        }

        throw new IllegalArgumentException("No matching type for id " + id);
    }
}
