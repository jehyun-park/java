package vo;

public class CartVO {
	private int dogId;
	private String dogImage;
	private String dogKind;
	private int dogPrice;
	private int qty;
	
	public int getDogId() {
		return dogId;
	}
	public void setDogId(int dogId) {
		this.dogId = dogId;
	}
	public String getDogImage() {
		return dogImage;
	}
	public void setDogImage(String dogImage) {
		this.dogImage = dogImage;
	}
	public String getDogKind() {
		return dogKind;
	}
	public void setDogKind(String dogKind) {
		this.dogKind = dogKind;
	}
	public int getDogPrice() {
		return dogPrice;
	}
	public void setDogPrice(int dogPrice) {
		this.dogPrice = dogPrice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
}