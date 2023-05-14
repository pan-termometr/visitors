import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class VisitService {

  private readonly VISIT_SAVE_URL = 'http://localhost:8081/api/v1/visits/save';

  constructor(private http: HttpClient) { }

  saveVisit(ipAddress: string, currentDate: string) {
    const visitData = {
      date: currentDate,
      ip: ipAddress
    };
    return this.http.post(this.VISIT_SAVE_URL, visitData);
  }
}
