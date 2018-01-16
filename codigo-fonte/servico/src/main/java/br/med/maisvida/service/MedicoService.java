package br.med.maisvida.service;

import br.med.maisvida.model.Medico;
import br.med.maisvida.repository.MedicoRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicoService extends BaseService<Medico, MedicoRepository> {
}
