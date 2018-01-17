import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the ShareScopeProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class ShareScopeProvider {

  private sharedMap: Map<String, Object>;

  constructor(public http: HttpClient) {
    this.sharedMap = new Map();
  }

  get(key: String) {
    return this.sharedMap.get(key);
  }

  put(key: String, obj: Object) {
    this.sharedMap.set(key, obj);
  }

  remove(key: String) {
    this.sharedMap.delete(key);
  }

}
