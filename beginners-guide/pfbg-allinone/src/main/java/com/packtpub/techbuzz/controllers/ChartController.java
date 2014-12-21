package com.packtpub.techbuzz.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 * @author K. Siva Prasad Reddy
 * Date : 16-Aug-2013
 */
@ManagedBean
@RequestScoped
public class ChartController implements Serializable
{
	private static final long serialVersionUID = 1L;
	private CartesianChartModel chartModel;
	private CartesianChartModel linearChartModel;
	private LineChartModel areaChartModel;
	private PieChartModel pieChartModel;
	private DonutChartModel donutChartModel;
	private BubbleChartModel bubbleChartModel;
	
	private LineChartModel lineModel1;
    private LineChartModel lineModel2;
		
    @PostConstruct
	public void init()
	{
		initChartModel();
		initLinearChartModel();
		initAreaChartModel();
		initPieChartModel();
		initDonutChartModel();
		initBubbleChartModel();
		
		createLineModels();
		
	}
	
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
 
    public LineChartModel getLineModel2() {
        return lineModel2;
    }
     
    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Linear Chart");
        lineModel1.setLegendPosition("se");
        lineModel1.setExtender("ext");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
         
        lineModel2 = initCategoryModel();
        lineModel2.setTitle("Category Chart");
        lineModel2.setLegendPosition("nw");
        lineModel2.setShowPointLabels(true);
        lineModel2.setAnimate(true);
        lineModel2.setZoom(true);
        lineModel2.setLegendCols(2);
        lineModel2.setBreakOnNull(true);
        lineModel2.setSeriesColors("800000,006400");
        lineModel2.setDatatipFormat(getDatatipFormat());
        
        
        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Years"));
        yAxis = lineModel2.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
        yAxis.setTickAngle(45);
        
    }
     
    private LineChartModel initLinearModel() {
    	LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");
 
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
 
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
 
        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);
 
        model.addSeries(series1);
        model.addSeries(series2);
         
        return model;
    }
     
    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 90);
        girls.set("2008", 120);
 
        model.addSeries(boys);
        model.addSeries(girls);
         
        return model;
    }

	private void initBubbleChartModel()
	{
		bubbleChartModel = new BubbleChartModel();
		bubbleChartModel.add(new BubbleChartSeries("New York", 2010, 180, 80));
		bubbleChartModel.add(new BubbleChartSeries("Texas", 2011, 170, 70));
		bubbleChartModel.add(new BubbleChartSeries("California", 2012, 250, 150));
		bubbleChartModel.add(new BubbleChartSeries("Chicago", 2013, 150, 50));
		
	}

	private void initDonutChartModel()
	{
		donutChartModel = new DonutChartModel();
		Map<String, Number> year2011Circle = new HashMap<String, Number>();
		year2011Circle.put("PrimeFaces", 80);
		year2011Circle.put("jQuery", 350);
		year2011Circle.put("JSF", 50);
		donutChartModel.addCircle(year2011Circle);
		
		Map<String, Number> year2012Circle = new HashMap<String, Number>();
		year2012Circle.put("PrimeFaces", 380);
		year2012Circle.put("jQuery", 60);
		year2012Circle.put("JSF", 320);
		donutChartModel.addCircle(year2012Circle);
		
		Map<String, Number> year2013Circle = new HashMap<String, Number>();
		year2013Circle.put("PrimeFaces", 520);
		year2013Circle.put("jQuery", 230);
		year2013Circle.put("JSF", 180);
		donutChartModel.addCircle(year2013Circle);
		
	}

	private void initPieChartModel()
	{
		pieChartModel = new PieChartModel();
		pieChartModel.set("JSF", 380);
		pieChartModel.set("PrimeFaces", 455);
		pieChartModel.set("jQuery", 202);
		pieChartModel.set("JPA", 180);
	}

	private void initAreaChartModel()
	{

		areaChartModel = new LineChartModel();
		
		LineChartSeries jquerySeries = new LineChartSeries();
		jquerySeries.setLabel("jQuery");
		jquerySeries.setFill(true);
		jquerySeries.set("2009", 80);
		jquerySeries.set("2010", 180);
		jquerySeries.set("2011", 160);
		jquerySeries.set("2012", 320);
		jquerySeries.set("2013", 280);
		
		LineChartSeries primefacesSeries = new LineChartSeries();
		primefacesSeries.setLabel("PrimeFaces");
		primefacesSeries.setFill(true);
		primefacesSeries.set("2009", 150);
		primefacesSeries.set("2010", 250);
		primefacesSeries.set("2011", 300);
		primefacesSeries.set("2012", 240);
		primefacesSeries.set("2013", 400);
		
		areaChartModel.addSeries(jquerySeries);
		areaChartModel.addSeries(primefacesSeries);
	
        areaChartModel.setTitle("Area Chart");
        areaChartModel.setLegendPosition("ne");
        areaChartModel.setStacked(true);
        areaChartModel.setShowPointLabels(true);
        
        Axis xAxis = new CategoryAxis("Years");
        areaChartModel.getAxes().put(AxisType.X, xAxis);
        Axis yAxis = areaChartModel.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
       // yAxis.setMin(0);
       // yAxis.setMax(300);
        
                
	}

	void initChartModel()
	{
		chartModel = new CartesianChartModel();
		
		ChartSeries primefacesSeries = new ChartSeries();
		primefacesSeries.setLabel("PrimeFaces");
		primefacesSeries.set("2009", 150);
		primefacesSeries.set("2010", 250);
		primefacesSeries.set("2011", 300);
		primefacesSeries.set("2012", 240);
		primefacesSeries.set("2013", 400);
		
		ChartSeries jquerySeries = new ChartSeries();
		jquerySeries.setLabel("jQuery");
		jquerySeries.set("2009", 210);
		jquerySeries.set("2010", 150);
		jquerySeries.set("2011", 200);
		//jquerySeries.set("2011", null);
		jquerySeries.set("2012", 280);
		jquerySeries.set("2013", 320);
		
		chartModel.addSeries(primefacesSeries);
		chartModel.addSeries(jquerySeries);
	}
	void initLinearChartModel()
	{
		linearChartModel = new CartesianChartModel();
		
		LineChartSeries primefacesSeries = new LineChartSeries();
		primefacesSeries.setLabel("PrimeFaces");
		//primefacesSeries.setMarkerStyle("diamond");
		primefacesSeries.set("2009", 150);
		primefacesSeries.set("2010", 250);
		primefacesSeries.set("2011", 300);
		primefacesSeries.set("2012", 240);
		primefacesSeries.set("2013", 400);
		
		LineChartSeries jquerySeries = new LineChartSeries();
		jquerySeries.setLabel("jQuery");
		jquerySeries.set("2009", 210);
		jquerySeries.set("2010", 150);
		jquerySeries.set("2011", 200);
		//jquerySeries.set("2011", null);
		jquerySeries.set("2012", 280);
		jquerySeries.set("2013", 320);
		
		linearChartModel.addSeries(primefacesSeries);
		linearChartModel.addSeries(jquerySeries);
	}
	
	public StreamedContent getJfreeChart()
	{
		StreamedContent content = null;
		try
		{
			DefaultPieDataset dataset = new DefaultPieDataset();  
	        dataset.setValue("PrimeFaces", 455);
	        dataset.setValue("JSF", 380);
			dataset.setValue("jQuery", 202);
			dataset.setValue("JPA", 180);
			
			boolean legend=true, tooltip=true, urls =false;
			JFreeChart chart = ChartFactory.createPieChart("JFreeChart", dataset, legend, tooltip, urls);
			
			File chartFile = new File("jfreechart");  
			int width=375, height=300;
			ChartUtilities.saveChartAsPNG(chartFile, chart, width, height);  
			
			content = new DefaultStreamedContent(new FileInputStream(chartFile), "image/png");
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return content;
	}
	 
	public void itemSelect(ItemSelectEvent event) {  
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
        				"Item selected",  
                        "Item Index: " + event.getItemIndex() 
                        + ", Series Index:" + event.getSeriesIndex());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
	
	public CartesianChartModel getChartModel()
	{
		return chartModel;
	}
	public CartesianChartModel getLinearChartModel()
	{
		return linearChartModel;
	}
	
	public LineChartModel getAreaChartModel()
	{
		return areaChartModel;
	}
	public DonutChartModel getDonutChartModel()
	{
		return donutChartModel;
	}
	public BubbleChartModel getBubbleChartModel()
	{
		return bubbleChartModel;
	}
	public String  getHorizontalChartDatatipFormat()
	{
		return "<span>No. of Posts: %s</span>";
	}
	public String getDatatipFormat()
	{
		return "<span style='display:none'>%s</span><span>No. of Posts: %s</span>";
	}
	public PieChartModel getPieChartModel()
	{
		return pieChartModel;
	}
}
