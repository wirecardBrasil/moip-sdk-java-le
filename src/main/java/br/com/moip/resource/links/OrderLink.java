package br.com.moip.resource.links;

public class OrderLink {
    private String title;
    private String href;

    public OrderLink(String title, String href) {
        this.title = title;
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "OrderLink{" +
                "title='" + title + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
