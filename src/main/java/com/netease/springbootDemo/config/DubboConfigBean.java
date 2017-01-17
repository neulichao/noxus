package com.netease.springbootDemo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;

//@Configuration
@PropertySource(value = "classpath:META-INF/dubbo.properties")
public class DubboConfigBean {

	@Value("${dubbo.application.name}")
	private String applicationName;

	@Value("${dubbo.registr.protocol}")
	private String protocol;

	@Value("${dubbo.registry.address}")
	private String registryAddress;

	@Value("${dubbo.protocol.name}")
	private String protocolName;

	@Value("${dubbo.protocol.port}")
	private int protocolPort;

	@Value("${dubbo.provider.timeout}")
	private int timeout;

	@Value("${dubbo.provider.retries}")
	private int retries;

	@Value("${dubbo.provider.delay}")
	private int delay;

	/**
	 * 设置dubbo扫描包
	 * @param packageName
	 * @return
	 */
	@Bean
	public static AnnotationBean annotationBean(@Value("${dubbo.annotation.package}") String packageName) {
		AnnotationBean annotationBean = new AnnotationBean();
		annotationBean.setPackage(packageName);
		return annotationBean;
	}

	/**
	 * 注入dubbo上下文
	 * 
	 * @return
	 */
	@Bean(name = "applicationConfig")
	public ApplicationConfig applicationConfig() {
		// 当前应用配置
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName(this.applicationName);
		return applicationConfig;
	}

	/**
	 * 注入dubbo注册中心配置,基于zookeeper
	 * 
	 * @return
	 */
	@Bean(name = "registryConfig")
	public RegistryConfig registryConfig() {
		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setProtocol(protocol);
		registry.setAddress(registryAddress);
		return registry;
	}

	/**
	 * 默认基于dubbo协议提供服务
	 * 
	 * @return
	 */
	@Bean(name = "protocolConfig")
	public ProtocolConfig protocolConfig() {
		// 服务提供者协议配置
		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setName(protocolName);
		protocolConfig.setPort(protocolPort);
		protocolConfig.setThreads(200);
		return protocolConfig;
	}

	/**
	 * dubbo服务提供
	 * 
	 * @param applicationConfig
	 * @param registryConfig
	 * @param protocolConfig
	 * @return
	 */
	@Bean(name = "defaultProvider")
	public ProviderConfig providerConfig(@Qualifier("applicationConfig") ApplicationConfig applicationConfig,
			@Qualifier("registryConfig") RegistryConfig registryConfig,
			@Qualifier("protocolConfig") ProtocolConfig protocolConfig) {
		ProviderConfig providerConfig = new ProviderConfig();
		providerConfig.setTimeout(timeout);
		providerConfig.setRetries(retries);
		providerConfig.setDelay(delay);
		providerConfig.setApplication(applicationConfig);
		providerConfig.setRegistry(registryConfig);
		providerConfig.setProtocol(protocolConfig);
		return providerConfig;
	}

}
