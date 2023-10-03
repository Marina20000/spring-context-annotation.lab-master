package org.shop.Profiler;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by User on 13.08.2017.
 */
public class InjectNewSpringAnnotationBeanPostProcessor implements BeanPostProcessor{
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods = bean.getClass().getMethods();
        for (Method method:methods){
            Annotation annotation = method.getAnnotation(HaveToBeLogged.class);
            if (annotation!=null){
                System.out.println("method="+method.getName());
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String BeanName) throws BeansException {
        return bean;
    }
}
