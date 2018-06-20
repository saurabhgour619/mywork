package com.cg.pojo;

public class Dti_product {

	private String pdt_code;
	private String pdt_name;
	private String pdt_desc;
	private Double printed_price;

	public Dti_product() {
	}

	public String getPdt_code() {
		return pdt_code;
	}

	public void setPdt_code(String pdt_code) {
		this.pdt_code = pdt_code;
	}

	public String getPdt_name() {
		return pdt_name;
	}

	public void setPdt_name(String pdt_name) {
		this.pdt_name = pdt_name;
	}

	public String getPdt_desc() {
		return pdt_desc;
	}

	public void setPdt_desc(String pdt_desc) {
		this.pdt_desc = pdt_desc;
	}

	public Double getPrinted_price() {
		return printed_price;
	}

	public void setPrinted_price(Double printed_price) {
		this.printed_price = printed_price;
	}

	@Override
	public String toString() {
		return "Product [pdt_code=" + pdt_code + ", pdt_name=" + pdt_name + ", pdt_desc=" + pdt_desc
				+ ", printed_price=" + printed_price + "]";
	}

}