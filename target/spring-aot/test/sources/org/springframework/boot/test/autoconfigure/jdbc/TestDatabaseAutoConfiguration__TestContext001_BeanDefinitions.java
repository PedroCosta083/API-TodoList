package org.springframework.boot.test.autoconfigure.jdbc;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TestDatabaseAutoConfiguration}.
 */
@Generated
public class TestDatabaseAutoConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'testDatabaseAutoConfiguration'.
   */
  public static BeanDefinition getTestDatabaseAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TestDatabaseAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(TestDatabaseAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean definition for 'embeddedDataSourceBeanFactoryPostProcessor'.
   */
  public static BeanDefinition getEmbeddedDataSourceBeanFactoryPostProcessorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TestDatabaseAutoConfiguration.class);
    beanDefinition.setTargetType(TestDatabaseAutoConfiguration.EmbeddedDataSourceBeanFactoryPostProcessor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(BeanInstanceSupplier.<TestDatabaseAutoConfiguration.EmbeddedDataSourceBeanFactoryPostProcessor>forFactoryMethod(TestDatabaseAutoConfiguration.class, "embeddedDataSourceBeanFactoryPostProcessor").withGenerator((registeredBean) -> TestDatabaseAutoConfiguration.embeddedDataSourceBeanFactoryPostProcessor()));
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link TestDatabaseAutoConfiguration.EmbeddedDataSourceFactoryBean}.
   */
  @Generated
  public static class EmbeddedDataSourceFactoryBean {
    /**
     * Get the bean definition for 'dataSource'.
     */
    public static BeanDefinition getDataSourceBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TestDatabaseAutoConfiguration.EmbeddedDataSourceFactoryBean.class);
      beanDefinition.setInstanceSupplier(TestDatabaseAutoConfiguration.EmbeddedDataSourceFactoryBean::new);
      return beanDefinition;
    }
  }
}
