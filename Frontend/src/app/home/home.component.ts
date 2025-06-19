import { Component } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule, MatDialog } from '@angular/material/dialog'

import { Lap } from '../models/lap.model';
import { LapService } from '../services/lap.service';
import { CreateLapComponent } from '../create-lap/create-lap.component';
import { CarService } from '../services/car.service';
import { Car } from '../models/car.model';
import { Circuit } from '../models/circuit.model';
import { Game } from '../models/game.model';
import { CircuitService } from '../services/circuit.service';
import { GameService } from '../services/game.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    MatIconModule,
    MatDialogModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  
  laps: Lap[] = [];
  cars: Car[] = [];
  circuits: Circuit[] = [];
  games: Game[] = [];

  constructor(
    private dialog: MatDialog,
    private lapService: LapService,
    private carService: CarService,
    private circuitService: CircuitService,
    private gameService: GameService
  ){}

  ngOnInit(): void {
    this.getAllLaps();
    this.getAllCars();
    this.getAllCircuits();
    this.getAllGames();
  }

  getAllLaps() {
    this.lapService.getAllLaps().subscribe({
      next: res => {
        this.laps = res;
      },
      error: err => {
        console.error('Error getting all laps', err);
      }
    });
  }

  getAllCars() {
    this.carService.getAllCars().subscribe({
      next: res => {
        this.cars = res;
      },
      error: err => {
        console.error('Error getting all cars', err);
      }
    });
  }

  getAllCircuits() {
    this.circuitService.getAllCircuits().subscribe({
      next: res => {
        this.circuits = res;
      },
      error: err => {
        console.error('Error getting all circuits', err);
      }
    });
  }

  getAllGames() {
    this.gameService.getAllGames().subscribe({
      next: res => {
        this.games = res;
      },
      error: err => {
        console.error('Error getting all games', err);
      }
    });
  }

  getCarName(carId: string) {
    const car = this.cars.find(car => car.carId === carId);
    return car ? `${car.brand} ${car.model}` : 'Desconocido';
  }

  getCircuitName(circuitId: string) {
    const circuit = this.circuits.find(circuit => circuit.circuitId === circuitId);
    return circuit ? `${circuit.name}` : 'Desconocido';
  }

  getGameName(gameId: string) {
    const game = this.games.find(game => game.gameId === gameId);
    return game ? `${game.name}` : 'Desconocido';
  }

  openLapForm() {    
    const dialogRef = this.dialog.open(CreateLapComponent, {
      width: 'auto',
      panelClass: 'create-lap-dialog'
    });

    dialogRef.afterClosed().subscribe((res) => {
      if (res === true) {
        this.getAllLaps();
      }
    })
  }

}
