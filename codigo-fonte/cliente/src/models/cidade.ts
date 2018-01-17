import { Estado } from './estado';

export class Cidade {
  id: any;
  nome: String;
  estado: Estado;

  constructor() {
    this.id = '';
    this.nome = '';
    this.estado = new Estado();
  }
}