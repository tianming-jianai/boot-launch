package com.zimug.bootlaunch.utils;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DozerUtils {

    static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass){
        List destinationList = Lists.newArrayList();
        for (Iterator i$ = sourceList.iterator(); i$.hasNext();){
            Object sourceObject = i$.next();
            Object destinationObject = mapper.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }
}
