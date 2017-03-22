/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapplication;

import com.sun.glass.events.KeyEvent;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author anony
 */
public class ChatClient extends javax.swing.JFrame {

    /**
     * Creates new form ChatMain
     */
    String username, serverIP = "127.0.0.1";
    int Port = 5000;
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    ArrayList<String> userList = new ArrayList();
    Boolean isConnected = false;
    String chatlog = "";
    String key = "Bar12345Bar12345";
    String initVector = "RandomInitVector";
    /** Creates new form Chat */
    public ChatClient() {
        initComponents();
        chatTextArea.setContentType("text/html");
    }

    public class IncomingReader implements Runnable{
        public void run() {
            String[] data;
            String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat", file = "File";
            
            try {
                while ((stream = reader.readLine()) != null) {
                    data = stream.split("¥");
                     if (data[2].equals(chat)) {
                         String temp;
                         if (data[1].contains("has connected") == false) {
                            temp = AESCrypto.decrypt(key, initVector, data[1]);
                         }
                         else temp = data[1];
                         /*
                         if (data[1].contains(":)") && data[1].contains(":))") == false && data[1].contains(":)]") == false)   
                             data[1] = data[1].replace(":)", "<img src = " + getClass().getResource("/image/1.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains(":(") && data[1].contains(":((") == false)   
                             data[1] = data[1].replace(":(", "<img src = " + getClass().getResource("/image/2.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains(";)") && data[1].contains(";;)") == false)   
                             data[1] = data[1].replace(";)", "<img src = " + getClass().getResource("/image/3.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains(":D") && data[1].contains(">:D<") == false)   
                             data[1] = data[1].replace(":D", "<img src = " + getClass().getResource("/image/4.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains(";;)"))   
                             data[1] = data[1].replace(";;)", "<img src = " + getClass().getResource("/image/5.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains(">:D<"))   
                             data[1] = data[1].replace(">:D<", "<img src = " + getClass().getResource("/image/6.gif") + " width = '50' height = '20'> &nbsp;");
                         if (data[1].contains(":-/"))   
                             data[1] = data[1].replace(":-/", "<img src = " + getClass().getResource("/image/7.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains(":x"))   
                             data[1] = data[1].replace(":x", "<img src = " + getClass().getResource("/image/8.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains(":\">"))   
                             data[1] = data[1].replace(":\">", "<img src = " + getClass().getResource("/image/9.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains(":P"))
                             data[1] = data[1].replace(":P", "<img src = " + getClass().getResource("/image/10.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains(":-*"))
                             data[1] = data[1].replace(":-*", "<img src = " + getClass().getResource("/image/11.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains("=(("))
                             data[1] = data[1].replace("=((", "<img src = " + getClass().getResource("/image/12.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains(":-O"))
                             data[1] = data[1].replace(":-O", "<img src = " + getClass().getResource("/image/13.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains("X("))
                             data[1] = data[1].replace("X(", "<img src = " + getClass().getResource("/image/14.gif") + " width = '40' height = '20'> &nbsp;");
                         if (data[1].contains(":>"))
                             data[1] = data[1].replace(":>", "<img src = " + getClass().getResource("/image/15.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains("B-)"))
                             data[1] = data[1].replace("B-)", "<img src = " + getClass().getResource("/image/16.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains(":-S") && data[1].contains("#:-S") == false)
                             data[1] = data[1].replace(":-S", "<img src = " + getClass().getResource("/image/17.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains("#:-S"))
                             data[1] = data[1].replace("#:-S", "<img src = " + getClass().getResource("/image/18.gif") + " width = '40' height = '20'> &nbsp;");
                         if (data[1].contains(">:)"))
                             data[1] = data[1].replace(">:)", "<img src = " + getClass().getResource("/image/19.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains(":(("))
                             data[1] = data[1].replace(":((", "<img src = " + getClass().getResource("/image/20.gif") + " width = '25' height = '20'> &nbsp;");
                         if (data[1].contains(":))"))
                             data[1] = data[1].replace(":))", "<img src = " + getClass().getResource("/image/21.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains(":|"))
                             data[1] = data[1].replace(":|", "<img src = " + getClass().getResource("/image/22.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains("/:)"))
                             data[1] = data[1].replace("/:)", "<img src = " + getClass().getResource("/image/23.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains("=))"))
                             data[1] = data[1].replace("=))", "<img src = " + getClass().getResource("/image/24.gif") + " width = '40' height = '20'> &nbsp;");
                         if (data[1].contains("O:-)"))
                             data[1] = data[1].replace("O:-)", "<img src = " + getClass().getResource("/image/25.gif") + " width = '40' height = '20'> &nbsp;");
                         if (data[1].contains(":-B"))
                             data[1] = data[1].replace(":-B", "<img src = " + getClass().getResource("/image/26.gif") + " width = '40' height = '20'> &nbsp;");
                         if (data[1].contains("=;"))
                             data[1] = data[1].replace("=;", "<img src = " + getClass().getResource("/image/27.gif") + " width = '20' height = '20'> &nbsp;");
                         if (data[1].contains(":-c"))
                             data[1] = data[1].replace(":-c", "<img src = " + getClass().getResource("/image/101.gif") + " width = '40' height = '20'> &nbsp;");
                         if (data[1].contains(":)]"))
                             data[1] = data[1].replace(":)]", "<img src = " + getClass().getResource("/image/100.gif") + " width = '40' height = '20'> &nbsp;");
                         if (data[1].contains("~X("))
                             data[1] = data[1].replace("~X(", "<img src = " + getClass().getResource("/image/102.gif") + " width = '50' height = '20'> &nbsp;");
                         */
                         
                         String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
                         String avatarURL = avatarTextField.getText();                         
                         if (data[0].equals(usernameField.getText())) { 
                            if (IsMatch(avatarURL,regex))
                                data[0] = "<img src = "+ avatarURL +" width = '60' height = '60'> &nbsp;"+data[0];
                            else 
                                data[0] = "<img src = " +  getClass().getResource("/image/no-avatar.png") + " width = '60' height = '60'> &nbsp;" + data[0];
                            if (IsMatch(temp,regex)) {
                                temp = "<a href='" + temp + "'target='_blank'><img src = "+temp+" width = '400' height = '250'></a>";                                
                                chatlog += "<font size= '6' color= 'blue'>" + data[0] + "</font>" + ": " + temp + "\n";
                            }
                            else 
                                chatlog += "<font size= '6' color= 'blue'>" + data[0] + "</font>" + ": " + "<font size= '5' color= 'black'>" + temp + "</font>" + "\n";
                         } 
                         else {
                            data[0] = "<img src = " +  getClass().getResource("/image/no-avatar.png") + " width = '60' height = '60'> &nbsp;" + data[0];
                            chatlog += "<font size= '6' color= 'red'>" + data[0] + "</font>" + ": " + "<font size= '5' color= 'black'>" + temp + "</font>" + "\n";
                         }
                         chatTextArea.setText(chatlog.replace("\n","<br />"));
                         chatTextArea.setCaretPosition(chatTextArea.getDocument().getLength());                        
                      
                    } else if (data[2].equals(connect)){

                        //chatTextArea.removeAll();
                        userAdd(data[0]);

                    } else if (data[2].equals(disconnect)) {

                        userRemove(data[0]);

                    } else if (data[2].equals(done)) {


                        usersList.setText("");
                        writeUsers();
                        userList.clear();

                    }
                }
           }catch(Exception ex) {
           }
        }
    }

