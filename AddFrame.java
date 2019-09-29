import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class AddFrame extends JFrame{
Container c;
JLabel lblRno, lblName;
JTextField txtRno, txtName;
JButton btnSave, btnBack;

AddFrame(){
c = getContentPane();
c.setLayout(new FlowLayout());

lblRno = new JLabel("Enter Rno ");
lblName = new JLabel("Enter Name ");
txtRno = new JTextField(10);
txtName = new JTextField(10);
btnSave = new JButton("SAVE");
btnBack = new JButton("BACK");

c.add(lblRno);
c.add(txtRno);
c.add(lblName);
c.add(txtName);
c.add(btnSave);
c.add(btnBack);

btnSave.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
try{
String rno = txtRno.getText();
if((rno == null) || (Integer.parseInt(rno) < 0)){
JOptionPane.showMessageDialog(new JDialog()," Enter Numbers only " );
txtRno.setText("");
txtRno.requestFocus();
}
else{
String name = txtName.getText();
if((name == null) || (!name.matches("^[a-zA-Z\\s]*$"))||(name.matches("^[\\s]*$"))){
JOptionPane.showMessageDialog(new JDialog()," Enter Alphabets only " );
txtName.setText("");
txtName.requestFocus();
}
else{
DbHandler db = new DbHandler();
db.addStudent(Integer.parseInt(rno), name);
}}
}catch(NumberFormatException ne){
JOptionPane.showMessageDialog(new JDialog()," Enter Numbers only " );
txtRno.setText("");
txtRno.requestFocus();
}
}
});

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
MainFrame a = new MainFrame();
dispose();
}
});

setTitle("Add Student ");
setSize(250, 250);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

}