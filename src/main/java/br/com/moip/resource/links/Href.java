package br.com.moip.resource.links;

public class Href {

    private String href;

    public String getHref() {
        return href;
    }

    @Override
    public String toString() {
        return new StringBuilder("Href{")
                .append("href='").append(href).append('\'')
                .append('}').toString();
    }
}
