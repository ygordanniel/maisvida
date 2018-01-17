import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';

import { Medico } from '../../models/medico';

/*
  Generated class for the MedicoServiceProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/

let API_BASE_URL = 'http://localhost:8080/maisvida/api/medico'

@Injectable()
export class MedicoServiceProvider {

  constructor(public http: HttpClient) {}

  getMedicos() {
    return this.getData<Array<Medico>>('');
  }

  getListaFormulario() {
    return this.getData<Map<String, Object>>('/lista-formulario');
  }

  putMedico(medico: Medico) {
    return this.putData<Medico>('', medico);
  }

  private getData<T>(path) {
    return new Promise((resolve, reject) => {
      let headers = new HttpHeaders().append('Authorization', localStorage.getItem('jwt'));
      this.http.get<T>(API_BASE_URL + path, {headers: headers})
        .subscribe(res => {
          resolve(res);
        }, (err) => {
          reject(err);
        });
    });
  }

  private putData<T>(path, body) {
    return new Promise((resolve, reject) => {
      let headers = new HttpHeaders()
        .append('Authorization', localStorage.getItem('jwt'))
        .append('Content-Type', 'application/json');
      this.http.put<T>(API_BASE_URL + path, JSON.stringify(body),{headers: headers})
        .subscribe(res => {
          resolve(res);
        }, (err) => {
          reject(err);
        });
    });
  }

}
