package kr.or.dgit.java_verification_coffee.component;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import kr.or.dgit.java_verification_coffee.ui.DBSettingUI;

@SuppressWarnings("serial")
public class AbstractBtnAction extends AbstractAction {
	private DBSettingUI settingMain;

	public AbstractBtnAction(String name, DBSettingUI settingMain) {
		super(name);
		this.settingMain = settingMain;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "초기화":
			settingMain.initial();
			break;
		case "백업":
			settingMain.backUpData();
			break;
		case "복원":
			settingMain.loadData();
			break;
		}
	}

}