    public void ListenThread() {
         Thread IncomingReader = new Thread(new IncomingReader());
         IncomingReader.start();
    }

    public void userAdd(String data) {
         userList.add(data);

     }

    public void userRemove(String data) {
         chatlog += "<img src = " +  getClass().getResource("/image/admin.jpg") + " width = '60' height = '60'> &nbsp;" + "<font size= '6' color= 'blue'>System: </font>" + data + "<font size= '5' color= 'black'> has disconnected.\n </font>";
          chatTextArea.setText(chatlog.replace("\n","<br />"));
         //chatTextArea.setText(data + " has disconnected.\n");
     }

    public void writeUsers() {
         String[] tempList = new String[(userList.size())];
         userList.toArray(tempList);
         for (String token:tempList) {

             usersList.append(token + "\n");

         }

     }

    public void sendDisconnect() {

       String bye = (username + "¥ ¥Disconnect");
        try{
            writer.println(bye); // Sends server the disconnect signal.
            writer.flush(); // flushes the buffer
        } catch (Exception e) {
            chatlog += "<img src = " +  getClass().getResource("/image/admin.jpg") + " width = '60' height = '60'> &nbsp;" + "<font size= '6' color= 'blue'>System: </font>" + "<font size= '5' color= 'black'> Could not send Disconnect message.\n </font>";
            chatTextArea.setText(chatlog.replace("\n","<br />"));
            //chatTextArea.setText(chatTextArea.getText() + "Could not send Disconnect message.\n"); //sua cai nay thanh html?
        }

    } 

    public void Disconnect() {

        try {
               chatlog += "<img src = " +  getClass().getResource("/image/admin.jpg") + " width = '60' height = '60'> &nbsp;" + "<font size= '6' color= 'blue'>System: </font>" + "<font size= '5' color= 'black'> You has Disconnected.\n </font>";
               chatTextArea.setText(chatlog.replace("\n","<br />"));
               //chatTextArea.setText(chatTextArea.getText() + "Disconnected.\n");
               sock.close();
        } catch(Exception ex) {
               chatlog += "<img src = " +  getClass().getResource("/image/admin.jpg") + " width = '60' height = '60'> &nbsp;" + "<font size= '6' color= 'blue'>System: </font>" + "<font size= '5' color= 'black'> Failed to disconnect. \n </font>";
               chatTextArea.setText(chatlog.replace("\n","<br />"));
              //chatTextArea.setText(chatTextArea.getText() + "Failed to disconnect. \n");
        }
        isConnected = false;
        usernameField.setEditable(true);
        usersList.setText("");

      }
    
