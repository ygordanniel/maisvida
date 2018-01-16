package br.med.maisvida.util;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class EntityConverter {

    private ModelMapper map;

    @PostConstruct
    private void init() {
        map = new ModelMapper();
    }

    public <D> D converter(Object source, Class<D> target){
        D retorno = map.map(source, target);

        return retorno;
    }

    public <D> List<D> converter(List sources, Class<D> target){
        List<D> list = new ArrayList<>();
        sources.forEach(o -> list.add(map.map(o, target)));

        return list;
    }

}
