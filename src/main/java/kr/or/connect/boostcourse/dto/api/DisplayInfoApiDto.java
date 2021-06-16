package kr.or.connect.boostcourse.dto.api;

import java.util.List;

import kr.or.connect.boostcourse.dto.Comments;
import kr.or.connect.boostcourse.dto.DisplayInfo;
import kr.or.connect.boostcourse.dto.DisplayInfoImage;
import kr.or.connect.boostcourse.dto.ProductImages;
import kr.or.connect.boostcourse.dto.ProductPrices;

public class DisplayInfoApiDto {
	private List<ProductPrices> productPrices;
	private List<ProductImages> productImages;
	private DisplayInfo displayInfo;
	private DisplayInfoImage displayInfoImage;
	private List<Comments> comments;
	private double averageScore;
	
	public List<ProductPrices> getProductPrices() {
		return productPrices;
	}
	public void setProductPrices(List<ProductPrices> productPrices) {
		this.productPrices = productPrices;
	}
	public List<ProductImages> getProductImages() {
		return productImages;
	}
	public void setProductImages(List<ProductImages> productImages) {
		this.productImages = productImages;
	}
	public DisplayInfo getDisplayInfo() {
		return displayInfo;
	}
	public void setDisplayInfo(DisplayInfo displayInfo) {
		this.displayInfo = displayInfo;
	}
	public DisplayInfoImage getDisplayInfoImage() {
		return displayInfoImage;
	}
	public void setDisplayInfoImage(DisplayInfoImage displayInfoImage) {
		this.displayInfoImage = displayInfoImage;
	}
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	public double getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}
	
}
