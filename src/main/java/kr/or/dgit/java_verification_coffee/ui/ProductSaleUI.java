package kr.or.dgit.java_verification_coffee.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.java_verification_coffee.component.InputContent;

@SuppressWarnings("serial")
public class ProductSaleUI extends JFrame implements ActionListener {
	private JPanel contentPane;
	private InputContent pPrdCode;
	private InputContent pPrdName;
	private InputContent pPrdCost;
	private InputContent pQuantity;
	private InputContent pMargin;
	private JButton btnInput;
	private JButton btnOuput1;
	private JButton btnOutput2;
	//private ProductService service;
	private ProductSaleRankUI rankSell;
	private ProductSaleRankUI rankMargin;

	public ProductSaleUI() {
		//service = new ProductService();
		initComponents();
	}

	private void initComponents() {
		setTitle("커피전문점");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pContent = new JPanel();
		contentPane.add(pContent, BorderLayout.CENTER);
		pContent.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel p1 = new JPanel();
		p1.setBorder(new EmptyBorder(5, 5, 5, 5));
		pContent.add(p1);
		p1.setLayout(new GridLayout(0, 2, 0, 0));

		pPrdCode = new InputContent("제품코드");
		pPrdCode.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		p1.add(pPrdCode);

		pPrdName = new InputContent("제품명");
		pPrdName.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		pPrdName.setEnable(false);
		p1.add(pPrdName);

		JPanel p2 = new JPanel();
		p2.setBorder(new EmptyBorder(5, 5, 5, 5));
		pContent.add(p2);
		p2.setLayout(new GridLayout(0, 2, 0, 0));

		pPrdCost = new InputContent("제품단가");
		pPrdCost.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		p2.add(pPrdCost);

		JPanel pEmpty1 = new JPanel();
		p2.add(pEmpty1);

		JPanel p3 = new JPanel();
		p3.setBorder(new EmptyBorder(5, 5, 5, 5));
		pContent.add(p3);
		p3.setLayout(new GridLayout(0, 2, 0, 0));

		pQuantity = new InputContent("판매수량");
		pQuantity.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		p3.add(pQuantity);

		JPanel pEmpty2 = new JPanel();
		p3.add(pEmpty2);

		JPanel p4 = new JPanel();
		p4.setBorder(new EmptyBorder(5, 5, 5, 5));
		pContent.add(p4);
		p4.setLayout(new GridLayout(0, 2, 0, 0));

		pMargin = new InputContent("마진율");
		pMargin.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		p4.add(pMargin);

		JPanel pEmpty3 = new JPanel();
		p4.add(pEmpty3);

		JPanel pBtn = new JPanel();
		pBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new GridLayout(0, 3, 10, 10));

		btnInput = new JButton("입력");
		pBtn.add(btnInput);

		btnOuput1 = new JButton("출력1[판매순위]");
		btnOuput1.addActionListener(this);
		pBtn.add(btnOuput1);

		btnOutput2 = new JButton("출력2[마진순위]");
		btnOutput2.addActionListener(this);
		pBtn.add(btnOutput2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOutput2) {
			actionPerformedBtnOutput2(e);
		}
		if (e.getSource() == btnOuput1) {
			actionPerformedBtnOuput1(e);
		}
	}

	protected void actionPerformedBtnOuput1(ActionEvent e) {
		if (rankSell == null) {
			rankSell = new ProductSaleRankUI("판 매 금 액 순 위");
		}
		rankSell.setVisible(true);
	}

	protected void actionPerformedBtnOutput2(ActionEvent e) {
		if (rankMargin == null) {
			rankMargin = new ProductSaleRankUI("마 진 액 순 위");
		}
		rankMargin.setVisible(true);
	}
}
