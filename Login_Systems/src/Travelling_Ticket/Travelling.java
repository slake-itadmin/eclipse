package Travelling_Ticket;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Travelling {

	private JFrame frame;
	private JTextField txtTax; 
	private JTextField txtSubTotal;
	private JTextField txtTotal;
	private JTextField txtChild;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTextField txtDate;
	private JTextField txtTime;
	private JTextField txtAdult;
	private JTextField txtTicket;
	private JTextField txtClass;
	private JTextField txtTicketNo;
	private JTextField txtPrice;
	private JTextField txtRoute;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Travelling window = new Travelling();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Travelling() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 24));
		frame.setBounds(-7, -3, 1380, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 1334, 77);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Travelling Ticketing System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ticket Type");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(10, 91, 516, 48);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnStandard = new JRadioButton("Standard");
		rdbtnStandard.setFont(new Font("Tahoma", Font.BOLD, 24));
		rdbtnStandard.setBounds(9, 161, 147, 23);
		frame.getContentPane().add(rdbtnStandard);
		
		JRadioButton rdbtnEconomy = new JRadioButton("Economy");
		rdbtnEconomy.setFont(new Font("Tahoma", Font.BOLD, 24));
		rdbtnEconomy.setBounds(9, 216, 147, 23);
		frame.getContentPane().add(rdbtnEconomy);
		
		JRadioButton rdbtnFirstClass = new JRadioButton("First Class");
		rdbtnFirstClass.setFont(new Font("Tahoma", Font.BOLD, 24));
		rdbtnFirstClass.setBounds(9, 271, 147, 23);
		frame.getContentPane().add(rdbtnFirstClass);
		
		JRadioButton rdbtnSingleTicket = new JRadioButton("Single Ticket");
		rdbtnSingleTicket.setFont(new Font("Tahoma", Font.BOLD, 24));
		rdbtnSingleTicket.setBounds(195, 155, 197, 35);
		frame.getContentPane().add(rdbtnSingleTicket);
		
		JRadioButton rdbtnReturnTicket = new JRadioButton("Return Ticket");
		rdbtnReturnTicket.setFont(new Font("Tahoma", Font.BOLD, 24));
		rdbtnReturnTicket.setBounds(195, 216, 197, 23);
		frame.getContentPane().add(rdbtnReturnTicket);
		
		JRadioButton rdbtnChild = new JRadioButton("Child");
		rdbtnChild.setFont(new Font("Tahoma", Font.BOLD, 24));
		rdbtnChild.setBounds(437, 216, 89, 23);
		frame.getContentPane().add(rdbtnChild);
		
		JRadioButton rdbtnAdult = new JRadioButton("Adult");
		rdbtnAdult.setFont(new Font("Tahoma", Font.BOLD, 24));
		rdbtnAdult.setBounds(437, 161, 89, 23);
		frame.getContentPane().add(rdbtnAdult);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 140, 516, 2);
		frame.getContentPane().add(separator);
		
		JComboBox cmbDestination = new JComboBox();
		cmbDestination.setModel(new DefaultComboBoxModel(new String[] {"Destination", "Kilburn", "Preston", "Oxford", "Leed"}));
		cmbDestination.setFont(new Font("Tahoma", Font.BOLD, 24));
		cmbDestination.setBounds(195, 265, 331, 35);
		frame.getContentPane().add(cmbDestination);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 326, 516, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTax.setBounds(34, 355, 147, 37);
		frame.getContentPane().add(lblTax);
		
		JLabel lblSubTotal = new JLabel("SubTotal");
		lblSubTotal.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSubTotal.setBounds(34, 419, 122, 34);
		frame.getContentPane().add(lblSubTotal);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTotal.setBounds(34, 478, 122, 35);
		frame.getContentPane().add(lblTotal);
		
		txtTax = new JTextField();
		txtTax.setHorizontalAlignment(SwingConstants.CENTER);
		txtTax.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtTax.setBounds(230, 362, 216, 35);
		frame.getContentPane().add(txtTax);
		txtTax.setColumns(10);
		
		
				
				
		
		
		JButton btnReset = new JButton("Reset");
		btnReset.setToolTipText("Reset System");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTax.setText(null);
				txtSubTotal.setText(null);
				txtTotal.setText(null);
				rdbtnStandard.setSelected(false);
				rdbtnEconomy.setSelected(false);
				rdbtnFirstClass.setSelected(false);
				rdbtnSingleTicket.setSelected(false);
				rdbtnReturnTicket.setSelected(false);
				rdbtnAdult.setSelected(false);
				rdbtnChild.setSelected(false);
				cmbDestination.setSelectedItem("Destination");
				txtClass.setText(null);
				txtTicket.setText(null);
				txtAdult.setText(null);
				txtChild.setText(null);
				txtFrom.setText(null);
				txtTo.setText(null);
				txtDate.setText(null);
				txtTime.setText(null);
				txtTicketNo.setText(null);
				txtPrice.setText(null);
				txtRoute.setText(null);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnReset.setBounds(217, 588, 122, 48);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setToolTipText("Exit System");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Ticket System",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnExit.setBounds(404, 588, 122, 48);
		frame.getContentPane().add(btnExit);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 559, 516, 2);
		frame.getContentPane().add(separator_2);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtSubTotal.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtSubTotal.setColumns(10);
		txtSubTotal.setBounds(230, 419, 216, 35);
		frame.getContentPane().add(txtSubTotal);
		
		txtTotal = new JTextField();
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtTotal.setColumns(10);
		txtTotal.setBounds(230, 478, 216, 35);
		frame.getContentPane().add(txtTotal);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(564, 140, 13, 509);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(605, 140, 695, 2);
		frame.getContentPane().add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(1341, 140, 13, 509);
		frame.getContentPane().add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(605, 217, 682, 2);
		frame.getContentPane().add(separator_6);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblClass.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblClass.setBounds(605, 99, 147, 37);
		frame.getContentPane().add(lblClass);
		
		JLabel lblTicket = new JLabel("Ticket");
		lblTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicket.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTicket.setBounds(786, 99, 150, 37);
		frame.getContentPane().add(lblTicket);
		
		JLabel lblChild = new JLabel("Child");
		lblChild.setHorizontalAlignment(SwingConstants.CENTER);
		lblChild.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblChild.setBounds(1150, 99, 150, 37);
		frame.getContentPane().add(lblChild);
		
		JLabel lblAdult = new JLabel("Adult");
		lblAdult.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAdult.setBounds(971, 99, 147, 37);
		frame.getContentPane().add(lblAdult);
		
		txtChild = new JTextField();
		txtChild.setHorizontalAlignment(SwingConstants.CENTER);
		txtChild.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtChild.setColumns(10);
		txtChild.setBounds(1150, 161, 150, 35);
		frame.getContentPane().add(txtChild);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setHorizontalAlignment(SwingConstants.LEFT);
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFrom.setBounds(605, 260, 123, 37);
		frame.getContentPane().add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTo.setBounds(605, 360, 123, 37);
		frame.getContentPane().add(lblTo);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDate.setBounds(605, 460, 123, 37);
		frame.getContentPane().add(lblDate);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTime.setBounds(605, 560, 123, 37);
		frame.getContentPane().add(lblTime);
		
		txtFrom = new JTextField();
		txtFrom.setHorizontalAlignment(SwingConstants.CENTER);
		txtFrom.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtFrom.setColumns(10);
		txtFrom.setBounds(739, 263, 169, 40);
		frame.getContentPane().add(txtFrom);
		
		txtTo = new JTextField();
		txtTo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTo.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtTo.setColumns(10);
		txtTo.setBounds(739, 354, 169, 40);
		frame.getContentPane().add(txtTo);
		
		txtDate = new JTextField();
		txtDate.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtDate.setColumns(10);
		txtDate.setBounds(739, 459, 169, 40);
		frame.getContentPane().add(txtDate);
		
		txtTime = new JTextField();
		txtTime.setHorizontalAlignment(SwingConstants.CENTER);
		txtTime.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtTime.setColumns(10);
		txtTime.setBounds(739, 559, 169, 40);
		frame.getContentPane().add(txtTime);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(959, 248, 13, 401);
		frame.getContentPane().add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(26, 682, 1294, 2);
		frame.getContentPane().add(separator_8);
		
		txtAdult = new JTextField();
		txtAdult.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdult.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtAdult.setColumns(10);
		txtAdult.setBounds(971, 161, 150, 35);
		frame.getContentPane().add(txtAdult);
		
		txtTicket = new JTextField();
		txtTicket.setHorizontalAlignment(SwingConstants.CENTER);
		txtTicket.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtTicket.setColumns(10);
		txtTicket.setBounds(786, 161, 150, 35);
		frame.getContentPane().add(txtTicket);
		
		txtClass = new JTextField();
		txtClass.setHorizontalAlignment(SwingConstants.CENTER);
		txtClass.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtClass.setColumns(10);
		txtClass.setBounds(602, 161, 150, 35);
		frame.getContentPane().add(txtClass);
		
		JLabel lblTicketNo = new JLabel("Ticket No");
		lblTicketNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTicketNo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTicketNo.setBounds(1070, 281, 123, 37);
		frame.getContentPane().add(lblTicketNo);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPrice.setBounds(1070, 384, 123, 37);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblRoute = new JLabel("Route");
		lblRoute.setHorizontalAlignment(SwingConstants.LEFT);
		lblRoute.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblRoute.setBounds(1070, 490, 123, 37);
		frame.getContentPane().add(lblRoute);
		
		txtTicketNo = new JTextField();
		txtTicketNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTicketNo.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtTicketNo.setColumns(10);
		txtTicketNo.setBounds(1070, 323, 147, 40);
		frame.getContentPane().add(txtTicketNo);
		
		txtPrice = new JTextField();
		txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrice.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtPrice.setColumns(10);
		txtPrice.setBounds(1070, 428, 147, 40);
		frame.getContentPane().add(txtPrice);
		
		txtRoute = new JTextField();
		txtRoute.setHorizontalAlignment(SwingConstants.CENTER);
		txtRoute.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtRoute.setColumns(10);
		txtRoute.setBounds(1070, 535, 147, 40);
		frame.getContentPane().add(txtRoute);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double tax = 19.50;
				double MilesK8 = 25.78;
				double MilesK12 = 25.10;
				double MilesK20 = 45.23;
				double MilesK30 = 55.98;
				double totalCost, eco = 3.85, fclass = 5.60;
				
				//=============================STANDARD====================================================
				if ((rdbtnStandard.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Kilburn"))
				{
					totalCost = (tax * MilesK8) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK8);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK8 + totalCost);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnStandard.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Kilburn"))
				{
					totalCost = (tax * (MilesK8 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK8 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK8 + totalCost) * 2);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("STD");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnStandard.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Kilburn"))
				{
					totalCost = (tax * MilesK8) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK8 - 18);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK8 + totalCost - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}																				
				else if ((rdbtnStandard.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Preston"))
				{
					totalCost = (tax * MilesK12) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK12);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK12 + totalCost);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnStandard.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Preston"))
				{
					totalCost = (tax * (MilesK8 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK8 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK8 + totalCost) * 2);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("STD");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnStandard.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Preston"))
				{
					totalCost = (tax * MilesK12) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK12);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK12 + totalCost - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnStandard.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Preston"))
				{
					totalCost = (tax * (MilesK8 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK8 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",((MilesK8 + totalCost) * 2) - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("STD");
					txtTicket.setText("RETURN");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}	
				else if ((rdbtnStandard.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Oxford"))
				{
					totalCost = (tax * MilesK20) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK20);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK20 + totalCost);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnStandard.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Oxford"))
				{
					totalCost = (tax * (MilesK8 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK8 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK8 + totalCost) * 2);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("STD");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnStandard.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Oxford"))
				{
					totalCost = (tax * MilesK20) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK20);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK20 + totalCost - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnStandard.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Oxford"))
				{
					totalCost = (tax * (MilesK8 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK8 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",((MilesK8 + totalCost) * 2) - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("STD");
					txtTicket.setText("RETURN");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnStandard.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Leed"))
				{
					totalCost = (tax * MilesK30) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK30);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK30 + totalCost);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnStandard.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Leed"))
				{
					totalCost = (tax * (MilesK8 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK8 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK8 + totalCost) * 2);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("STD");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnStandard.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Leed"))
				{
					totalCost = (tax * MilesK30) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK30);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK30 + totalCost - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnStandard.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Leed"))
				{
					totalCost = (tax * (MilesK8 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK8 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",((MilesK8 + totalCost) * 2) - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("STD");
					txtTicket.setText("RETURN");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				
				//==============================ECONOMY====================================================
				
				else if ((rdbtnEconomy.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Kilburn"))
				{
					totalCost = (tax * (MilesK8 + eco)) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK8 + eco);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK8 + totalCost + eco);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("ECONOMY");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnStandard.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Kilburn"))
				{
					totalCost = (tax * (MilesK8 + eco)) / 100;
					String sTax = String.format("$%.2f",(totalCost + eco) - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK8 + eco);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK8 + totalCost + eco) - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("ECONOMY");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnEconomy.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Kilburn"))
				{
					totalCost = (tax * (MilesK8 + eco)) / 100;
					String sTax = String.format("$%.2f",(totalCost + eco) - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK8 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",((MilesK8 + totalCost) * 2) - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("ECONOMY");
					txtTicket.setText("RETURN");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnEconomy.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Kilburn"))
				{
					totalCost = (tax * (MilesK8 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK8 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK8 + totalCost) * 2);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("ECONOMY");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnEconomy.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Preston"))
				{
					totalCost = (tax * (MilesK12 + eco)) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK12 + eco);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK12 + totalCost + eco);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("ECONOMY");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnEconomy.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Preston"))
				{
					totalCost = (tax * MilesK12 + eco) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK12 + eco);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK12 + totalCost + eco) - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("ECONOMY");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnEconomy.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Preston"))
				{
					totalCost = (tax * (MilesK12 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK12 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",((MilesK12 + totalCost) * 2) - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("ECONOMY");
					txtTicket.setText("RETURN");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnEconomy.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Preston"))
				{
					totalCost = (tax * (MilesK12 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK12 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK12 + totalCost) * 2);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("ECONOMY");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnEconomy.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Oxford"))
				{
					totalCost = (tax * MilesK20 + eco) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK20 + eco);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK20 + totalCost + eco);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("ECONOMY");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnEconomy.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Oxford"))
				{
					totalCost = (tax * MilesK20 + eco) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK20 + eco);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK20 + totalCost + eco) - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("ECONOMY");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnEconomy.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Oxford"))
				{
					totalCost = (tax * (MilesK20 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK20 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",((MilesK20 + totalCost) * 2) - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("ECONOMY");
					txtTicket.setText("RETURN");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnEconomy.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Oxford"))
				{
					totalCost = (tax * (MilesK20 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK20 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK20 + totalCost) * 2);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("ECONOMY");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnEconomy.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Leed"))
				{
					totalCost = (tax * MilesK30 + 2) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK30 + eco);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK30 + totalCost + eco);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("ECONOMY");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnEconomy.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Leed"))
				{
					totalCost = (tax * MilesK30 + eco) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK30 + eco);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK30 + totalCost + eco) - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("ECONOMY");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnEconomy.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Leed"))
				{
					totalCost = (tax * MilesK30 * 2) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK30 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",((MilesK30 + totalCost) * 2) - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("ECONOMY");
					txtTicket.setText("RETURN");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnEconomy.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Leed"))
				{
					totalCost = (tax * (MilesK30 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK30 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK30 + totalCost) * 2);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("ECONOMY");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				
				//==============================FIRST CLASS==================================================
				
				else if ((rdbtnFirstClass.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Kilburn"))
				{
					totalCost = (tax * (MilesK8 + fclass)) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK8 + fclass);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK8 + totalCost + fclass);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("FIRST");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnFirstClass.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Kilburn"))
				{
					totalCost = (tax * (MilesK8 + fclass)) / 100;
					String sTax = String.format("$%.2f",(totalCost + fclass) - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK8 + fclass);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK8 + fclass + totalCost);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("FIRST");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnFirstClass.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Kilburn"))
				{
					totalCost = (tax * (MilesK8 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK8 - 18);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK8  * 2);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("FIRST");
					txtTicket.setText("RETURN");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnFirstClass.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Kilburn"))
				{
					totalCost = (tax * (MilesK8 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK8 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK8 + totalCost) * 2);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("FIRST");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnFirstClass.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Preston"))
				{
					totalCost = (tax * (MilesK12 + fclass)) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK12 + fclass);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK12 + totalCost + fclass);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("FIRST");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnFirstClass.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Preston"))
				{
					totalCost = (tax * MilesK12 + fclass) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK12 + fclass);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK12 + totalCost + fclass) - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("FIRST");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnFirstClass.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Preston"))
				{
					totalCost = (tax * (MilesK12 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK12 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",((MilesK12 + totalCost) * 2) - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("FIRST");
					txtTicket.setText("RETURN");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				//
				else if ((rdbtnFirstClass.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Preston"))
				{
					totalCost = (tax * (MilesK12 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK12 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK12 + totalCost) * 2);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("FIRST");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnFirstClass.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Oxford"))
				{
					totalCost = (tax * MilesK20 + fclass) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK20 + fclass);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK20 + totalCost + fclass);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("FIRST");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnFirstClass.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Oxford"))
				{
					totalCost = (tax * MilesK20 + fclass) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK20 + fclass);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK20 + totalCost + fclass) - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("FIRST");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnFirstClass.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Oxford"))
				{
					totalCost = (tax * (MilesK20 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK20 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",((MilesK20 + totalCost) * 2) - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("FIRST");
					txtTicket.setText("RETURN");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnFirstClass.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Oxford"))
				{
					totalCost = (tax * (MilesK20 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK20 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK20 + totalCost) * 2);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("FIRST");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnFirstClass.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Leed"))
				{
					totalCost = (tax * MilesK30 + 2) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK30 + fclass);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",MilesK30 + totalCost + fclass);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("FIRST");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnFirstClass.isSelected()) && (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Leed"))
				{
					totalCost = (tax * MilesK30 + fclass) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK30 + fclass);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK30 + totalCost + fclass) - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("FIRST");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnFirstClass.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestination.getSelectedItem().equals("Leed"))
				{
					totalCost = (tax * MilesK30 * 2) / 100;
					String sTax = String.format("$%.2f",totalCost - 18);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK30 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",((MilesK30 + totalCost) * 2) - 18);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("FIRST");
					txtTicket.setText("RETURN");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnFirstClass.isSelected()) && (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestination.getSelectedItem().equals("Leed"))
				{
					totalCost = (tax * (MilesK30 * 2)) / 100;
					String sTax = String.format("$%.2f",totalCost);
					txtTax.setText(sTax);
					String subTotal = String.format("$%.2f",MilesK30 * 2);
					txtSubTotal.setText(subTotal);
					String Total = String.format("$%.2f",(MilesK30 + totalCost) * 2);
					txtTotal.setText(Total);
					txtPrice.setText(Total);
					txtClass.setText("FIRST");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				//
				
				
				
				
				
				
				
				
				
				
				
				
				}
		});
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//====================Time============================================
					Calendar timer = Calendar.getInstance();
					timer.getTime();
					SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
					txtTime.setText(tTime.format(timer.getTime()));
				//====================Date============================================
					SimpleDateFormat Tdate = new SimpleDateFormat("dd-MM-yyyy");
					txtDate.setText(Tdate.format(timer.getTime()));
					txtFrom.setText("London *");
					txtTo.setText((String) cmbDestination.getSelectedItem()+ " *");
				//==========Random Number Generator===================================
					int num1;
					String q1 ="";
					num1 = 1325 + (int) (Math.random()*4238);
					q1 += num1 + 1325;
					txtTicketNo.setText(q1);
				//====================================================================
					txtRoute.setText("ANY");
			}
		});
		btnTotal.setToolTipText("Reset System");
		btnTotal.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnTotal.setBounds(34, 588, 122, 48);
		frame.getContentPane().add(btnTotal);
	}
}
