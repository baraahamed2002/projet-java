
public class ItemToPurchase {
	private String itemName;
	private int itemPrice;
	private int itemQuantity;
	private String itemDescription;

	public ItemToPurchase() {
		itemName = "none";
		itemPrice = 0;
		itemQuantity = 0;
		itemDescription = "none";
	}

	public ItemToPurchase(String name, int price, int quantity, String description) {
		this.itemName = name;
		this.itemPrice = price;
		this.itemQuantity = quantity;
		this.itemDescription = description;
	}

	public void printItemCost() {
		System.out.println(this.getName() + " " + this.getQuantity() + " @ DT" + this.getPrice() + " = DT"
				+ (this.getPrice() * this.getQuantity()));
	}

	public void printItemDescription() {
		System.out.println(this.getName() + ": " + this.getDescription());
	}

	public String getName() {
		return itemName;
	}

	public void setName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return itemPrice;
	}

	public void setPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getQuantity() {
		return itemQuantity;
	}

	public void setQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getDescription() {
		return this.itemDescription;
	}

	public void setDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

}
