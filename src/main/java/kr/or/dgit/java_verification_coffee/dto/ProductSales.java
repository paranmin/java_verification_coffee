package kr.or.dgit.java_verification_coffee.dto;

public class ProductSales {
	private Product product;
	private int no;
	private int price;
	private int saleCnt;
	private int marginRate;
	private int rank;
	private int suprice;
	private int tax;
	private int sellprice;
	private int marginPrice;

	public ProductSales() {
	}

	public ProductSales(Product product, int price, int saleCnt, int marginRate) {
		this.product = product;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
	}

	public ProductSales(Product product, int no, int price, int saleCnt, int marginRate) {
		this.product = product;
		this.no = no;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
	}

	public ProductSales(Product product, int price, int saleCnt, int marginRate, int rank, int suprice, int tax,
			int sellprice, int marginPrice) {
		this.product = product;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
		this.rank = rank;
		this.suprice = suprice;
		this.tax = tax;
		this.sellprice = sellprice;
		this.marginPrice = marginPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSaleCnt() {
		return saleCnt;
	}

	public void setSaleCnt(int saleCnt) {
		this.saleCnt = saleCnt;
	}

	public int getMarginRate() {
		return marginRate;
	}

	public void setMarginRate(int marginRate) {
		this.marginRate = marginRate;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getSuprice() {
		return suprice;
	}

	public void setSuprice(int suprice) {
		this.suprice = suprice;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getSellprice() {
		return sellprice;
	}

	public void setSellprice(int sellprice) {
		this.sellprice = sellprice;
	}

	public int getMarginPrice() {
		return marginPrice;
	}

	public void setMarginPrice(int marginPrice) {
		this.marginPrice = marginPrice;
	}

	@Override
	public String toString() {
		return String.format(
				"ProductSales [product=%s, price=%s, saleCnt=%s, marginRate=%s, rank=%s, suprice=%s, tax=%s, sellprice=%s, marginPrice=%s]",
				product, price, saleCnt, marginRate, rank, suprice, tax, sellprice, marginPrice);
	}

	public Object[] toArray() {
		return new Object[] { rank, product.getCode(), product.getName(), String.format("%,d", price),
				String.format("%,d", saleCnt), String.format("%,d", suprice), String.format("%,d", tax),
				String.format("%,d", sellprice), marginRate, String.format("%,d", marginPrice) };
	}

}
