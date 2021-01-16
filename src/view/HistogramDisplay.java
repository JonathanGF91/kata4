package view;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class HistogramDisplay extends ApplicationFrame{

    private final Histogram<String> histogram;
    
    public HistogramDisplay(String title, Histogram<String> histogram) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }
    
    public void Execute(){
        this.setVisible(true);
    }
    
    public JPanel createPanel(){
        ChartPanel charPanel = new ChartPanel(createChart(createDataset()));
        charPanel.setPreferredSize(new Dimension(500,400));
        return charPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("JFREEChart Histogram",
                                                        "email domine",
                                                        "nº email",
                                                        dataSet,
                                                        PlotOrientation.VERTICAL,
                                                        false,
                                                        false,
                                                        rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
    
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for (String key : histogram.keySet()){
            dataSet.addValue(histogram.get(key), "", key);
        }
        return dataSet;
    }
}
