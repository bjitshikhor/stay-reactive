package beautiful.reactive.stayreactive.model;

public class Item {
    private Integer shopId;
    private Integer itemId;
    private String name;


    public Item(Integer shopId, Integer itemId, String name) {
        this.shopId = shopId;
        this.itemId = itemId;
        this.name = name;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "shopId=" + shopId +
                ", itemId=" + itemId +
                ", name='" + name + '\'' +
                '}';
    }
}
