/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexaminationsystem;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import java.io.FileInputStream;
import javax.swing.ButtonGroup;
import java.io.*;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ayush
 */
public class QuestionPane extends javax.swing.JFrame {

    
    /**
     * Creates new form QuestionPane
     */
    
    private static String name;
    private ButtonGroup bg = new ButtonGroup();
    private static int j=0;
    private static int nques;
    private static Questions[] qvector = new Questions[100];
    private static int[] response = new int[100];
    private static long startTime = System.currentTimeMillis(); 
    static
    {
        for(int i=0;i<100;i++)
            response[i]=0;
    }
    
    public QuestionPane(String name) {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.name=name;
        nameLabel.setText("Welcome " + this.name + "!");
        qno.setText("Question 1:");
        
        op1.setText("Option 1");
        op2.setText("Option 2");
        op3.setText("Option 3");
        op4.setText("Option 4");
        bg.add(op1);
        bg.add(op2);
        bg.add(op3);
        bg.add(op4);
        question.setText("This is a question");
        //jTable1.setModel(new DefaultTableModel(this.nques,1));
    }
    public QuestionPane(Questions q,int nques)
    {
        initComponents();
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        prevButton.setBackground(Color.WHITE);
        nextButton.setBackground(Color.WHITE);
        deselectButton.setBackground(Color.WHITE);
        submitButton.setBackground(Color.WHITE);
        submitButton.setForeground(new Color(10,7,158));
        //getContentPane().setBackground(new Color(153,220,204));
        getContentPane().setBackground(Color.WHITE);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        //this.name=name;
        nameLabel.setText("Welcome " + this.name + "!");
        qno.setText("Question "+(this.j+1)+":");
        ButtonGroup bg = new ButtonGroup();
        op1.setText(q.get_o1());
        op2.setText(q.get_o2());
        op3.setText(q.get_o3());
        op4.setText(q.get_o4());
        bg.add(op1);
        bg.add(op2);
        bg.add(op3);
        bg.add(op4);
        question.setText(q.get_ques());
        this.nques=nques;
        JButton[] b = new JButton[nques];
        jPanel1.setLayout(new GridLayout(nques,1));
        ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                //System.out.println(((JButton)e.getSource()));
                for(int i=0;i<nques;i++)
                {
                    if((JButton)e.getSource()==b[i])
                    {
                        //System.out.println(i);
                        if(op1.isSelected())
                        {
                            response[j]=1;
                        }
                        else if(op2.isSelected())
                        {
                            response[j]=2;
                        }
                        else if(op3.isSelected())
                        {
                            response[j]=3;
                        }
                        else if(op4.isSelected())
                        {
                            response[j]=4;
                        }

                        j=i;
                        
                        
                        setVisible(false);
                        new QuestionPane(qvector[j],nques).setVisible(true);
                        
                    }
                }
                
            }
        }
    };
        jPanel1.setBackground(Color.WHITE);
        for(int i=0;i<nques;i++)
        {
            b[i] = new JButton("quesButton"+(i+1));
            b[i].setText("Question "+(i+1));
            b[i].setBackground(Color.WHITE);
            b[i].setFont(new Font(b[i].getFont().getName(),Font.BOLD,b[i].getFont().getSize()));
            if(response[i]==0)
                b[i].setForeground(Color.red);
            b[i].addActionListener(listener);
            jPanel1.add(b[i]);
        }
        
        
        if(response[j]==1)
            op1.setSelected(true);
        else if(response[j]==2)
            op2.setSelected(true);
        else if(response[j]==3)
            op3.setSelected(true);
        else if(response[j]==4)
            op4.setSelected(true);
        long tconsumed = (System.currentTimeMillis()-this.startTime)/1000;
        long tleft = 1200 - tconsumed;
        if(tleft<=0)
        {
            this.setVisible(false);
            ScoreCard sc = new ScoreCard(this.name,this.get_correct(),this.get_incorrect());
            sc.setVisible(true);
        }
    }
    public static int get_correct()
    {
        int c=0;
        for(int i=0;i<nques;i++)
        {
            System.out.println(response[i]);
            if(qvector[i].get_ans().equals(Integer.toString(response[i])))
                c++;
        }
        return c;
    }
    public static int get_incorrect()
    {
        int ic=0;
        for(int i=0;i<nques;i++)
        {
            if(response[i]!=0 && !qvector[i].get_ans().equals(Integer.toString(response[i])))
                ic++;
        }   
        return ic;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        qno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        question = new javax.swing.JTextArea();
        op1 = new javax.swing.JRadioButton();
        op2 = new javax.swing.JRadioButton();
        op3 = new javax.swing.JRadioButton();
        op4 = new javax.swing.JRadioButton();
        nextButton = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        deselectButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));

        qno.setFont(new java.awt.Font("Bitstream Charter", 1, 18)); // NOI18N
        qno.setText("Question 1:");

        question.setEditable(false);
        question.setColumns(20);
        question.setFont(new java.awt.Font("Rekha", 0, 18)); // NOI18N
        question.setRows(5);
        question.setText("This is a question.");
        question.setWrapStyleWord(true);
        question.setAutoscrolls(false);
        jScrollPane1.setViewportView(question);

        op1.setFont(new java.awt.Font("Abyssinica SIL", 1, 15)); // NOI18N
        op1.setText("Option 1");
        op1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op1ActionPerformed(evt);
            }
        });

        op2.setFont(new java.awt.Font("Abyssinica SIL", 1, 15)); // NOI18N
        op2.setText("Option 2");

        op3.setFont(new java.awt.Font("Abyssinica SIL", 1, 15)); // NOI18N
        op3.setText("Option 3");

        op4.setFont(new java.awt.Font("Abyssinica SIL", 1, 15)); // NOI18N
        op4.setText("Option 4");

        nextButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        nextButton.setIcon(new javax.swing.ImageIcon("/home/ayush/SoftwareLab/Project/OnlineExaminationSystem/front.jpg")); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        prevButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        prevButton.setIcon(new javax.swing.ImageIcon("/home/ayush/SoftwareLab/Project/OnlineExaminationSystem/back.jpg")); // NOI18N
        prevButton.setText("Previous");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        submitButton.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        submitButton.setText("SubmitTest");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        deselectButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        deselectButton.setText("Deselect");
        deselectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deselectButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/ayush/SoftwareLab/Project/OnlineExaminationSystem/logo.jpg")); // NOI18N

        nameLabel.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(95, 88, 165));
        nameLabel.setText("jLabel3");

        timeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(235, 32, 32));
        timeLabel.setText("Time Left - ");

        jPanel1.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(prevButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(deselectButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nextButton))
                                    .addComponent(submitButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(op1)
                                    .addComponent(op2)
                                    .addComponent(op3)
                                    .addComponent(op4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(qno, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(nameLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(qno)
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(op1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(op2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(op3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(op4)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prevButton)
                            .addComponent(nextButton)
                            .addComponent(deselectButton))
                        .addGap(40, 40, 40)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void op1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_op1ActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        //this.setVisible(false);
        //System.out.println("Correct -> "+this.get_correct() + "Incorrect -> "+this.get_incorrect());
        if(op1.isSelected())
        {
            this.response[this.j]=1;
        }
        else if(op2.isSelected())
        {
            this.response[this.j]=2;
        }
        else if(op3.isSelected())
        {
            this.response[this.j]=3;
        }
        else if(op4.isSelected())
        {
            this.response[this.j]=4;
        }
        ConfirmationClass cc = new ConfirmationClass(this,this.name);
        cc.setVisible(true);
    }//GEN-LAST:event_submitButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        if(op1.isSelected())
        {
            this.response[this.j]=1;
        }
        else if(op2.isSelected())
        {
            this.response[this.j]=2;
        }
        else if(op3.isSelected())
        {
            this.response[this.j]=3;
        }
        else if(op4.isSelected())
        {
            this.response[this.j]=4;
        }
        
        this.j+=1;
        if(this.j>=this.nques)
        {
            //ConfirmationClass cc = new ConfirmationClass(this,this.name);
            //cc.setVisible(true);
            this.j=0;
        }
        if(this.j<this.nques)
        {
            this.setVisible(false);
            new QuestionPane(qvector[this.j],this.nques).setVisible(true);
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        // TODO add your handling code here:
        if(op1.isSelected())
        {
            this.response[this.j]=1;
        }
        else if(op2.isSelected())
        {
            this.response[this.j]=2;
        }
        else if(op3.isSelected())
        {
            this.response[this.j]=3;
        }
        else if(op4.isSelected())
        {
            this.response[this.j]=4;
        }
        
        this.j-=1;
        if(this.j<0)
        {
            //ConfirmationClass cc = new ConfirmationClass(this,this.name);
            //cc.setVisible(true);
            this.j=this.nques-1;
        }
        if(this.j<this.nques)
        {
            this.setVisible(false);
            new QuestionPane(qvector[this.j],this.nques).setVisible(true);
        }
    }//GEN-LAST:event_prevButtonActionPerformed

    private void deselectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deselectButtonActionPerformed
        // TODO add your handling code here:
        //System.out.println("HEre");
        response[this.j]=0;
        /*this.op1.setSelected(false);
        this.op2.setSelected(false);
        this.op3.setSelected(false);
        this.op4.setSelected(false);*/
        this.setVisible(false);
        new QuestionPane(qvector[this.j],this.nques).setVisible(true);
        
    }//GEN-LAST:event_deselectButtonActionPerformed

     public static class Questions
     {
         private String ques,o1,o2,o3,o4,ans;
         public Questions(String ques,String o1,String o2,String o3,String o4,String ans)
         {
             this.ques=ques;
             this.o1=o1;
             this.o2=o2;
             this.o3=o3;
             this.o4=o4;
             this.ans=ans;
         }
         public String get_ques()
         {
             return this.ques;
         }
         public String get_o1()
         {
             return this.o1;
         }
         public String get_o2()
         {
             return this.o2;
         }
         public String get_o3()
         {
             return this.o3;
         }
         public String get_o4()
         {
             return this.o4;
         }
         public String get_ans()
         {
             return this.ans;
         }
     }
     
     static ActionListener updateClockAction = new ActionListener()
     {
         public void actionPerformed(ActionEvent e)
         {
             long tconsumed = (System.currentTimeMillis()-startTime)/1000;
             long tleft = 1200 - tconsumed;
             if(tleft==0)
             {
                 //submitButtonActionPerformed(null);
                 ScoreCard sc = new ScoreCard(name,get_correct(),get_incorrect());
                 sc.setVisible(true);
                 
             }
             else if(tleft>0)
             {
                String hr = String.format("%02d",tleft/3600);
                String min = String.format("%02d",(tleft%3600)/60);
                String sec = String.format("%02d",tleft%60);
                timeLabel.setText("Time Left - "+hr+":"+min+":"+sec);
             }
         }
     };
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuestionPane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuestionPane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuestionPane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuestionPane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new QuestionPane().setVisible(true);
                Timer t = new Timer(1000, updateClockAction);
                t.start();
                int nques=0;
                
                try
                {
                    //String executionPath = System.getProperty("user.dir");
                    //System.out.println(executionPath);
                    //InputStream fin = new FileInputStream("/home/ayush/SoftwareLab/Project/OnlineExaminationSystem/src/onlineexaminationsystem/input_data.txt");
                    InputStream fin = new FileInputStream("input_data.txt");
                    InputStreamReader isr = new InputStreamReader(fin, Charset.forName("UTF-8"));
                    BufferedReader br = new BufferedReader(isr);
            
                    
                    String q,o1,o2,o3,o4,ans;
                    //nques=0;
                    while((q=br.readLine())!=null)
                    {
                        o1=br.readLine();
                        o2=br.readLine();
                        o3=br.readLine();
                        o4=br.readLine();
                        ans=br.readLine();
                        qvector[nques] = new Questions(q,o1,o2,o3,o4,ans);
                        nques++;
                    }
                    /*for(int i=0;i<nques;i++)
                    {
                        System.out.println(qvector[i].get_o1() +" "qvector)
                    }*/
                    //System.out.println(nques);
                }
                catch(IOException e)
                {
                    System.out.println("Error reading Input file" + e);
                }
                new QuestionPane(qvector[0],nques).setVisible(true);
                /*for(int i=0;i<nques;i++)
                {
                    new QuestionPane(qvector[i]).setVisible(true);
                }*/
          
            }
            
            
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deselectButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JRadioButton op1;
    private javax.swing.JRadioButton op2;
    private javax.swing.JRadioButton op3;
    private javax.swing.JRadioButton op4;
    private javax.swing.JButton prevButton;
    private javax.swing.JLabel qno;
    private javax.swing.JTextArea question;
    private javax.swing.JButton submitButton;
    private static javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
