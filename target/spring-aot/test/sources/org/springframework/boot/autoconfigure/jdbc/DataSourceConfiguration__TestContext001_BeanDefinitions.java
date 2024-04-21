package org.springframework.boot.autoconfigure.jdbc;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DataSourceConfiguration}.
 */
@Generated
public class DataSourceConfiguration__TestContext001_BeanDefinitions {
  /**
   * Bean definitions for {@link DataSourceConfiguration.Hikari}.
   */
  @Generated
  public static class Hikari {
    /**
     * Get the bean definition for 'hikari'.
     */
    public static BeanDefinition getHikariBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceConfiguration.Hikari.class);
      beanDefinition.setInstanceSupplier(DataSourceConfiguration.Hikari::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'jdbcConnectionDetailsHikariBeanPostProcessor'.
     */
    private static BeanInstanceSupplier<HikariJdbcConnectionDetailsBeanPostProcessor> getJdbcConnectionDetailsHikariBeanPostProcessorInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<HikariJdbcConnectionDetailsBeanPostProcessor>forFactoryMethod(DataSourceConfiguration.Hikari.class, "jdbcConnectionDetailsHikariBeanPostProcessor", ObjectProvider.class)
              .withGenerator((registeredBean, args) -> DataSourceConfiguration.Hikari.jdbcConnectionDetailsHikariBeanPostProcessor(args.get(0)));
    }

    /**
     * Get the bean definition for 'jdbcConnectionDetailsHikariBeanPostProcessor'.
     */
    public static BeanDefinition getJdbcConnectionDetailsHikariBeanPostProcessorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceConfiguration.Hikari.class);
      beanDefinition.setTargetType(HikariJdbcConnectionDetailsBeanPostProcessor.class);
      beanDefinition.setInstanceSupplier(getJdbcConnectionDetailsHikariBeanPostProcessorInstanceSupplier());
      return beanDefinition;
    }
  }
}
