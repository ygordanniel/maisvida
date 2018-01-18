package br.med.maisvida.controller;

import br.med.maisvida.model.Medico;
import br.med.maisvida.model.dto.CidadeDTO;
import br.med.maisvida.model.dto.EspecialidadeDTO;
import br.med.maisvida.model.dto.EstadoDTO;
import br.med.maisvida.model.dto.MedicoDTO;
import br.med.maisvida.repository.CidadeRepository;
import br.med.maisvida.repository.EspecialidadeRepository;
import br.med.maisvida.repository.EstadoRepository;
import br.med.maisvida.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medico")
public class MedicoController extends BaseController<MedicoService, MedicoDTO, Medico> {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping("")
    public ResponseEntity<List<MedicoDTO>> listar() {
        return buildResposta(service.listarOrdenado());
    }

    @PutMapping("")
    public ResponseEntity<MedicoDTO> adicionar(@RequestBody MedicoDTO dto) {
        Medico medico = this.converter.converter(dto, Medico.class);
        return buildResposta(service.salvar(medico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> buscarPorId(@PathVariable Long id) {
        return buildResposta(service.buscarPorId(id));
    }

    @GetMapping("/lista-formulario")
    public ResponseEntity<Map<String, Object>> buscarListaFormulario() {
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("especialidade", converter.converter(especialidadeRepository.findAll(), EspecialidadeDTO.class, false));
        resposta.put("estado", converter.converter(estadoRepository.findAll(), EstadoDTO.class, false));
        resposta.put("cidade", converter.converter(cidadeRepository.findAll(), CidadeDTO.class, false));
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    protected ResponseEntity buildResposta(List list) {
        if(list == null || list.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        }
        return new ResponseEntity<>(converter.converter(list, MedicoDTO.class, false), HttpStatus.OK);
    }

    protected ResponseEntity buildResposta(Medico e) {
        if(e == null) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(converter.converter(e, MedicoDTO.class), HttpStatus.OK);
    }
}
