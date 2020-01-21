package quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;
import quoters.InjectRandomInt;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    //get invoked BEFORE init method
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();

        Arrays.stream(fields).forEach(field -> {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);

            if (annotation != null){
                int min = annotation.min();
                int max = annotation.max();
                int i = ThreadLocalRandom.current().nextInt(min, max);
                field.setAccessible(true);
                ReflectionUtils.setField(field,bean,i);
            }
        });
        return bean;
    }
    // get invoked AFTER init method
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
