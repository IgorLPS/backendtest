/**
 * 
 */
package com.mymovements.view;

import javax.swing.JFrame; 
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;  
import javax.swing.GroupLayout;


/**
 * Classe view, Janela principal da interface grafica
 * @author igor.leonardo.silva
 *
 */
public class MinhasContasView extends JFrame{
	    private JMenu jMenu1;
	    private JMenu jMenu2;
	    private JMenuBar jMenuBar1;
	    private JMenuItem jMenuItem1;
	    private JMenuItem jMenuItem2; 
	    private JTabbedPane jTabbedPane1;

	/**
	 * 
	 * Metodo contrutor
	 */
	public MinhasContasView() {
		initComponents();
		setExtendedState(MAXIMIZED_BOTH);
        setTitle("Minhas Contas");
	}
	
	/**
	 * Iniciar os objetos graficos
	 */
	private void initComponents() {
		jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem(); 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); 
        jMenu1.setText("Help");

        jMenuItem1.setText("Configuração");
        jMenuItem1.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        
        jMenu1.add(jMenuItem1); 
        jMenuBar1.add(jMenu1); 
        jMenu2.setText("Lançamentos"); 
        jMenuItem2.setText("Minhas Contas");
        jMenuItem2.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2); 
         
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 1336, GroupLayout.PREFERRED_SIZE)
                .addContainerGap( GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, GroupLayout.Alignment.TRAILING,GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
        ); 
        pack(); 
	}
	
	
	 private void jMenuItem1ActionPerformed(ActionEvent evt) {  
	    if (jTabbedPane1.indexOfTab("JPanelConfig") == -1) {
	            JPanelConfig cavl = new JPanelConfig(); 
	            jTabbedPane1.addTab("Configuração", cavl);
	            jTabbedPane1.setSelectedComponent(cavl);
	            int i = jTabbedPane1.getSelectedIndex();
	            jTabbedPane1.setTabComponentAt(i, new ButtonTabComponent(jTabbedPane1));
	        } else {
	            jTabbedPane1.setSelectedIndex(jTabbedPane1.indexOfTab("Configuração"));
	        } 
	        
	    }
	 
	    private void jMenuItem2ActionPerformed(ActionEvent evt) {     
	         if (jTabbedPane1.indexOfTab("Minhas Contas/Movimentações") == -1) {
	            JPaneLancamentos cavl = new JPaneLancamentos(); 
	            jTabbedPane1.addTab("Minhas Contas/Movimentações", cavl);
	            jTabbedPane1.setSelectedComponent(cavl);
	            int i = jTabbedPane1.getSelectedIndex();
	            jTabbedPane1.setTabComponentAt(i, new ButtonTabComponent(jTabbedPane1));
	        } else {
	            jTabbedPane1.setSelectedIndex(jTabbedPane1.indexOfTab("Minhas Contas/Movimentações"));
	        }
	        
	    }
	     
 

}
