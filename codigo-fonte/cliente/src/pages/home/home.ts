import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

import { MedicoServiceProvider } from '../../providers/medico-service/medico-service';
import { Medico } from '../../models/medico';
import { ContactPage } from '../contact/contact';
import { ShareScopeProvider } from '../../providers/share-scope/share-scope';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  medicos: Array<Medico>;

  constructor(public navCtrl: NavController, public medicoService: MedicoServiceProvider,
    public shareScope: ShareScopeProvider) {
    medicoService.getMedicos().then((result: Array<Medico>) => {
      this.medicos = result;
    });
  }

  editar(medico: Medico) {
    this.shareScope.put('medicoEditar', medico);
    this.navCtrl.push(ContactPage, {isVisualizar: true});
  }

  cadastrar() {
    this.navCtrl.push(ContactPage, {isVisualizar: false});
  }

}
