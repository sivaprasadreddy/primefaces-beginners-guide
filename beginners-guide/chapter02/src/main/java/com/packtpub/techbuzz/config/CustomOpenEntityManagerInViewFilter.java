/**
 * 
 */
package com.packtpub.techbuzz.config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

/**
 * @author Siva
 *
 */
public class CustomOpenEntityManagerInViewFilter extends OpenEntityManagerInViewFilter
{
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request)
			throws ServletException {
		return request.getRequestURI().contains("javax.faces.resource");
	}
}
