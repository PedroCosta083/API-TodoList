package pedro.costa.TaskManagerAPI;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link TaskManagerApiApplication}.
 */
@Generated
public class TaskManagerApiApplication__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'taskManagerApiApplication'.
   */
  public static BeanDefinition getTaskManagerApiApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TaskManagerApiApplication.class);
    beanDefinition.setTargetType(TaskManagerApiApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(TaskManagerApiApplication.class);
    beanDefinition.setInstanceSupplier(TaskManagerApiApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
