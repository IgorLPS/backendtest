package com.mymovements.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import com.mymovements.controller.LancamentoController;
import com.mymovements.dto.MovimentacaoDTO;
import com.mymovements.util.LancamentoUtil;

/**
 * Classe JPanel, que disponibiliza todas as informações sobre a conta
 * @author igor.leonardo.silva
 *
 */
public class JPaneLancamentos extends JPanel {

	private JButton jButtonSalvar;
	private JButton jButtonLimpar;
	private JButton jButtonLoad;// log de movimentações de forma ordenada
	private JButton jButtonTotalGategoria;// total de gastos por categoria
	private JButton jButtonGategoriaMax;// categoria cliente gastou mais
	private JButton jButtonMesMax;// o mês que cliente mais gastou
	private JButton jButtonTotalPagamento;// quanto de dinheiro o cliente gastou
	private JButton jButtonTotalRecebido;// quanto de dinheiro o cliente recebeu
	private JButton jButtonSaldoConta;// saldo total de movimentações do cliente
	private JScrollPane jScrollPane1;
	private JLabel label;
	private JTextArea areadeTextoInferior;
	private LancamentoController controller;
	private static Boolean load, totalCategoria, categoriaMax, totalPagamento, totalRecebido, saldoConta,mesMax;

	/**
	 * Metodo construtor JPaneLancamentos
	 */

	public JPaneLancamentos() {
		initComponents();
		controller = new LancamentoController();
		load = false;// log de movimentações de forma ordenada
		totalCategoria = false;// total de gastos por categoria
		categoriaMax = false;// categoria cliente gastou mais
		totalPagamento = false;// quanto de dinheiro o cliente gastou
		mesMax = false;// o mês que cliente mais gastou
		totalRecebido = false;// quanto de dinheiro o cliente recebeu
		saldoConta = false;// saldo total de movimentações do cliente
	}

