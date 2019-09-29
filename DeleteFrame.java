import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DeleteFrame extends JFrame{
Container c;
JLabel lblRno;
JTextField txtRno;
JButton btnDelete, btnBack;

DeleteFrame(){
c = getContentPane();
c.setLayout(new FlowLayout());

lblRno = new JLabel("Enter Rno ");
txtRno = new JTextField(10);
btnDelete = new JButton("DELETE");
btnBack = new JButton("BACK");

c.add(lblRno);
c.add(txtRno);
c.add(btnDelete);
c.add(btnBack);

btnDelete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
try{
String rno = txtRno.getText();
if((rno == null) || (Integer.parseInt(rno) < 0)){
JOptionPane.showMessageDialog(new JDialog()," Enter Numbers  " );
txtRno.setText("");
txtRno.requestFocus();
}
else{
DbHandler db = new DbHandler();
db.deleteStudent(Integer.parseInt(rno));
txtRno.setText("");
txtRno.requestFocus();
}
}catch(NumberFormatException ne){
JOptionPane.showMessageDialog(new JDialog()," Enter Numbers  " );
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

setTitle("Delete Student ");
setSize(250, 250);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

}