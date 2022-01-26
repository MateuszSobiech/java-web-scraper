public record ConnectUrlService(String language, String city) {

    static String baseUrl = "https://www.pracuj.pl/praca/java;kw/warszawa;wp?rd=30";

    public String getConnectUrl() {
        String URL = "https://www.pracuj.pl/praca/%s;kw/%s;wp?rd=30";
        return String.format(URL, language, city);
    }
}
