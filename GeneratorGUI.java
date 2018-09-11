package sequence;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Color;

public class GeneratorGUI extends JFrame {

	private JPanel contentPane;
	private JTextField message_textField;
	private JTextField md5_textField;
	private JTextField sha1_textField;
	private JTextField sha256_textField;
	private JTextField sha512_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneratorGUI frame = new GeneratorGUI();
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
	public GeneratorGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GeneratorGUI.class.getResource("/sequence/Image.jpg")));
		setTitle("Message Digest Algorithm Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 539);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Input message sequence\uFF1A");
		lblNewLabel.setFont(new Font("Ó×Ô²", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 28, 175, 25);
		contentPane.add(lblNewLabel);
		
		message_textField = new JTextField();
		message_textField.setBounds(222, 29, 448, 22);
		contentPane.add(message_textField);
		message_textField.setColumns(10);
		
		ButtonGroup buttonGroup= new ButtonGroup();//µ¥Ñ¡¿ò
		
		JLabel lblNewLabel_1 = new JLabel("Choose a generate algorithm:");
		lblNewLabel_1.setFont(new Font("Ó×Ô²", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(23, 93, 210, 16);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("MD5");
		rdbtnNewRadioButton.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBounds(222, 89, 68, 25);
		contentPane.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("SHA1");
		rdbtnNewRadioButton_1.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 13));
		rdbtnNewRadioButton_1.setBounds(336, 89, 73, 25);
		contentPane.add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("SHA-256");
		rdbtnNewRadioButton_2.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 13));
		rdbtnNewRadioButton_2.setBounds(461, 89, 81, 25);
		contentPane.add(rdbtnNewRadioButton_2);
		buttonGroup.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("SHA-512");
		rdbtnNewRadioButton_3.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 13));
		rdbtnNewRadioButton_3.setBounds(589, 89, 81, 25);
		contentPane.add(rdbtnNewRadioButton_3);
		buttonGroup.add(rdbtnNewRadioButton_3);
		
		JLabel lblMd = new JLabel("MD5\uFF1A");
		lblMd.setFont(new Font("Ó×Ô²", Font.PLAIN, 14));
		lblMd.setBounds(23, 139, 175, 16);
		contentPane.add(lblMd);
		
		md5_textField = new JTextField();
		md5_textField.setBounds(222, 136, 448, 22);
		contentPane.add(md5_textField);
		md5_textField.setColumns(10);
		md5_textField.setEditable(false);
		
		JLabel lblNewLabel_2 = new JLabel("SHA1:");
		lblNewLabel_2.setFont(new Font("Ó×Ô²", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(23, 183, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		sha1_textField = new JTextField();
		sha1_textField.setBounds(222, 180, 448, 22);
		contentPane.add(sha1_textField);
		sha1_textField.setColumns(10);
		sha1_textField.setEditable(false);
		
		JLabel lblNewLabel_3 = new JLabel("SHA-256\uFF1A");
		lblNewLabel_3.setFont(new Font("Ó×Ô²", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(23, 228, 87, 16);
		contentPane.add(lblNewLabel_3);
		
		sha256_textField = new JTextField();
		sha256_textField.setBounds(222, 225, 448, 22);
		contentPane.add(sha256_textField);
		sha256_textField.setColumns(10);
		sha256_textField.setEditable(false);
		
		JLabel lblNewLabel_4 = new JLabel("SHA-512:");
		lblNewLabel_4.setFont(new Font("Ó×Ô²", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(23, 274, 56, 16);
		contentPane.add(lblNewLabel_4);
		
		sha512_textField = new JTextField();
		sha512_textField.setBounds(222, 271, 448, 22);
		contentPane.add(sha512_textField);
		sha512_textField.setColumns(10);
		sha512_textField.setEditable(false);
		
		JLabel lblNewLabel_5 = new JLabel("Note\uFF1A");
		lblNewLabel_5.setFont(new Font("Ó×Ô²", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(23, 320, 56, 16);
		contentPane.add(lblNewLabel_5);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(222, 320, 448, 109);
		contentPane.add(textArea);
		textArea.setEditable(false);
		
		JButton refreshNewButton = new JButton("Refresh");
		refreshNewButton.setBounds(87, 442, 111, 25);
		contentPane.add(refreshNewButton);
		refreshNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				message_textField.setText("");
				md5_textField.setText("");
				sha1_textField.setText("");
				sha256_textField.setText("");
				sha512_textField.setText("");
				textArea.setText("");
				buttonGroup.clearSelection();
			}
		});
		
		
		JButton executeNewButton = new JButton("Execute");
		executeNewButton.setBounds(309, 442, 111, 25);
		contentPane.add(executeNewButton);
		executeNewButton.addActionListener(new ActionListener() {			
		@Override
			public void actionPerformed(ActionEvent e) {
				if(!rdbtnNewRadioButton.isSelected()&&!rdbtnNewRadioButton_1.isSelected()&&
						!rdbtnNewRadioButton_2.isSelected()&&!rdbtnNewRadioButton_3.isSelected()||message_textField.getText().equals("")
						||message_textField.getText()==null	) {
					textArea.setText("");
					textArea.append("Please choose a generate algorithm or input your message sequence!"+"\n");				
				}else {
					if(rdbtnNewRadioButton.isSelected()) {
						md5_textField.setText(Generator.MD5(message_textField.getText()));
						sha1_textField.setText(Generator.SHA1(message_textField.getText()));
						sha256_textField.setText(Generator.SHA256(message_textField.getText()));
						sha512_textField.setText(Generator.SHA512(message_textField.getText()));
						textArea.setText("");
						textArea.append("Your input message sequence is :"+message_textField.getText()+"\n");	
						textArea.append("MD5:"+Generator.MD5(message_textField.getText())+"\n");
						textArea.append("SHA1:"+Generator.SHA1(message_textField.getText())+"\n");
						textArea.append("SHA-256:"+Generator.SHA256(message_textField.getText())+"\n");
						textArea.append("SHA-512:"+Generator.SHA512(message_textField.getText())+"\n");
						
					}else if(rdbtnNewRadioButton_1.isSelected()) {
						md5_textField.setText(Generator.MD5(message_textField.getText()));
						sha1_textField.setText(Generator.SHA1(message_textField.getText()));
						sha256_textField.setText(Generator.SHA256(message_textField.getText()));
						sha512_textField.setText(Generator.SHA512(message_textField.getText()));
						textArea.setText("");
						textArea.append("Your input message sequence is :"+message_textField.getText()+"\n");	
						textArea.append("MD5:"+Generator.MD5(message_textField.getText())+"\n");
						textArea.append("SHA1:"+Generator.SHA1(message_textField.getText())+"\n");
						textArea.append("SHA-256:"+Generator.SHA256(message_textField.getText())+"\n");
						textArea.append("SHA-512:"+Generator.SHA512(message_textField.getText())+"\n");
					}else if(rdbtnNewRadioButton_2.isSelected()) {
						md5_textField.setText(Generator.MD5(message_textField.getText()));
						sha1_textField.setText(Generator.SHA1(message_textField.getText()));
						sha256_textField.setText(Generator.SHA256(message_textField.getText()));
						sha512_textField.setText(Generator.SHA512(message_textField.getText()));
						textArea.setText("");
						textArea.append("Your input message sequence is :"+message_textField.getText()+"\n");	
						textArea.append("MD5:"+Generator.MD5(message_textField.getText())+"\n");
						textArea.append("SHA1:"+Generator.SHA1(message_textField.getText())+"\n");
						textArea.append("SHA-256:"+Generator.SHA256(message_textField.getText())+"\n");
						textArea.append("SHA-512:"+Generator.SHA512(message_textField.getText())+"\n");
					}else if(rdbtnNewRadioButton_3.isSelected()) {
						md5_textField.setText(Generator.MD5(message_textField.getText()));
						sha1_textField.setText(Generator.SHA1(message_textField.getText()));
						sha256_textField.setText(Generator.SHA256(message_textField.getText()));
						sha512_textField.setText(Generator.SHA512(message_textField.getText()));
						textArea.setText("");
						textArea.append("Your input message sequence is :"+message_textField.getText()+"\n");	
						textArea.append("MD5:"+Generator.MD5(message_textField.getText())+"\n");
						textArea.append("SHA1:"+Generator.SHA1(message_textField.getText())+"\n");
						textArea.append("SHA-256:"+Generator.SHA256(message_textField.getText())+"\n");
						textArea.append("SHA-512:"+Generator.SHA512(message_textField.getText())+"\n");
					}
					
				
					
				}
				
			}
		});
		
		
		
		JButton saveNewButton = new JButton("Save");
		saveNewButton.setBounds(512, 442, 111, 25);
		contentPane.add(saveNewButton);
		saveNewButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					GeneratorGUI.setSysClipboardText(md5_textField.getText());
				}else if(rdbtnNewRadioButton_1.isSelected()) {
					GeneratorGUI.setSysClipboardText(sha1_textField.getText());
				}else if(rdbtnNewRadioButton_2.isSelected()) {
					GeneratorGUI.setSysClipboardText(sha256_textField.getText());				
				}else if(rdbtnNewRadioButton_3.isSelected()) {
					GeneratorGUI.setSysClipboardText(sha512_textField.getText());		
				}
			
			}
		});
		
		
		JLabel lblNewLabel_6 = new JLabel("Input your message sequence/string which you want to encrypt. ");
		lblNewLabel_6.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(222, 64, 448, 16);
		contentPane.add(lblNewLabel_6);
	}
	public static void setSysClipboardText(String writeMe) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(writeMe);
        clip.setContents(tText, null);
    }
	
}
