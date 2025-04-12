package models;

public class Product {
	private String name;
	private int id;
	private double price;
	private String image;
	
	//ecomproject
	
	public Product(String name, int id, double price, String image) {
		
		this.name = name;
		this.id = id;
		this.price = price;
		this.image = image;
	}
	
	
	public Product() {
		
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "Product [name=" + name + ", id=" + id + ", price=" + price + ", image=" + image + "]";
	}

}
