import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { switchMap } from 'rxjs';
import { Ip } from 'src/app/models/ip';
import { IpApiService } from 'src/app/services/ip-api.service';
import { VisitService } from 'src/app/services/visit.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit{

  ip?: Ip;
  currentDate: string;

  constructor(private ipService: IpApiService, private visitService: VisitService, private router: Router) {
    this.currentDate = new Date().toISOString().slice(0, 10);
   }

  ngOnInit() {
    this.ipService.getUserIp().pipe(
      switchMap((userIp: Ip) => {
        this.ip = userIp;
        return this.visitService.saveVisit(userIp.ip, this.currentDate)
    })
    ).subscribe(() => {
      console.log('Visit successfully saved in db');
    });
  };

  redirectToStatistics() {
    this.router.navigate(['/statistics']);
  }
}
