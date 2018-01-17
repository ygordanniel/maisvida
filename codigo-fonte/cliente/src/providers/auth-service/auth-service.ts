import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NavController } from 'ionic-angular';
import { TabsPage } from '../../pages/tabs/tabs';
import { HttpResponse } from '@angular/common/http/src/response';

/*
  Generated class for the AuthServiceProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
let API_BASE_URL = 'http://localhost:8080/maisvida/api/'

@Injectable()
export class AuthServiceProvider {

  constructor(public http: HttpClient) {}

  login(body, navCtrl: NavController) {
    this.postData(body, 'login').then((result: HttpResponse<string>) => {
      let jwt = result.headers.get('authorization');
      if(jwt) {
        localStorage.setItem('jwt', jwt);
        navCtrl.push(TabsPage, {}, {animate: false});
      }
    });
  }

  private postData(body, path) {
    return new Promise((resolve, reject) => {
      this.http.post(API_BASE_URL + path, JSON.stringify(body), {observe: 'response', responseType: 'text'})
        .subscribe(res => {
          resolve(res);
        }, (err) => {
          reject(err);
        });
    });
  }

}
