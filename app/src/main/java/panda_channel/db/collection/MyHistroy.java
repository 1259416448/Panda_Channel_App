package panda_channel.db.collection;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "MY_HISTROY".
 */
public class MyHistroy {

    private Long id;
    private String img;
    private String title;
    private String date;
    private String moviepath;

    public MyHistroy() {
    }

    public MyHistroy(Long id) {
        this.id = id;
    }

    public MyHistroy(Long id, String img, String title, String date, String moviepath) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.date = date;
        this.moviepath = moviepath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMoviepath() {
        return moviepath;
    }

    public void setMoviepath(String moviepath) {
        this.moviepath = moviepath;
    }

}
