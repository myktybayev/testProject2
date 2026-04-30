package kz.worldskills.a202;

public class Food {
    String name;
    String price;
    String remark;
    String type_id;
    String score;
    int image_url;

    public Food(String name, String price, String remark, String type_id, String score, int image_url) {
        this.name = name;
        this.price = price;
        this.remark = remark;
        this.type_id = type_id;
        this.score = score;
        this.image_url = image_url;
    }
}
