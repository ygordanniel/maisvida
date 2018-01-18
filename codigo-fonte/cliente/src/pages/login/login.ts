import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

import { Usuario } from '../../models/usuario';
import { TabsPage } from '../tabs/tabs';
import { AuthServiceProvider } from '../../providers/auth-service/auth-service';

/**
 * Generated class for the LoginPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {

  usuario: Usuario  = new Usuario();

  constructor(public navCtrl: NavController, public navParams: NavParams, public authService: AuthServiceProvider) {
    //Usuario default
    this.usuario.email = 'ygordanniel@gmail.com';
    this.usuario.senha = '12345678';
  }

  login() {
    this.authService.login(this.usuario, this.navCtrl);
  }

}
