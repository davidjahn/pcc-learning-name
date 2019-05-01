package io.pivotal.pcc.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.cache.config.EnableGemfireCaching;
import org.springframework.data.gemfire.config.annotation.EnableCachingDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnableClusterConfiguration;

@Configuration
@EnableCachingDefinedRegions
@EnableGemfireCaching
@EnableClusterConfiguration(useHttp = true)
public class GeodeConfiguration {
}
