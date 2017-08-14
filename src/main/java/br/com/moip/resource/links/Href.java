package br.com.moip.resource.links;

public class Href {

    private String href;
    private String title = "";

    public String getHref() {
        return href;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        return new StringBuilder("Href{")
                .append("href='").append(href).append('\'')
                .append("title='").append(title).append('\'')
                .append('}').toString();
    }
}
