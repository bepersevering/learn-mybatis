package com.mingshashan.mybatis.learn.copier;

import net.sf.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;

@Component
public class SpringCglibCopier {
    /**
     * cglib 对象转换
     *
     * @param source
     * @param target
     * @param <K>
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public <K, T> T copy(K source, Class<T> target) throws IllegalAccessException, InstantiationException {
        BeanCopier copier = BeanCopier.create(source.getClass(), target, false);
        T res = target.newInstance();
        copier.copy(source, res, null);
        return res;
    }
}