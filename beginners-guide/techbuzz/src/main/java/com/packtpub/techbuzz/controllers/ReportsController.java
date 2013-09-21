package com.packtpub.techbuzz.controllers;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.packtpub.techbuzz.services.PostService;
import com.packtpub.techbuzz.services.TagService;
import com.packtpub.techbuzz.web.view.TagPostCountBean;

/**
 * @author K. Siva Prasad Reddy
 * Date : 21-Sep-2013
 */
@Component
@Scope("view")
public class ReportsController implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Autowired private PostService postService;
	@Autowired private TagService tagService;
	
	private CartesianChartModel tagPostsChartModel;
	private PieChartModel pieChartModel;
	
	@PostConstruct
	public void init()
	{
		initTagPostsChartModel();
		initPieChartModel();
	}

	private void initPieChartModel()
	{
		pieChartModel = new PieChartModel();
		List<TagPostCountBean> tagPostCountBeans = tagService.getTagPostCounts();
		for (TagPostCountBean tagPostCountBean : tagPostCountBeans)
		{
			pieChartModel.set(tagPostCountBean.getTag(), tagPostCountBean.getPostCount());
		}
		
	}

	private void initTagPostsChartModel()
	{
		tagPostsChartModel = new CartesianChartModel();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		List<TagPostCountBean> tagPostCountBeans = tagService.getTagPostCounts();
		for (TagPostCountBean tagPostCountBean : tagPostCountBeans)
		{
			ChartSeries series = new ChartSeries();
			series.setLabel(tagPostCountBean.getTag());
			series.set(String.valueOf(year), tagPostCountBean.getPostCount());
			tagPostsChartModel.addSeries(series);
		}
		
	}
	public CartesianChartModel getTagPostsChartModel()
	{
		return tagPostsChartModel;
	}
	
	public PieChartModel getPieChartModel()
	{
		return pieChartModel;
	}
	
}
