package kr.or.dgit.java_verification_coffee.component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.SwingConstants;

import kr.or.dgit.java_verification_coffee.dto.ProductSales;
import kr.or.dgit.java_verification_coffee.service.ProductSalesService;


@SuppressWarnings("serial")
public class TableContent extends AbtractTableContent<ProductSales> {

	public void setTableAlignWidth() {
		setTableRowHeight(30);
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		setTableCellWidth(100, 200, 200, 200, 200, 200, 200, 200, 150, 200);
	}

	public Object[] getColumnNames() {
		return new String[] { "순위", "제품코드", "제품명", "제품단가", "판매수량", "공급가액", "부가세액", "판매금액", "마진율", "마진액" };
	}

	public Object[][] getRows(List<ProductSales> list) {
		Object[][] rows = new Object[list.size()+1][];

		for (int i = 0; i < rows.length-1; i++) {
			ProductSales sales = list.get(i);
			rows[i] = sales.toArray();
		}
		rows[list.size()] = getTotal();
		return rows;
	}

	private Object[] getTotal() {
		List<Map<String,Object>> res = ProductSalesService.getInstance().getTotal();
		Map<String,Object> maps = res.get(0);
		
		String[] total = new String[10];
		total[0] = "합계";
		Arrays.fill(total, 1, 4, "");
		total[5] = String.format("%,.0f", maps.get("suprice"));
		total[6] = String.format("%,.0f", maps.get("tax"));
		total[7] = String.format("%,.0f", maps.get("sellprice"));
		total[8] = "";
		total[9] = String.format("%,.0f", maps.get("marprice"));
		return total;
	}
}
