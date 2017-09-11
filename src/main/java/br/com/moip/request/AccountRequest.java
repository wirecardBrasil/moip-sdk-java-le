package br.com.moip.request;

public class AccountRequest {

    private EmailRequest email;
    private PersonRequest person;
    private CompanyRequest company;
    private BusinessSegmentRequest businessSegment;
    private String site;
    private Type type;
    private Boolean transparentAccount;
    private TosAcceptanceRequest tosAcceptance;

    public AccountRequest email(String email) {
        this.email = new EmailRequest(email);

        return this;
    }

    public AccountRequest person(PersonRequest person) {
        this.person = person;

        return this;
    }

    public AccountRequest company(CompanyRequest company) {
        this.company = company;

        return this;
    }

    public AccountRequest businessSegment(BusinessSegmentRequest businessSegment) {
        this.businessSegment = businessSegment;

        return this;
    }

    public AccountRequest site(String site) {
        this.site = site;

        return this;
    }

    public AccountRequest type(Type type) {
        this.type = type;

        return this;
    }

    public AccountRequest transparentAccount(Boolean transparentAccount) {
        this.transparentAccount = transparentAccount;

        return this;
    }

    public AccountRequest tosAcceptance(TosAcceptanceRequest tosAcceptance) {
        this.tosAcceptance = tosAcceptance;

        return this;
    }

    public static final class EmailRequest {
        private String address;

        public EmailRequest(String address) {
            this.address = address;
        }

        public String getAddress() {
            return address;
        }
    }

    public static class BusinessSegmentRequest {
        private String id;

        public BusinessSegmentRequest(String id) {
            this.id = id;
        }
    }

    public static class TosAcceptanceRequest {
        private ApiDateRequest acceptedAt;
        private String ip;
        private String userAgent;

        public TosAcceptanceRequest acceptedAt(ApiDateRequest acceptedAt) {
            this.acceptedAt = acceptedAt;

            return this;
        }

        public TosAcceptanceRequest ip(String ip) {
            this.ip = ip;

            return this;
        }

        public TosAcceptanceRequest userAgent(String userAgent) {
            this.userAgent = userAgent;

            return this;
        }
    }

    public enum Type {
        MERCHANT, CONSUMER
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountRequest{");
        sb.append("email='").append(email);
        sb.append(", person=").append(person);
        sb.append(", company=").append(company);
        sb.append(", businessSegment=").append(businessSegment);
        sb.append(", site=").append(site).append('\'');
        sb.append(", type=").append(type).append('\'');
        sb.append(", transparentAccount=").append(transparentAccount);
        sb.append(", tosAcceptance=").append(tosAcceptance);
        sb.append('}');
        return sb.toString();
    }
}
