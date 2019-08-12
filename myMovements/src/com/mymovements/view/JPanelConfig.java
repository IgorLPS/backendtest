package com.mymovements.view;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.mymovements.controller.LancamentoController; 

/** 
 * View das Configurações
 * 
 * @author igor.leonardo.silva
 *
 */
public class JPanelConfig extends JPanel {
	private JLabel labelArquivo;
	private JLabel labelPagamento;
	private JLabel labelRecebimento;

	/**
	 * Creates new form JPanelCadastro
	 */
	public JPanelConfig() {
		initComponents();
	}

	/**
  		Metodo inicia os componentes
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() { 
		labelArquivo = new JLabel();
		labelArquivo.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14)); 
		labelPagamento = new JLabel();
		labelPagamento.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));  
		labelRecebimento = new JLabel();
		labelRecebimento.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));

		LancamentoController controller = new LancamentoController();
		HashMap<String, String> listConfig = controller.configList();
		String outPut = new String();
		for (Map.Entry<String, String> entrys : listConfig.entrySet()) {
			outPut = new String();
			String key = entrys.getKey();
			String value = entrys.getValue();
			outPut = outPut.concat(key.toUpperCase() + " : ").concat(value);
			if ("EndPoint Pagamento".equalsIgnoreCase(key)) {
				labelPagamento.setText(outPut);
			}
			if ("EndPoint Recebimento".equalsIgnoreCase(key)) {
				labelRecebimento.setText(outPut);
			}
			if ("Path Arquivo log".equalsIgnoreCase(key)) {
				labelArquivo.setText(outPut);
			}
		} 
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout); 
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGroup(

						layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(labelArquivo, GroupLayout.PREFERRED_SIZE, 2000,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(labelPagamento, GroupLayout.PREFERRED_SIZE, 2000,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(labelRecebimento, GroupLayout.PREFERRED_SIZE, 2000,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
						.addGap(0, 0, Short.MAX_VALUE)));

		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)).addGap(26, 26, 26)
						.addComponent(labelArquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(labelPagamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(labelRecebimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)));
	}//

}
