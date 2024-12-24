/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package featurehub;

/**
 *
 * @author daved
 */

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.title.TextTitle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class FrmVisualization extends javax.swing.JFrame {
    private final Map<String, Integer> departmentData;
    private final Map<String, Integer> yearData;
    private final Map<String, Integer> genderData;
    private final Map<String, Integer> regionData;
    private final JPanel mainPanel;
    private final JPanel chartsPanel;
    private String username;
   
    
    /**
     * Creates new form VisualizationFrame
     * @param username
     */
    public FrmVisualization(String username) {
        initComponents();
        this.username = username;
         // Initialize data structures
        departmentData = new HashMap<>();
        yearData = new HashMap<>();
        genderData = new HashMap<>();
        regionData = new HashMap<>();
        
        // Load initial data
        loadSampleData();
        
        // Setting JFrame properties
        setupFrame();
        
        // Create main panel with BorderLayout
        mainPanel = new JPanel(new BorderLayout());
        
        // Create charts panel
        chartsPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        chartsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Add charts
        chartsPanel.add(createBarChartPanel());
        chartsPanel.add(createPieChartPanel());
        chartsPanel.add(createBarChartPanel2());
        chartsPanel.add(createPieChartPanel2());
        
        // Add panels to main panel
        mainPanel.add(createHeaderPanel(), BorderLayout.NORTH);
        mainPanel.add(chartsPanel, BorderLayout.CENTER);
        mainPanel.add(createControlPanel(), BorderLayout.SOUTH);
        
        // Add main panel to frame
        setContentPane(mainPanel);
    }

    private FrmVisualization() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   private void setupFrame() {
        setTitle("LSPU SPCC Enrollment Monitoring System");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 102, 204));
        headerPanel.setPreferredSize(new Dimension(getWidth(), 60));
        
        JLabel titleLabel = new JLabel("LSPU SPCC Enrollment Dashboard");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);
        
        return headerPanel;
    }
    
    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(new Color(240, 240, 240));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        
        JButton backButton = new JButton("Back");
        
       
        
        
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // Close the current FrmVisualization frame and open FrmDashboard
                FrmVisualization.this.dispose();  // Close FrmVisualization
                FrmDashboard frmdashboard = new FrmDashboard(username);
                frmdashboard.setVisible(true);
               
            }
        });
        
       
        controlPanel.add(backButton);
        
        return controlPanel;
    }
    
    private void loadSampleData() {
        // Department data
        departmentData.put("CCS", 200);
        departmentData.put("CCJE", 150);
        departmentData.put("CTE", 180);
        departmentData.put("COE", 220);
        departmentData.put("CAS", 160);
        departmentData.put("HRM", 140);
        
        // Year data
        yearData.put("2022", 500);
        yearData.put("2023", 600);
        yearData.put("2024", 650);
        
        // Gender data
        genderData.put("Male", 400);
        genderData.put("Female", 350);
        
        // Region data
        regionData.put("Urban", 450);
        regionData.put("Rural", 300);
    }
    
    private JFreeChart createBarChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : departmentData.entrySet()) {
            dataset.addValue(entry.getValue(), "Enrollment", entry.getKey());
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
                "Enrollment by Department", 
                "Department", 
                "Number of Students",
                dataset, 
                PlotOrientation.VERTICAL, 
                true, true, false);
        
        customizeChart(chart);
        customizeBarPlot((CategoryPlot) chart.getPlot());
        
        return chart;
    }
    
    private JFreeChart createBarChart2() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : yearData.entrySet()) {
            dataset.addValue(entry.getValue(), "Enrollment", entry.getKey());
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
                "Enrollment Trends by Year", 
                "Year", 
                "Number of Students",
                dataset, 
                PlotOrientation.VERTICAL, 
                true, true, false);
        
        customizeChart(chart);
        customizeBarPlot((CategoryPlot) chart.getPlot());
        
        return chart;
    }
    
    private JFreeChart createPieChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Map.Entry<String, Integer> entry : genderData.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        
        JFreeChart chart = ChartFactory.createPieChart(
                "Gender Distribution", 
                dataset, 
                true, true, false);
        
        customizeChart(chart);
        customizePiePlot((PiePlot) chart.getPlot());
        
        return chart;
    }
    
    private JFreeChart createPieChart2() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Map.Entry<String, Integer> entry : regionData.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        
        JFreeChart chart = ChartFactory.createPieChart(
                "Regional Distribution", 
                dataset, 
                true, true, false);
        
        customizeChart(chart);
        customizePiePlot((PiePlot) chart.getPlot());
        
        return chart;
    }
    
    private void customizeChart(JFreeChart chart) {
        chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setFont(new Font("Arial", Font.BOLD, 16));
        chart.addSubtitle(new TextTitle("LSPU SPCC", 
                new Font("Arial", Font.ITALIC, 12)));
    }
    
    private void customizeBarPlot(CategoryPlot plot) {
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.GRAY);
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(0, 102, 204));
    }
    
    private void customizePiePlot(PiePlot plot) {
        plot.setBackgroundPaint(Color.WHITE);
        plot.setLabelFont(new Font("Arial", Font.PLAIN, 12));
        plot.setLabelBackgroundPaint(new Color(255, 255, 255, 220));
    }
    
    private JPanel createBarChartPanel() {
        ChartPanel chartPanel = new ChartPanel(createBarChart());
        chartPanel.setPreferredSize(new Dimension(500, 300));
        return chartPanel;
    }
    
    private JPanel createBarChartPanel2() {
        ChartPanel chartPanel = new ChartPanel(createBarChart2());
        chartPanel.setPreferredSize(new Dimension(500, 300));
        return chartPanel;
    }
    
    private JPanel createPieChartPanel() {
        ChartPanel chartPanel = new ChartPanel(createPieChart());
        chartPanel.setPreferredSize(new Dimension(500, 300));
        return chartPanel;
    }
    
    private JPanel createPieChartPanel2() {
        ChartPanel chartPanel = new ChartPanel(createPieChart2());
        chartPanel.setPreferredSize(new Dimension(500, 300));
        return chartPanel;
    }
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVisualization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
         try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVisualization().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
