import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DailyVisitStatistic } from 'src/app/models/daily-statistic';
import { StatisticsService } from 'src/app/services/statistics.service';

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.scss']
})
export class StatisticsComponent implements OnInit {

  dailyVisits?: DailyVisitStatistic[];

  constructor(private statisticsService: StatisticsService, private router: Router) {}

  ngOnInit() {
    this.statisticsService.getStatistics().subscribe((visitStats: DailyVisitStatistic[]) => {
        this.dailyVisits = visitStats;
    });
  };

  goBack() {
    this.router.navigate(['/']);
  }
}
