import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Ip } from '../models/ip';

@Injectable({
  providedIn: 'root'
})
export class IpApiService {

  constructor(private http: HttpClient) {}

  getUserIp(): Observable<Ip> {
    return this.http
      .get<Ip>('http://api.ipify.org/?format=json');
  }
}
