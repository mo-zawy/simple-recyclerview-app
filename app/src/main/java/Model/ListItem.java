package Model;


public class ListItem {
    private String title;
    private String discription;
    private int imageId;
    private boolean isCompleted;


    public ListItem(String title, String discription, int id) {
        this.title = title;
        this.discription = discription;
        this.imageId = id;
        this.isCompleted = false;
    }
    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }




    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}

