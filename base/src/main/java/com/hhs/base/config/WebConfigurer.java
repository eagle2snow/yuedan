package com.hhs.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
class WebConfigurer implements WebMvcConfigurer {

	@Value("${file.root.path}")
	private String fileRealPath;
	@Value("${img.root.path}")
	private String imgRealPath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/file/**").addResourceLocations("file:///" + fileRealPath);
		registry.addResourceHandler("/img/**").addResourceLocations("file:///" + imgRealPath);
		// linux
		// registry.addResourceHandler("/files/**").addResourceLocations("file:///gm/uploaded_files");
	}
}