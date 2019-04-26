package io.pivotal.pcc.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.config.annotation.EnableCachingDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnableClusterConfiguration;
import org.springframework.data.gemfire.config.annotation.EnablePdx;

@Configuration
@EnableCachingDefinedRegions
@EnableClusterConfiguration(useHttp = true)
public class GeodeConfiguration {
}
