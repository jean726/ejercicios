package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sistema_de_tienda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblPrecio;
	private JLabel lblStock;
	private JTextField txtnom;
	private JTextField txtprecio;
	private JTextField txtstock;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sistema_de_tienda frame = new sistema_de_tienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public sistema_de_tienda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Nombre de producto:");
		lblNewLabel.setBounds(10, 26, 121, 26);
		contentPane.add(lblNewLabel);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 54, 55, 26);
		contentPane.add(lblPrecio);
		
		lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 90, 121, 26);
		contentPane.add(lblStock);
		
		txtnom = new JTextField();
		txtnom.setBounds(136, 30, 96, 19);
		contentPane.add(txtnom);
		txtnom.setColumns(10);
		
		txtprecio = new JTextField();
		txtprecio.setColumns(10);
		txtprecio.setBounds(75, 58, 96, 19);
		contentPane.add(txtprecio);
		
		txtstock = new JTextField();
		txtstock.setColumns(10);
		txtstock.setBounds(75, 94, 96, 19);
		contentPane.add(txtstock);
		
		btnNewButton = new JButton("Guardar Producto");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(10, 126, 165, 35);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 183, 257, 181);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
	String nom = txtnom.getText();
	String precio = txtprecio.getText();
	String stock = txtstock.getText();
	
	if(nom.isEmpty() || precio.isEmpty() || stock.isEmpty()) {
		JOptionPane.showMessageDialog(this, "complete todo los campos por favor!!");
		return;
	}
	else {
		try {
			
			double p = Double.parseDouble(precio);
			int s = Integer.parseInt(stock);
			
			if(txtS.getText().isEmpty()) {
	    		txtS.append("--------------------------------------------------------------\n");
	    		txtS.append("                       Registro de Bodega                     \n");  
	    		txtS.append("--------------------------------------------------------------\n");
	        }
			
			
			Registro d = new Registro(nom, p, s);
	        txtS.append(d.getNombre() + "\t" + d.getPrecio() + "\t" + d.getStock() + "\n");		
	        
	        txtnom.setText("");
	        txtprecio.setText("");
	        txtstock.setText("");
	        //precio
		}
		catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "El precio y stock deben ser númmeros validos");
		}
	}
	
	
	
	
	}
	
	
	
}
