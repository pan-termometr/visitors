import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Visit } from '../models/visit';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VisitService {

  private readonly VISIT_SAVE_URL = 'http://localhost:8081/api/v1/visits/save';

  constructor(private http: HttpClient) { }

  saveVisit(ipAddress: string, currentDate: string): Observable<Visit> {
    const visitData: Visit = {
      date: currentDate,
      ip: ipAddress
    };
    return this.http.post<Visit>(this.VISIT_SAVE_URL, visitData);
  }
}