	/** 
	 * Metodo que inicializa os componentes
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {
		areadeTextoInferior = new JTextArea(30, 80);
		areadeTextoInferior.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
		jButtonSalvar = new JButton();
		jScrollPane1 = new JScrollPane(areadeTextoInferior);
		jButtonLimpar = new JButton();
		jButtonLoad = new JButton();
		jButtonTotalGategoria = new JButton();
		jButtonGategoriaMax = new JButton();
		jButtonMesMax = new JButton();
		jButtonTotalPagamento = new JButton();
		jButtonTotalRecebido = new JButton();
		jButtonSaldoConta = new JButton();
		label = new JLabel();
		label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));

		jButtonSalvar.setText("Salvar");
		jButtonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonSalvarActionPerformed(evt);
			}
		});

		jButtonLimpar.setText("Limpar");
		jButtonLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonLimparActionPerformed(evt);
			}
		});

		jButtonLoad.setText("Log de movimentações");
		jButtonLoad.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonLoadActionPerformed(evt);
			}
		});

		jButtonTotalGategoria.setText("Total de gastos por categoria");
		jButtonTotalGategoria.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonTotalGategoriaActionPerformed(evt);
			}
		});

		jButtonGategoriaMax.setText("Categoria com mais gasto");
		jButtonGategoriaMax.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonGategoriaMaxActionPerformed(evt);
			}
		});

		jButtonMesMax.setText("Mês que mais gastou");
		jButtonMesMax.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonMesMaxActionPerformed(evt);
			}
		});

		jButtonTotalPagamento.setText("Total de Gastos");
		jButtonTotalPagamento.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonTotalPagamentoActionPerformed(evt);
			}
		});

		jButtonTotalRecebido.setText("Total Recebido");
		jButtonTotalRecebido.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonTotalRecebidoActionPerformed(evt);
			}
		});

		jButtonSaldoConta.setText("Saldo em Conta");
		jButtonSaldoConta.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSaldoContaActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);

		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup().addGroup(

						layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 2000, GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup().addComponent(jButtonSalvar)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jButtonLimpar).addGap(18, 18, 18).addComponent(jButtonLoad)
										.addComponent(jButtonTotalGategoria).addComponent(jButtonGategoriaMax)
										.addComponent(jButtonMesMax).addComponent(jButtonTotalPagamento)
										.addComponent(jButtonTotalRecebido).addComponent(jButtonSaldoConta)))
						.addGap(0, 0, Short.MAX_VALUE)));

		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jButtonSalvar)
								.addComponent(jButtonLimpar).addComponent(jButtonLoad)
								.addComponent(jButtonTotalGategoria).addComponent(jButtonGategoriaMax)
								.addComponent(jButtonMesMax).addComponent(jButtonTotalPagamento)
								.addComponent(jButtonTotalRecebido).addComponent(jButtonSaldoConta))
						.addGap(26, 26, 26)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)));

	}
    /**
     * ActionPerformed chamado no botão salvar, para salvar as informações
     * @param evt
     */
	private void jButtonSalvarActionPerformed(ActionEvent evt) {
		if (areadeTextoInferior.getText() == null || areadeTextoInferior.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Arquivo Vazio", "Arquivo Vazio", JOptionPane.ERROR_MESSAGE);
		} else {
			JFrame parentFrame = new JFrame("Teste");
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Salvar resultado");
			fileChooser.setName("Teste");
			fileChooser.setSelectedFile(new File(label.getText() + ".txt"));
			int userSelection = fileChooser.showSaveDialog(parentFrame);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File fileToSave = fileChooser.getSelectedFile();
				try {
					FileWriter inserindo = new FileWriter(fileToSave, true);
					inserindo.write(areadeTextoInferior.getText());
					inserindo.close();
				} catch (IOException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage(),
							"Erro ao salvar arquivo " + fileToSave.getAbsolutePath(), JOptionPane.ERROR_MESSAGE);
				}

				JOptionPane.showMessageDialog(null, "Sucesso", "Salvo com Sucesso " + fileToSave.getAbsolutePath(),
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}
    
	/**
	 * ActionPerformed chamado no botão limpar, para limpar a textArea
	 * @param evt
	 */
	private void jButtonLimparActionPerformed(ActionEvent evt) {
		int val = JOptionPane.showConfirmDialog(null, "Deseja realmente Limpar os dados  ?");
		if (val == 0) {
			areadeTextoInferior.setText(null);
			label.setText(null);
			load = false;
			totalCategoria = false;
			categoriaMax = false;
			totalPagamento = false;
			mesMax = false;
			totalRecebido = false;
			saldoConta = false;
		}
	}
    /**
     * ActionPerformed do botão saldo da conta
     * @param evt
     */
	private void jButtonSaldoContaActionPerformed(ActionEvent evt) {
		if (saldoConta) {
			JOptionPane.showMessageDialog(null, "Ei", "Essa opção já foi inserida", JOptionPane.WARNING_MESSAGE);
		} else {
		insertLine();
		Double saldoTotal = controller.saldoTotal();
		String strLabel = getTextLabel() + "Saldo total em conta";
		label.setText(strLabel);
		areadeTextoInferior.append("Saldo total em conta");
		areadeTextoInferior.append("\n");
		areadeTextoInferior.append(LancamentoUtil.convertDoubleToView(saldoTotal));
		areadeTextoInferior.append("\n");
		saldoConta = true;
		}
	}
    /**
     * ActionPerformed, chamado no botão total recebido
     * @param evt
     */
	private void jButtonTotalRecebidoActionPerformed(ActionEvent evt) {
		if (totalRecebido) {
			JOptionPane.showMessageDialog(null, "Ei", "Essa opção já foi inserida", JOptionPane.WARNING_MESSAGE);
		} else {
		insertLine();
		Double totalRecebido = controller.totalRecebido();
		String strLabel = getTextLabel() + "Total Recebido";
		label.setText(strLabel);
		areadeTextoInferior.append("Total Recebido");
		areadeTextoInferior.append("\n");
		areadeTextoInferior.append(LancamentoUtil.convertDoubleToView(totalRecebido));
		areadeTextoInferior.append("\n");
		this.totalRecebido = true;
		}
	}
    /**
     * Metodo para verificar se já foi escrito algo na textArea
     * @return
     */
	private String getTextLabel() {
		if (label.getText() == null || label.getText().isEmpty()) {
			return new String();
		}
		return label.getText() + ", ";
	} 
	/**
	 * ActionPerformed chamado no botão Total pagamento
	 * @param evt
	 */
	private void jButtonTotalPagamentoActionPerformed(ActionEvent evt) { 
		if (totalPagamento) {
			JOptionPane.showMessageDialog(null, "Ei", "Essa opção já foi inserida", JOptionPane.WARNING_MESSAGE);
		} else {
		insertLine();
		Double totalGasto = controller.totalGasto();
		String strLabel = getTextLabel() + "Total de gasto";
		label.setText(strLabel);
		areadeTextoInferior.append("Total de gasto");
		areadeTextoInferior.append("\n");
		areadeTextoInferior.append(LancamentoUtil.convertDoubleToView(totalGasto));
		areadeTextoInferior.append("\n");
		totalPagamento = true;
		}
	}

	/**
	 * ActionPerformed chamado no botão Mês com mais gasto
	 * @param evt
	 */
	private void jButtonMesMaxActionPerformed(java.awt.event.ActionEvent evt) {
		if (mesMax) {
			JOptionPane.showMessageDialog(null, "Ei", "Essa opção já foi inserida", JOptionPane.WARNING_MESSAGE);
		} else {
		insertLine();
		String maxMes = controller.maiorGastoMes();
		String strLabel = getTextLabel() + "Mês com mais gastos";
		label.setText(strLabel);
		areadeTextoInferior.append("Mês com mais gastos");
		areadeTextoInferior.append("\n");
		areadeTextoInferior.append(maxMes);
		mesMax = true;
		}
	}
    
	/**
	 * ActionPerformed para saber a categoria com mais gastos
	 * @param evt
	 */
	private void jButtonGategoriaMaxActionPerformed(java.awt.event.ActionEvent evt) {
		if (categoriaMax) {
			JOptionPane.showMessageDialog(null, "Ei", "Essa opção já foi inserida", JOptionPane.WARNING_MESSAGE);
		} else {
		insertLine();
		String maxGasto = controller.maiorGastoCategoria();
		String strLabel = getTextLabel() + "Categoria com mais gastos";
		label.setText(strLabel);
		areadeTextoInferior.append("Categoria com mais gastos");
		areadeTextoInferior.append("\n");
		areadeTextoInferior.append(maxGasto);
		categoriaMax=true;
		}
	}

	/**
	 ActionPerformed chamado no botã total de gasto por categoria
	 * 
	 * @param evt
	 */
	private void jButtonTotalGategoriaActionPerformed(ActionEvent evt) {
		if (totalCategoria) {
			JOptionPane.showMessageDialog(null, "Ei", "Essa opção já foi inserida", JOptionPane.WARNING_MESSAGE);
		} else {
			insertLine();
			String outPut = controller.gastosPorCategoria();
			String strLabel = getTextLabel() + "Total de gastos por categoria";
			label.setText(strLabel);
			areadeTextoInferior.append("Total de gastos por categoria");
			areadeTextoInferior.append("\n");
			areadeTextoInferior.append(outPut);
			totalCategoria = true;
		}
	}

	/**
	 * ActionPerformed Chamado no botão movimentações
	 * @param evt
	 */
	private void jButtonLoadActionPerformed(ActionEvent evt) {
		if (load) {
			JOptionPane.showMessageDialog(null, "Ei", "Essa opção já foi inserida", JOptionPane.WARNING_MESSAGE);
		} else {
			insertLine();
			List<MovimentacaoDTO> dtoList = controller.movimentacaoOrdenada();
			String strLabel = getTextLabel() + "Movimentações";
			label.setText(strLabel);
			areadeTextoInferior.append("Movimentações");
			areadeTextoInferior.append("\n");
			dtoList.stream().forEach(d -> areadeTextoInferior.append(createLine(d)));
			load = true;
		}
	}

	/**
	 * Metodo para formatar os dados para inserir na textArea
	 * @param d
	 * @return
	 */
	private String createLine(MovimentacaoDTO d) {
		StringBuilder line = new StringBuilder();
		line.append(LancamentoUtil.formatDateToView(d.getData())).append("\t\t").append(d.getDescricao()).append("\t\t")
				.append(LancamentoUtil.convertDoubleToView(d.getValor())).append("\t\t")
				.append(null != d.getMoeda() ? d.getMoeda() : "R$").append("\t\t")
				.append(null != d.getCategoria() ? d.getCategoria() : "").append("\n");
		return line.toString();
	}

	/**
	 * Metodo para pular uma linha
	 */
	private void insertLine() {
		if (!areadeTextoInferior.getText().isEmpty()) {
			areadeTextoInferior.append("\n");
		}
	}
}
