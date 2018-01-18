package br.med.maisvida.util;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entidade para a conversao DTO <-> Entidade
 */
@Component
public class EntityConverter {

    private ModelMapper map;

    @PostConstruct
    private void init() {
        map = new ModelMapper();
    }

    /**
     * conversao de um unico objeto
     * @param source
     * @param target
     * @param <D>
     * @return
     */
    public <D> D converter(Object source, Class<D> target){
        D retorno = map.map(source, target);

        return retorno;
    }

    /**
     * conversao de uma lista de objetos
     * @param sources
     * @param target
     * @param <D>
     * @return
     */
    public <D> List<D> converter(List sources, Class<D> target, boolean withNullObjects){
        List<D> list = new ArrayList<>();
        if(withNullObjects) {
            sources.forEach(o -> list.add(map.map(o, target)));
        } else {
            sources
                .stream()
                .filter(Objects::nonNull)
                .forEach(o -> list.add(map.map(o, target)));
        }

        return list;
    }

}
