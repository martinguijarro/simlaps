import { Component } from '@angular/core';

import { Lap } from '../models/lap.model';
import { LapService } from '../services/lap.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  
  laps: Lap[] = [];

  constructor(
    private lapService: LapService
  ){}

  ngOnInit(): void {
    this.getAllLaps();
  }

  getAllLaps() {
    this.lapService.getAllLaps().subscribe({
      next: res => {
        this.laps = res;
      },
      error: err => {
        console.error('Error getting all laps', err);
      }
    })
  }

}
