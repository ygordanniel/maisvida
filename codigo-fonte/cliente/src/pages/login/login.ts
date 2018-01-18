import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

import { Usuario } from '../../models/usuario';

import { AuthServiceProvider } from '../../providers/auth-service/auth-service';
import { CookieService } from 'ngx-cookie-service';

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
  isCache: Boolean = false;

  constructor(public navCtrl: NavController, public navParams: NavParams, public authService: AuthServiceProvider,
    public cookieService: CookieService) {
    //Usuario default
    this.usuario.email = 'ygordanniel@gmail.com';
    this.usuario.senha = '12345678';
  }

  ionViewWillEnter() {
    let jwt = this.cookieService.get('jwt');
    if(jwt) {
      this.authService.loginWithCache(this.navCtrl, jwt);
    }
  }

  login() {
    this.authService.login(this.usuario, this.navCtrl, this.isCache);
  }

}
