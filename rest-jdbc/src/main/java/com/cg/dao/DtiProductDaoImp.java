package com.cg.dao;

import static com.cg.utils.DBUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.cg.pojo.Dti_product;

public class DtiProductDaoImp implements DtiProductDaoInf {
	Dti_product product = new Dti_product();
	Connection cn;
	PreparedStatement preparedStatement;

	public Dti_product getPdt(String id) throws Exception {
		
		cn = getConnection();
		
		String query = "SELECT PDT_CODE, PDT_NAME, PDT_DESC, PRINTED_PRICE FROM DTI.DTI_PRODUCT WHERE PDT_CODE = ?";
		preparedStatement = cn.prepareStatement(query);
		preparedStatement.setString(1, id);

		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {

			String pdtCode1 = rs.getString("PDT_CODE");
			product.setPdt_code(pdtCode1);

			String pdtName1 = rs.getString("PDT_NAME");
			product.setPdt_name(pdtName1);

			String pdt_desc1 = rs.getString("PDT_DESC");
			product.setPdt_desc(pdt_desc1);

			Double printed_price1 = rs.getDouble("PRINTED_PRICE");
			product.setPrinted_price(printed_price1);

		}
		cleanUp();
		return product;
	}

	public void cleanUp() throws Exception {
		if (preparedStatement != null)
			preparedStatement.close();
		if (cn != null)
			cn.close();
	}
}