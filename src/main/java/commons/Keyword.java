package commons;

public class Keyword {
    private String keyword;
    private String dateTime;

    public Keyword(String keyword, String dateTime) {
        super();
        this.keyword = keyword;
        this.dateTime = dateTime;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getDateTime(){
        return dateTime;
    }

    public void setUrl(String url) {
        this.keyword = keyword;
    }

    public void setDateTime(String dateTime){
        this.dateTime = dateTime;
    }

}
