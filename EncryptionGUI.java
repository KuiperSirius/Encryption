package security;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncryptionGUI extends JFrame {
	private JPanel contentPane;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private String encryptResultStr;
	private String decryptResultStr;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncryptionGUI frame = new EncryptionGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*
	 * 
	 * 将内容保存至计算机剪切板
	 */
	public static void setSysClipboardText(String writeMe) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(writeMe);
        clip.setContents(tText, null);
    }
	/**
	 * Create the frame.
	 */

	
	public EncryptionGUI() {
		
		ButtonGroup buttonGroup= new ButtonGroup();//单选框
		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionGUI.class.getResource("/security/Image.jpg")));
		setTitle("Advanced Encryption Standard 256");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 430);
		contentPane= new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setResizable(false);
		contentPane.setLayout(null);
		
		/**
		 * 以下内容为添加内容面板信息
		 * 
		 */
		JTextArea textArea = new JTextArea();
		textArea.setBounds(182, 252, 314, 78);
		contentPane.add(textArea);
		textArea.setEditable(false);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Encryption");
		rdbtnNewRadioButton.setFont(new Font("幼圆", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(182, 23, 157, 25);
		rdbtnNewRadioButton.setSelected(false);
		buttonGroup.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textArea.setText("");
			}
		});
		
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Decryption");
		rdbtnNewRadioButton_1.setFont(new Font("幼圆", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBounds(372, 25, 124, 21);
		buttonGroup.add(rdbtnNewRadioButton_1);
		contentPane.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textArea.setText("");
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("Operation:");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 17));
		lblNewLabel.setBounds(35, 13, 100, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pending codes:");
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(35, 68, 144, 25);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(182, 70, 314, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Symmetric key:");
		lblNewLabel_2.setFont(new Font("幼圆", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(35, 125, 144, 25);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(182, 127, 314, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Process result:");
		lblNewLabel_3.setFont(new Font("幼圆", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(35, 186, 144, 25);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(182, 188, 314, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
		JLabel lblNewLabel_4 = new JLabel("Notes:");
		lblNewLabel_4.setFont(new Font("幼圆", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(35, 250, 118, 25);
		contentPane.add(lblNewLabel_4);
		
		
		
		JButton btnNewButton = new JButton("Execute");
		btnNewButton.setFont(new Font("幼圆", Font.PLAIN, 13));
		btnNewButton.setBounds(224, 347, 97, 25);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {		
			
			if(!rdbtnNewRadioButton.isSelected()&&!rdbtnNewRadioButton_1.isSelected()) {					
					textArea.setText("Please choose an operation!");
				}else if(rdbtnNewRadioButton.isSelected()) {
					if(textField.getText()==null||textField.getText().trim()==""||
							textField.getText().equals("")||textField_1.getText()==null||
									textField_1.getText().equals("")||textField_1.getText().trim()=="") {
						textArea.setText("Please input your plaintext and encryption key!");
					}else {				
					encryptResultStr = AES256.encrypt(textField.getText(), textField_1.getText());
					textField_2.setText(encryptResultStr);
					textArea.setText("");
					textArea.append("Plaintext : "+textField.getText()+"\n");
					textArea.append("Encryption key : "+textField_1.getText()+"\n");
					textArea.append("Encryption result : "+textField_2.getText()+"\n");
					}
				}else if(rdbtnNewRadioButton_1.isSelected()) {//判断解密条件
					
					if(textField.getText()==null||textField.getText().trim()==""||
							textField.getText().equals("")||textField_1.getText()==null||
									textField_1.getText().equals("")||textField_1.getText().trim()=="") {
						textArea.setText("Please input your ciphertext and decryption key!");
					}else {	
						
					decryptResultStr = AES256.decrypt(textField.getText().getBytes(), textField_1.getText());
						 if(decryptResultStr ==null||decryptResultStr .equals("")) {
							textArea.append("There is something wrong with the programm."+"\n");
							textArea.append("The decryption key is not matching!"+"\n");
							textArea.append("Please check the encryption/decryption key and try again."+"\n");
						 }else {
					System.out.println("解密结果是"+decryptResultStr+"...................");
					textField_2.setText(decryptResultStr);
					textArea.setText("");
					textArea.append("Ciphertext : "+textField.getText()+"\n");
					textArea.append("Encryption key : "+textField_1.getText()+"\n");
					textArea.append("Decryption result : "+textField_2.getText()+"\n");
						
						 }
					
					}
					
					
				}
		
			}
		});
		
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setFont(new Font("幼圆", Font.PLAIN, 13));
		btnNewButton_1.setBounds(399, 347, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("幼圆", Font.PLAIN, 13));
		btnRefresh.setBounds(35, 345, 97, 25);
		contentPane.add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textArea.setText("");
				buttonGroup.clearSelection();
			
			}
		});
		
		
		JLabel lblNewLabel_5 = new JLabel("Input the content that you want to encrypt or decrypt.");
		lblNewLabel_5.setFont(new Font("微软雅黑 Light", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(182, 100, 335, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblEnterTheEncryption = new JLabel("Enter the encryption/decryption key for encryption algorithm.");
		lblEnterTheEncryption.setFont(new Font("微软雅黑 Light", Font.PLAIN, 11));
		lblEnterTheEncryption.setBounds(182, 163, 335, 16);
		contentPane.add(lblEnterTheEncryption);
		
		JLabel lblNewLabel_6 = new JLabel("Click Save to copy the process result to clipboard. ");
		lblNewLabel_6.setFont(new Font("微软雅黑 Light", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(182, 223, 335, 16);
		contentPane.add(lblNewLabel_6);
	
		btnNewButton_1.addActionListener(new ActionListener() {
			/**
			 * 将处理结果保存至计算机剪切板
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				EncryptionGUI.setSysClipboardText(textField_2.getText());
				
				
			}
		});
		
		
	}
}
