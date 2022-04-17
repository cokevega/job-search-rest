package com.jgvega.rest.jobsearch.languages;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.sun.codemodel.JCodeModel;

@Component
@Profile("languages")
public class LanguageModelCreator implements CommandLineRunner {
	
	@Value("${languages.creation.endpoint.languages}")
	private String endpoint;
	@Value("${languages.creation.files.path-to-package}")
	private String packagePath;
	@Value("${languages.creation.files.package-name}")
	private String packageName;
	@Value("${languages.creation.files.java-class}")
	private String javaClassName;
	
	@Override
	public void run(String... args) throws Exception {
		getLanguages();
		System.exit(0);
	}

	private void getLanguages() throws IOException {
		URL uri = new URL(endpoint);
		File packageLocation = new File(packagePath);
		convertJsonToLanguage(uri, packageLocation, packageName, javaClassName);
	}

	private void convertJsonToLanguage(URL jsonUrl, File outputJavaClass, String packageName, String javaClass)
			throws IOException {
		JCodeModel codeModel = new JCodeModel();
		GenerationConfig config = new DefaultGenerationConfig() {

			@Override
			public boolean isGenerateBuilders() {
				return true;
			}

			@Override
			public SourceType getSourceType() {
				return SourceType.JSON;
			}
		};
		SchemaMapper mapper = new SchemaMapper(
				new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
		mapper.generate(codeModel, javaClass, packageName, jsonUrl);
		codeModel.build(outputJavaClass);
	}
	
}
