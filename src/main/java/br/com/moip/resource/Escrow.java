package br.com.moip.resource;

import br.com.moip.resource.links.EscrowLinks;

import java.util.Date;

public class Escrow {

    private String id;
    private EscrowStatus status;
    private String description;
    private Integer amount;
    private Date createdAt;
    private Date updatedAt;
    private EscrowLinks _links;

    public String getId() {
        return id;
    }

    public EscrowStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAmount() {
        return amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public EscrowLinks getLinks() {
        return _links;
    }
}
