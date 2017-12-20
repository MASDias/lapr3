/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import lapr.project.controller.MockUpController;
import lapr.project.model.Project;

/**
 *
 * @author MarioDias
 */
public class Mockup extends javax.swing.JFrame {

    private static final long serialVersionUID = 1;

    protected Project m_project;
    private JFileChooser m_jfc;
    private MockUpController controller;

    /**
     * Creates new form Mockup
     */
    public Mockup() {
        initComponents();
        controller = new MockUpController();
        initFileChooser();
    }

    public void initFileChooser() {
        m_jfc = new JFileChooser();
        FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("HTML files (*.html)", "html");
        m_jfc.setFileFilter(xmlfilter);
        m_jfc.setCurrentDirectory(new File(System.getProperty("user.dir")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        itemProject = new javax.swing.JMenu();
        menuItemCreateProject = new javax.swing.JMenuItem();
        menuItemOpenProject = new javax.swing.JMenuItem();
        itemProjectEditProject = new javax.swing.JMenuItem();
        itemProjectCopyProject = new javax.swing.JMenuItem();
        menuNetworkAnalysis = new javax.swing.JMenu();
        menuItemBestPath = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuResults = new javax.swing.JMenu();
        menuItemSave = new javax.swing.JMenu();
        menuItemExportShow = new javax.swing.JMenu();
        subMenuItemExport = new javax.swing.JMenu();
        subMenuItemExportCSV = new javax.swing.JMenu();
        subItemMenuShow = new javax.swing.JMenu();
        menuItemFile = new javax.swing.JMenu();
        exportHTML = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        googleMenuItem = new javax.swing.JMenuItem();

        jCheckBox1.setText("jCheckBox1");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lapr_wallpaper.jpg"))); // NOI18N

        itemProject.setText("Project");

        menuItemCreateProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon.png"))); // NOI18N
        menuItemCreateProject.setText("Create project");
        menuItemCreateProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCreateProjectActionPerformed(evt);
            }
        });
        itemProject.add(menuItemCreateProject);

        menuItemOpenProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/open_icon.png"))); // NOI18N
        menuItemOpenProject.setText("Open project");
        menuItemOpenProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOpenProjectActionPerformed(evt);
            }
        });
        itemProject.add(menuItemOpenProject);

        itemProjectEditProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit_icon.png"))); // NOI18N
        itemProjectEditProject.setText("Edit project");
        itemProjectEditProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProjectEditProjectActionPerformed(evt);
            }
        });
        itemProject.add(itemProjectEditProject);

        itemProjectCopyProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/copy_icon.png"))); // NOI18N
        itemProjectCopyProject.setText("Copy project");
        itemProjectCopyProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProjectCopyProjectActionPerformed(evt);
            }
        });
        itemProject.add(itemProjectCopyProject);

        jMenuBar1.add(itemProject);

        menuNetworkAnalysis.setText("Network Analysis");

        menuItemBestPath.setText("Shortest/Best path");
        menuNetworkAnalysis.add(menuItemBestPath);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fastest_icon.png"))); // NOI18N
        jMenuItem4.setText("Fastest Path");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuNetworkAnalysis.add(jMenuItem4);

        jMenuBar1.add(menuNetworkAnalysis);

        menuResults.setText("Results");

        menuItemSave.setText("Save current results into project");
        menuResults.add(menuItemSave);

        menuItemExportShow.setText("Export/Show");

        subMenuItemExport.setText("Export HTML");
        menuItemExportShow.add(subMenuItemExport);

        subMenuItemExportCSV.setText("Export CSV");
        menuItemExportShow.add(subMenuItemExportCSV);

        subItemMenuShow.setText("Show results");
        menuItemExportShow.add(subItemMenuShow);

        menuResults.add(menuItemExportShow);

        jMenuBar1.add(menuResults);

        menuItemFile.setText("File");

        exportHTML.setIcon(new javax.swing.ImageIcon(getClass().getResource("/html_icon.png"))); // NOI18N
        exportHTML.setText("Export Project");
        exportHTML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportHTMLActionPerformed(evt);
            }
        });
        menuItemFile.add(exportHTML);

        jMenuBar1.add(menuItemFile);

        menuHelp.setText("Help");

        googleMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/google_icon.png"))); // NOI18N
        googleMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                googleMenuItemActionPerformed(evt);
            }
        });
        menuHelp.add(googleMenuItem);

        jMenuBar1.add(menuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemOpenProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOpenProjectActionPerformed
        OpenProjectUI ui = new OpenProjectUI(this, rootPaneCheckingEnabled);
        ui.setLocationRelativeTo(this);
        ui.setVisible(true);
    }//GEN-LAST:event_menuItemOpenProjectActionPerformed

    private void itemProjectEditProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProjectEditProjectActionPerformed
        new EditProjectUI(this).setVisible(true);
    }//GEN-LAST:event_itemProjectEditProjectActionPerformed

    private void itemProjectCopyProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProjectCopyProjectActionPerformed
        CopyProjectUI ui = new CopyProjectUI(this, rootPaneCheckingEnabled);
        ui.setLocationRelativeTo(this);
        ui.setVisible(true);
    }//GEN-LAST:event_itemProjectCopyProjectActionPerformed

    private void menuItemCreateProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCreateProjectActionPerformed
        new CreateProjectUI(this).setVisible(true);
    }//GEN-LAST:event_menuItemCreateProjectActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new FastestPathUI().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void googleMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_googleMenuItemActionPerformed
        openWebPage("https://www.google.pt/");
    }//GEN-LAST:event_googleMenuItemActionPerformed

    private void exportHTMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportHTMLActionPerformed
        int returnvalue = m_jfc.showOpenDialog(this);
        if (returnvalue == JFileChooser.APPROVE_OPTION) {
            File file = m_jfc.getSelectedFile();
            controller.exportHTML(file.getPath());
            JOptionPane.showMessageDialog(this, "Project exported with success.", "Project Export", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_exportHTMLActionPerformed

    private void openWebPage(String url) {
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }

    protected void setProject(Project p) {
        this.m_project = p;
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Mockup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Mockup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Mockup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Mockup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Mockup().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exportHTML;
    private javax.swing.JMenuItem googleMenuItem;
    private javax.swing.JMenu itemProject;
    private javax.swing.JMenuItem itemProjectCopyProject;
    private javax.swing.JMenuItem itemProjectEditProject;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenu menuItemBestPath;
    private javax.swing.JMenuItem menuItemCreateProject;
    private javax.swing.JMenu menuItemExportShow;
    private javax.swing.JMenu menuItemFile;
    private javax.swing.JMenuItem menuItemOpenProject;
    private javax.swing.JMenu menuItemSave;
    private javax.swing.JMenu menuNetworkAnalysis;
    private javax.swing.JMenu menuResults;
    private javax.swing.JMenu subItemMenuShow;
    private javax.swing.JMenu subMenuItemExport;
    private javax.swing.JMenu subMenuItemExportCSV;
    // End of variables declaration//GEN-END:variables
}
