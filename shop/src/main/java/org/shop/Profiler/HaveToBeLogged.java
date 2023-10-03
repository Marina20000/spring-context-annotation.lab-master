package org.shop.Profiler;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by User on 13.08.2017.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface HaveToBeLogged {
    String info="invoked";
}
