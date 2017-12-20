/*
 */
package lapr.project.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lapr.project.controller.EditProjectController;

/**
 *
 * @author pc asus
 */
public class EditProjectUI extends javax.swing.JDialog {

    private static final long serialVersionUID = 1;
    private EditProjectController controller;

    /**
     * Creates new form EditProjectUI
     */
    public EditProjectUI(JFrame parent) {
        super(parent,true);
        initComponents();
        controller = new EditProjectController();
        if (controller.getActiveProject() == null) {
            JOptionPane.showMessageDialog(this, "There is not an active project at the moment.\nPress OK to close");
            
        } else {
            jtf_currentProject.setText(controller.getActiveProjectName());
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

        jl_name = new javax.swing.JLabel();
        jl_description = new javax.swing.JLabel();
        jtf_name = new javax.swing.JTextField();
        jtf_description = new javax.swing.JTextField();
        jb_save = new javax.swing.JButton();
        jb_cancel = new javax.swing.JButton();
        jl_name1 = new javax.swing.JLabel();
        jtf_currentProject = new javax.swing.JTextField();
        btn_roads = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Project");

        jl_name.setText("Name:");

        jl_description.setText("Description:");

        jb_save.setText("Save");
        jb_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_saveActionPerformed(evt);
            }
        });

        jb_cancel.setText("Cancel");
        jb_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelActionPerformed(evt);
            }
        });

        jl_name1.setText("Current Project:");

        jtf_currentProject.setEditable(false);

        btn_roads.setText("New Roads");

        jButton2.setText("New Vehicles");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jb_cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_save))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jl_name)
                            .addComponent(jl_description)
                            .addComponent(jl_name1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_name)
                            .addComponent(jtf_description)
                            .addComponent(jtf_currentProject, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_roads)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addComponent(jButton2)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_name1)
                    .addComponent(jtf_currentProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_name))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_description)
                    .addComponent(jtf_description, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_roads)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_save)
                    .addComponent(jb_cancel))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_jb_cancelActionPerformed

    private void jb_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_saveActionPerformed
        String nameProject = jtf_name.getText();
        String descriptionProject = jtf_description.getText();
        if (nameProject.isEmpty() || descriptionProject.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill the project title or description");
            jtf_name.setText("");
            jtf_description.setText("");
        } else {
            controller.editNewProject(nameProject, descriptionProject);
        }
        dispose();
    }//GEN-LAST:event_jb_saveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_roads;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jb_cancel;
    private javax.swing.JButton jb_save;
    private javax.swing.JLabel jl_description;
    private javax.swing.JLabel jl_name;
    private javax.swing.JLabel jl_name1;
    private javax.swing.JTextField jtf_currentProject;
    private javax.swing.JTextField jtf_description;
    private javax.swing.JTextField jtf_name;
    // End of variables declaration//GEN-END:variables
}
