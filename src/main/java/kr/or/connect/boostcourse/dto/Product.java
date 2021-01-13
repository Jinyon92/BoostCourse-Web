package kr.or.connect.boostcourse.dto;

public class Product {
	private int displayInfoId;
	private String placeName;
	private String productContent;
	private String productDescription;
	private int productId;
	private String productImageUrl;
	
	public int getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getProductContent() {
		return productContent;
	}
	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductImageUrl() {
		return productImageUrl;
	}
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
	
	@Override
	public String toString() {
		return "Product [displayInfoId=" + displayInfoId + ", placeName=" + placeName + ", productContent="
				+ productContent + ", productDescription=" + productDescription + ", productId=" + productId
				+ ", productImageUrl=" + productImageUrl + "]";
	}
	
}
