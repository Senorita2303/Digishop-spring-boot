package com.example.digishop.context.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.digishop.context.Context;
import com.example.digishop.context.ContextHelper;
import com.example.digishop.context.properties.ContextProperties;

import lombok.extern.slf4j.Slf4j;

/**
 * Servlet filter that manages application-specific context. Clears the context
 * after request processing completes.
 *
 * @author SunTao
 * @since 2024-07-02
 */
@Slf4j
@Component
public class ContextFilter extends OncePerRequestFilter {
	private ContextProperties contextProperties;

	/**
	 * Sets the ContextProperties instance.
	 *
	 * @param contextProperties The ContextProperties instance to set
	 */
	@Autowired
	public void setContextProperties(ContextProperties contextProperties) {
		this.contextProperties = contextProperties;
	}

	/**
	 * Core method of the filter. Sets up context on request entry and cleans up
	 * after request processing.
	 *
	 * @param request     HttpServletRequest representing the client request
	 * @param response    HttpServletResponse representing the server response
	 * @param filterChain FilterChain for invoking the next filter or target
	 *                    resource
	 * @throws ServletException in case of a servlet exception
	 * @throws IOException      in case of an I/O error
	 */
	@Override
	protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response,
			@NotNull FilterChain filterChain) throws ServletException, IOException {
		try {
			final String options = "OPTIONS";
			if (!options.equals(request.getMethod())) {
				ContextHelper.createContext(request, contextProperties);
				Context.print();
			}
			filterChain.doFilter(request, response);
		} finally {
			ContextHelper.clearContext();
		}
	}
}