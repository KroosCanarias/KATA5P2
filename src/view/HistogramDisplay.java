package view;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import model.*;
public class HistogramDisplay extends ApplicationFrame {

    private final Histogram <String> histogram;
    public HistogramDisplay(Histogram <String> histogram) {
        super("HISTOGRAMA");
        this.histogram=histogram;
        setContentPane(CreatePanel());
        pack();
    }
    private JPanel CreatePanel() {
        ChartPanel chartPanel =  new ChartPanel(CreateChart(CreateDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    private JFreeChart CreateChart(DefaultCategoryDataset dataSet){
        JFreeChart chart=ChartFactory.createBarChart("Histograma JFreeChart",
                "Dominios Email","Numero de correos",dataSet,PlotOrientation.VERTICAL,
                false,false,rootPaneCheckingEnabled);
        return chart;
    }
    private DefaultCategoryDataset CreateDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (String key : histogram.keySet())dataSet.addValue(histogram.get(key),"",key);
        
        return dataSet;   
    }
    public void execute(){
        setVisible(true);
    }
}
