/*
 */
package lapr.project.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import lapr.project.controller.OpenProjectController;
import lapr.project.model.Project;
import lapr.project.utils.Session;

/**
 *
 * @author pc asus
 */
public class OpenProjectUI extends javax.swing.JDialog {

    private static final long serialVersionUID = 1;

    private final OpenProjectController controller;
    private DefaultComboBoxModel<String> projectComboBox = new DefaultComboBoxModel<>();

    /**
     * Creates new form OpenProjectUI
     *
     * @param parent
     * @param modal
     */
    public OpenProjectUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        controller = new OpenProjectController();

        List<String> projectsList = new ArrayList<>();
        try {
            projectsList = controller.getProjects();
        } catch (SQLException ex) {
            Logger.getLogger(OpenProjectUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Oops, something went wrong!\n\nVerify the project is functional.", "Loading Error", JOptionPane.ERROR_MESSAGE);
        }

        for (String p : projectsList) {
            projectComboBox.addElement(p);
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlProjects = new javax.swing.JLabel();
        jcb_projects = new javax.swing.JComboBox<>();
        jbSave = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Open Project");

        jlProjects.setText("Projects:");

        jcb_projects.setModel(projectComboBox);

        jbSave.setText("Save");
        jbSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSaveActionPerformed(evt);
            }
        });

        jbCancel.setText("Cancel");
        jbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlProjects)
                        .addContainerGap(154, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcb_projects, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jbSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbCancel)))
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jlProjects)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcb_projects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancel)
                    .addComponent(jbSave))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaveActionPerformed
        try {
            String proj = projectComboBox.getSelectedItem().toString();
            controller.setActiveProject(proj);
            Project p = Session.getActiveProject();
            String message = String.format("Loaded: \n%s roads\n %s sections\n %s junctions\n %s vehicles", p.getListRoads().size(), p.getRoadNetwork().numEdges(), p.getRoadNetwork().numVertices(), p.getListVehicles().size());
            JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(OpenProjectUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Couldn't load the selected project.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbSaveActionPerformed

    private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbSave;
    private javax.swing.JComboBox<String> jcb_projects;
    private javax.swing.JLabel jlProjects;
    // End of variables declaration//GEN-END:variables
}
