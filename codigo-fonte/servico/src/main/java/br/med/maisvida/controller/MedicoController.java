package br.med.maisvida.controller;

import br.med.maisvida.model.Medico;
import br.med.maisvida.model.dto.MedicoDTO;
import br.med.maisvida.service.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController extends BaseController<MedicoService, MedicoDTO, Medico>{

    @GetMapping("")
    public ResponseEntity<List<MedicoDTO>> listar() {
        return buildResposta(service.listar());
    }

    @PutMapping("")
    public ResponseEntity<MedicoDTO> adicionar(@RequestBody MedicoDTO dto) {
        Medico medico = this.converter.converter(dto, Medico.class);
        medico.setIsAtivo(true);
        medico.setIsOcupado(false);
        return buildResposta(service.salvar(medico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> buscarPorId(@PathVariable Long id) {
        return buildResposta(service.buscarPorId(id));
    }

    protected ResponseEntity buildResposta(List list) {
        if(list == null || list.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(converter.converter(list, MedicoDTO.class), HttpStatus.OK);
    }

    protected ResponseEntity buildResposta(Medico e) {
        if(e == null) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(converter.converter(e, MedicoDTO.class), HttpStatus.OK);
    }
}
