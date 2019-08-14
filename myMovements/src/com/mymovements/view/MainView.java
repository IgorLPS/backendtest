package com.mymovements.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import com.mymovements.controller.LancamentoController;
import com.mymovements.dto.MovimentacaoDTO;
import com.mymovements.util.LancamentoUtil;

/**
 * Classe principal
 * 
 * @author igor.leonardo.silva
 *
 */
public class MainView {

	/**
	 * Metodo principal
	 * @param args
	 */
	public static void main(String[] args) {
		LancamentoController controller = new LancamentoController();
		controller.atualizarDados();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// Menu 1
		String op = null;
		System.out.println("Como deseja executar esse programa?");
		System.out.println("1 - Pelo Console do DOS");
		System.out.println("2 - Por uma interface grafica amigavel(nada contra a tela do DOS)");
		System.out.println("Digite o número da opção escolhida");

		try {
			op = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (op.equalsIgnoreCase("2")) {
			openView();
		} else {

			do {

				// Menu 2
				System.out.println();
				System.out.println("Opção escolhida 1");
				System.out.println("Então vamos começar, abaixo informações sobre a sua conta");
				System.out.println("1 - Log de movimentações de forma ordenada por Mês");
				System.out.println("2 - Total de gastos por categoria");
				System.out.println("3 - Categoria que você gastou mais");
				System.out.println("4 - Mês que você mais gastou");
				System.out.println("5 - Quanto que você gastou");
				System.out.println("6 - Quanto que você recebeu");
				System.out.println("7 - Saldo total de movimentações");
				System.out.println("8 - Todas as opções");
				System.out.println();
				BufferedReader readerMenu2 = new BufferedReader(new InputStreamReader(System.in));
				do {
					System.out.println("Digite o número da opção desejada");
					try {
						op = readerMenu2.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}

				} while (!testResposta2(op));


				System.out.println("Opção escolhida " + op);
				if (op.equalsIgnoreCase("1")) {
					option1(controller);
				}
				if (op.equalsIgnoreCase("2")) {
					option2(controller);
				}
				if (op.equalsIgnoreCase("3")) {
					option3(controller);
				}
				if (op.equalsIgnoreCase("4")) {
					option4(controller);
				}
				if (op.equalsIgnoreCase("5")) {
					option5(controller);
				}
				if (op.equalsIgnoreCase("6")) {
					option6(controller);
				}
				if (op.equalsIgnoreCase("7")) {
					option7(controller);
				}
				if (op.equalsIgnoreCase("8")) {
					option1(controller);
					System.out.println();
					option2(controller);
					option3(controller);
					option4(controller);
					option5(controller);
					System.out.println();
					option6(controller);
					System.out.println();
					option7(controller);
				}

				do {

					System.out.println("Retornar ao Menu anterior ?  1 - Sim, 2 - Não");
					BufferedReader readerMenu3 = new BufferedReader(new InputStreamReader(System.in));
					try {
						op = readerMenu3.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}

				} while (!testResposta3(op));

			} while (op.equalsIgnoreCase("1"));

			
			
			do {
				System.out.println("Deseja testar a versão de interface gráfica?");
				System.out.println("1 - Sim");
				System.out.println("2 - Não");
				System.out.println("Digite o número da opção escolhida");
				try {
					op = reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (op.equalsIgnoreCase("1")) {
					openView();
					break;
				}
			} while (!testResposta3(op));
		}

		

	}

	/**
	 * Metodo para abrir a interface grafica
	 */
	public static void openView() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MinhasContasView.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MinhasContasView.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MinhasContasView.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MinhasContasView.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MinhasContasView().setVisible(true);
			}
		});
	}

	/**
	 * 
	 * @param controller
	 */
	public static void option1(LancamentoController controller) {
		List<MovimentacaoDTO> dtoList = controller.movimentacaoOrdenada();
		System.out.println("1 - Log de movimentações de forma ordenada por Mês:");
		dtoList.stream().forEach(d -> System.out.println(createLine(d)));
	}

	/**
	 * 
	 * @param controller
	 */
	public static void option2(LancamentoController controller) {
		String outPut = controller.gastosPorCategoria();
		System.out.println("2 - Total de gastos por categoria: \n" + outPut);
	}

	/**
	 * 
	 * @param controller
	 */
	public static void option3(LancamentoController controller) {
		String maxGasto = controller.maiorGastoCategoria();
		System.out.println("3 - Categoria que você gastou mais: \n" + maxGasto);
	}

	/**
	 * 
	 * @param controller
	 */
	public static void option4(LancamentoController controller) {
		String maxMes = controller.maiorGastoMes();
		System.out.println("4 - Mês que você mais gastou: \n" + maxMes);
	}

	/**
	 * 
	 * @param controller
	 */
	public static void option5(LancamentoController controller) {
		Double totalGasto = controller.totalGasto();
		System.out.println("5 - Quanto que você gastou: \n" + LancamentoUtil.convertDoubleToView(totalGasto));
	}

	/**
	 * 
	 * @param controller
	 */
	public static void option6(LancamentoController controller) {
		Double totalRecebido = controller.totalRecebido();
		System.out.println("6 - Quanto que você recebeu: \n" + LancamentoUtil.convertDoubleToView(totalRecebido));
	}

	/**
	 * 
	 * @param controller
	 */
	public static void option7(LancamentoController controller) {
		Double saldoTotal = controller.saldoTotal();
		System.out.println("7 - Saldo total de movimentações: \n" + LancamentoUtil.convertDoubleToView(saldoTotal));
	}

	/**
	 * 
	 * @param d
	 * @return
	 */
	private static String createLine(MovimentacaoDTO d) {
		StringBuilder line = new StringBuilder();
		line.append(LancamentoUtil.formatDateToView(d.getData())).append("\t\t").append(d.getDescricao()).append("\t\t")
				.append(LancamentoUtil.convertDoubleToView(d.getValor())).append("\t\t")
				.append(null != d.getMoeda() ? d.getMoeda() : "R$").append("\t\t")
				.append(null != d.getCategoria() ? d.getCategoria() : "");
		return line.toString();
	}

	/**
	 * Metodo para validar resposta
	 * @param op
	 * @return
	 */
	public static Boolean testResposta2(String op) {
		if (op.equalsIgnoreCase("1")) {
			return true;
		}
		if (op.equalsIgnoreCase("2")) {
			return true;
		}
		if (op.equalsIgnoreCase("3")) {
			return true;
		}
		if (op.equalsIgnoreCase("4")) {
			return true;
		}
		if (op.equalsIgnoreCase("5")) {
			return true;
		}
		if (op.equalsIgnoreCase("6")) {
			return true;
		}
		if (op.equalsIgnoreCase("7")) {
			return true;
		}
		if (op.equalsIgnoreCase("8")) {
			return true;
		}
		System.out.println("Opção invalida, digite novamente!");
		return false;
	}

	/**
	 * Metodo para validar resposta
	 * @param op
	 * @return
	 */
	public static Boolean testResposta3(String op) {
		if (op.equalsIgnoreCase("1")) {
			return true;
		}
		if (op.equalsIgnoreCase("2")) {
			return true;
		}
		System.out.println("Opção invalida, digite novamente!");
		return false;
	}
}
