import java.io.Serializable;

public class Goods implements Serializable {
    private Long id;
    private String model;
    private String name;
    private int price;

    public Goods(){}
    public Goods(Long id, String model, String name, int price) {
        this.id = id;
        this.model = model;
        this.name = name;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGoods() {
        return id + ") " +
                " model = '" + model + '\'' +
                ", name = '" + name + '\'' +
                ", price = " + price + ';';
    }
}