     public boolean IsMatch(String s, String pattern) {
        try {
            Pattern patt = Pattern.compile(pattern);
            Matcher matcher = patt.matcher(s);
            return matcher.matches();
        } 
        catch (RuntimeException e) {
            return false;
        }
    }  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();
        usersList = new javax.swing.JTextArea();
        inputTextArea = new java.awt.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatTextArea = new javax.swing.JEditorPane();
        jLabel4 = new javax.swing.JLabel();
        avatarTextField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exitMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Username");

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Online Users");
        jLabel3.setToolTipText("");

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        usersList.setEditable(false);
        usersList.setColumns(20);
        usersList.setRows(5);

        inputTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputTextAreaKeyPressed(evt);
            }
        });

        chatTextArea.setEditable(false);
        chatTextArea.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(chatTextArea);

        jLabel4.setText("Avatar");

        jMenu1.setText("File");

        exitMenu.setText("Exit");
        jMenu1.add(exitMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(disconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(avatarTextField))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(usersList))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(usersList))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(usernameField)
                                .addComponent(connectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(disconnectButton)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(avatarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        // TODO add your handling code here:
            if (isConnected == false) {
            username = usernameField.getText();
            usernameField.setEditable(false);

            try {
                sock = new Socket(serverIP, Port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println(username + "¥has connected.¥Connect"); // Displays to everyone that user connected.
                writer.flush(); // flushes the buffer
                isConnected = true; // Used to see if the client is connected.
            } catch (Exception ex) {
                chatlog += "<img src = " +  getClass().getResource("/image/admin.jpg") + " width = '60' height = '60'> &nbsp;" + "<font size= '6' color= 'blue'>System: </font>" + "<font size= '5' color= 'black'> Cannot Connect! Try Again. \n </font>";
                chatTextArea.setText(chatlog.replace("\n","<br />"));
                //chatTextArea.setText(chatTextArea.getText() + "Cannot Connect! Try Again. \n");
                usernameField.setEditable(true);
            }
            ListenThread();
        } else if (isConnected == true) {
            chatlog += "<img src = " +  getClass().getResource("/image/admin.jpg") + " width = '60' height = '60'> &nbsp;" + "<font size= '6' color= 'blue'>System: </font>" + "<font size= '5' color= 'black'> You are already connected. \n </font>";
            chatTextArea.setText(chatlog.replace("\n","<br />"));
            //chatTextArea.setText(chatTextArea.getText() + "You are already connected. \n");
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:
        String nothing = "";
        if ((inputTextArea.getText()).equals(nothing)) {
            inputTextArea.setText("");
            inputTextArea.requestFocus();
        } else {
            try {
               String encrypted = AESCrypto.encrypt(key, initVector, inputTextArea.getText());
               writer.println(username + "¥" + encrypted + "¥" + "Chat");
               writer.flush(); // flushes the buffer
            } catch (Exception ex) {
                chatlog += "<img src = " +  getClass().getResource("/image/admin.jpg") + " width = '60' height = '60'> &nbsp;" + "<font size= '6' color= 'blue'>System: </font>" + "<font size= '5' color= 'black'> Message was not sent. \n </font>";
                chatTextArea.setText(chatlog.replace("\n","<br />"));
                //chatTextArea.setText(chatTextArea.getText() + "Message was not sent. \n");
            }
            inputTextArea.setText("");
            inputTextArea.requestFocus();
        }

        inputTextArea.setText("");
        inputTextArea.requestFocus();
    }//GEN-LAST:event_sendButtonActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        // TODO add your handling code here:
        sendDisconnect();
        Disconnect();
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void inputTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTextAreaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String nothing = "";
            if ((inputTextArea.getText()).equals(nothing)) {
                inputTextArea.setText("");
                inputTextArea.requestFocus();
            } else {
                try {      
                    String encrypted = AESCrypto.encrypt(key, initVector, inputTextArea.getText());
                    writer.println(username + "¥" + encrypted + "¥" + "Chat");
                    writer.flush(); // flushes the buffer
                } catch (Exception ex) {
                    chatlog += "<img src = " +  getClass().getResource("/image/admin.jpg") + " width = '60' height = '60'> &nbsp;" + "<font size= '6' color= 'blue'>System: </font>" + "<font size= '5' color= 'black'> Message was not sent. \n </font>";
                    chatTextArea.setText(chatlog.replace("\n","<br />"));
                    //chatTextArea.setText(chatTextArea.getText() + "Message was not sent. \n");
                }
                inputTextArea.setText("");
                inputTextArea.requestFocus();
            }

            inputTextArea.setText("");
            inputTextArea.requestFocus();
        }
    }//GEN-LAST:event_inputTextAreaKeyPressed
                                
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField avatarTextField;
    private javax.swing.JEditorPane chatTextArea;
    private javax.swing.JButton connectButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JFileChooser fileChooser;
    private java.awt.TextField inputTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JTextArea usersList;
    // End of variables declaration//GEN-END:variables
}
