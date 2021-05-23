import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class imageoperation 
{
    
    public static void operate(int key)
    {
            JFileChooser filechooser=new JFileChooser();
            filechooser.showOpenDialog(null);
           File file=filechooser.getSelectedFile(); 
        
      //  file FileInputstream
        try{

            FileInputStream fis=new FileInputStream(file);
            byte[] data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }

        // file outputstream

            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"done");

        }catch(Exception e)
        {
            e.printStackTrace();
        } 
    }     
    public static void main(String[] args) {
    
        System.out.println("processing");

        JFrame f=new JFrame();
        f.setTitle("Image Encrption & Decryption");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font=new Font("Helvetica",Font.BOLD,25);

        //creating button
         
        JButton button=new JButton();
        button.setText("open image");
        button.setFont(font);

        //creating text field

        JTextField textfield=new JTextField(10);
        textfield.setFont(font);
        f.setLayout(new FlowLayout());

        button.addActionListener(e->{ 
            System.out.println("button clicked");
           String text=textfield.getText();
           int temp=Integer.parseInt(text);
           operate(temp);

        }); 

        f.add(button);
        f.add(textfield); 

        f.setVisible(true); 
        
    }

}