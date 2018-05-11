package kr.or.dgit.java_verification_coffee;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.java_verification_coffee.ui.DBSettingUI;
import kr.or.dgit.java_verification_coffee.ui.ProductSaleUI;

@SuppressWarnings("serial")
public class Client extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton btnDBSetting;
	private JButton btnCoffeeUI;
	private DBSettingUI dbUI;
	private ProductSaleUI productUI;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Client() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));

		btnDBSetting = new JButton("DB Setting");
		btnDBSetting.addActionListener(this);
		contentPane.add(btnDBSetting);

		btnCoffeeUI = new JButton("CoffeeUI");
		btnCoffeeUI.addActionListener(this);
		contentPane.add(btnCoffeeUI);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCoffeeUI) {
			actionPerformedBtnCoffeeUI(e);
		}
		if (e.getSource() == btnDBSetting) {
			actionPerformedBtnDBSetting(e);
		}
	}

	protected void actionPerformedBtnDBSetting(ActionEvent e) {
		if (dbUI == null) {
			dbUI = new DBSettingUI();
		}
		dbUI.setVisible(true);
	}

	protected void actionPerformedBtnCoffeeUI(ActionEvent e) {
		if (productUI == null) {
			productUI = new ProductSaleUI();
		}
		productUI.setVisible(true);
	}
}
