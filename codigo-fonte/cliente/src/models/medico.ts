import { Especialidade } from './especialidade'
import { Cidade } from './cidade'

export class Medico {
  id: any;
  primeiroNome: String;
  ultimoNome: String;
  email: String;
  isAtivo: Boolean;
  isOcupado: Boolean;
  especialidade: Especialidade;
  cidade: Cidade;

  constructor() {
    this.id = '';
    this.primeiroNome = '';
    this.ultimoNome = '';
    this.email = '';
    this.isAtivo = true;
    this.isOcupado = false;
    this.especialidade = new Especialidade();
    this.cidade = new Cidade();
  }
}