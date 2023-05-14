import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DailyVisitStatistic } from '../models/daily-statistic';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {

  private readonly VISIT_SAVE_URL = 'http://localhost:8081/api/v1/statistics';

  constructor(private http: HttpClient) { }

  getStatistics(): Observable<DailyVisitStatistic[]> {
    return this.http.get<DailyVisitStatistic[]>(this.VISIT_SAVE_URL);
  }
}
