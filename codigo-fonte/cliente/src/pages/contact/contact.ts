import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { AlertController } from 'ionic-angular';
import { NavParams } from 'ionic-angular/navigation/nav-params';

import { ShareScopeProvider } from '../../providers/share-scope/share-scope';
import { MedicoServiceProvider } from '../../providers/medico-service/medico-service';

import { HomePage } from '../home/home';

import { Estado } from '../../models/estado';
import { Medico } from '../../models/medico';

@Component({
  selector: 'page-contact',
  templateUrl: 'contact.html'
})
export class ContactPage {

  medicoEditar: any;
  isVisualizar: Boolean = false;
  isNovo: Boolean = false;
  estados: Array<Estado>;
  cidades: Array<Estado>;
  especialidades: Array<Estado>;

  constructor(public navCtrl: NavController, public shareScope: ShareScopeProvider, public navParams: NavParams,
    public medicoService: MedicoServiceProvider, public alertCtrl: AlertController) {
    this.medicoEditar = shareScope.get('medicoEditar');
    this.isVisualizar = navParams.get('isVisualizar');
    if(!shareScope.get('medicoEditar')) {
      this.medicoEditar = new Medico();
      this.listarFormularios();
      this.isNovo = true;
    }
  }

  ionViewWillLeave() {
    this.shareScope.remove('medicoEditar');
  }

  editar() {
    this.isVisualizar = false;
    this.listarFormularios();
  }

  salvar() {
    this.medicoService.putMedico(this.medicoEditar).then((result: Medico) => {
      let title = this.isNovo ? 'Cadastro Realizado!' : 'Dados Atualizados!'
      let subTitle = this.isNovo ?
        'Dr(a). ' + result.primeiroNome + ' ' +  result.ultimoNome + ' cadastrado com sucesso!': 
        'Os dados do(a) Dr(a). ' + result.primeiroNome + ' ' +  result.ultimoNome + ' foram atualizados com sucesso!'
      let alert = this.alertCtrl.create({
        title: title,
        subTitle: subTitle,
        buttons: ['OK']
      });
      alert.present();
      this.navCtrl.setRoot(HomePage);
    }).catch(err => {
      let alert = this.alertCtrl.create({
        title: 'Erro!',
        subTitle: 'Erro ao tentar salvar o médico!',
        buttons: ['OK']
      });
    });
  }

  voltar() {
    this.navCtrl.pop();
  }

  compareFn(e1: any, e2: any): boolean {
    return e1 && e2 ? e1.id === e2.id : e1 === e2;
  }

  private listarFormularios() {
    this.medicoService.getListaFormulario().then(result => {
      if(result) {
        this.estados = result.estado;
        this.cidades = result.cidade;
        this.especialidades = result.especialidade;
      }
    });
  }

}
